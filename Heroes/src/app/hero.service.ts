import { Injectable } from '@angular/core';
import { Hero } from './hero';
import { Observable, of } from 'rxjs';
import { MessageService } from './message.service';
import { HttpClient , HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class HeroService {

  private api: string;
  private getHeroByName: string;

   httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private messageService: MessageService , private Http: HttpClient) { 
    this.api = 'http://localhost:8080/Heroes';
    this.getHeroByName = 'http://localhost:8080/HeroesByName'; 
  }

  getHeroes(): Observable<Hero[]> { 
    this.messageService.add('HeroService: fetched heroes');
    return this.Http.get<Hero[]>(this.api);
  }

  getHero(id:number): Observable<Hero> {
    this.messageService.add('HeroService: fetched hero id=' + id);
    return this.Http.get<Hero>(this.api + "/" + id);  
  }

  /** PUT: update the hero on the server */
updateHero (hero: Hero): Observable<any> { 
  return this.Http.put(this.api, hero, this.httpOptions);
  
}

addHero (hero: Hero): Observable<Hero> {
  return this.Http.post<Hero>(this.api, hero, this.httpOptions);
}

deleteHero(hero: Hero): Observable<Hero> {
  return this.Http.delete<Hero>(this.api + '?id=' + hero.id, this.httpOptions);
}

searchHeroes(term: string): Observable<Hero[]> {
  if(!term.trim){
    //if not search term, return empty hero array
    return of([]);
  }
  return this.Http.get<Hero[]>(this.getHeroByName + '?name=' + term);
}


}

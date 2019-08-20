import { Component, OnInit, SimpleChanges } from '@angular/core';
import { Hero } from '../hero';
import { HeroService } from '../hero.service';

@Component({
  selector: 'app-heros',
  templateUrl: './heros.component.html',
  styleUrls: ['./heros.component.css']
})
export class HerosComponent implements OnInit {

  heroes: Hero[];
  
  constructor(private heroService: HeroService) { }

  ngOnInit() {
    this.getHeroes();
  }

  getHeroes(): void {
    this.heroService.getHeroes()
        .subscribe(heros => this.heroes = heros);
  }

  add(name: string): void {
    name = name.trim();
    if (!name) { return; }
    this.heroService.addHero({ name } as Hero).subscribe(  );
      setTimeout(funct => {this.getHeroes();
        
      }, 300);
    }

  delete(hero: Hero): void {
    this.heroes = this.heroes.filter(h => h !==hero);
    this.heroService.deleteHero(hero).subscribe();
  }
}

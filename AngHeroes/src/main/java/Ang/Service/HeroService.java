package Ang.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ang.Model.Hero;
import Ang.Repo.HeroRepo;

@Service
public class HeroService {

	private HeroRepo heroRepo;
	
	@Autowired
	public HeroService(HeroRepo heroRepo) {
		this.heroRepo = heroRepo;
	}
	
	public List<Hero> findAll(){
		if(heroRepo.findAll().size() == 0) {
			Hero hero1 = new Hero("Dr. Nice");
			heroRepo.save(hero1);
			Hero hero2 = new Hero("Narco");
			heroRepo.save(hero2);
			Hero hero3 = new Hero("Bombasto");
			heroRepo.save(hero3);
			Hero hero4 = new Hero("Celeritas");
			heroRepo.save(hero4);
			Hero hero5 = new Hero("Magneta");
			heroRepo.save(hero5);
			Hero hero6 = new Hero("RubberMan");
			heroRepo.save(hero6);
			Hero hero7 = new Hero("Dynama");
			heroRepo.save(hero7);
			Hero hero8 = new Hero("Dr IQ");
			heroRepo.save(hero8);
			Hero hero9 = new Hero("Magma");
			heroRepo.save(hero9);
			Hero hero10 = new Hero("Tornado");
			heroRepo.save(hero10);
			
		}
		return heroRepo.findAll();
	}
	
	public Hero findById(long id) {
		return heroRepo.findById(id);
	}
	
	public void save(Hero hero) {
		heroRepo.save(hero);
	}
	
	public void deleteById(long id) {
		heroRepo.deleteById(id);
	}
	
	public List<Hero> findByName(String name){
		return heroRepo.findAllByName(name);
	}
	
	public List<Hero> findByNameUpdated(String name){
		List<Hero> all = heroRepo.findAll();
		List<Hero> found = new ArrayList<>();
		
		for(int i = 0; i < all.size(); i ++) {
			int counter = 0;
			for(int y = 0; y < name.length(); y++) {
				if(Character.toUpperCase(name.charAt(y)) == Character.toUpperCase(all.get(i).getName().charAt(y))) {
					counter++;
				}
			}
			if(counter == name.length()) {
				found.add(all.get(i));
			}
		}
		
		return found;
	}
	

}

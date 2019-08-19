package Ang.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Ang.Model.Hero;
import Ang.Service.HeroService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MainController {
	
	private HeroService heroService;
	
	@Autowired
	public MainController(HeroService heroService) {
		this.heroService = heroService;
	}
	
	@GetMapping("/HeroesByName")
	public List<Hero> getAllHerosByName(@RequestParam String name){
		return heroService.findByNameUpdated(name);
	}

	@GetMapping("/Heroes/{id}")
	public Hero getHeroById(@PathVariable("id") long id) {
		return heroService.findById(id);
	}
	
	@GetMapping("/Heroes")
	public List<Hero> getAllHeroes(){
		return this.heroService.findAll();
	}
	
	@PutMapping("/Heroes")
	public void updateAHero(@RequestBody Hero hero) {
		heroService.save(hero);
	}
	
	@PostMapping("/Heroes")
	public void createANewHero(@RequestBody Hero hero) {
		heroService.save(hero);
	}
	
	@DeleteMapping("/Heroes")
	public void deleteHero(@RequestParam long id) {
		heroService.deleteById(id);
	}
	

}

package Ang.Repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Ang.Model.Hero;

@Repository
public interface HeroRepo extends CrudRepository <Hero,Long> {
	
	List<Hero> findAll();
	
	Hero findById(long id);
	
	List<Hero> findAllByName(String name);

}

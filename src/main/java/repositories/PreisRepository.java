package repositories;

import java.util.List;
import java.util.Optional;

import entities.Preis;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PreisRepository extends JpaRepository<Preis, Long> {

	//NEED HELP HERE?
	
	List<Preis> findAllByOrderByName();

	Optional<Preis> findByName(String name);

}
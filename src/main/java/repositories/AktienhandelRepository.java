package repositories;

import java.util.List;
import java.util.Optional;

import entities.Aktienhandel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AktienhandelRepository extends JpaRepository<Aktienhandel, Long> {

	
	//NEED HELP HERE?
	List<Aktienhandel> findAllByOrderByName();

	//Optional<Aktienhandel> findByName(String name);

}
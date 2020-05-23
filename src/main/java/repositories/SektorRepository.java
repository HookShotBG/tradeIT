package repositories;

import java.util.List;
import java.util.Optional;

import entities.Sektor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SektorRepository extends JpaRepository<Sektor, Long> {

	List<Sektor> findAllByOrderByName();

	Optional<Sektor> findByName(String industriegebiet);

}
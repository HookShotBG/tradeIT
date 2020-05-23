package repositories;

import java.util.List;
import java.util.Optional;

import entities.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresseRepository extends JpaRepository<Adresse, Long> {

	List<Adresse> findAllByOrderByName();

	Optional<Adresse> findByName(String ort);

}
package repositories;

import java.util.List;
import java.util.Optional;

import entities.Kreditkartenanbieter;
import org.springframework.data.jpa.repository.JpaRepository;


public interface KreditkartenanbieterRepository extends JpaRepository<Kreditkartenanbieter, Long> {

List<Kreditkartenanbieter> findAllByOrderByName();

Optional<Kreditkartenanbieter> findByName(String name);

}
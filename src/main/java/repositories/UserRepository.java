package repositories;

import java.util.List;
import java.util.Optional;

import entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findAllByOrderByName();

	Optional<User> findByName(String name);

}
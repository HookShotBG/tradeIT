package repositories;

import java.util.List;
import java.util.Optional;

import entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CountryRepository extends JpaRepository<Country, Long> {

List<Country> findAllByOrderByName();

Optional<Country> findByName(String countryName);

}
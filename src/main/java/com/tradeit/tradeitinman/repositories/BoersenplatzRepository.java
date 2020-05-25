package com.tradeit.tradeitinman.repositories;

import com.tradeit.tradeitinman.entities.Boersenplatz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface BoersenplatzRepository extends JpaRepository<Boersenplatz, Long> {

List<Boersenplatz> findAllByOrderByName();

Optional<Boersenplatz> findByName(String name);

}
package com.infom.tradeit.demo.repositories;

import java.util.List;
import java.util.Optional;

import com.infom.tradeit.demo.entities.Boersenplatz;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoersenplatzRepository extends JpaRepository<Boersenplatz, Long> {

List<Boersenplatz> findAllByOrderByName();

Optional<Boersenplatz> findByName(String name);

}
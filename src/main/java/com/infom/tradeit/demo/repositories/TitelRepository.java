package com.infom.tradeit.demo.repositories;

import java.util.List;
import java.util.Optional;

import com.infom.tradeit.demo.entities.Aktie;
import com.infom.tradeit.demo.entities.Titel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TitelRepository extends JpaRepository<Titel, Long> {

	List<Aktie> findAllByOrderByName();

	Optional<Aktie> findByName(String name);

}
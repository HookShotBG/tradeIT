package com.infom.tradeit.demo.repositories;

import java.util.List;
import java.util.Optional;

import com.infom.tradeit.demo.entities.Preis;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PreisRepository extends JpaRepository<Preis, Long> {

	//NEED HELP HERE?
	
	List<Preis> findAllByOrderByPreis();

	//Optional<Preis> findByName(String name);

}
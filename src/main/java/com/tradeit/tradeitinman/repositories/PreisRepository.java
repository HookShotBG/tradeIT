package com.tradeit.tradeitinman.repositories;


import com.tradeit.tradeitinman.entities.Preis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PreisRepository extends JpaRepository<Preis, Long> {

	//NEED HELP HERE?
	
	List<Preis> findAllByOrderByPreis();

	//Optional<Preis> findByName(String name);

}
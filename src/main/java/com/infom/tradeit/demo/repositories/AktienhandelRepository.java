package com.infom.tradeit.demo.repositories;

import java.util.List;

import com.infom.tradeit.demo.entities.Aktienhandel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AktienhandelRepository extends JpaRepository<Aktienhandel, Long> {

	
	//NEED HELP HERE?
	List<Aktienhandel> findAllByOrderByIdTitel();

	//Optional<Aktienhandel> findByName(String name);

}
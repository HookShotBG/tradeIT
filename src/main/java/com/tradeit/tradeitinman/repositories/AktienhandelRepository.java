package com.tradeit.tradeitinman.repositories;


import com.tradeit.tradeitinman.entities.Aktienhandel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AktienhandelRepository extends JpaRepository<Aktienhandel, Long> {

	
	//NEED HELP HERE?
	List<Aktienhandel> findAllByOrderByInvested();

	//Optional<Aktienhandel> findByName(String name);

}
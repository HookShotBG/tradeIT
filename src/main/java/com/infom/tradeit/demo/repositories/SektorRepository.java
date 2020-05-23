package com.infom.tradeit.demo.repositories;

import java.util.List;
import java.util.Optional;

import com.infom.tradeit.demo.entities.Sektor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SektorRepository extends JpaRepository<Sektor, Long> {

	List<Sektor> findAllByOrderByIndustriegebiet();

	//Optional<Sektor> findByName(String industriegebiet);

}
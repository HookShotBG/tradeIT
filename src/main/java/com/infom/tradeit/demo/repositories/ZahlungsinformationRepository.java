package com.infom.tradeit.demo.repositories;

import java.util.List;
import java.util.Optional;

import com.infom.tradeit.demo.entities.Kreditkartenanbieter;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ZahlungsinformationRepository extends JpaRepository<Kreditkartenanbieter, Long> {

List<Kreditkartenanbieter> findAllByOrderByName();

Optional<Kreditkartenanbieter> findByName(int kreditkartennr);

}
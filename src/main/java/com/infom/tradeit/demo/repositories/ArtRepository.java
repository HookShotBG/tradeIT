package com.infom.tradeit.demo.repositories;

import java.util.List;
import java.util.Optional;

import com.infom.tradeit.demo.entities.Art;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArtRepository extends JpaRepository<Art, Long> {

List<Art> findAllByOrderByName();

Optional<Art> findByName(String name);

}
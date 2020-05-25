package com.tradeit.tradeitinman.repositories;


import com.tradeit.tradeitinman.entities.Art;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ArtRepository extends JpaRepository<Art, Long> {

List<Art> findAllByOrderByName();

Optional<Art> findByName(String name);

}
package com.tradeit.tradeitinman.repositories;


import com.tradeit.tradeitinman.entities.Art;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface ArtRepository extends JpaRepository<Art, Long> {

    @Query("SELECT DISTINCT a from Art a where a.name = ?1 order by a.beschreibung")
    List<Art> selectDistOrderByName(String name);
    List<Art> findAllByOrderByName();

}
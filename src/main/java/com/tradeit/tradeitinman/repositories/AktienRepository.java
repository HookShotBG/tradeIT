package com.tradeit.tradeitinman.repositories;


import com.tradeit.tradeitinman.entities.Aktie;
import com.tradeit.tradeitinman.entities.Titel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AktienRepository extends JpaRepository<Aktie, Long> {
    List<Titel> findAllByOrderByName();

    Optional<Titel> findByName(String name);

}

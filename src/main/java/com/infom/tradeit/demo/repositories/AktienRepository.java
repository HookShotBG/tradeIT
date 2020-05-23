package com.infom.tradeit.demo.repositories;

import com.infom.tradeit.demo.entities.Aktie;
import com.infom.tradeit.demo.entities.Titel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AktienRepository extends JpaRepository<Aktie, Long> {
    List<Titel> findAllByOrderByName();

    Optional<Titel> findByName(String name);

}

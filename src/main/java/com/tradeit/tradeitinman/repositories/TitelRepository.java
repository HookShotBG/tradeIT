package com.tradeit.tradeitinman.repositories;

import com.tradeit.tradeitinman.entities.Aktie;
import com.tradeit.tradeitinman.entities.Titel;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface TitelRepository extends JpaRepository<Titel, Long> {

	List<Titel> findAllByOrderByName();

	List<Titel> findDistinctFirstByName(String name);

	List<Titel> findAllByOrderByCurrencyAsc();

	Optional<Titel> findDistinctFirstByNameContaining(String contains);

	Optional<Titel> findByValor(int valor);

}
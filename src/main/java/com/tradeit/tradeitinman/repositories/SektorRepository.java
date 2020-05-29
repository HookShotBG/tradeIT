package com.tradeit.tradeitinman.repositories;


import com.tradeit.tradeitinman.entities.Sektor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SektorRepository extends JpaRepository<Sektor, Long> {
}
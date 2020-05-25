package com.tradeit.tradeitinman.repositories;

import com.tradeit.tradeitinman.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findAllByOrderByGuthaben();

	//Optional<User> findByName(String name);

}
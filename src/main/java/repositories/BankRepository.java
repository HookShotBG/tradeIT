package repositories;

import java.util.List;
import java.util.Optional;

import entities.Bank;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BankRepository extends JpaRepository<Bank, Long> {

List<Bank> findAllByOrderByName();

Optional<Bank> findByName(String name);

}
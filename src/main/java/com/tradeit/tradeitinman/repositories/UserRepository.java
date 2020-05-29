package com.tradeit.tradeitinman.repositories;

import com.tradeit.tradeitinman.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findAllByOrderByGuthaben();

	@Query("SELECT distinct u FROM User u inner JOIN Aktienhandel akh on akh.datum > u.geburtsdatum WHERE u.guthaben > :money order by u.vorname")
	List<User> findUsersWithMoreMoneyThan(@Param("money") double guthaben);

	@Query("SELECT distinct u FROM User u inner JOIN Aktienhandel akh on akh.user = u.idUser and akh.datum > u.geburtsdatum WHERE u.guthaben > :money order by u.vorname")
	List<User> findUsersWithSomeAttributes(@Param("money") double guthaben);


	@Query("SELECT u FROM User u WHERE u.identitaetskartennr = ?1")
	User findUserByIdnr(String identitaetskartennr);

	@Query("SELECT u FROM User u WHERE u.identitaetskartennr LIKE ?1%")
	List<User> findUsersWhichContainIdnr(String identitaetskartennr);

	@Query("SELECT u FROM User u WHERE u.vorname = :vorname and u.nachname = :name")
	List<User> findUserByVorUndNachname(@Param("vorname") String vorname, @Param("name") String nachname);

}
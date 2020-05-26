package com.tradeit.tradeitinman.repositories;


import com.tradeit.tradeitinman.entities.Aktienhandel;
import com.tradeit.tradeitinman.entities.Titel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface AktienhandelRepository extends JpaRepository<Aktienhandel, Long> {


	List<Aktienhandel> findAllByOrderByInvested();

	Optional<Aktienhandel> findByTitel(Titel titel);

	Optional<Aktienhandel> findByIdAktienhandel(long id);


	//select akh.invested, akh.datum, akh.stop_loss, akh.take_profit, t.name, p.preis from aktienhandel akh inner join  titel t on akh.titel_id_titel=t.id_titel inner join preis p on akh.datum=p.valid_from inner join titel_preis tp on tp.titel_id_titel=t.id_titel and tp.preis_id_preis=p.id_preis;
	@Query("SELECT akh from Aktienhandel akh INNER JOIN Titel t on akh.titel=t.idTitel INNER JOIN Preis p on akh.datum=p.valid_from INNER JOIN t.preis tp ON tp.idPreis=p.idPreis")
	List<Aktienhandel> getDetailsfromAktienhandel();

}
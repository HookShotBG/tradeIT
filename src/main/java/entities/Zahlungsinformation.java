package entities;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Zahlungsinformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idZahlungsinformation;
	
	private int kreditkartennr;
	private String kreditkarteninhaber;
	private Date ablaufdatum;
	
	//do cardinality
	private Long idKreditkartenanbieter;

	public Long getIdZahlungsinformation() {
		return idZahlungsinformation;
	}

	public void setIdZahlungsinformation(Long idZahlungsinformation) {
		this.idZahlungsinformation = idZahlungsinformation;
	}

	public int getKreditkartennr() {
		return kreditkartennr;
	}

	public void setKreditkartennr(int kreditkartennr) {
		this.kreditkartennr = kreditkartennr;
	}

	public String getKreditkarteninhaber() {
		return kreditkarteninhaber;
	}

	public void setKreditkarteninhaber(String kreditkarteninhaber) {
		this.kreditkarteninhaber = kreditkarteninhaber;
	}

	public Date getAblaufdatum() {
		return ablaufdatum;
	}

	public void setAblaufdatum(Date ablaufdatum) {
		this.ablaufdatum = ablaufdatum;
	}

	public Long getIdKreditkartenanbieter() {
		return idKreditkartenanbieter;
	}

	public void setIdKreditkartenanbieter(Long idKreditkartenanbieter) {
		this.idKreditkartenanbieter = idKreditkartenanbieter;
	}
	
	
}

package entities;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Preis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPreis;
	
	private int preis;
	private Date valid_from;
	private Date valid_until;
	
	//do cardinality
	private Long idTitel;

	public Long getIdPreis() {
		return idPreis;
	}

	public void setIdPreis(Long idPreis) {
		this.idPreis = idPreis;
	}

	public int getPreis() {
		return preis;
	}

	public void setPreis(int preis) {
		this.preis = preis;
	}

	public Date getValid_from() {
		return valid_from;
	}

	public void setValid_from(Date valid_from) {
		this.valid_from = valid_from;
	}

	public Date getValid_until() {
		return valid_until;
	}

	public void setValid_until(Date valid_until) {
		this.valid_until = valid_until;
	}

	public Long getIdTitel() {
		return idTitel;
	}

	public void setIdTitel(Long idTitel) {
		this.idTitel = idTitel;
	}
	
	
}

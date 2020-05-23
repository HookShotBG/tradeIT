package entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kreditkartenanbieter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idKreditkartenAnbieter;
	
	private String name;
	
	//do cardinality
	private Long idCountry;
	
	//do cardinality
	private Long idBanke;

	public Long getIdKreditkartenAnbieter() {
		return idKreditkartenAnbieter;
	}

	public void setIdKreditkartenAnbieter(Long idKreditkartenAnbieter) {
		this.idKreditkartenAnbieter = idKreditkartenAnbieter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(Long idCountry) {
		this.idCountry = idCountry;
	}

	public Long getIdBanke() {
		return idBanke;
	}

	public void setIdBanke(Long idBanke) {
		this.idBanke = idBanke;
	}
	
	
}

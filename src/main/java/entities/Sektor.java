package entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sektor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSektor;
	
	private String industriegebiet;

	public Long getIdSektor() {
		return idSektor;
	}

	public void setIdSektor(Long idSektor) {
		this.idSektor = idSektor;
	}

	public String getIndustriegebiet() {
		return industriegebiet;
	}

	public void setIndustriegebiet(String industriegebiet) {
		this.industriegebiet = industriegebiet;
	}
	
	
}

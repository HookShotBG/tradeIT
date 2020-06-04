package com.tradeit.tradeitinman.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Adresse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAdresse;
	private String addresse;
	private String postleitzahl;
	private String ort;

	@ManyToMany
	private List<User> users;

	public Adresse() {
	}

	public Adresse(String adresse, String postleitzahl, String ort, List<User> users) {
		this.addresse = adresse;
		this.postleitzahl = postleitzahl;
		this.ort = ort;
		this.users = users;
	}

	public Long getIdAdresse() {return idAdresse;	}

	public void setIdAdresse(Long idAdresse) {this.idAdresse = idAdresse;}

	public String getAddresse() {return addresse;	}

	public void setAddresse(String addresse) {this.addresse = addresse;	}

	public String getPostleitzahl() {return postleitzahl;	}

	public void setPostleitzahl(String postleitzahl) {this.postleitzahl = postleitzahl;	}

	public String getOrt() {return ort;	}

	public void setOrt(String ort) {ort = ort;	}

	public List<User> getUsers() {return users;	}

	public void setUsers(List<User> users) {this.users = users;	}
}

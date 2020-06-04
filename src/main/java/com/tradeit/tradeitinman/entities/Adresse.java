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
	private String Ort;

	@ManyToMany
	private List<User> users;

	public Adresse() {
	}

	public Long getIdAdresse() {return idAdresse;	}

	public void setIdAdresse(Long idAdresse) {this.idAdresse = idAdresse;}

	public String getAddresse() {return addresse;	}

	public void setAddresse(String addresse) {this.addresse = addresse;	}

	public String getPostleitzahl() {return postleitzahl;	}

	public void setPostleitzahl(String postleitzahl) {this.postleitzahl = postleitzahl;	}

	public String getOrt() {return Ort;	}

	public void setOrt(String ort) {Ort = ort;	}

	public List<User> getUsers() {return users;	}

	public void setUsers(List<User> users) {this.users = users;	}
}

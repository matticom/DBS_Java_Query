package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kandidat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "KID")
	private 	long	kid;
	
	@Column(name = "VORNAME")
	private 	String 	vorname;
	
	@Column(name = "NACHNAME")
	private 	String	nachname;
	
	@Column(name = "GESCHLECHT")
	private 	String 	geschlecht;

	public Kandidat() {
	}

	public Kandidat(long kid, String vorname, String nachname, String geschlecht) {
		this.kid = kid;
		this.vorname = vorname;
		this.nachname = nachname;
		this.geschlecht = geschlecht;
	}

	public long getKid() {
		return kid;
	}

	public void setKid(long kid) {
		this.kid = kid;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}

	@Override
	public String toString() {
		return "Kandidat [kid=" + kid + ", vorname=" + vorname + ", nachname=" + nachname + ", geschlecht=" + geschlecht + "]";
	}
	
	
}

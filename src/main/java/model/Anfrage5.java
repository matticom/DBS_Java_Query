package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Anfrage5 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EID")
	private 	long	eId;
	
	@Column(name = "TITEL")
	private 	String 	titel;
	
	@Column(name = "Anzahl")
	private 	int numberOfQueries;
	

	public Anfrage5() {
		
	}

	public Anfrage5(long eId, String titel, int numberOfQueries) {
		this.eId = eId;
		this.titel = titel;
		this.numberOfQueries = numberOfQueries;
	}

	public long geteId() {
		return eId;
	}


	public void seteId(long eId) {
		this.eId = eId;
	}


	public String getTitel() {
		return titel;
	}


	public void setTitel(String titel) {
		this.titel = titel;
	}


	public int getNumberOfQueries() {
		return numberOfQueries;
	}


	public void setNumberOfQueries(int numberOfQueries) {
		this.numberOfQueries = numberOfQueries;
	}


	@Override
	public String toString() {
		return "Anfrage5 [eId=" + eId + ", titel=" + titel + ", numberOfQueries=" + numberOfQueries + "]";
	}

}

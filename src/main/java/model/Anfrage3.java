package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Anfrage3 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EID")
	private 	long	eId;
	
	@Column(name = "CLICKURL")
	private 	String 	clickURL;
	
	@Column(name = "MENGE")
	private 	int numberOfQueries;
	

	public Anfrage3() {
		
	}


	public Anfrage3(long eId, String clickURL, int numberOfQueries) {
		this.eId = eId;
		this.clickURL = clickURL;
		this.numberOfQueries = numberOfQueries;
	}


	public long geteId() {
		return eId;
	}


	public void seteId(long eId) {
		this.eId = eId;
	}


	public String getClickURL() {
		return clickURL;
	}


	public void setClickURL(String clickURL) {
		this.clickURL = clickURL;
	}


	public int getNumberOfQueries() {
		return numberOfQueries;
	}


	public void setNumberOfQueries(int numberOfQueries) {
		this.numberOfQueries = numberOfQueries;
	}


	@Override
	public String toString() {
		return "Anfrage3 [eId=" + eId + ", clickURL=" + clickURL + ", numberOfQueries=" + numberOfQueries + "]";
	}

}

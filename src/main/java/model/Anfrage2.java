package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Anfrage2 implements Anfrage_IF {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EID")
	private 	long	eId;
	
	@Column(name = "TAGESZEIT")
	private 	String 	date_HH24;
	
	@Column(name = "MENGE")
	private 	int numberOfQueries;
	

	public Anfrage2() {
		
	}


	public Anfrage2(long eId, String date_MMDD, int numberOfQueries) {
		this.eId = eId;
		this.date_HH24 = date_MMDD;
		this.numberOfQueries = numberOfQueries;
	}


	public long geteId() {
		return eId;
	}


	public void seteId(long eId) {
		this.eId = eId;
	}


	public String getDate_MMDD() {
		return date_HH24;
	}


	public void setDate_MMDD(String date_MMDD) {
		this.date_HH24 = date_MMDD;
	}


	public int getNumberOfQueries() {
		return numberOfQueries;
	}


	public void setNumberOfQueries(int numberOfQueries) {
		this.numberOfQueries = numberOfQueries;
	}

	@Override
	public String toString() {
		return "Anfrage2 [eId=" + eId + ", date_HH24=" + date_HH24 + ", numberOfQueries=" + numberOfQueries + "]";
	}
	
}

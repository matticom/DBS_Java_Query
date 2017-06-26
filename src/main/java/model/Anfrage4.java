package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Anfrage4 implements Anfrage_IF {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EID")
	private 	long	eId;
	
	@Column(name = "DATUM")
	private 	String 	date_MMDD;
	
	@Column(name = "MENGE")
	private 	int numberOfQueries;
	

	public Anfrage4() {
		
	}


	public Anfrage4(long eId, String date_MMDD, int numberOfQueries) {
		this.eId = eId;
		this.date_MMDD = date_MMDD;
		this.numberOfQueries = numberOfQueries;
	}


	public long geteId() {
		return eId;
	}


	public void seteId(long eId) {
		this.eId = eId;
	}


	public String getDate_MMDD() {
		return date_MMDD;
	}


	public void setDate_MMDD(String date_MMDD) {
		this.date_MMDD = date_MMDD;
	}


	public int getNumberOfQueries() {
		return numberOfQueries;
	}


	public void setNumberOfQueries(int numberOfQueries) {
		this.numberOfQueries = numberOfQueries;
	}


	@Override
	public String toString() {
		return "Anfrage4 [eId=" + eId + ", date_MMDD=" + date_MMDD + ", numberOfQueries=" + numberOfQueries + "]";
	}


}

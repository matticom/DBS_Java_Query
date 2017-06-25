package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Anfrage9 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EID")
	private 	long	eId;
	
	@Column(name = "NAME")
	private 	String 	name;
	
	@Column(name = "TAG")
	private 	String 	date_MMDD;
	
	@Column(name = "MENGE")
	private 	int numberOfQueries;
	

	public Anfrage9() {
		
	}

	public Anfrage9(long eId, String name, String date_MMDD, int numberOfQueries) {
		this.eId = eId;
		this.name = name;
		this.date_MMDD = date_MMDD;
		this.numberOfQueries = numberOfQueries;
	}

	public long geteId() {
		return eId;
	}


	public void seteId(long eId) {
		this.eId = eId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "Anfrage9 [eId=" + eId + ", name=" + name + ", date_MMDD=" + date_MMDD + ", numberOfQueries=" + numberOfQueries + "]";
	}

}

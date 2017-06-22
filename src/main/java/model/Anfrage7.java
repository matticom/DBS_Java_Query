package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Anfrage7 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EID")
	private 	long	eId;
	
	@Column(name = "NAME")
	private 	String 	name;
	
	@Column(name = "ANZAHL_DER_SUCHANFRAGEN")
	private 	int numberOfQueries;
	
	@Column(name = "STATUS")
	private 	String 	status;
	
	public Anfrage7() {
		
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

	public int getNumberOfQueries() {
		return numberOfQueries;
	}

	public void setNumberOfQueries(int numberOfQueries) {
		this.numberOfQueries = numberOfQueries;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Anfrage7 [eId=" + eId + ", name=" + name + ", numberOfQueries=" + numberOfQueries + ", status=" + status
				+ "]";
	}
}

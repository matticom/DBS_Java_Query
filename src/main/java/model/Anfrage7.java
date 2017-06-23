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
	
	@Column(name = "VNAME")
	private 	String 	vname;
	
	@Column(name = "NNAME")
	private 	String 	nname;
	
	@Column(name = "ANZAHL_DER_SUCHANFRAGEN")
	private 	int numberOfQueries;
	
	@Column(name = "STATUS")
	private 	String 	status;
	
	public Anfrage7() {
		
	}

	public Anfrage7(long eId, String vname, String nname, int numberOfQueries, String status) {
		this.eId = eId;
		this.vname = vname;
		this.nname = nname;
		this.numberOfQueries = numberOfQueries;
		this.status = status;
	}

	public long geteId() {
		return eId;
	}

	public void seteId(long eId) {
		this.eId = eId;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public String getNname() {
		return nname;
	}

	public void setNname(String nname) {
		this.nname = nname;
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
		return "Anfrage7 [eId=" + eId + ", vname=" + vname + ", nname=" + nname + ", numberOfQueries=" + numberOfQueries + ", status=" + status + "]";
	}
	
}

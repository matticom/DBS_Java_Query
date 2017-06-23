package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Anfrage6 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EID")
	private 	long	eId;
	
	@Column(name = "DATE_MM_DD")
	private 	String 	date_MMDD;
	
	@Column(name = "SENDUNGSNAME")
	private 	String	show;
	
	@Column(name = "SUCHANFRAGEN_MENGE")
	private 	int numberOfQueries;
	
	@Column(name = "ZUSCHAUERANZAHL")
	private 	int numberOfViewers;

	public Anfrage6() {
	}

	public Anfrage6(long eId, String date_MMDD, String show, int numberOfQueries, int numberOfViewers) {
		this.eId = eId;
		this.date_MMDD = date_MMDD;
		this.show = show;
		this.numberOfQueries = numberOfQueries;
		this.numberOfViewers = numberOfViewers;
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

	public String getShow() {
		return show;
	}

	public void setShow(String show) {
		this.show = show;
	}

	public int getNumberOfQueries() {
		return numberOfQueries;
	}

	public void setNumberOfQueries(int numberOfQueries) {
		this.numberOfQueries = numberOfQueries;
	}

	public int getNumberOfViewers() {
		return numberOfViewers;
	}

	public void setNumberOfViewers(int numberOfViewers) {
		this.numberOfViewers = numberOfViewers;
	}

	@Override
	public String toString() {
		return "Anfrage6 [eId=" + eId + ", date_MMDD=" + date_MMDD + ", show=" + show + ", numberOfQueries=" + numberOfQueries + ", numberOfViewers=" + numberOfViewers + "]";
	}

	
}

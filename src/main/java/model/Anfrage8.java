package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Anfrage8 implements Anfrage_IF {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EID")
	private 	long	eId;
	
	@Column(name = "ITEMRANK")
	private 	String 	itemRank;
	
	@Column(name = "MENGE")
	private 	int numberOfQueries;
	

	public Anfrage8() {
		
	}

	public Anfrage8(long eId, String itemRank, int numberOfQueries) {
		this.eId = eId;
		this.itemRank = itemRank;
		this.numberOfQueries = numberOfQueries;
	}

	public long geteId() {
		return eId;
	}


	public void seteId(long eId) {
		this.eId = eId;
	}
	
	public String getItemRank() {
		return itemRank;
	}

	public void setItemRank(String itemRank) {
		this.itemRank = itemRank;
	}

	public int getNumberOfQueries() {
		return numberOfQueries;
	}


	public void setNumberOfQueries(int numberOfQueries) {
		this.numberOfQueries = numberOfQueries;
	}

	@Override
	public String toString() {
		return "Anfrage8 [eId=" + eId + ", itemRank=" + itemRank + ", numberOfQueries=" + numberOfQueries + "]";
	}

}

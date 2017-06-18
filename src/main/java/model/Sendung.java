package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Sendung {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SID")
	private 	long	sid;
	
	@Column(name = "AIR_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private 	Date 	airDate;
	
	@Column(name = "ORT")
	private 	String 	ort;
	
	@Column(name = "SENDUNGSNAME")
	private 	String	sendungsname;
	
	@Column(name = "MID")
	private 	long 	mid;
	
	@Column(name = "ZUSCHAUERANZAHL")
	private 	int	zuschauerAnzahl;
			
	public Sendung() {
	}

	public long getSid() {
		return sid;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}

	public Date getAirDate() {
		return airDate;
	}

	public void setAirDate(Date airDate) {
		this.airDate = airDate;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getSendungsname() {
		return sendungsname;
	}

	public void setSendungsname(String sendungsname) {
		this.sendungsname = sendungsname;
	}

	public long getMid() {
		return mid;
	}

	public void setMid(long mid) {
		this.mid = mid;
	}

	public int getZuschauerAnzahl() {
		return zuschauerAnzahl;
	}

	public void setZuschauerAnzahl(int zuschauerAnzahl) {
		this.zuschauerAnzahl = zuschauerAnzahl;
	}

	@Override
	public String toString() {
		return "Sendung [sid=" + sid + ", airDate=" + airDate + ", ort=" + ort + ", sendungsname=" + sendungsname + ", mid=" + mid + ", zuschauerAnzahl=" + zuschauerAnzahl + "]";
	}

		

	/**
	 * @param myPerson_Storage
	 * This method persists "this" instance and calls in Person_Storage the methid insertPerson (...) 
	 */
//	public void persist(Person_Storage myPerson_Storage) {
//		myPerson_Storage.insertPerson(person_id, first_name, last_name, born_date);
//	}

	
	/**
	 * @param first_name
	 * @param last_name
	 * @param born_date
	 * @return sha1
	 * 
	 * This method invokes the java crypt library with attributes first_name, last_name, born_date. 
	 * The method outputs a sha1 id which is unique for each person.  
	 */
//	private long generatePerson_ID(String first_name, String last_name, Date born_date) 
//	{
//		long sha1 = 0;
//	    try
//	    {
//	        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
//	        crypt.reset();
//	        String phrase = first_name + last_name + born_date.toString()+ Long.toString(System.currentTimeMillis());
//	        crypt.update(phrase.getBytes("UTF-8"));
//	        sha1 = byteToLong(crypt.digest());
//	    }
//	    catch(NoSuchAlgorithmException e)
//	    {
//	        e.printStackTrace();
//	    }
//	    catch(UnsupportedEncodingException e)
//	    {
//	        e.printStackTrace();
//	    }
//	    if (sha1 < 0) 
//	    	sha1 = sha1*-1;  
//	    return sha1;
//	}

//	private static long byteToLong(byte[]  by)
//	{
//		long value = 0;
//		for (int i = 0; i < by.length; i++)
//		{
//		   value += ((long) by[i] & 0xffL) << (8 * i);
//		}	
//		return value;
//	}
	
	

}

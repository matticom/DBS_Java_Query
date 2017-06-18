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
public class QueryData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private 	long	id;
	
	@Column(name = "ANONID")
	private 	String 	anonID;
	
	@Column(name = "QUERY")
	private 	String	query;
	
	@Column(name = "QUERYTIME")
	@Temporal(TemporalType.TIMESTAMP)
	private 	Date 	querytime;
	
	@Column(name = "ITEMRANK")
	private 	int 	itemRank;
	
	@Column(name = "CLICKURL")
	private 	String	clickURL;
			
	public QueryData() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAnonID() {
		return anonID;
	}

	public void setAnonID(String anonID) {
		this.anonID = anonID;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public Date getQuerytime() {
		return querytime;
	}

	public void setQuerytime(Date querytime) {
		this.querytime = querytime;
	}

	public int getItemRank() {
		return itemRank;
	}

	public void setItemRank(int itemRank) {
		this.itemRank = itemRank;
	}

	public String getClickURL() {
		return clickURL;
	}

	public void setClickURL(String clickURL) {
		this.clickURL = clickURL;
	}

	@Override
	public String toString() {
		return "AOL_Query [id=" + id + ", anonID=" + anonID + ", query=" + query + ", querytime=" + querytime + ", itemRank=" + itemRank + ", clickURL=" + clickURL + "]";
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

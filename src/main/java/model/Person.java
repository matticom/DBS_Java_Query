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
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PERSON_ID")
	private 	long	person_id;
	@Column(name = "FIRST_NAME")
	private 	String 	first_name;
	@Column(name = "LAST_NAME")
	private 	String	last_name;
	
	@Column(name = "BORN_DATE")
	@Temporal(TemporalType.DATE)
	private 	Date 	born_date;
	
			
	public Person() {
	}

	public Person(String first_name, String last_name, Date born_date) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.born_date = born_date;
	}

	public long getPerson_id() {
		return person_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Date getBorn_date() {
		return born_date;
	}
	public void setBorn_date(Date born_date) {
		this.born_date = born_date;
	}

	@Override
	public String toString() {
		return "Person [person_id=" + person_id + ", first_name=" + first_name + ", last_name=" + last_name + ", born_date=" + born_date + "]";
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

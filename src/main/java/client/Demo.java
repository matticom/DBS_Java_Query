package client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.AOL_QueryDAO;
import dao.Anfrage6_DAO;
import dao.KandidatDAO;
import dao.PersonDAO;
import dao.SendungDAO;
import model.QueryData;
import model.Sendung;
import model.Anfrage6;
import model.Kandidat;
import model.Person;

public class Demo {

	private static EntityManagerFactory emfactory;
	private static EntityManager entitymanager;

	private PersonDAO personDAO;
	private KandidatDAO kandidatDAO;
	private AOL_QueryDAO aolQueryDAO;
	private SendungDAO sendungDAO;
	private Anfrage6_DAO anfrage6DAO;

	public void selectAll() {
		List<Person> personList = personDAO.selectAllPersons();
		for (Person person : personList) {
			System.out.println("\n-----------------------------------------------------------------------");
			System.out.println(person.toString());
			System.out.println("\n");
		}
		List<Kandidat> kandidatList = kandidatDAO.selectAllKandidats();
		for (Kandidat kandidat : kandidatList) {
			System.out.println("\n-----------------------------------------------------------------------");
			System.out.println(kandidat.toString());
			System.out.println("\n");
		}
//		List<QueryData> aolQueryList = aolQueryDAO.selectFirstAOLQueries();
//		for (QueryData aolQuery : aolQueryList) {
//			System.out.println(aolQuery.toString());
//		}
		List<Sendung> sendungList = sendungDAO.selectAllSendungen();
		for (Sendung sendung : sendungList) {
			System.out.println(sendung.toString());
		}
		
		List<Anfrage6> anfrage6List = anfrage6DAO.anfrage6();
		for (Anfrage6 anfrage6_Entity : anfrage6List) {
			System.out.println(anfrage6_Entity.toString());
		}
	}

	public void setUpDB() {
		try {
			emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA_Oracle");
			entitymanager = emfactory.createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		}

		personDAO = new PersonDAO(entitymanager);
		kandidatDAO = new KandidatDAO(entitymanager);
		aolQueryDAO = new AOL_QueryDAO(entitymanager);
		sendungDAO = new SendungDAO(entitymanager);
		anfrage6DAO = new Anfrage6_DAO(entitymanager);
	}
	
	public void tearDown() {
		entitymanager.close();
		emfactory.close();
	}
	
	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.setUpDB();
		demo.selectAll();
		demo.tearDown();
	}

}

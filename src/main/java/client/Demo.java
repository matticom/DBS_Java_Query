package client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.PersonDAO;
import model.Person;

public class Demo {

	private static EntityManagerFactory emfactory;
	private static EntityManager entitymanager;

	private PersonDAO personDAO;

	public void selectAll() {
		List<Person> personList = personDAO.selectAllPersons();
		for (Person person : personList) {
			System.out.println(person.toString());
			System.out.println("\n");
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

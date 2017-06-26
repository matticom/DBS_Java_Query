package dbDatenAbfragen;

import java.time.Instant;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.Anfragen_DAO;
import model.Anfrage_IF;


public class AnfragenDBzuList {
	
	private static EntityManagerFactory emfactory;
	private static EntityManager entitymanager;
	
	private Anfragen_DAO anfrageDAO;

	public List<? extends Anfrage_IF> getDataFromDB(Anfragen anfrage) {
		setUpDB();
		List<? extends Anfrage_IF> anfrageList = null;
				
		long start = Instant.now().getEpochSecond();
		
		switch (anfrage) {
		case Anfrage1:
			anfrageList = anfrageDAO.anfrage1();
			break;
		case Anfrage2:
			anfrageList = anfrageDAO.anfrage2();
			break;
		case Anfrage3:
			anfrageList = anfrageDAO.anfrage3();
			break;
		case Anfrage4:
			anfrageList = anfrageDAO.anfrage4();
			break;
		case Anfrage5:
			anfrageList = anfrageDAO.anfrage5();
			break;
		case Anfrage6:
			anfrageList = anfrageDAO.anfrage6();
			break;
		case Anfrage7:
			anfrageList = anfrageDAO.anfrage7();
			break;
		case Anfrage8:
			anfrageList = anfrageDAO.anfrage8();
			break;
		case Anfrage9:
			anfrageList = anfrageDAO.anfrage9();
			break;
		case Anfrage10_MOD:
			anfrageList = anfrageDAO.anfrage10_MOD();
			break;
		case Anfrage10_JUR:
			anfrageList = anfrageDAO.anfrage10_JUR();
			break;
		}
		
		long ende = Instant.now().getEpochSecond();
		System.err.println("Die Anfrage benötigte " + (ende-start) + " Sekunden");
		tearDown();
		return anfrageList;
	}

	protected void setUpDB() {
		try {
			emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA_Oracle");
			entitymanager = emfactory.createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		}

		anfrageDAO = new Anfragen_DAO(entitymanager);
	}
	
	protected void tearDown() {
		entitymanager.close();
		emfactory.close();
	}
}

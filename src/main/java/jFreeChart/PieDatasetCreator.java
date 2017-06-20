package jFreeChart;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import dao.KandidatDAO;
import model.Kandidat;


public class PieDatasetCreator {
	
	private static EntityManagerFactory emfactory;
	private static EntityManager entitymanager;
	
	protected List<Kandidat> kandidatList;
	protected DefaultPieDataset kandidatenPieDataset;
	private KandidatDAO kandidatDAO;
	
	
	public static PieDataset createKandidatenPieDataset() {
		PieDatasetCreator creator = new PieDatasetCreator();
		creator.setUpDB();
		creator.selectKandidaten();
		creator.createPieDatasetFromList();
		creator.tearDown();
		return creator.kandidatenPieDataset;
	}

	protected void selectKandidaten() {
		kandidatList = kandidatDAO.selectAllKandidats();
	}
	
	protected void createPieDatasetFromList() {
		int female = 0;
		int male = 0;
		for(Kandidat kandidat: kandidatList) {
			if (kandidat.getGeschlecht().equals("w")) {
				female++;
			} else {
				male++;
			}
		}
		kandidatenPieDataset = new DefaultPieDataset( );
		kandidatenPieDataset.setValue( "Weibliche Kandidaten" , new Integer( female ) );  
		kandidatenPieDataset.setValue( "Männliche Kandidaten" , new Integer( male ) );           
	}

	protected void setUpDB() {
		try {
			emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA_Oracle");
			entitymanager = emfactory.createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
		kandidatDAO = new KandidatDAO(entitymanager);
	}
	
	protected void tearDown() {
		entitymanager.close();
		emfactory.close();
	}
}

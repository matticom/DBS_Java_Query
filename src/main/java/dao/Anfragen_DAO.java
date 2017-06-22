package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import model.Anfrage5;
import model.Anfrage6;
import model.Anfrage7;
import model.Kandidat;



public class Anfragen_DAO {
	private EntityManager entitymanager;

	public Anfragen_DAO(EntityManager entitymanager) {
		this.entitymanager = entitymanager;
	}

	public List<Anfrage5> anfrage5() {
		CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
		CriteriaQuery<Anfrage5> criteriaQuery = criteriaBuilder.createQuery(Anfrage5.class);
		Root<Anfrage5> entity = criteriaQuery.from(Anfrage5.class);
		criteriaQuery.select(entity);
		return entitymanager.createQuery(criteriaQuery).getResultList();
	}
	
	public List<Anfrage6> anfrage6() {
		CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
		CriteriaQuery<Anfrage6> criteriaQuery = criteriaBuilder.createQuery(Anfrage6.class);
		Root<Anfrage6> entity = criteriaQuery.from(Anfrage6.class);
		criteriaQuery.select(entity);
		return entitymanager.createQuery(criteriaQuery).getResultList();
	}
	
	public List<Anfrage7> anfrage7() {
		CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
		CriteriaQuery<Anfrage7> criteriaQuery = criteriaBuilder.createQuery(Anfrage7.class);
		Root<Anfrage7> entity = criteriaQuery.from(Anfrage7.class);
		criteriaQuery.select(entity);
		return entitymanager.createQuery(criteriaQuery).getResultList();
	}
}
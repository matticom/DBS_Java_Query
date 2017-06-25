package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import model.Anfrage1;
import model.Anfrage10_JUR;
import model.Anfrage10_MOD;
import model.Anfrage2;
import model.Anfrage3;
import model.Anfrage4;
import model.Anfrage5;
import model.Anfrage6;
import model.Anfrage7;
import model.Anfrage8;
import model.Anfrage9;
import model.Kandidat;



public class Anfragen_DAO {
	private EntityManager entitymanager;

	public Anfragen_DAO(EntityManager entitymanager) {
		this.entitymanager = entitymanager;
	}

	public List<Anfrage1> anfrage1() {
		CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
		CriteriaQuery<Anfrage1> criteriaQuery = criteriaBuilder.createQuery(Anfrage1.class);
		Root<Anfrage1> entity = criteriaQuery.from(Anfrage1.class);
		criteriaQuery.select(entity);
		return entitymanager.createQuery(criteriaQuery).getResultList();
	}
	
	public List<Anfrage2> anfrage2() {
		CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
		CriteriaQuery<Anfrage2> criteriaQuery = criteriaBuilder.createQuery(Anfrage2.class);
		Root<Anfrage2> entity = criteriaQuery.from(Anfrage2.class);
		criteriaQuery.select(entity);
		return entitymanager.createQuery(criteriaQuery).getResultList();
	}
	
	public List<Anfrage3> anfrage3() {
		CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
		CriteriaQuery<Anfrage3> criteriaQuery = criteriaBuilder.createQuery(Anfrage3.class);
		Root<Anfrage3> entity = criteriaQuery.from(Anfrage3.class);
		criteriaQuery.select(entity);
		return entitymanager.createQuery(criteriaQuery).getResultList();
	}
	
	public List<Anfrage4> anfrage4() {
		CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
		CriteriaQuery<Anfrage4> criteriaQuery = criteriaBuilder.createQuery(Anfrage4.class);
		Root<Anfrage4> entity = criteriaQuery.from(Anfrage4.class);
		criteriaQuery.select(entity);
		return entitymanager.createQuery(criteriaQuery).getResultList();
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
	
	public List<Anfrage8> anfrage8() {
		CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
		CriteriaQuery<Anfrage8> criteriaQuery = criteriaBuilder.createQuery(Anfrage8.class);
		Root<Anfrage8> entity = criteriaQuery.from(Anfrage8.class);
		criteriaQuery.select(entity);
		return entitymanager.createQuery(criteriaQuery).getResultList();
	}
	
	public List<Anfrage9> anfrage9() {
		CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
		CriteriaQuery<Anfrage9> criteriaQuery = criteriaBuilder.createQuery(Anfrage9.class);
		Root<Anfrage9> entity = criteriaQuery.from(Anfrage9.class);
		criteriaQuery.select(entity);
		return entitymanager.createQuery(criteriaQuery).getResultList();
	}
	
	public List<Anfrage10_MOD> anfrage10_MOD() {
		CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
		CriteriaQuery<Anfrage10_MOD> criteriaQuery = criteriaBuilder.createQuery(Anfrage10_MOD.class);
		Root<Anfrage10_MOD> entity = criteriaQuery.from(Anfrage10_MOD.class);
		criteriaQuery.select(entity);
		return entitymanager.createQuery(criteriaQuery).getResultList();
	}
	
	public List<Anfrage10_JUR> anfrage10_JUR() {
		CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
		CriteriaQuery<Anfrage10_JUR> criteriaQuery = criteriaBuilder.createQuery(Anfrage10_JUR.class);
		Root<Anfrage10_JUR> entity = criteriaQuery.from(Anfrage10_JUR.class);
		criteriaQuery.select(entity);
		return entitymanager.createQuery(criteriaQuery).getResultList();
	}
}
package dao;

import java.util.List;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.eclipse.persistence.expressions.Expression;
import org.eclipse.persistence.expressions.ExpressionBuilder;

import model.Kandidat;
import model.Person;
import model.QueryData;


public class Anfrage6_DAO {
	private EntityManager entitymanager;

	public Anfrage6_DAO(EntityManager entitymanager) {
		this.entitymanager = entitymanager;
	}

//	public Person create(Person customer) {
//		entitymanager.persist(customer);
//		return customer;
//	}

//	public Person selectById(int id) {
//		Person customer = entitymanager.find(Person.class, id);
//		if (customer == null) {
//			throw new NoResultException("Kein Kunde mit der ID gefunden");
//		}
//		return customer;
//	}
//
//	public Person selectByName(String name) throws NoResultException {
//		CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
//		CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
//
//		Root<Person> customer = criteriaQuery.from(Person.class);
//		Predicate whereFilter = criteriaBuilder.like(criteriaBuilder.lower(customer.get(Person_.name)), name.toLowerCase());
//		criteriaQuery.select(customer).where(whereFilter);
//
//		return entitymanager.createQuery(criteriaQuery).getSingleResult();
//	}

	public List<Person> selectAnfrage6() {
		
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<Tuple> cq = cb.createTupleQuery();
//		Root e = cq.from(Employee.class);
//		cq.multiselect(e.get("firstName").alias("first"), employee.get("lastName").alias("last"));
//		Query query = em.createQuery(cq);
//		List<Tuple> results = query.getResultList();
//		String first = results.get(0).get("first");
//		String last = results.get(0).get("last");
		
		
//		CriteriaQuery cq = cb.createQuery();
//		Root e = cq.from(Employee.class);
//		Subquery sq = cq.subquery(Employee.class);
//		Root e2 = cq.from(Employee.class);
//		sq.select(e2.get("salary"));
//		cq.where(cb.lessThan(e.get("salary"), cb.all(sq)));
//		Query query = em.createQuery(cq)
//		List<Employee> = query.getResultList();
		
//		CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
//		CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createTupleQuery();
//		Subquery<QueryData> sq = criteriaQuery.subquery(QueryData.class);
//		Root<Person> person = criteriaQuery.from(sq);
//		criteriaQuery.select(person);
//
//		return entitymanager.createQuery(criteriaQuery).getResultList();
		
		ExpressionBuilder kandidat = new ExpressionBuilder();
		Expression exp = kandidat.get("vorname").equal("Brenna");
//		Vector employees = session.readAllObjects(Kandidat.class,
//		                   exp.and(emp.get("salary").greaterThan(10000)));
		return null;
	}

//	public Person update(Person customer, Person newPerson) {
//		customer.setName(newPerson.getName());
//		return customer;
//	}
//
//	public void delete(Person customer) {
//		entitymanager.remove(customer);
//	}
	
	
//	private Translations selectTranslation(String normalName, String lang) throws NoResultException {
//
//		CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
//		CriteriaQuery<Translations> criteriaQuery = criteriaBuilder.createQuery(Translations.class);
//
//		Root<Translations> translation = criteriaQuery.from(Translations.class);
//		Join<Translations, Languages> langJoin = translation.join(Translations_.languages);
//
//		Predicate selectLanguage = criteriaBuilder.like(criteriaBuilder.lower(langJoin.get(Languages_.name)), lang.toLowerCase());
//		Predicate selectTermName = criteriaBuilder.like(criteriaBuilder.lower(translation.get(Translations_.normalName)), normalName.toLowerCase());
//		Predicate whereFilter = criteriaBuilder.and(selectLanguage, selectTermName);
//		criteriaQuery.select(translation).where(whereFilter);
//
//		Translations translationResult = entitymanager.createQuery(criteriaQuery).getSingleResult();
//
//		return translationResult;
//	}
}
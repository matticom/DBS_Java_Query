package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import model.QueryData;
import model.QueryData_;

public class AOL_QueryDAO {
	private EntityManager entitymanager;

	public AOL_QueryDAO(EntityManager entitymanager) {
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

	public List<QueryData> selectFirstAOLQueries() {
		CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
		CriteriaQuery<QueryData> criteriaQuery = criteriaBuilder.createQuery(QueryData.class);

		Root<QueryData> aolQuery = criteriaQuery.from(QueryData.class);
		Predicate whereFilter = criteriaBuilder.lessThan(aolQuery.get(QueryData_.id), (long)200);
		criteriaQuery.select(aolQuery).where(whereFilter);

		return entitymanager.createQuery(criteriaQuery).getResultList();
	}

//	public Person update(Person customer, Person newPerson) {
//		customer.setName(newPerson.getName());
//		return customer;
//	}
//
//	public void delete(Person customer) {
//		entitymanager.remove(customer);
//	}
}

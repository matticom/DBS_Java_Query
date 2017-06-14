package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import model.Person;
import model.Person_;

public class PersonDAO {
	private EntityManager entitymanager;

	public PersonDAO(EntityManager entitymanager) {
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

	public List<Person> selectAllPersons() {
		CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
		CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);

		Root<Person> person = criteriaQuery.from(Person.class);
		criteriaQuery.select(person);

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

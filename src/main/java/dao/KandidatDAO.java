package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import model.Kandidat;
import model.Kandidat_;

public class KandidatDAO {
	private EntityManager entitymanager;

	public KandidatDAO(EntityManager entitymanager) {
		this.entitymanager = entitymanager;
	}

//	public Kandidat create(Kandidat customer) {
//		entitymanager.persist(customer);
//		return customer;
//	}

//	public Kandidat selectById(int id) {
//		Kandidat customer = entitymanager.find(Kandidat.class, id);
//		if (customer == null) {
//			throw new NoResultException("Kein Kunde mit der ID gefunden");
//		}
//		return customer;
//	}
//
//	public Kandidat selectByName(String name) throws NoResultException {
//		CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
//		CriteriaQuery<Kandidat> criteriaQuery = criteriaBuilder.createQuery(Kandidat.class);
//
//		Root<Kandidat> customer = criteriaQuery.from(Kandidat.class);
//		Predicate whereFilter = criteriaBuilder.like(criteriaBuilder.lower(customer.get(Kandidat_.name)), name.toLowerCase());
//		criteriaQuery.select(customer).where(whereFilter);
//
//		return entitymanager.createQuery(criteriaQuery).getSingleResult();
//	}

	public List<Kandidat> selectAllKandidats() {
		CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
		CriteriaQuery<Kandidat> criteriaQuery = criteriaBuilder.createQuery(Kandidat.class);

		Root<Kandidat> kandidat = criteriaQuery.from(Kandidat.class);
		criteriaQuery.select(kandidat);

		return entitymanager.createQuery(criteriaQuery).getResultList();
	}

//	public Kandidat update(Kandidat customer, Kandidat newKandidat) {
//		customer.setName(newKandidat.getName());
//		return customer;
//	}
//
//	public void delete(Kandidat customer) {
//		entitymanager.remove(customer);
//	}
}

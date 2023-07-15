package it.softwaredoctor.chucknorris.repository.impl;


import java.util.ArrayList;
import java.util.List;


import it.softwaredoctor.chucknorris.entity.Battuta;
import it.softwaredoctor.chucknorris.repository.*; 
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

public class BattutaRepositoryImpl extends JpaRepositoryImpl<Battuta, Integer> implements BattutaRepository {

	@Override
	public List<Battuta> findAllOrderByDate() {
		List<Battuta> battute = new ArrayList<Battuta>();
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			TypedQuery<Battuta> query = em.createQuery("select b from Battuta b ORDER BY updatedAt",
					Battuta.class);
			battute = query.getResultList();
			tx.commit();
		} catch (PersistenceException e) {
			System.err.println(e.getMessage());
			if (tx != null && tx.isActive())
				tx.rollback();
		} finally {
			if (em != null)
				em.close();
		}
		return battute;
	}

	@Override
	public List<Battuta> findByValueoOrUpdatedAt(String term) {
		List<Battuta> battute = new ArrayList<Battuta>();
		EntityManager em = null;
		EntityTransaction tx = null;
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			TypedQuery<Battuta> query = em.createQuery(
					"select b from Battuta b WHERE b.value like :term OR b.updatedAt like :term",
					Battuta.class);
			query.setParameter("term", "%" + term + "%");
			battute = query.getResultList();
			tx.commit();
		} catch (PersistenceException e) {
			System.err.println(e.getMessage());
			if (tx != null && tx.isActive())
				tx.rollback();
		} finally {
			if (em != null)
				em.close();
		}
		return battute;
	
	}
	


}
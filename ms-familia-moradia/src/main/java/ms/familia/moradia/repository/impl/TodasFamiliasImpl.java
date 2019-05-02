package ms.familia.moradia.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ms.familia.moradia.models.Familias;

public interface TodasFamiliasImpl {
	
	EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("Finda");
	EntityManager entityManager = entityFactory.createEntityManager();
	
	@SuppressWarnings("unchecked")
	public static List<Familias> findByStatus(Integer status){
		
		try {
			entityManager.getTransaction().begin();
			
			List<Familias> resultList = entityManager.createNativeQuery(
					"select * from familias where status = ?",
					Familias.class)
					.setParameter(1, status)
					.getResultList();

			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			entityManager.close();
		}			
	}
}
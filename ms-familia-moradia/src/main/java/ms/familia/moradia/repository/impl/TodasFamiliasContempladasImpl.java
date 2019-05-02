package ms.familia.moradia.repository.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.cache.annotation.Cacheable;

import ms.familia.moradia.models.FamiliasContempladas;

public interface TodasFamiliasContempladasImpl {
	
	EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("Finda");
	EntityManager entityManager = entityFactory.createEntityManager();
	
	@Cacheable(value = "familiasContempladas")
	@SuppressWarnings("unchecked")
	public static List<FamiliasContempladas> findByData(Date data){
		
		entityManager.getTransaction().begin();
		
		try {
			List<FamiliasContempladas> resultList = entityManager.createNativeQuery(
					"select * from familias_contempladas where data = ?",
					FamiliasContempladas.class)
					.setParameter(1, data)
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

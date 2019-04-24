package org.gov.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.gov.model.FichaCampo;
import org.gov.util.JPAUtil;

public class FichaCampoDaoImpl implements FichaCampoDao {

	/**
	 *
	 */

	EntityManager entityManager = new JPAUtil().getEntityManager();


	public List<FichaCampo> fichasCampo() {

		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("FROM FichaCampo");

		List<FichaCampo> fichasCampo = query.getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();

		return fichasCampo;

	}


}

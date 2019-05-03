package org.gov.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.gov.model.ExportCnarh;
import org.gov.util.JPAUtil;

public class ExportCnarhDaoImpl implements Export_CnarhDao {

	/**
	 *
	 */
	private static final long serialVersionUID = 1485465443747692284L;
	/**
	 *
	 */

	EntityManager entityManager = new JPAUtil().getEntityManager();

	public List<ExportCnarh> exportCnarhs() {

		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("FROM ExportCnarh");

		List<ExportCnarh> exportCnarhs = query.getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();
		return exportCnarhs;

	}

}

package org.gov.dao;

import javax.persistence.EntityManager;

import org.gov.model.Industria;
import org.gov.util.JPAUtil;

public class IndustriaDaoImpl implements IndustriaDao {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	EntityManager entityManager;


	public String gravar(Industria industria) {
			entityManager = new JPAUtil().getEntityManager();

			entityManager.getTransaction().begin();
			entityManager.persist(industria);
			entityManager.getTransaction().commit();
			entityManager.close();

		return "ok";
	}

	public String remover(Integer id) {

		String retorno = null;

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		Industria industria = entityManager.find(Industria.class, id);

		if(industria != null) {

			entityManager.remove(industria);
			entityManager.getTransaction().commit();
			retorno = "ok";
		}
		entityManager.close();

		return retorno;
	}

	public String editar(Industria industria) {

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		entityManager.merge(industria);
		entityManager.getTransaction().commit();
		entityManager.close();

		return "ok";

	}



	public Industria pesquisar(int id) {

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		Industria abIndustria = entityManager.find(Industria.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();

		return abIndustria;
	}

}

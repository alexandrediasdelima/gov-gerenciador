package org.gov.dao;

import javax.persistence.EntityManager;

import org.gov.model.Asbama;
import org.gov.util.JPAUtil;

public class AsbamaDaoImpl implements AsbamaDao {





	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	EntityManager entityManager;


	public String gravar(Asbama asbama) {
			entityManager = new JPAUtil().getEntityManager();

			entityManager.getTransaction().begin();
			entityManager.persist(asbama);
			entityManager.getTransaction().commit();
			entityManager.close();

		return "ok";
	}

	public String remover(Integer id) {

		String retorno = null;

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		Asbama asbama = entityManager.find(Asbama.class, id);

		if(asbama != null) {

			entityManager.remove(asbama);
			entityManager.getTransaction().commit();
			retorno = "ok";
		}
		entityManager.close();

		return retorno;
	}

	public String editar(Asbama asbama) {

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		entityManager.merge(asbama);
		entityManager.getTransaction().commit();
		entityManager.close();

		return "ok";

	}



	public Asbama pesquisar(int id) {

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		Asbama abAsbama = entityManager.find(Asbama.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();

		return abAsbama;
	}

}

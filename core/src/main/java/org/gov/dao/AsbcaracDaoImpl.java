package org.gov.dao;

import javax.persistence.EntityManager;

import org.gov.model.Asbcarac;
import org.gov.util.JPAUtil;

public class AsbcaracDaoImpl implements AsbcaracDao {





	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	EntityManager entityManager;


	public String gravar(Asbcarac asbcarac) {
			entityManager = new JPAUtil().getEntityManager();

			entityManager.getTransaction().begin();
			entityManager.persist(asbcarac);
			entityManager.getTransaction().commit();
			entityManager.close();

		return "ok";
	}

	public String remover(Integer id) {

		String retorno = null;

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		Asbcarac asbcarac = entityManager.find(Asbcarac.class, id);

		if(asbcarac != null) {

			entityManager.remove(asbcarac);
			entityManager.getTransaction().commit();
			retorno = "ok";
		}
		entityManager.close();

		return retorno;
	}

	public String editar(Asbcarac asbcarac) {

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		entityManager.merge(asbcarac);
		entityManager.getTransaction().commit();
		entityManager.close();

		return "ok";

	}



	public Asbcarac pesquisar(int id) {

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		Asbcarac abAsbcarac = entityManager.find(Asbcarac.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();

		return abAsbcarac;
	}

}

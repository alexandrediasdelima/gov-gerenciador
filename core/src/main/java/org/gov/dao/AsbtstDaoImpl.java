package org.gov.dao;

import javax.persistence.EntityManager;

import org.gov.model.Asbtst;
import org.gov.util.JPAUtil;

public class AsbtstDaoImpl implements AsbtstDao {





	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	EntityManager entityManager;


	public String gravar(Asbtst asbtst) {
			entityManager = new JPAUtil().getEntityManager();

			entityManager.getTransaction().begin();
			entityManager.persist(asbtst);
			entityManager.getTransaction().commit();
			entityManager.close();

		return "ok";
	}

	public String remover(Integer id) {

		String retorno = null;

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		Asbtst asbtst = entityManager.find(Asbtst.class, id);

		if(asbtst != null) {

			entityManager.remove(asbtst);
			entityManager.getTransaction().commit();
			retorno = "ok";
		}
		entityManager.close();

		return retorno;
	}

	public String editar(Asbtst asbtst) {

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		entityManager.merge(asbtst);
		entityManager.getTransaction().commit();
		entityManager.close();

		return "ok";

	}



	public Asbtst pesquisar(int id) {

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		Asbtst abAsbtst = entityManager.find(Asbtst.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();

		return abAsbtst;
	}

}

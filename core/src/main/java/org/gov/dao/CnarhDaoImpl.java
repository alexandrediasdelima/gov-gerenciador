package org.gov.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.gov.model.Cnarh;
import org.gov.model.Usuario;
import org.gov.util.JPAUtil;

public class CnarhDaoImpl implements CnarhDao {



	/**
	 *
	 */
	private static final long serialVersionUID = 2417578921915142472L;

	EntityManager entityManager = new JPAUtil().getEntityManager();


	public String gravar(Cnarh cnarh) {

			entityManager.getTransaction().begin();
			entityManager.persist(cnarh);
			entityManager.getTransaction().commit();
			entityManager.close();

		return "ok";
	}



	public List<Cnarh> cnarhs() {

		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("FROM Cnarh ORDER BY cnarh_id");

		List<Cnarh> cnarhs = query.getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();

		return cnarhs;
	}

	public String remover(String id) {

		entityManager.getTransaction().begin();
		Cnarh cnarh = entityManager.find(Cnarh.class, id);

		entityManager.remove(cnarh);
		entityManager.getTransaction().commit();
		entityManager.close();

		return "ok";
	}

	public String editar(Cnarh cnarh) {

		entityManager.getTransaction().begin();
		entityManager.merge(cnarh);
		entityManager.getTransaction().commit();
		entityManager.close();

		return "ok";

	}

	public Cnarh pesquisar(String id) {

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		Cnarh cnarh = entityManager.find(Cnarh.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();

		return cnarh;
	}
	
}

package org.gov.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.gov.model.Apac;
import org.gov.model.Asbcarac;
import org.gov.util.JPAUtil;

public class AsbcaracDaoImpl implements AsbcaracDao {



	/**
	 *
	 */
	private static final long serialVersionUID = 2417578921915142472L;

	EntityManager entityManager = new JPAUtil().getEntityManager();


	public String gravar(Asbcarac asbcarac) {

			entityManager.getTransaction().begin();
			entityManager.persist(asbcarac);
			entityManager.getTransaction().commit();
			entityManager.close();

		return "ok";
	}



	public List<Apac> apacs() {

		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("FROM Apac");

		List<Apac> apacs = query.getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();

		return apacs;
	}

	public String remover(String id) {

		entityManager.getTransaction().begin();
		Apac apac = entityManager.find(Apac.class, id);

		entityManager.remove(apac);
		entityManager.getTransaction().commit();
		entityManager.close();

		return "ok";
	}

	public String editar(Apac apac) {

		entityManager.getTransaction().begin();
		entityManager.merge(apac);
		entityManager.getTransaction().commit();
		entityManager.close();

		return "ok";

	}



	public Asbcarac pesquisar(int id) {

		entityManager.getTransaction().begin();
		Asbcarac abAsbcarac = entityManager.find(Asbcarac.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();

		return abAsbcarac;
	}

}

package org.gov.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.gov.model.Apac;
import org.gov.util.JPAUtil;

public class ApacDaoImpl implements ApacDao {



	/**
	 *
	 */
	private static final long serialVersionUID = 2417578921915142472L;

	EntityManager entityManager = new JPAUtil().getEntityManager();


	public String gravar(Apac apac) {

			entityManager.getTransaction().begin();
			entityManager.persist(apac);
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

//	public String remover(int id) {
//
//		entityManager.getTransaction().begin();
//		Livro livro = entityManager.find(Livro.class, id);
//
//		entityManager.remove(livro);
//		entityManager.getTransaction().commit();
//		entityManager.close();
//
//		return "ok";
//	}

	public String editar(Apac apac) {

		entityManager.getTransaction().begin();
		entityManager.merge(apac);
		entityManager.getTransaction().commit();
		entityManager.close();

		return "ok";

	}

}

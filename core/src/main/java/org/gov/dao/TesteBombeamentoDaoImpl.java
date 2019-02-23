package org.gov.dao;

import javax.persistence.EntityManager;

import org.gov.model.TesteBombeamento;
import org.gov.util.JPAUtil;

public class TesteBombeamentoDaoImpl implements TesteBombeamentoDao {





	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	EntityManager entityManager;


	public String gravar(TesteBombeamento testeBombeamento) {
			entityManager = new JPAUtil().getEntityManager();

			entityManager.getTransaction().begin();
			entityManager.persist(testeBombeamento);
			entityManager.getTransaction().commit();
			entityManager.close();

		return "ok";
	}

	public String remover(Integer id) {

		String retorno = null;

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		TesteBombeamento testeBombeamento = entityManager.find(TesteBombeamento.class, id);

		if(testeBombeamento != null) {

			entityManager.remove(testeBombeamento);
			entityManager.getTransaction().commit();
			retorno = "ok";
		}
		entityManager.close();

		return retorno;
	}

	public String editar(TesteBombeamento testeBombeamento) {

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		entityManager.merge(testeBombeamento);
		entityManager.getTransaction().commit();
		entityManager.close();

		return "ok";

	}



	public TesteBombeamento pesquisar(int id) {

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		//TODO: Ta certo este nome de variavel?
		TesteBombeamento abTesteBombeamento = entityManager.find(TesteBombeamento.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();

		return abTesteBombeamento;
	}

}

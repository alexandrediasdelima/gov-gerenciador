package org.gov.dao;

import javax.persistence.EntityManager;

import org.gov.model.Vazao;
import org.gov.util.JPAUtil;

public class VazaoDaoImpl implements VazaoDao {





	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	EntityManager entityManager;


	public String gravar(Vazao vazao) {
			entityManager = new JPAUtil().getEntityManager();

			entityManager.getTransaction().begin();
			entityManager.persist(vazao);
			entityManager.getTransaction().commit();
			entityManager.close();

		return "ok";
	}

	public String remover(Integer id) {

		String retorno = null;

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		Vazao vazao = entityManager.find(Vazao.class, id);

		if(vazao != null) {

			entityManager.remove(vazao);
			entityManager.getTransaction().commit();
			retorno = "ok";
		}
		entityManager.close();

		return retorno;
	}

	public String editar(Vazao vazao) {

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		entityManager.merge(vazao);
		entityManager.getTransaction().commit();
		entityManager.close();

		return "ok";

	}



	public Vazao pesquisar(int id) {

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		//TODO: Ta certo este nome de variavel?
		Vazao abVazao = entityManager.find(Vazao.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();

		return abVazao;
	}

}

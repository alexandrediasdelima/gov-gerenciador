package org.gov.dao;

import javax.persistence.EntityManager;

import org.gov.model.Captacao;
import org.gov.util.JPAUtil;

public class CaptacaoDaoImpl implements CaptacaoDao {





	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	EntityManager entityManager;


	public String gravar(Captacao captacao) {
			entityManager = new JPAUtil().getEntityManager();

			entityManager.getTransaction().begin();
			entityManager.persist(captacao);
			entityManager.getTransaction().commit();
			entityManager.close();

		return "ok";
	}

	public String remover(Integer id) {

		String retorno = null;

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		Captacao captacao = entityManager.find(Captacao.class, id);

		if(captacao != null) {

			entityManager.remove(captacao);
			entityManager.getTransaction().commit();
			retorno = "ok";
		}
		entityManager.close();

		return retorno;
	}

	public String editar(Captacao captacao) {

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		entityManager.merge(captacao);
		entityManager.getTransaction().commit();
		entityManager.close();

		return "ok";

	}



	public Captacao pesquisar(int id) {

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		Captacao abCaptacao = entityManager.find(Captacao.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();

		return abCaptacao;
	}

}

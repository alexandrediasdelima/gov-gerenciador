package org.gov.dao;

import javax.persistence.EntityManager;

import org.gov.model.Lancamento;
import org.gov.util.JPAUtil;

public class LancamentoDaoImpl implements LancamentoDao {





	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	EntityManager entityManager;


	public String gravar(Lancamento lancamento) {
			entityManager = new JPAUtil().getEntityManager();

			entityManager.getTransaction().begin();
			entityManager.persist(lancamento);
			entityManager.getTransaction().commit();
			entityManager.close();

		return "ok";
	}

	public String remover(Integer id) {

		String retorno = null;

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		Lancamento lancamento = entityManager.find(Lancamento.class, id);

		if(lancamento != null) {

			entityManager.remove(lancamento);
			entityManager.getTransaction().commit();
			retorno = "ok";
		}
		entityManager.close();

		return retorno;
	}

	public String editar(Lancamento lancamento) {

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		entityManager.merge(lancamento);
		entityManager.getTransaction().commit();
		entityManager.close();

		return "ok";

	}



	public Lancamento pesquisar(int id) {

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		//TODO: Ta certo este nome de variavel?
		Lancamento abLancamento = entityManager.find(Lancamento.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();

		return abLancamento;
	}

}

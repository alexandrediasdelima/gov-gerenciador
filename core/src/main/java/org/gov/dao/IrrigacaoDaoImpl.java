package org.gov.dao;

import javax.persistence.EntityManager;

import org.gov.model.Irrigacao;
import org.gov.util.JPAUtil;

public class IrrigacaoDaoImpl implements IrrigacaoDao {





	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	EntityManager entityManager;


	public String gravar(Irrigacao irrigacao) {
			entityManager = new JPAUtil().getEntityManager();

			entityManager.getTransaction().begin();
			entityManager.persist(irrigacao);
			entityManager.getTransaction().commit();
			entityManager.close();

		return "ok";
	}

	public String remover(Integer id) {

		String retorno = null;

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		Irrigacao irrigacao = entityManager.find(Irrigacao.class, id);

		if(irrigacao != null) {

			entityManager.remove(irrigacao);
			entityManager.getTransaction().commit();
			retorno = "ok";
		}
		entityManager.close();

		return retorno;
	}

	public String editar(Irrigacao irrigacao) {

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		entityManager.merge(irrigacao);
		entityManager.getTransaction().commit();
		entityManager.close();

		return "ok";

	}



	public Irrigacao pesquisar(int id) {

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		//TODO: Ta certo este nome de variavel?
		Irrigacao abIrrigacao = entityManager.find(Irrigacao.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();

		return abIrrigacao;
	}

}

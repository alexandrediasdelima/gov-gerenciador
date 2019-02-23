package org.gov.dao;

import javax.persistence.EntityManager;

import org.gov.model.Pecuaria;
import org.gov.util.JPAUtil;

public class PecuariaDaoImpl implements PecuariaDao {





	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	EntityManager entityManager;


	public String gravar(Pecuaria pecuaria) {
			entityManager = new JPAUtil().getEntityManager();

			entityManager.getTransaction().begin();
			entityManager.persist(pecuaria);
			entityManager.getTransaction().commit();
			entityManager.close();

		return "ok";
	}

	public String remover(Integer id) {

		String retorno = null;

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		Pecuaria pecuaria = entityManager.find(Pecuaria.class, id);

		if(pecuaria != null) {

			entityManager.remove(pecuaria);
			entityManager.getTransaction().commit();
			retorno = "ok";
		}
		entityManager.close();

		return retorno;
	}

	public String editar(Pecuaria pecuaria) {

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		entityManager.merge(pecuaria);
		entityManager.getTransaction().commit();
		entityManager.close();

		return "ok";

	}



	public Pecuaria pesquisar(int id) {

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		//TODO: Ta certo este nome de variavel?
		Pecuaria abPecuaria = entityManager.find(Pecuaria.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();

		return abPecuaria;
	}

}

package org.gov.dao;

import javax.persistence.EntityManager;

import org.gov.model.ConsumoHumano;
import org.gov.util.JPAUtil;

public class ConsumoHumanoDaoImpl implements ConsumoHumanoDao {





	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	EntityManager entityManager;


	public String gravar(ConsumoHumano consumoHumano) {
			entityManager = new JPAUtil().getEntityManager();

			entityManager.getTransaction().begin();
			entityManager.persist(consumoHumano);
			entityManager.getTransaction().commit();
			entityManager.close();

		return "ok";
	}

	public String remover(Integer id) {

		String retorno = null;

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		ConsumoHumano consumoHumano = entityManager.find(ConsumoHumano.class, id);

		if(consumoHumano != null) {

			entityManager.remove(consumoHumano);
			entityManager.getTransaction().commit();
			retorno = "ok";
		}
		entityManager.close();

		return retorno;
	}

	public String editar(ConsumoHumano consumoHumano) {

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		entityManager.merge(consumoHumano);
		entityManager.getTransaction().commit();
		entityManager.close();

		return "ok";

	}



	public ConsumoHumano pesquisar(int id) {

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		ConsumoHumano abConsumoHumano = entityManager.find(ConsumoHumano.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();

		return abConsumoHumano;
	}

}

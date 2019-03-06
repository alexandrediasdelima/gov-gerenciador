package org.gov.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.gov.model.Lancamento;
import org.gov.model.OutraInfo;
import org.gov.util.JPAUtil;

public class OutraInfoDaoImpl implements OutraInfoDao {



	/**
	 *
	 */
	private static final long serialVersionUID = 2417578921915142472L;

	EntityManager entityManager;


	public String gravar(OutraInfo outrainfo) {
			entityManager = new JPAUtil().getEntityManager();

			entityManager.getTransaction().begin();
			entityManager.persist(outrainfo);
			entityManager.getTransaction().commit();
			entityManager.close();

		return "ok";
	}

	public String remover(Integer id) {

		String retorno = null;

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		OutraInfo outrainfo = entityManager.find(OutraInfo.class, id);

		if(outrainfo != null) {

			entityManager.remove(outrainfo);
			entityManager.getTransaction().commit();
			retorno = "ok";
		}
		entityManager.close();

		return retorno;
	}

	public String editar(OutraInfo outrainfo) {

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		entityManager.merge(outrainfo);
		entityManager.getTransaction().commit();
		entityManager.close();

		return "ok";

	}



	public OutraInfo pesquisar(int id) {

		entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		OutraInfo outrainfo = entityManager.find(OutraInfo.class, id);
		entityManager.getTransaction().commit();
		entityManager.close();

		return outrainfo;
	}

}

package org.gov.dao;

import javax.persistence.EntityManager;

import org.gov.model.Interferencia;
import org.gov.util.JPAUtil;

public class InterferenciaDaoImpl implements InterferenciaDao {


	/**
	 *
	 */
	private static final long serialVersionUID = 6708511625522519225L;

	EntityManager entityManager = new JPAUtil().getEntityManager();


	public String gravar(Interferencia interferencia) {

			entityManager.getTransaction().begin();
			entityManager.persist(interferencia);
			entityManager.getTransaction().commit();
			entityManager.close();

		return "ok";
	}



//	public List<Apac> apacs() {
//
//		entityManager.getTransaction().begin();
//		Query query = entityManager.createQuery("FROM Apac");
//
//		List<Apac> apacs = query.getResultList();
//
//		entityManager.getTransaction().commit();
//		entityManager.close();
//
//		return apacs;
//	}
//
//	public String remover(String id) {
//
//		entityManager.getTransaction().begin();
//		Apac apac = entityManager.find(Apac.class, id);
//
//		entityManager.remove(apac);
//		entityManager.getTransaction().commit();
//		entityManager.close();
//
//		return "ok";
//	}
//
//	public String editar(Apac apac) {
//
//		entityManager.getTransaction().begin();
//		entityManager.merge(apac);
//		entityManager.getTransaction().commit();
//		entityManager.close();
//
//		return "ok";
//
//	}

}

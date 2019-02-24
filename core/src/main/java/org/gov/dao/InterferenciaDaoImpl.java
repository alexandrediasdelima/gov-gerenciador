package org.gov.dao;

import javax.persistence.EntityManager;
import org.gov.model.Interferencia;
import org.gov.util.JPAUtil;
import java.util.List;
import javax.persistence.Query;

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

	public List<Interferencia> interferencias() {

		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("FROM Interferencia");

		List<Interferencia> interferencias = query.getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();

		return interferencias;
	}

	public String remover(Integer id) {

		entityManager.getTransaction().begin();
		Interferencia interferencia = entityManager.find(Interferencia.class, id);

		entityManager.remove(interferencia);
		entityManager.getTransaction().commit();
		entityManager.close();

		return "ok";
	}

	public String editar(Interferencia interferencia) {

		entityManager.getTransaction().begin();
		entityManager.merge(interferencia);
		entityManager.getTransaction().commit();
		entityManager.close();

		return "ok";

	}

}

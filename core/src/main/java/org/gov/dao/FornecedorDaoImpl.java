package org.gov.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.gov.model.Asbama;
import org.gov.model.Fornecedor;
import org.gov.model.Interferencia;
import org.gov.model.Usuario;
import org.gov.util.JPAUtil;

public class FornecedorDaoImpl implements FornecedorDao {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	EntityManager entityManager = new JPAUtil().getEntityManager();

	public String gravar(Fornecedor fornecedor) {

		entityManager.getTransaction().begin();
		entityManager.persist(fornecedor);
		entityManager.getTransaction().commit();
		entityManager.close();

		return "ok";
	}

	public List<Fornecedor> fornecedores() {

		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("FROM Fornecedor ORDER BY forn_id");

		List<Fornecedor> fornecedors = query.getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();

		return fornecedors;

	}

	public String remover(Integer id) {
		entityManager.getTransaction().begin();
		Fornecedor fornecedor = entityManager.find(Fornecedor.class, id);

		entityManager.remove(fornecedor);
		entityManager.getTransaction().commit();
		entityManager.close();

		return "ok";
	}

	public String editar(Fornecedor fornecedor) {
		entityManager.getTransaction().begin();
		entityManager.merge(fornecedor);
		entityManager.getTransaction().commit();
		entityManager.close();

		return "ok";
	}

	public List<Integer> ids() {
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("SELECT u.usuario_id FROM Usuario u");

		List<Integer> ids = query.getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();

		return ids;
	}

}

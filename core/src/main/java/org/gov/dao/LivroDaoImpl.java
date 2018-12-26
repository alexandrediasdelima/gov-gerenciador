package org.gov.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.gov.model.Livro;
import org.gov.util.JPAUtil;

public class LivroDaoImpl implements LivroDao {

	/**
	 *
	 */
	private static final long serialVersionUID = -5779326521469749102L;



	public String gravar(Livro livro) {

			EntityManager entityManager = new JPAUtil().getEntityManager();

			entityManager.getTransaction().begin();
			entityManager.persist(livro);
			entityManager.getTransaction().commit();

			entityManager.close();

		return "ok";
	}

	public List<Livro> livros() {

		EntityManager entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();

		Query query = entityManager.createQuery("FROM Livro");

		List<Livro> livros = query.getResultList();

		entityManager.getTransaction().commit();

		return livros;
	}

	public String remover(int id) {

		EntityManager entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();

		Livro livro = entityManager.find(Livro.class, id);

		entityManager.remove(livro);
		entityManager.getTransaction().commit();

		return "ok";
	}

	public String editar(Livro livro) {

		EntityManager entityManager = new JPAUtil().getEntityManager();

		entityManager.getTransaction().begin();
		entityManager.merge(livro);
		entityManager.getTransaction().commit();

		return "ok";

	}

}

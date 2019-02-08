package org.gov.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.gov.model.Usuario;
import org.gov.util.JPAUtil;

public class UsuarioDaoImpl implements UsuarioDao {



	/**
	 *
	 */
	private static final long serialVersionUID = 2417578921915142472L;

	EntityManager entityManager = new JPAUtil().getEntityManager();


	public String gravar(Usuario usuario) {

			entityManager.getTransaction().begin();
			entityManager.persist(usuario);
			entityManager.getTransaction().commit();
			entityManager.close();

		return "ok";
	}



	public List<Usuario> usuarios() {

		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("FROM Usuario");

		List<Usuario> usuarios = query.getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();

		return usuarios;
	}

	public String remover(String id) {

		entityManager.getTransaction().begin();
		Usuario usuario = entityManager.find(Usuario.class, id);

		entityManager.remove(usuario);
		entityManager.getTransaction().commit();
		entityManager.close();

		return "ok";
	}

	public String editar(Usuario usuario) {

		entityManager.getTransaction().begin();
		entityManager.merge(usuario);
		entityManager.getTransaction().commit();
		entityManager.close();

		return "ok";

	}

}

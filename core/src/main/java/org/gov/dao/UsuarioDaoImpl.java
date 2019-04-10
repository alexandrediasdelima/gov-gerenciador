package org.gov.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.gov.model.Regiao;
import org.gov.model.Usuario;
import org.gov.util.JPAUtil;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;

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
		Query query = entityManager.createQuery("FROM Usuario ORDER BY usuario_id");

		List<Usuario> usuarios = query.getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();

		return usuarios;
	}

	public String remover(Integer id) {

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



	public List<Regiao> buscarMunicipios(String emp_ds_uf) {

		entityManager.getTransaction().begin();

		Query query = entityManager.createQuery("Select r from Regiao r where r.uf =:uf");
		query.setParameter("uf", emp_ds_uf);

		List<Regiao> regioes = query.getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();

		return regioes;

	}



	public Integer buscarIbge(String apa_muni_correspondencia) {

		entityManager.getTransaction().begin();

		Query query = entityManager.createQuery("Select r.codIbge from Regiao r where r.municipio =:municipio");
		query.setParameter("municipio", apa_muni_correspondencia);

		Integer codigo = (Integer) query.getSingleResult();

		entityManager.getTransaction().commit();
		entityManager.close();

		return codigo;
	}

}

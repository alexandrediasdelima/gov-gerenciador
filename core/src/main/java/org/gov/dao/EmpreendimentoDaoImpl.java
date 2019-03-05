package org.gov.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.gov.model.Asbama;
import org.gov.model.Empreendimento;
import org.gov.model.Interferencia;
import org.gov.model.Usuario;
import org.gov.util.JPAUtil;

public class EmpreendimentoDaoImpl implements EmpreendimentoDao {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	EntityManager entityManager = new JPAUtil().getEntityManager();

	public String gravar(Empreendimento empreendimento) {

		entityManager.getTransaction().begin();
		entityManager.persist(empreendimento);
		entityManager.getTransaction().commit();
		entityManager.close();

		return "ok";
	}

	public List<Empreendimento> empreendimentos() {

		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("FROM Empreendimento ORDER BY emp_id");

		List<Empreendimento> empreendimentos = query.getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();

		return empreendimentos;

	}

	public String remover(Integer id) {
		entityManager.getTransaction().begin();
		Empreendimento empreendimento = entityManager.find(Empreendimento.class, id);

		entityManager.remove(empreendimento);
		entityManager.getTransaction().commit();
		entityManager.close();

		return "ok";
	}

	public String editar(Empreendimento empreendimento) {
		entityManager.getTransaction().begin();
		entityManager.merge(empreendimento);
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

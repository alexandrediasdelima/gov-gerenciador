package org.gov.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.gov.model.Asbama;
import org.gov.model.Empreendimento;
import org.gov.model.Interferencia;
import org.gov.model.Regiao;
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

	public List<Usuario> usuarios() {
		entityManager.getTransaction().begin();
		Query query = entityManager.createNativeQuery("SELECT u.usuario_id, CONCAT(u.emp_nm_usuario, ' (', u.emp_nu_cpfcnpj, ')') FROM tb_usuario1 u ORDER BY u.emp_nm_usuario");

		List<Usuario> usuarios = query.getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();

		return usuarios;
	}

	public List<Regiao> buscarMunicipios(String uf) {

		entityManager.getTransaction().begin();

		Query query = entityManager.createQuery("Select r from Regiao r where r.uf =:uf");
		query.setParameter("uf", uf);

		List<Regiao> regioes = query.getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();

		return regioes;

	}



	public Integer buscarIbge(String municipio) {

		entityManager.getTransaction().begin();

		Query query = entityManager.createQuery("Select r.codIbge from Regiao r where r.municipio =:municipio");
		query.setParameter("municipio", municipio);

		Integer codigo = (Integer) query.getResultList().stream().findFirst().orElse(0); 
		//query.getSingleResult();

		entityManager.getTransaction().commit();
		entityManager.close();

		return codigo;
	}

}

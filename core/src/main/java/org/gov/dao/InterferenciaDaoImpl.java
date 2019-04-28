package org.gov.dao;

import javax.persistence.EntityManager;

import org.gov.model.Apac;
import org.gov.model.Cnarh;
import org.gov.model.Empreendimento;
import org.gov.model.Interferencia;
import org.gov.model.Usuario;
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
		Query query = entityManager.createQuery("FROM Interferencia ORDER BY int_id");

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

	public List<Cnarh> cnarhs() {
		entityManager.getTransaction().begin();
		Query query = entityManager.createNativeQuery("SELECT c.cnarh_id FROM tb_cnarh c ORDER BY c.cnarh_id");

		List<Cnarh> cnarhs = query.getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();

		return cnarhs;
	}
	
	public List<Apac> processos() {
		entityManager.getTransaction().begin();
		Query query = entityManager.createNativeQuery("SELECT a.out_nu_processo FROM tb_apac a ORDER BY a.out_nu_processo");

		List<Apac> processos = query.getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();

		return processos;
	}
	
	public List<Empreendimento> empreendimentos() {
		entityManager.getTransaction().begin();
		Query query = entityManager.createNativeQuery("SELECT e.emp_id, e.emp_nm_empreendimento, u.emp_nu_cpfcnpj, u.emp_nm_usuario FROM tb_empreendimento e INNER JOIN tb_usuario u ON e.usuario_id = u.usuario_id ORDER BY e.emp_nm_empreendimento");

		List<Empreendimento> empreendimentos = query.getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();

		return empreendimentos;
	}
	
}

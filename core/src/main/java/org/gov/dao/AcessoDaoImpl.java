package org.gov.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.gov.model.Acesso;
import org.gov.model.Apac;
import org.gov.util.JPAUtil;

public class AcessoDaoImpl implements AcessoDao {

	/**
	 *
	 */
	private static final long serialVersionUID = -5872030167565892531L;
	private String login = "admin";
	private String senha = "admin";

	EntityManager entityManager = new JPAUtil().getEntityManager();

	public boolean acesso(Acesso acessoTela) {

		boolean retorno = false;

		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("FROM Acesso");

		List<Acesso> acesso = query.getResultList();

		entityManager.getTransaction().commit();
		entityManager.close();

		for (Acesso usuario : acesso) {

			if((acessoTela.getLogin().equals(usuario.getLogin())) && (acessoTela.getSenha().equals(usuario.getSenha()))) {
				retorno = true;
				break;
			}

		}

		return retorno;

	}


//	public boolean verificarAcesso(Acesso acesso) {
//
//
//
//	}




}

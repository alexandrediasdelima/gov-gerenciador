package org.gov.dao;

import org.gov.model.Acesso;

public class AcessoDaoImpl implements AcessoDao {

	/**
	 *
	 */
	private static final long serialVersionUID = -5872030167565892531L;
	private String login = "admin";
	private String senha = "admin";


	public boolean verificarAcesso(Acesso acesso) {

		if(login.equals(acesso.getLogin()) && senha.equals(acesso.getSenha())) {
			return true;
		} else {
			return false;
		}

	}


}

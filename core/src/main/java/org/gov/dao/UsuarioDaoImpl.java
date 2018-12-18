package org.gov.dao;

import org.gov.model.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

	/**
	 *
	 */
	private static final long serialVersionUID = -5872030167565892531L;
	private String login = "admin";
	private String senha = "admin";


	public boolean verificarAcesso(Usuario usuario) {

		if(login.equals(usuario.getLogin()) && senha.equals(usuario.getSenha())) {
			return true;
		} else {
			return false;
		}

	}


}

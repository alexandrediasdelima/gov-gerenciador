package org.gov.service;

import org.gov.dao.UsuarioDao;
import org.gov.dao.UsuarioDaoImpl;
import org.gov.model.Usuario;


public class UsuarioServiceImpl implements UsuarioService{

	/**
	 *
	 */
	private static final long serialVersionUID = 8814755819598169756L;

	private UsuarioDao usuarioDao;

	public boolean verificarAcesso(Usuario usuario) {

		usuarioDao = new UsuarioDaoImpl();

		return usuarioDao.verificarAcesso(usuario);


	}



}

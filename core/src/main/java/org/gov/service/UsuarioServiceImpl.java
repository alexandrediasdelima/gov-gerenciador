package org.gov.service;

import java.util.List;

import org.gov.dao.UsuarioDao;
import org.gov.dao.UsuarioDaoImpl;
import org.gov.model.Usuario;


public class UsuarioServiceImpl implements UsuarioService{



	//private LivroDao livroDao;

	private UsuarioDao usuarioDao;

	/**
	 *
	 */
	private static final long serialVersionUID = 7934347956668614856L;

	public String gravar(Usuario usuario) {

		usuarioDao = new UsuarioDaoImpl();
		return usuarioDao.gravar(usuario);
	}

	public List<Usuario> usuarios() {
		usuarioDao = new UsuarioDaoImpl();
		return usuarioDao.usuarios();
	}

	public String remover(String id) {
		usuarioDao = new UsuarioDaoImpl();
		return usuarioDao.remover(id);
	}

	public String editar(Usuario usuario) {

		usuarioDao = new UsuarioDaoImpl();
		return usuarioDao.editar(usuario);
	}

}

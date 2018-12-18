package org.gov.service;

import java.io.Serializable;
import java.util.List;

import org.gov.model.Livro;
import org.gov.model.Usuario;

public interface UsuarioService extends Serializable {

	public boolean verificarAcesso(Usuario usuario);

}

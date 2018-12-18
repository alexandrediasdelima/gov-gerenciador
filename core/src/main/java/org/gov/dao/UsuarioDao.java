package org.gov.dao;

import java.io.Serializable;

import org.gov.model.Usuario;

public interface UsuarioDao extends Serializable {

		public boolean verificarAcesso(Usuario usuario);

}

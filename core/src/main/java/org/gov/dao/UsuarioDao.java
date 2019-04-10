package org.gov.dao;

import java.io.Serializable;
import java.util.List;

import org.gov.model.Regiao;
import org.gov.model.Usuario;

public interface UsuarioDao extends Serializable {

	public String gravar(Usuario usuario);
	public List<Usuario> usuarios();
	public String remover(Integer id);
	public String editar(Usuario usuario);
	public List<Regiao> buscarMunicipios(String emp_ds_uf);
	public Integer buscarIbge(String apa_muni_correspondencia);

}

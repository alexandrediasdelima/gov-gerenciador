package org.gov.service;

import java.io.Serializable;
import java.util.List;

import org.gov.model.Cnarh;
import org.gov.model.Empreendimento;
import org.gov.model.Regiao;
import org.gov.model.Usuario;

public interface EmpreendimentoService extends Serializable {

	public String gravar(Empreendimento empreendimento);
	public List<Empreendimento> empreendimentos();
	public String remover(Integer id);
	public String editar(Empreendimento empreendimento);
	public List<Usuario> usuarios();
	public List<Regiao> buscarMunicipios(String uf);
	public Integer buscarIbge(String municipio);
	public Empreendimento pesquisar(int id);
}

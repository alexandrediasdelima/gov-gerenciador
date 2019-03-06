package org.gov.dao;

import java.io.Serializable;
import java.util.List;

import org.gov.model.Lancamento;
import org.gov.model.OutraInfo;

public interface OutraInfoDao extends Serializable {

	public String gravar(OutraInfo outrainfo);
	//public List<OutraInfo> outrainfos();
	public OutraInfo pesquisar(int id);
	public String remover(Integer id);
	public String editar(OutraInfo outrainfo);

}

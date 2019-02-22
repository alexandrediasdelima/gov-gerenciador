package org.gov.dao;

import java.io.Serializable;

import org.gov.model.ConsumoHumano;

public interface ConsumoHumanoDao extends Serializable {

	public String gravar(ConsumoHumano consumoHumano);
	public ConsumoHumano pesquisar(int id);
	public String remover(Integer id);
	public String editar(ConsumoHumano consumoHumano);

}

package org.gov.service;

import java.io.Serializable;

import org.gov.model.ConsumoHumano;

public interface ConsumoHumanoService extends Serializable {

	public String gravar(ConsumoHumano consumoHumano);
	public ConsumoHumano pesquisar(int id);
	public String remover(Integer id);
	public String editar(ConsumoHumano consumoHumano);

}

package org.gov.service;

import java.io.Serializable;
import java.util.List;
import org.gov.model.Interferencia;

public interface InterferenciaService extends Serializable {

	public String gravar(Interferencia interferencia);
	public List<Interferencia> interferencias();
	public String remover(Integer id);
	public String editar(Interferencia interferencia);

}

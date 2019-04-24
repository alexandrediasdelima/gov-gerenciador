package org.gov.service;

import java.io.Serializable;
import java.util.List;
import org.gov.model.FichaCampo;

public interface FichaCampoService extends Serializable {

	public List<FichaCampo> fichasCampo();

}

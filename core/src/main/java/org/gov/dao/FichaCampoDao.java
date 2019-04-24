package org.gov.dao;

import java.io.Serializable;
import java.util.List;

import org.gov.model.FichaCampo;

public interface FichaCampoDao extends Serializable {

	public List<FichaCampo> fichasCampo();


}

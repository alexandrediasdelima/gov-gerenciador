package org.gov.service;

import java.util.List;
import org.gov.dao.FichaCampoDao;
import org.gov.dao.FichaCampoDaoImpl;
import org.gov.model.FichaCampo;


public class FichaCampoServiceImpl implements FichaCampoService {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	private FichaCampoDao fichaCampoDao;

	public List<FichaCampo> fichasCampo() {
		fichaCampoDao = new FichaCampoDaoImpl();
		List<FichaCampo> fichasCampo = fichaCampoDao.fichasCampo();

		return fichasCampo;
	}

}

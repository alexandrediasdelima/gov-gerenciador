package org.gov.service;

import java.util.List;

import org.gov.dao.FichaCampoDao;
import org.gov.dao.FichaCampoDaoImpl;
import org.gov.model.FichaCampo;


public class FichaCampoServiceImpl implements FichaCampoService{

	/**
	 *
	 */

	private FichaCampoDao fichaCampoDao;

	public List<FichaCampo> fichasCampo() {

		fichaCampoDao = new FichaCampoDaoImpl();
		return fichaCampoDao.fichasCampo();
	}

}

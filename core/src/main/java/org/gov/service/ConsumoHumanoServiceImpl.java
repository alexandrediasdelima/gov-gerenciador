package org.gov.service;

import org.gov.dao.ConsumoHumanoDao;
import org.gov.dao.ConsumoHumanoDaoImpl;
import org.gov.model.ConsumoHumano;


public class ConsumoHumanoServiceImpl implements ConsumoHumanoService{


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private ConsumoHumanoDao consumoHumanoDao;


	public String gravar(ConsumoHumano consumoHumano) {

		consumoHumanoDao = new ConsumoHumanoDaoImpl();
		return consumoHumanoDao.gravar(consumoHumano);
	}


	public ConsumoHumano pesquisar(int id) {

		consumoHumanoDao = new ConsumoHumanoDaoImpl();
		return consumoHumanoDao.pesquisar(id);
	}


	public String editar(ConsumoHumano consumoHumano) {
		return consumoHumanoDao.editar(consumoHumano);
	}

	public String remover(Integer id) {
		consumoHumanoDao = new ConsumoHumanoDaoImpl();
		return consumoHumanoDao.remover(id);
	}


}

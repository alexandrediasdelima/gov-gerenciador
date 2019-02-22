package org.gov.service;

import org.gov.dao.IrrigacaoDao;
import org.gov.dao.IrrigacaoDaoImpl;
import org.gov.model.Irrigacao;


public class IrrigacaoServiceImpl implements IrrigacaoService{


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private IrrigacaoDao irrigacaoDao;


	public String gravar(Irrigacao irrigacao) {

		irrigacaoDao = new IrrigacaoDaoImpl();
		return irrigacaoDao.gravar(irrigacao);
	}


	public Irrigacao pesquisar(int id) {

		irrigacaoDao = new IrrigacaoDaoImpl();
		return irrigacaoDao.pesquisar(id);
	}


	public String editar(Irrigacao irrigacao) {
		return irrigacaoDao.editar(irrigacao);
	}

	public String remover(Integer id) {
		irrigacaoDao = new IrrigacaoDaoImpl();
		return irrigacaoDao.remover(id);
	}


}

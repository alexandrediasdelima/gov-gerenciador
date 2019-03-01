package org.gov.service;

import java.util.List;

import org.gov.dao.EmpreendimentoDao;
import org.gov.dao.EmpreendimentoDaoImpl;
import org.gov.model.Empreendimento;


public class EmpreendimentoServiceImpl implements EmpreendimentoService{

	/**
	 *
	 */
	private static final long serialVersionUID = -5803732226558628525L;

	private EmpreendimentoDao empreendimentoDao;

	public String gravar(Empreendimento empreendimento) {

		empreendimentoDao = new EmpreendimentoDaoImpl();
		empreendimentoDao.gravar(empreendimento);

		return "ok";
	}

	public List<Empreendimento> empreendimentos() {

		empreendimentoDao = new EmpreendimentoDaoImpl();
		return empreendimentoDao.empreendimentos();
	}

	public String remover(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String editar(Empreendimento empreendimento) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Integer> ids() {
		empreendimentoDao = new EmpreendimentoDaoImpl();
		return empreendimentoDao.ids();
	}






}

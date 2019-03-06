package org.gov.service;


import org.gov.dao.OutraInfoDao;
import org.gov.dao.OutraInfoDaoImpl;
import org.gov.model.OutraInfo;


public class OutraInfoServiceImpl implements OutraInfoService{


	private static final long serialVersionUID = 1L;
	private OutraInfoDao outrainfoDao;


	public String gravar(OutraInfo outrainfo) {

		outrainfoDao = new OutraInfoDaoImpl();
		return outrainfoDao.gravar(outrainfo);
	}


	public OutraInfo pesquisar(int id) {

		outrainfoDao = new OutraInfoDaoImpl();
		return outrainfoDao.pesquisar(id);
	}


	public String editar(OutraInfo outrainfo) {
		return outrainfoDao.editar(outrainfo);
	}

	public String remover(Integer id) {
		outrainfoDao = new OutraInfoDaoImpl();
		return outrainfoDao.remover(id);
	}

}

package org.gov.service;

import java.util.List;
import org.gov.dao.InterferenciaDao;
import org.gov.dao.InterferenciaDaoImpl;
import org.gov.model.Apac;
import org.gov.model.Cnarh;
import org.gov.model.Empreendimento;
import org.gov.model.Interferencia;
import org.gov.util.EnumUtils;

public class InterferenciaServiceImpl implements InterferenciaService{

	private InterferenciaDao interferenciaDao;
	private EnumUtils enumUtil;

	/**
	 *
	 */
	private static final long serialVersionUID = 7934347956668614856L;

	public String gravar(Interferencia interferencia) {

		interferenciaDao = new InterferenciaDaoImpl();
		return interferenciaDao.gravar(interferencia);
	}

	public List<Interferencia> interferencias() {
		interferenciaDao = new InterferenciaDaoImpl();
		List<Interferencia> interferencias = interferenciaDao.interferencias();
		
		for (int i=0; i < interferencias.size(); i++) {
			if(interferencias.get(i).getInt_tin_cd() != null && !"".equals(interferencias.get(i).getInt_tin_cd())) {
				interferencias.get(i).setInt_tin_cd(enumUtil.obterValorTipoInterferencia(Integer.valueOf(interferencias.get(i).getInt_tin_cd())));
			}
			
			if(interferencias.get(i).getInt_tsi_cd() != null && !"".equals(interferencias.get(i).getInt_tsi_cd())) {
				interferencias.get(i).setInt_tsi_cd(enumUtil.obterValorSituacaoInterferencia(Integer.valueOf(interferencias.get(i).getInt_tsi_cd())));
			}
			
			if(interferencias.get(i).getFou_tou_cd() != null && !"".equals(interferencias.get(i).getFou_tou_cd())) {
				interferencias.get(i).setFou_tou_cd(enumUtil.obterValorTipoOutroUso(Integer.valueOf(interferencias.get(i).getFou_tou_cd())));
			}
			
			if(interferencias.get(i).getFin_tfn_cd() != null && !"".equals(interferencias.get(i).getFin_tfn_cd())) {
				interferencias.get(i).setFin_tfn_cd(enumUtil.obterValorTipoFinalidade(Integer.valueOf(interferencias.get(i).getFin_tfn_cd())));
			}
		}
		
		return interferencias;
	}


	public String remover(Integer id) {
		interferenciaDao = new InterferenciaDaoImpl();
		return interferenciaDao.remover(id);
	}

	public String editar(Interferencia interferencia) {

		interferenciaDao = new InterferenciaDaoImpl();
		return interferenciaDao.editar(interferencia);
	}
	
	public List<Cnarh> cnarhs() {
		interferenciaDao = new InterferenciaDaoImpl();
		return interferenciaDao.cnarhs();
	}
	
	public List<Apac> processos() {
		interferenciaDao = new InterferenciaDaoImpl();
		return interferenciaDao.processos();
	}
	
	public List<Empreendimento> empreendimentos() {
		interferenciaDao = new InterferenciaDaoImpl();
		return interferenciaDao.empreendimentos();
	}

}

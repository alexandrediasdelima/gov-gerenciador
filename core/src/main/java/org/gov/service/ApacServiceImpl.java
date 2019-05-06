package org.gov.service;

import java.util.List;

import org.gov.dao.ApacDao;
import org.gov.dao.ApacDaoImpl;
import org.gov.model.Apac;
import org.gov.model.Interferencia;
import org.gov.util.EnumUtils;


public class ApacServiceImpl implements ApacService{


	private ApacDao apacDao;
	private EnumUtils enumUtil;

	/**
	 *
	 */
	private static final long serialVersionUID = 7934347956668614856L;

	public String gravar(Apac apac) {

		apacDao = new ApacDaoImpl();
		return apacDao.gravar(apac);
	}

	public List<Apac> apacs() {
		apacDao = new ApacDaoImpl();
		List<Apac> apacs = apacDao.apacs();
		
		for (int i=0; i < apacs.size(); i++) {
			
			
			if(apacs.get(i).getOut_tpo_cd() != null && !"".equals(apacs.get(i).getOut_tpo_cd())) {
				apacs.get(i).setOut_tpo_cd(enumUtil.obterValorTipoOutorga(Integer.valueOf(apacs.get(i).getOut_tpo_cd())));
			}
			
			if(apacs.get(i).getOut_tsp_cd() != null && !"".equals(apacs.get(i).getOut_tsp_cd())) {
				apacs.get(i).setOut_tsp_cd(enumUtil.obterValorSituacaoOutorga(Integer.valueOf(apacs.get(i).getOut_tsp_cd())));
			}
				
		}
		
		return apacs;
	}

	public String remover(String id) {
		apacDao = new ApacDaoImpl();
		return apacDao.remover(id);
	}

	public String editar(Apac apac) {

		apacDao = new ApacDaoImpl();
		return apacDao.editar(apac);
	}

}

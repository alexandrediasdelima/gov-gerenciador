package org.gov.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.gov.model.FichaCampo;
import org.gov.service.FichaCampoService;
import org.gov.service.FichaCampoServiceImpl;
import org.gov.util.EnumUtils;


public class FichaCampoBean extends Controller  {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private FichaCampo fichaCampo;
	private FichaCampoService fichaCampoService;
	private List<FichaCampo> fichasCampo;
	private List<FichaCampo> filteredFichaCampo;
	private EnumUtils enumUtil; 

	public FichaCampoBean() {
		
		setFichaCampo(new FichaCampo());
		fichaCampoService = new FichaCampoServiceImpl();
		setFichasCampo(new ArrayList<FichaCampo>());
		fichasCampo();
		
	}

	public void fichasCampo() {
		setFichasCampo(fichaCampoService.fichasCampo());
	}
	
	public String telaFicha(FichaCampo fichaCampo) {
		setView(EDIT);
		this.fichaCampo = fichaCampo;
		
		//ANEXO 1		
		if(fichaCampo.getInt_tin_cd() != null && StringUtils.isNumeric(fichaCampo.getInt_tin_cd())) { this.fichaCampo.setInt_tin_cd(EnumUtils.obterValorTipoInterferencia(Integer.valueOf(fichaCampo.getInt_tin_cd()))); }
		
		//ANEXO 2
		if(fichaCampo.getInt_tsu_cd() != null && StringUtils.isNumeric(fichaCampo.getInt_tsu_cd())) { this.fichaCampo.setInt_tsu_cd(EnumUtils.obterValorSubTipoCaptacao(Integer.valueOf(fichaCampo.getInt_tsu_cd()))); }
				
		//ANEXO 3
		if(fichaCampo.getInt_tsi_cd() != null && StringUtils.isNumeric(fichaCampo.getInt_tsi_cd())) { this.fichaCampo.setInt_tsi_cd(EnumUtils.obterValorSituacaoInterferencia(Integer.valueOf(fichaCampo.getInt_tsi_cd()))); }
				
		//ANEXO 4
		if(fichaCampo.getOut_tpo_cd() != null && StringUtils.isNumeric(fichaCampo.getOut_tpo_cd())) { this.fichaCampo.setOut_tpo_cd(EnumUtils.obterValorTipoOutorga(Integer.valueOf(fichaCampo.getOut_tpo_cd()))); }
				
		//ANEXO 5
		if(fichaCampo.getOut_tsp_cd() != null && StringUtils.isNumeric(fichaCampo.getOut_tsp_cd())) { this.fichaCampo.setOut_tsp_cd(EnumUtils.obterValorSituacaoOutorga(Integer.valueOf(fichaCampo.getOut_tsp_cd()))); }
				
		//ANEXO 6
		if(fichaCampo.getFin_tfn_cd() != null && StringUtils.isNumeric(fichaCampo.getFin_tfn_cd())) { this.fichaCampo.setFin_tfn_cd(EnumUtils.obterValorTipoFinalidade(Integer.valueOf(fichaCampo.getFin_tfn_cd()))); }
				
		//ANEXO 7
		if(fichaCampo.getFou_tou_cd() != null && StringUtils.isNumeric(fichaCampo.getFou_tou_cd())) { this.fichaCampo.setFou_tou_cd(EnumUtils.obterValorTipoOutroUso(Integer.valueOf(fichaCampo.getFou_tou_cd()))); }
				
		//ANEXO 8
		if(fichaCampo.getSir_tsi_cd() != null && StringUtils.isNumeric(fichaCampo.getSir_tsi_cd())) { this.fichaCampo.setSir_tsi_cd(EnumUtils.obterValorTipoIrrigacao(Integer.valueOf(fichaCampo.getSir_tsi_cd()))); }
		if(fichaCampo.getSir_tsi_cd_2() != null && StringUtils.isNumeric(fichaCampo.getSir_tsi_cd_2())) { this.fichaCampo.setSir_tsi_cd_2(EnumUtils.obterValorTipoIrrigacao(Integer.valueOf(fichaCampo.getSir_tsi_cd_2()))); }
		if(fichaCampo.getSir_tsi_cd_3() != null && StringUtils.isNumeric(fichaCampo.getSir_tsi_cd_3())) { this.fichaCampo.setSir_tsi_cd_3(EnumUtils.obterValorTipoIrrigacao(Integer.valueOf(fichaCampo.getSir_tsi_cd_3()))); }
				
		//ANEXO 9
		if(fichaCampo.getSir_tct_cd() != null && StringUtils.isNumeric(fichaCampo.getSir_tct_cd())) { this.fichaCampo.setSir_tct_cd(EnumUtils.obterValorTipoCultura(Integer.valueOf(fichaCampo.getSir_tct_cd()))); }
		if(fichaCampo.getSir_tct_cd_2() != null && StringUtils.isNumeric(fichaCampo.getSir_tct_cd_2())) { this.fichaCampo.setSir_tct_cd_2(EnumUtils.obterValorTipoCultura(Integer.valueOf(fichaCampo.getSir_tct_cd_2()))); }
		if(fichaCampo.getSir_tct_cd_3() != null && StringUtils.isNumeric(fichaCampo.getSir_tct_cd_3())) { this.fichaCampo.setSir_tct_cd_3(EnumUtils.obterValorTipoCultura(Integer.valueOf(fichaCampo.getSir_tct_cd_3()))); }
				
		//ANEXO 10
		if(fichaCampo.getAsb_tnp_cd() != null && StringUtils.isNumeric(fichaCampo.getAsb_tnp_cd())) { this.fichaCampo.setAsb_tnp_cd(EnumUtils.obterValorNaturezaPonto(Integer.valueOf(fichaCampo.getAsb_tnp_cd()))); }
				
		//ANEXO 11
		if(fichaCampo.getAsb_tpn_cd() != null && StringUtils.isNumeric(fichaCampo.getAsb_tpn_cd())) { this.fichaCampo.setAsb_tpn_cd(EnumUtils.obterValorTipoPenetracaoAquifero(Integer.valueOf(fichaCampo.getAsb_tpn_cd()))); }
				
		//ANEXO 12
		if(fichaCampo.getAsb_tca_cd() != null && StringUtils.isNumeric(fichaCampo.getAsb_tca_cd())) { this.fichaCampo.setAsb_tca_cd(EnumUtils.obterValorTipoCondicaoAquifero(Integer.valueOf(fichaCampo.getAsb_tca_cd()))); }
				
		//ANEXO 13
		if(fichaCampo.getTst_ttb_cd() != null && StringUtils.isNumeric(fichaCampo.getTst_ttb_cd())) { this.fichaCampo.setTst_ttb_cd(EnumUtils.obterValorTipoTesteBombeamento(Integer.valueOf(fichaCampo.getTst_ttb_cd()))); }
				
		//ANEXO 14
		if(fichaCampo.getTst_tmi_cd() != null && StringUtils.isNumeric(fichaCampo.getTst_tmi_cd())) { this.fichaCampo.setTst_tmi_cd(EnumUtils.obterValorTipoMetodoInterpretacao(Integer.valueOf(fichaCampo.getTst_tmi_cd()))); }
				
		//ANEXO 15
		if(fichaCampo.getAsb_aqp_cd() != null && StringUtils.isNumeric(fichaCampo.getAsb_aqp_cd())) { this.fichaCampo.setAsb_aqp_cd(EnumUtils.obterValorIdentificadorAquiferoPonto(Integer.valueOf(fichaCampo.getAsb_aqp_cd()))); }
		
		return eval(index());
	}

	public String voltar() {
		setView(LIST);
		return "/fichacampo/index";
	}
	
	public String index() {
		return "/fichacampo/index";
	}
		
	public void resetView() {
		setView(LIST);
	}

	public FichaCampo getFichaCampo() {
		return fichaCampo;
	}

	public void setFichaCampo(FichaCampo fichaCampo) {
		this.fichaCampo = fichaCampo;
	}

	public List<FichaCampo> getFichasCampo() {
		return fichasCampo;
	}

	public void setFichasCampo(List<FichaCampo> fichasCampo) {
		this.fichasCampo = fichasCampo;
	}

	public List<FichaCampo> getFilteredFichaCampo() {
		return filteredFichaCampo;
	}

	public void setFilteredFichaCampo(List<FichaCampo> filteredFichaCampo) {
		this.filteredFichaCampo = filteredFichaCampo;
	}

	public EnumUtils getEnumUtil() {
		return enumUtil;
	}

	public void setEnumUtil(EnumUtils enumUtil) {
		this.enumUtil = enumUtil;
	}

	

}

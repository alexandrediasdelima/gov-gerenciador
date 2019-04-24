package org.gov.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.gov.model.FichaCampo;
import org.gov.service.FichaCampoService;
import org.gov.service.FichaCampoServiceImpl;


public class FichaCampoBean extends Controller  {


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	private FichaCampo fichaCampo;
	private FichaCampoService fichaCampoService;
	private List<FichaCampo> fichasCampo;
	private List<FichaCampo> filteredFichaCampo;

	public FichaCampoBean() {

		setFichaCampo(new FichaCampo());
		fichaCampoService = new FichaCampoServiceImpl();
		setFichasCampo(new ArrayList<FichaCampo>());
		fichasCampo();
		
	}

	public String index() {
		return "/fichacampo/index";
	}
	
	public String voltar() {
		return "/fichacampo/index";
	}
	

	public String fichasCampo() {
		setFichasCampo(fichaCampoService.fichasCampo());
		setView(LIST);
		return eval(index());
	}
	
	public String telaFicha(FichaCampo fichaCampo) {
		this.fichaCampo = fichaCampo;
		setView(EDIT);
		return eval(index());
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

	

}

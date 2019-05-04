package org.gov.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

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

	public void fichasCampo() {
		setFichasCampo(fichaCampoService.fichasCampo());
//		setView(LIST);
//		return eval(index());
	}
	
	public String telaFicha(FichaCampo fichaCampo) {
		setView(EDIT);
		this.fichaCampo = fichaCampo;
		
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

	

}

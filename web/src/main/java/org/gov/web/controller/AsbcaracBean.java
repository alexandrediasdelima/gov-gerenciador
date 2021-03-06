package org.gov.web.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.gov.model.Asbcarac;
import org.gov.service.AsbcaracService;
import org.gov.service.AsbcaracServiceImpl;



public class AsbcaracBean extends Controller {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private Asbcarac asbcarac;
	private AsbcaracService asbcaracService;
	private FacesContext facesContext;


	public AsbcaracBean () {
		asbcaracService = new AsbcaracServiceImpl();
	}

	public String redirecionarTelaCadastro(int id) {

		asbcarac = new Asbcarac();
		this.asbcarac.setId(id);

		Asbcarac asb = asbcaracService.pesquisar(id);
		setView(ADD);

		if(asb != null) {
			this.asbcarac = asb;
			setView(EDIT);
		}

		return eval(index());
	}

	public String gravar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(asbcaracService.gravar(asbcarac))){
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravado com sucesso", null));
			setView(EDIT);
		}
		return eval(index());
	}

	public String alterar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(asbcaracService.editar(asbcarac))){
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alterado com sucesso", null));
			setView(EDIT);
		}
		return eval(index());
	}

	public String deletar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(asbcaracService.remover(asbcarac.getId()))){
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletado com sucesso", null));
			setView(ADD);
		} else {
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Dados não encontrado para excluir", null));
			setView(ADD);
		}

		limpaForm();
		return eval(index());
	}

	public String voltar() {
		return eval("/interferencia/index");
	}
	
	public String index() {
		return "/asbcarac/index";
	}

	public Asbcarac getAsbcarac() {
		return asbcarac;
	}

	public void setAsbcarac(Asbcarac asbcarac) {
		this.asbcarac = asbcarac;
	}

	public AsbcaracService getAsbcaracService() {
		return asbcaracService;
	}

	public void setAsbcaracService(AsbcaracService asbcaracService) {
		this.asbcaracService = asbcaracService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private void limpaForm() {
		this.asbcarac.setAltitudeTerreno(null);
		this.asbcarac.setAltitudeBocaTubulacao(null);
		this.asbcarac.setIdentificadorAquiferoPonto(null);
		this.asbcarac.setDataInstalacaoPoco(null);
		this.asbcarac.setDiametroPerfuracao(null);
		this.asbcarac.setDiametroFiltro(null);
		this.asbcarac.setProfundidadeBaseMedidaApartirSuperficie(null);
		this.asbcarac.setProfundidadeTopoMedidaApartirSuperficie(null);
		this.asbcarac.setCodigoIdentificador(null);
		this.asbcarac.setTipoPenetracaoAquifero(null);
		this.asbcarac.setCondicaoAquifero(null);

	}






}

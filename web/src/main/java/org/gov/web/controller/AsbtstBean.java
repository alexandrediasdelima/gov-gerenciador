package org.gov.web.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.gov.model.Asbtst;
import org.gov.service.AsbtstService;
import org.gov.service.AsbtstServiceImpl;



public class AsbtstBean extends Controller {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private Asbtst asbtst;
	private AsbtstService asbtstService;
	private FacesContext facesContext;


	public AsbtstBean () {
		asbtstService = new AsbtstServiceImpl();
	}

	public String redirecionarTelaCadastroAsbtst(int id) {

		asbtst = new Asbtst();
		this.asbtst.setTst_int_pfk(id);

		Asbtst asb = asbtstService.pesquisar(id);
		setView(ADD);

		if(asb != null) {
			this.asbtst = asb;
			setView(EDIT);
		}

		return eval(index());
	}

	public String gravar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(asbtstService.gravar(asbtst))){
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravado com sucesso", null));
			setView(EDIT);
		}
		return eval(index());
	}

	public String alterar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(asbtstService.editar(asbtst))){
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alterado com sucesso", null));
			setView(EDIT);
		}
		return eval(index());
	}

	public String deletar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(asbtstService.remover(asbtst.getTst_int_pfk()))){
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
		return "/asbtst/index";
	}

	public Asbtst getAsbtst() {
		return asbtst;
	}

	public void setAsbtst(Asbtst asbtst) {
		this.asbtst = asbtst;
	}

	public AsbtstService getAsbtstService() {
		return asbtstService;
	}

	public void setAsbtstService(AsbtstService asbtstService) {
		this.asbtstService = asbtstService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private void limpaForm() {

//		this.asbtst.setAltitudeBocaTubulacao(null);
//		this.asbtst.setAltitudeTerreno(null);
//		this.asbtst.setCodigoIdentificador(null);
//		this.asbtst.setCondicaoAquifero(null);
//		this.asbtst.setDataInstalacaoPoco(null);
//		this.asbtst.setDiametroFiltro(null);
//		this.asbtst.setDiametroPerfuracao(null);
//		this.asbtst.setIdentificadorAquiferoPonto(null);
//		this.asbtst.setProfundidadeBaseMedidaApartirSuperficie(null);
//		this.asbtst.setProfundidadeTopoMedidaApartirSuperficie(null);
//		this.asbtst.setTipoPenetracaoAquifero(null);

	}






}

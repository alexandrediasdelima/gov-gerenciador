package org.gov.web.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.gov.model.Captacao;
import org.gov.service.CaptacaoService;
import org.gov.service.CaptacaoServiceImpl;



public class CaptacaoBean extends Controller {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private Captacao captacao;
	private CaptacaoService captacaoService;
	private FacesContext facesContext;


	public CaptacaoBean () {
		captacaoService = new CaptacaoServiceImpl();
	}

	public String redirecionarTelaCadastro(int id) {

		captacao = new Captacao();
		this.captacao.setCap_int_pfk(id);

		Captacao asb = captacaoService.pesquisar(id);
		setView(ADD);

		if(asb != null) {
			this.captacao = asb;
			setView(EDIT);
		}

		return eval(index());
	}

	public String gravar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(captacaoService.gravar(captacao))){
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravado com sucesso", null));
			setView(EDIT);
		}
		return eval(index());
	}

	public String alterar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(captacaoService.editar(captacao))){
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alterado com sucesso", null));
			setView(EDIT);
		}
		return eval(index());
	}

	public String deletar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(captacaoService.remover(captacao.getCap_int_pfk()))){
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
		return "/captacao/index";
	}

	public Captacao getCaptacao() {
		return captacao;
	}

	public void setCaptacao(Captacao captacao) {
		this.captacao = captacao;
	}

	public CaptacaoService getCaptacaoService() {
		return captacaoService;
	}

	public void setCaptacaoService(CaptacaoService captacaoService) {
		this.captacaoService = captacaoService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private void limpaForm() {

//		this.captacao.setAltitudeBocaTubulacao(null);
//		this.captacao.setAltitudeTerreno(null);
//		this.captacao.setCodigoIdentificador(null);
//		this.captacao.setCondicaoAquifero(null);
//		this.captacao.setDataInstalacaoPoco(null);
//		this.captacao.setDiametroFiltro(null);
//		this.captacao.setDiametroPerfuracao(null);
//		this.captacao.setIdentificadorAquiferoPonto(null);
//		this.captacao.setProfundidadeBaseMedidaApartirSuperficie(null);
//		this.captacao.setProfundidadeTopoMedidaApartirSuperficie(null);
//		this.captacao.setTipoPenetracaoAquifero(null);

	}






}

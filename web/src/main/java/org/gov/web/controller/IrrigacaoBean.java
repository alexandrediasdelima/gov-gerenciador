package org.gov.web.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.gov.model.Irrigacao;
import org.gov.service.IrrigacaoService;
import org.gov.service.IrrigacaoServiceImpl;



public class IrrigacaoBean extends Controller {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private Irrigacao irrigacao;
	private IrrigacaoService irrigacaoService;
	private FacesContext facesContext;


	public IrrigacaoBean () {
		irrigacaoService = new IrrigacaoServiceImpl();
	}

	public String redirecionarTelaCadastro(int id) {

		irrigacao = new Irrigacao();
		this.irrigacao.setIrr_int_pfk(id);

		Irrigacao asb = irrigacaoService.pesquisar(id);
		setView(ADD);

		if(asb != null) {
			this.irrigacao = asb;
			setView(EDIT);
		}

		return eval(index());
	}

	public String gravar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(irrigacaoService.gravar(irrigacao))){
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravado com sucesso", null));
			setView(EDIT);
		}
		return eval(index());
	}

	public String alterar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(irrigacaoService.editar(irrigacao))){
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alterado com sucesso", null));
			setView(EDIT);
		}
		return eval(index());
	}

	public String deletar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(irrigacaoService.remover(irrigacao.getIrr_int_pfk()))){
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
		return "/irrigacao/index";
	}

	public Irrigacao getIrrigacao() {
		return irrigacao;
	}

	public void setIrrigacao(Irrigacao irrigacao) {
		this.irrigacao = irrigacao;
	}

	public IrrigacaoService getIrrigacaoService() {
		return irrigacaoService;
	}

	public void setIrrigacaoService(IrrigacaoService irrigacaoService) {
		this.irrigacaoService = irrigacaoService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private void limpaForm() {

//		this.irrigacao.setAltitudeBocaTubulacao(null);
//		this.irrigacao.setAltitudeTerreno(null);
//		this.irrigacao.setCodigoIdentificador(null);
//		this.irrigacao.setCondicaoAquifero(null);
//		this.irrigacao.setDataInstalacaoPoco(null);
//		this.irrigacao.setDiametroFiltro(null);
//		this.irrigacao.setDiametroPerfuracao(null);
//		this.irrigacao.setIdentificadorAquiferoPonto(null);
//		this.irrigacao.setProfundidadeBaseMedidaApartirSuperficie(null);
//		this.irrigacao.setProfundidadeTopoMedidaApartirSuperficie(null);
//		this.irrigacao.setTipoPenetracaoAquifero(null);

	}

}

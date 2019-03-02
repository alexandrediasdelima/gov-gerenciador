package org.gov.web.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.gov.model.Lancamento;
import org.gov.service.LancamentoService;
import org.gov.service.LancamentoServiceImpl;



public class LancamentoBean extends Controller {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private Lancamento lancamento;
	private LancamentoService lancamentoService;
	private FacesContext facesContext;


	public LancamentoBean () {
		lancamentoService = new LancamentoServiceImpl();
	}

	public String redirecionarTelaCadastro(int id) {

		lancamento = new Lancamento();
		this.lancamento.setLan_int_pfk(id);

		Lancamento asb = lancamentoService.pesquisar(id);
		setView(ADD);

		if(asb != null) {
			this.lancamento = asb;
			setView(EDIT);
		}

		return eval(index());
	}

	public String gravar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(lancamentoService.gravar(lancamento))){
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravado com sucesso", null));
			setView(EDIT);
		}
		return eval(index());
	}

	public String alterar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(lancamentoService.editar(lancamento))){
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alterado com sucesso", null));
			setView(EDIT);
		}
		return eval(index());
	}

	public String deletar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(lancamentoService.remover(lancamento.getLan_int_pfk()))){
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
		return "/lancamento/index";
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

	public LancamentoService getLancamentoService() {
		return lancamentoService;
	}

	public void setLancamentoService(LancamentoService lancamentoService) {
		this.lancamentoService = lancamentoService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private void limpaForm() {

//		this.lancamento.setAltitudeBocaTubulacao(null);
//		this.lancamento.setAltitudeTerreno(null);
//		this.lancamento.setCodigoIdentificador(null);
//		this.lancamento.setCondicaoAquifero(null);
//		this.lancamento.setDataInstalacaoPoco(null);
//		this.lancamento.setDiametroFiltro(null);
//		this.lancamento.setDiametroPerfuracao(null);
//		this.lancamento.setIdentificadorAquiferoPonto(null);
//		this.lancamento.setProfundidadeBaseMedidaApartirSuperficie(null);
//		this.lancamento.setProfundidadeTopoMedidaApartirSuperficie(null);
//		this.lancamento.setTipoPenetracaoAquifero(null);

	}

}

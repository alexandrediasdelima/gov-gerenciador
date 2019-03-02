package org.gov.web.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.gov.model.TesteBombeamento;
import org.gov.service.TesteBombeamentoService;
import org.gov.service.TesteBombeamentoServiceImpl;



public class TesteBombeamentoBean extends Controller {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private TesteBombeamento testebombeamento;
	private TesteBombeamentoService testebombeamentoService;
	private FacesContext facesContext;


	public TesteBombeamentoBean () {
		testebombeamentoService = new TesteBombeamentoServiceImpl();
	}

	public String redirecionarTelaCadastro(int id) {

		testebombeamento = new TesteBombeamento();
		this.testebombeamento.setTstbomb_int_pfk(id);

		TesteBombeamento asb = testebombeamentoService.pesquisar(id);
		setView(ADD);

		if(asb != null) {
			this.testebombeamento = asb;
			setView(EDIT);
		}

		return eval(index());
	}

	public String gravar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(testebombeamentoService.gravar(testebombeamento))){
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravado com sucesso", null));
			setView(EDIT);
		}
		return eval(index());
	}

	public String alterar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(testebombeamentoService.editar(testebombeamento))){
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alterado com sucesso", null));
			setView(EDIT);
		}
		return eval(index());
	}

	public String deletar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(testebombeamentoService.remover(testebombeamento.getTstbomb_int_pfk()))){
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
		return "/testebombeamento/index";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public TesteBombeamento getTestebombeamento() {
		return testebombeamento;
	}

	public void setTestebombeamento(TesteBombeamento testebombeamento) {
		this.testebombeamento = testebombeamento;
	}

	public TesteBombeamentoService getTestebombeamentoService() {
		return testebombeamentoService;
	}

	public void setTestebombeamentoService(TesteBombeamentoService testebombeamentoService) {
		this.testebombeamentoService = testebombeamentoService;
	}

	private void limpaForm() {

//		this.testebombeamento.setAltitudeBocaTubulacao(null);
//		this.testebombeamento.setAltitudeTerreno(null);
//		this.testebombeamento.setCodigoIdentificador(null);
//		this.testebombeamento.setCondicaoAquifero(null);
//		this.testebombeamento.setDataInstalacaoPoco(null);
//		this.testebombeamento.setDiametroFiltro(null);
//		this.testebombeamento.setDiametroPerfuracao(null);
//		this.testebombeamento.setIdentificadorAquiferoPonto(null);
//		this.testebombeamento.setProfundidadeBaseMedidaApartirSuperficie(null);
//		this.testebombeamento.setProfundidadeTopoMedidaApartirSuperficie(null);
//		this.testebombeamento.setTipoPenetracaoAquifero(null);

	}

}

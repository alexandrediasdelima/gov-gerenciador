package org.gov.web.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.gov.model.Vazao;
import org.gov.service.VazaoService;
import org.gov.service.VazaoServiceImpl;



public class VazaoBean extends Controller {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private Vazao vazao;
	private VazaoService vazaoService;
	private FacesContext facesContext;


	public VazaoBean () {
		vazaoService = new VazaoServiceImpl();
	}

	public String redirecionarTelaCadastro(int id) {

		vazao = new Vazao();
		this.vazao.setVz_int_pfk(id);

		Vazao asb = vazaoService.pesquisar(id);
		setView(ADD);

		if(asb != null) {
			this.vazao = asb;
			setView(EDIT);
		}

		return eval(index());
	}

	public String gravar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(vazaoService.gravar(vazao))){
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravado com sucesso", null));
			setView(EDIT);
		}
		return eval(index());
	}

	public String alterar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(vazaoService.editar(vazao))){
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alterado com sucesso", null));
			setView(EDIT);
		}
		return eval(index());
	}

	public String deletar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(vazaoService.remover(vazao.getVz_int_pfk()))){
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
		return "/vazao/index";
	}

	public Vazao getVazao() {
		return vazao;
	}

	public void setVazao(Vazao vazao) {
		this.vazao = vazao;
	}

	public VazaoService getVazaoService() {
		return vazaoService;
	}

	public void setVazaoService(VazaoService vazaoService) {
		this.vazaoService = vazaoService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private void limpaForm() {

//		this.vazao.setAltitudeBocaTubulacao(null);
//		this.vazao.setAltitudeTerreno(null);
//		this.vazao.setCodigoIdentificador(null);
//		this.vazao.setCondicaoAquifero(null);
//		this.vazao.setDataInstalacaoPoco(null);
//		this.vazao.setDiametroFiltro(null);
//		this.vazao.setDiametroPerfuracao(null);
//		this.vazao.setIdentificadorAquiferoPonto(null);
//		this.vazao.setProfundidadeBaseMedidaApartirSuperficie(null);
//		this.vazao.setProfundidadeTopoMedidaApartirSuperficie(null);
//		this.vazao.setTipoPenetracaoAquifero(null);

	}

}

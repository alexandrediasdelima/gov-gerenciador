package org.gov.web.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.gov.model.ConsumoHumano;
import org.gov.service.ConsumoHumanoService;
import org.gov.service.ConsumoHumanoServiceImpl;



public class ConsumoHumanoBean extends Controller {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private ConsumoHumano consumohumano;
	private ConsumoHumanoService consumohumanoService;
	private FacesContext facesContext;


	public ConsumoHumanoBean () {
		consumohumanoService = new ConsumoHumanoServiceImpl();
	}

	public String redirecionarTelaCadastro(int id) {

		consumohumano = new ConsumoHumano();
		this.consumohumano.setCh_int_pfk(id);

		ConsumoHumano asb = consumohumanoService.pesquisar(id);
		setView(ADD);

		if(asb != null) {
			this.consumohumano = asb;
			setView(EDIT);
		}

		return eval(index());
	}

	public String gravar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(consumohumanoService.gravar(consumohumano))){
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravado com sucesso", null));
			setView(EDIT);
		}
		return eval(index());
	}

	public String alterar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(consumohumanoService.editar(consumohumano))){
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alterado com sucesso", null));
			setView(EDIT);
		}
		return eval(index());
	}

	public String deletar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(consumohumanoService.remover(consumohumano.getCh_int_pfk()))){
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
		return "/consumohumano/index";
	}

	public ConsumoHumano getConsumohumano() {
		return consumohumano;
	}

	public void setConsumohumano(ConsumoHumano consumohumano) {
		this.consumohumano = consumohumano;
	}

	public ConsumoHumanoService getConsumohumanoService() {
		return consumohumanoService;
	}

	public void setConsumohumanoService(ConsumoHumanoService consumohumanoService) {
		this.consumohumanoService = consumohumanoService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private void limpaForm() {

//		this.consumohumano.setAltitudeBocaTubulacao(null);
//		this.consumohumano.setAltitudeTerreno(null);
//		this.consumohumano.setCodigoIdentificador(null);
//		this.consumohumano.setCondicaoAquifero(null);
//		this.consumohumano.setDataInstalacaoPoco(null);
//		this.consumohumano.setDiametroFiltro(null);
//		this.consumohumano.setDiametroPerfuracao(null);
//		this.consumohumano.setIdentificadorAquiferoPonto(null);
//		this.consumohumano.setProfundidadeBaseMedidaApartirSuperficie(null);
//		this.consumohumano.setProfundidadeTopoMedidaApartirSuperficie(null);
//		this.consumohumano.setTipoPenetracaoAquifero(null);

	}

}

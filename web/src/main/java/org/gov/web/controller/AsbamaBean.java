package org.gov.web.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.gov.model.Asbama;
import org.gov.service.AsbamaService;
import org.gov.service.AsbamaServiceImpl;



public class AsbamaBean extends Controller {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private Asbama asbama;
	private AsbamaService asbamaService;
	private FacesContext facesContext;


	public AsbamaBean () {
		asbamaService = new AsbamaServiceImpl();
	}

	public String redirecionarTelaCadastro(int id) {

		asbama = new Asbama();
		this.asbama.setAma_int_pfk(id);

		Asbama asb = asbamaService.pesquisar(id);
		setView(ADD);

		if(asb != null) {
			this.asbama = asb;
			setView(EDIT);
		}

		return eval(index());
	}

	public String gravar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(asbamaService.gravar(asbama))){
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravado com sucesso", null));
			setView(EDIT);
		}
		return eval(index());
	}

	public String alterar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(asbamaService.editar(asbama))){
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alterado com sucesso", null));
			setView(EDIT);
		}
		return eval(index());
	}

	public String deletar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(asbamaService.remover(asbama.getAma_int_pfk()))){
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
		return "/asbama/index";
	}

	public Asbama getAsbama() {
		return asbama;
	}

	public void setAsbama(Asbama asbama) {
		this.asbama = asbama;
	}

	public AsbamaService getAsbamaService() {
		return asbamaService;
	}

	public void setAsbamaService(AsbamaService asbamaService) {
		this.asbamaService = asbamaService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private void limpaForm() {
		this.asbama.setAma_qt_calcio(null);
		this.asbama.setAma_qt_cloreto(null);
		this.asbama.setAma_qt_carbonato(null);
		this.asbama.setAma_qt_durezatotal(null);
		this.asbama.setAma_qt_fluoretos(null);
		this.asbama.setAma_qt_ferrototal(null);
		this.asbama.setAma_qt_bicarbonato(null);
		this.asbama.setAma_qt_potassio(null);
		this.asbama.setAma_qt_magnesio(null);
		this.asbama.setAma_qt_sodio(null);
		this.asbama.setAma_qt_nitritos(null);
		this.asbama.setAma_qt_nitratos(null);
		this.asbama.setAma_qt_sulfato(null);
		this.asbama.setAma_nu_condutividadeeletrica(null);
		this.asbama.setAma_dt_analise(null);
		this.asbama.setAma_dt_coleta(null);
		this.asbama.setAma_qt_coliformesfecais(null);
		this.asbama.setAma_qt_coliformestotais(null);
		this.asbama.setAma_qt_ph(null);
		this.asbama.setAma_qt_std(null);
		this.asbama.setAma_qt_temperatura(null);
	}
}

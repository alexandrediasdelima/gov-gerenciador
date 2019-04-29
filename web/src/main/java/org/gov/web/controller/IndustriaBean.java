package org.gov.web.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.gov.model.Industria;
import org.gov.service.IndustriaService;
import org.gov.service.IndustriaServiceImpl;



public class IndustriaBean extends Controller {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private Industria industria;
	private IndustriaService industriaService;
	private FacesContext facesContext;


	public IndustriaBean () {
		industriaService = new IndustriaServiceImpl();
	}

	public String redirecionarTelaCadastro(int id) {

		industria = new Industria();
		this.industria.setInd_int_pfk(id);

		Industria asb = industriaService.pesquisar(id);
		setView(ADD);

		if(asb != null) {
			this.industria = asb;
			setView(EDIT);
		}

		return eval(index());
	}

	public String gravar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(industriaService.gravar(industria))){
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravado com sucesso", null));
			setView(EDIT);
		}
		return eval(index());
	}

	public String alterar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(industriaService.editar(industria))){
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alterado com sucesso", null));
			setView(EDIT);
		}
		return eval(index());
	}

	public String deletar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(industriaService.remover(industria.getInd_int_pfk()))){
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
		return "/industria/index";
	}

	public Industria getIndustria() {
		return industria;
	}

	public void setIndustria(Industria industria) {
		this.industria = industria;
	}

	public IndustriaService getIndustriaService() {
		return industriaService;
	}

	public void setIndustriaService(IndustriaService industriaService) {
		this.industriaService = industriaService;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private void limpaForm() {
		this.industria.setCam_indus_tp(null);
		this.industria.setCam_indus_nu_empregados(null);
		this.industria.setCam_indus_materia_prima(null);
		this.industria.setCam_qt_pdt_an(null);
		this.industria.setCam_qt_pdt_an_uni(null);
	}

}

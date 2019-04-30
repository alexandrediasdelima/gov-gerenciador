package org.gov.web.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.gov.model.Pecuaria;
import org.gov.service.PecuariaService;
import org.gov.service.PecuariaServiceImpl;



public class PecuariaBean extends Controller {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private Pecuaria pecuaria;
	private PecuariaService pecuariaService;
	private FacesContext facesContext;


	public PecuariaBean () {
		pecuariaService = new PecuariaServiceImpl();
	}

	public String redirecionarTelaCadastro(int id) {

		pecuaria = new Pecuaria();
		this.pecuaria.setPec_int_pfk(id);

		Pecuaria asb = pecuariaService.pesquisar(id);
		setView(ADD);

		if(asb != null) {
			this.pecuaria = asb;
			setView(EDIT);
		}

		return eval(index());
	}

	public String gravar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(pecuariaService.gravar(pecuaria))){
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravado com sucesso", null));
			setView(EDIT);
		}
		return eval(index());
	}

	public String alterar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(pecuariaService.editar(pecuaria))){
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alterado com sucesso", null));
			setView(EDIT);
		}
		return eval(index());
	}

	public String deletar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(pecuariaService.remover(pecuaria.getPec_int_pfk()))){
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
		return "/pecuaria/index";
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pecuaria getPecuaria() {
		return pecuaria;
	}

	public void setPecuaria(Pecuaria pecuaria) {
		this.pecuaria = pecuaria;
	}

	public PecuariaService getPecuariaService() {
		return pecuariaService;
	}

	public void setPecuariaService(PecuariaService pecuariaService) {
		this.pecuariaService = pecuariaService;
	}

	private void limpaForm() {
		this.pecuaria.setCam_qt_equideo(null);
		this.pecuaria.setCam_qt_bovino(null);
		this.pecuaria.setCam_qt_ovino(null);
		this.pecuaria.setCam_qt_caprino(null);
		this.pecuaria.setCam_qt_suino(null);
		this.pecuaria.setCam_qt_ave(null);
		this.pecuaria.setCam_pec_outro(null);
		this.pecuaria.setCam_qt_outro(null);
	}

}

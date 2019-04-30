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
		this.vazao.setInt_vz_maxima(null);
		this.vazao.setCam_vz_afe(null);
		this.vazao.setOpe_qt_horasjan(null);
		this.vazao.setOpe_qt_horasfev(null);
		this.vazao.setOpe_qt_horasmar(null);
		this.vazao.setOpe_qt_horasabr(null);
		this.vazao.setOpe_qt_horasmai(null);
		this.vazao.setOpe_qt_horasjun(null);
		this.vazao.setOpe_qt_horasjul(null);
		this.vazao.setOpe_qt_horasago(null);
		this.vazao.setOpe_qt_horasset(null);
		this.vazao.setOpe_qt_horasout(null);
		this.vazao.setOpe_qt_horasnov(null);
		this.vazao.setOpe_qt_horasdez(null);
		this.vazao.setOpe_qt_diajan(null);
		this.vazao.setOpe_qt_diafev(null);
		this.vazao.setOpe_qt_diamar(null);
		this.vazao.setOpe_qt_diaabr(null);
		this.vazao.setOpe_qt_diamai(null);
		this.vazao.setOpe_qt_diajun(null);
		this.vazao.setOpe_qt_diajul(null);
		this.vazao.setOpe_qt_diaago(null);
		this.vazao.setOpe_qt_diaset(null);
		this.vazao.setOpe_qt_diaout(null);
		this.vazao.setOpe_qt_dianov(null);
		this.vazao.setOpe_qt_diadez(null);
		this.vazao.setOpe_vz_mesjan(null);
		this.vazao.setOpe_vz_mesfev(null);
		this.vazao.setOpe_vz_mesmar(null);
		this.vazao.setOpe_vz_mesabr(null);
		this.vazao.setOpe_vz_mesmai(null);
		this.vazao.setOpe_vz_mesjul(null);
		this.vazao.setOpe_vz_mesjun(null);
		this.vazao.setOpe_vz_mesago(null);
		this.vazao.setOpe_vz_mesout(null);
		this.vazao.setOpe_vz_messet(null);
		this.vazao.setOpe_vz_mesnov(null);
		this.vazao.setOpe_vz_mesdez(null);
	}

}

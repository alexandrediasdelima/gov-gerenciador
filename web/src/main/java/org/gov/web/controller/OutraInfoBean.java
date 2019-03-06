package org.gov.web.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.gov.model.OutraInfo;
import org.gov.service.OutraInfoService;
import org.gov.service.OutraInfoServiceImpl;



public class OutraInfoBean extends Controller {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private OutraInfo outrainfo;
	private OutraInfoService outrainfoService;
	private FacesContext facesContext;


	public OutraInfoBean () {
		outrainfoService = new OutraInfoServiceImpl();
	}

	public String redirecionarTelaCadastro(int id) {

		outrainfo = new OutraInfo();
		this.outrainfo.setOi_emp_pfk(id);

		OutraInfo asb = outrainfoService.pesquisar(id);
		setView(ADD);

		if(asb != null) {
			this.outrainfo = asb;
			setView(EDIT);
		}

		return eval(index());
	}

	public String gravar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(outrainfoService.gravar(outrainfo))){
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravado com sucesso", null));
			setView(EDIT);
		}
		return eval(index());
	}

	public String alterar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(outrainfoService.editar(outrainfo))){
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alterado com sucesso", null));
			setView(EDIT);
		}
		return eval(index());
	}

	public String deletar() {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(outrainfoService.remover(outrainfo.getOi_emp_pfk()))){
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
		return eval("/empreendimento/index");
	}
	
	public String index() {
		return "/outrasinformacoes/index";
	}

	private void limpaForm() {

//		this.outrainfo.setAltitudeBocaTubulacao(null);
//		this.outrainfo.setAltitudeTerreno(null);
//		this.outrainfo.setCodigoIdentificador(null);
//		this.outrainfo.setCondicaoAquifero(null);
//		this.outrainfo.setDataInstalacaoPoco(null);
//		this.outrainfo.setDiametroFiltro(null);
//		this.outrainfo.setDiametroPerfuracao(null);
//		this.outrainfo.setIdentificadorAquiferoPonto(null);
//		this.outrainfo.setProfundidadeBaseMedidaApartirSuperficie(null);
//		this.outrainfo.setProfundidadeTopoMedidaApartirSuperficie(null);
//		this.outrainfo.setTipoPenetracaoAquifero(null);

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OutraInfo getOutrainfo() {
		return outrainfo;
	}

	public void setOutrainfo(OutraInfo outrainfo) {
		this.outrainfo = outrainfo;
	}

	public OutraInfoService getOutrainfoService() {
		return outrainfoService;
	}

	public void setOutrainfoService(OutraInfoService outrainfoService) {
		this.outrainfoService = outrainfoService;
	}
	
}

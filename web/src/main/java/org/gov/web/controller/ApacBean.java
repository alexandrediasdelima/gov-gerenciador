package org.gov.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.gov.model.Apac;
import org.gov.service.ApacService;
import org.gov.service.ApacServiceImpl;
import org.primefaces.event.SelectEvent;

public class ApacBean extends Controller  {



	/**
	 *
	 */
	private static final long serialVersionUID = 1L;



	private Apac apac;
	private ApacService apacService;
	private List<Apac> apacs;


	public ApacBean() {

		setApac(new Apac());
		apacService = new ApacServiceImpl();
		apacs = new ArrayList<Apac>();
		apacs();
	}


	public String gravar() {

		apacService.gravar(apac);
		apacs();

		return eval(index());
	}

	public String apacs() {

		apacs = apacService.apacs();
		setView(LIST);
		return eval(index());

	}

	public String adicionarBtnNovoApac() {
		setView(ADD);
		limparForm();
		return eval(index());
	}

	public String telaEditar(Apac apac) {

		this.apac = apac;
		setView(EDIT);
		return eval(index());
	}

	public String editar() {

		apacService.editar(apac);
		apacs();

		return eval(index());
	}

	public String deletar(Apac apac) {

		apacService.remover(apac.getNumeroProcesso());
		apacs();
		return eval(index());
	}

	 private void limparForm() {

		 this.apac.setAnalistaResponsavel(null);
		 this.apac.setAtoAdministrativoPublicacaoInstrumento(null);
		 this.apac.setDataEntradaProcessoApac(null);
		 this.apac.setDataEntradaProcessoCprh(null);
		 this.apac.setDataInicioPrazoOutorga(null);
		 this.apac.setDataTerminoPrazoOutorga(null);
		 this.apac.setDataVencimentoContrato(null);
		 this.apac.setDataVistoria(null);
		 this.apac.setGarantia(null);
		 this.apac.setHorasRequeridaParaCaptacaoPorDia(null);
		 this.apac.setNomeObra(null);
		 this.apac.setNumeroAto(null);
		 this.apac.setNumeroNotificacaoIrregularidadeApac(null);
		 this.apac.setNumeroNotificacaoIsencaoApac(null);
		 this.apac.setNumeroProcesso(null);
		 this.apac.setNumeroProcessoNaCprh(null);
		 this.apac.setNumeroTermo(null);
		 this.apac.setOutorgaValidaAbril(null);
		 this.apac.setOutorgaValidaAgosto(null);
		 this.apac.setOutorgaValidaDezembro(null);
		 this.apac.setOutorgaValidaFevereiro(null);
		 this.apac.setOutorgaValidaJaneiro(null);
		 this.apac.setOutorgaValidaJulho(null);
		 this.apac.setOutorgaValidaJunho(null);
		 this.apac.setOutorgaValidaMaio(null);
		 this.apac.setOutorgaValidaMarco(null);
		 this.apac.setOutorgaValidaNovembro(null);
		 this.apac.setOutorgaValidaOutubro(null);
		 this.apac.setOutorgaValidaSetembro(null);
		 this.apac.setPrazoNotificacao(null);
		 this.apac.setTipoObra(null);
		 this.apac.setVazaoOutorgada(null);
		 this.apac.setVazaoOutorgadaMedia(null);
		 this.apac.setVazaoRequiridaLs(null);
		 this.apac.setVazaoRequiridaMediaDia(null);

	}

	public void onDateSelect(SelectEvent event) {
	        FacesContext facesContext = FacesContext.getCurrentInstance();
	        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
	    }


	public String index() {
		return "/apac/index";
	}


	public Apac getApac() {
		return apac;
	}


	public void setApac(Apac apac) {
		this.apac = apac;
	}


	public List<Apac> getApacs() {
		return apacs;
	}


	public void setApacs(List<Apac> apacs) {
		this.apacs = apacs;
	}

}

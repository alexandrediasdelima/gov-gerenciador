package org.gov.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.gov.model.Apac;
import org.gov.model.Cnarh;
import org.gov.model.Empreendimento;
import org.gov.model.Interferencia;
import org.gov.model.Usuario;
import org.gov.service.InterferenciaService;
import org.gov.service.InterferenciaServiceImpl;




public class InterferenciaBean extends Controller  {


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Interferencia interferencia;
	private List<Interferencia> interferencias;
	private InterferenciaService interferenciaService;
	private List<Interferencia> filteredInterferencias;
	private List<Cnarh> cnarhs;
	private List<Apac> processos;
	private List<Empreendimento> empreendimentos;
	
	private boolean isOutroUso;
	
	public InterferenciaBean() {
		setInterferencia(new Interferencia());
		interferenciaService = new InterferenciaServiceImpl();
		interferencias = new ArrayList<Interferencia>();
		cnarhs = new ArrayList<Cnarh>();
		processos = new ArrayList<Apac>();
		empreendimentos = new ArrayList<Empreendimento>();
		interferencias();
	}
	
	public String interferencias() {
		interferencias = interferenciaService.interferencias();
		setView(LIST);
		return eval(index());
	}
	
	public String gravar() {
		interferenciaService.gravar(interferencia);
		interferencias();
		return eval(index());
	}
	
	public String adicionarNovo() {
		setView(ADD);
		limparForm();
		this.setCnarhs(interferenciaService.cnarhs());
		this.setProcessos(interferenciaService.processos());
		this.setEmpreendimentos(interferenciaService.empreendimentos());
		return eval(index());
	}

	public String telaEditar(Interferencia interferencia) {
		this.interferencia = interferencia;
		setView(EDIT);
		return eval(index());
	}

	public String editar() {
		interferenciaService.editar(interferencia);
		interferencias();

		return eval(index());
	}

	public String deletar() {
		interferenciaService.remover(interferencia.getInt_id());
		interferencias();
		return eval(index());
	}
	
	private void limparForm() {
//		 this.usuario.setAreaTotalReserv(null);
//		 this.usuario.setNumeroSiagas(null);
//		 this.usuario.setVolumeMaxReserv(null);
	}	

	public void apresentarOutroUso() {
		if ("53".equals(interferencia.getFou_tou_cd())) {
			isOutroUso = true;
		} else {
			isOutroUso = false;
		}
	}
	 
	
	public String index() {
		return "/interferencia/index";
	}
	
	public Interferencia getInterferencia() {
		return interferencia;
	}

	public void setInterferencia(Interferencia interferencia) {
		this.interferencia = interferencia;
	}
	
	public List<Interferencia> getInterferencias() {
		return interferencias;
	}


	public void setInterferencias(List<Interferencia> interferencias) {
		this.interferencias = interferencias;
	}

	public List<Interferencia> getFilteredInterferencias() {
		return filteredInterferencias;
	}

	public void setFilteredInterferencias(List<Interferencia> filteredInterferencias) {
		this.filteredInterferencias = filteredInterferencias;
	}

	public Boolean getIsOutroUso() {
		return isOutroUso;
	}

	public void setIsOutroUso(Boolean isOutroUso) {
		this.isOutroUso = isOutroUso;
	}

	public List<Cnarh> getCnarhs() {
		return cnarhs;
	}

	public void setCnarhs(List<Cnarh> cnarhs) {
		this.cnarhs = cnarhs;
	}

	public List<Apac> getProcessos() {
		return processos;
	}

	public void setProcessos(List<Apac> processos) {
		this.processos = processos;
	}

	public List<Empreendimento> getEmpreendimentos() {
		return empreendimentos;
	}

	public void setEmpreendimentos(List<Empreendimento> empreendimentos) {
		this.empreendimentos = empreendimentos;
	}

	
	
}

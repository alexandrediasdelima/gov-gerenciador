package org.gov.web.controller;

import java.util.ArrayList;
import java.util.List;
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
	
	public String interferencias() {
		interferencias = interferenciaService.interferencias();
		setView(LIST);
		return eval(index());
	}
	
	public InterferenciaBean() {
		setInterferencia(new Interferencia());
		interferenciaService = new InterferenciaServiceImpl();
		interferencias = new ArrayList<Interferencia>();
		interferencias();
	}
	
	public String gravar() {
		interferenciaService.gravar(interferencia);
		interferencias();
		return eval(index());
	}
	
	public String adicionarNovo() {
		setView(ADD);
		limparForm();
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

	public String deletar(Interferencia interferencia) {
		interferenciaService.remover(interferencia.getId());
		interferencias();
		return eval(index());
	}
	
	 private void limparForm() {
//		 this.usuario.setAreaTotalReserv(null);
//		 this.usuario.setNumeroSiagas(null);
//		 this.usuario.setVolumeMaxReserv(null);
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
	
//	public InterferenciaBean() {
//		this.interferencia = new Interferencia();
//	}

//	public String gravar() {
//		System.out.println(interferencia);
//		return null;
//	}



}

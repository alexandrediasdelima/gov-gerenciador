package org.gov.web.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.gov.model.Regiao;
import org.gov.model.Usuario;
import org.gov.service.UsuarioService;
import org.gov.service.UsuarioServiceImpl;

public class UsuarioBean extends Controller  {



	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private UsuarioService usuarioService;
	private List<Usuario> usuarios;
	private List<Regiao> regioes;

	public UsuarioBean() {

		setUsuario(new Usuario());
		usuarioService = new UsuarioServiceImpl();
		usuarios = new ArrayList<Usuario>();
		usuarios();
	}


	public String gravar() {

		usuarioService.gravar(usuario);
		usuarios();

		return eval(index());
	}

	public String usuarios() {

		usuarios = usuarioService.usuarios();
		setView(LIST);
		return eval(index());

	}

	public void atualizarMunicipios() {
		setRegioes(usuarioService.buscarMunicipios(usuario.getEmp_ds_uf()));
	}

	public void atualizarIbge() {
		usuario.setEmp_cd_codigoibgecorrespondencia(usuarioService.buscarIbge(usuario.getApa_muni_correspondencia()));
	}

	public String adicionarNovo() {
		setView(ADD);
		limparForm();
		this.setRegioes(usuarioService.buscarMunicipios(usuario.getEmp_ds_uf()));
		return eval(index());
	}

	public String telaEditar(Usuario usuario) {
		setView(EDIT);
		this.usuario = usuario;
		this.setRegioes(usuarioService.buscarMunicipios(usuario.getEmp_ds_uf()));
		return eval(index());
	}

	public String editar() {
		usuarioService.editar(usuario);
		usuarios();
		return eval(index());
	}

	public String deletar() {
		usuarioService.remover(usuario.getUsuario_id());
		usuarios();
		return eval(index());
	}

	 private void limparForm() {
//		 this.usuario.setAreaTotalReserv(null);
//		 this.usuario.setNumeroSiagas(null);
//		 this.usuario.setVolumeMaxReserv(null);
	}

//	public void onDateSelect(SelectEvent event) {
//	        FacesContext facesContext = FacesContext.getCurrentInstance();
//	        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//	        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
//	    }


	public String index() {
		return "/usuario/index";
	}

	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public List<Usuario> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}


	public List<Regiao> getRegioes() {
		return regioes;
	}


	public void setRegioes(List<Regiao> regioes) {
		this.regioes = regioes;
	}



}

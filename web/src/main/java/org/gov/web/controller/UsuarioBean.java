package org.gov.web.controller;

import java.util.ArrayList;
import java.util.List;

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

	public String adicionarBtnNovoUsuario() {
		setView(ADD);
		limparForm();
		return eval(index());
	}

	public String telaEditar(Usuario usuario) {

		this.usuario = usuario;
		setView(EDIT);
		return eval(index());
	}

	public String editar() {

		usuarioService.editar(usuario);
		usuarios();

		return eval(index());
	}

	public String deletar(Usuario usuario) {

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

}

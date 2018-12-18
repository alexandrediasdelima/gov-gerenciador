package org.gov.web.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.gov.service.UsuarioService;
import org.gov.service.UsuarioServiceImpl;
import org.gov.web.model.Usuario;

public class LoginBean extends Controller {

	/**
	 *
	 */
	private static final long serialVersionUID = -7849970183863861263L;

	private UsuarioService usuarioService = new UsuarioServiceImpl();
	private Usuario usuario = new Usuario();


	public String verificarAcesso() {

		org.gov.model.Usuario user = new org.gov.model.Usuario();

		user.setLogin(usuario.getUsuario());
		user.setSenha(usuario.getSenha());

		if(usuarioService.verificarAcesso(user)) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.getExternalContext().getSessionMap().put("usuarioLogado", true);
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Tente novamente", "Credenciais incorreta!"));
		}
		return "";
	}

	public String deslogar() {
		FacesContext context = FacesContext.getCurrentInstance();
	    context.getExternalContext().getSessionMap().remove("usuarioLogado");

	    return "/index.xhtml?faces-redirect=true";

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

}

package org.gov.web.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.gov.service.AcessoService;
import org.gov.service.AcessoServiceImpl;
import org.gov.web.model.Acesso;

public class LoginBean extends Controller {

	/**
	 *
	 */
	private static final long serialVersionUID = -7849970183863861263L;

	private AcessoService usuarioService = new AcessoServiceImpl();
	private Acesso acesso = new Acesso();


	public String verificarAcesso() {

		org.gov.model.Acesso user = new org.gov.model.Acesso();

		user.setLogin(acesso.getUsuario());
		user.setSenha(acesso.getSenha());

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
	    context.getExternalContext().getSessionMap().remove("idInterferencia");
	    return "/index.xhtml?faces-redirect=true";

	}

	public Acesso getUsuario() {
		return acesso;
	}

	public void setUsuario(Acesso usuario) {
		this.acesso = usuario;
	}

	public AcessoService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(AcessoService usuarioService) {
		this.usuarioService = usuarioService;
	}

}

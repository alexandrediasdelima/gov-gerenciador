package org.gov.web.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class Autorizador implements PhaseListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 6843047315113401114L;



	public void afterPhase(PhaseEvent arg0) {

		 String nomePagina = FacesContext.getCurrentInstance().getViewRoot().getViewId();
		 FacesContext facesContext = FacesContext.getCurrentInstance();

		 Boolean usuarioLogado = (Boolean) facesContext.getExternalContext().getSessionMap().get("usuarioLogado");

		 if("/index.xhtml".equals(nomePagina)) {

			 return;
		 }

		 if(usuarioLogado != null && usuarioLogado) {
			 return;
		 }

		 //Redirecionamento para a tela de login

		 NavigationHandler handler = facesContext.getApplication().getNavigationHandler();

		 handler.handleNavigation(facesContext,null, "/index.xhtml?faces-redirect=true");




	}

	public void beforePhase(PhaseEvent arg0) {


	}

	public PhaseId getPhaseId() {

		return PhaseId.RESTORE_VIEW;
	}

}

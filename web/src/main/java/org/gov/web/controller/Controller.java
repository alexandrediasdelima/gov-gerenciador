package org.gov.web.controller;

import java.io.Serializable;

import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Controller implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Logger looger = LoggerFactory.getLogger(getClass());

	public static final String VIEW_ACTION_KEY = "actionKey";

	public static final String ADD = "add";

	public static final String EDIT = "edit";

	public static final String LIST = "list";

	public static final String CONFIG = "config";

	private String view;

	public Controller() {
		looger.debug("Criando instancia de controller " + getClass().getSimpleName());
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	protected Logger getLogger() {
		return this.looger;
	}

	protected String eval(String nextViewId) {
		String lastViewId = FacesContext.getCurrentInstance().getViewRoot().getViewId();
		return lastViewId.startsWith(nextViewId) ? null : nextViewId;
	}
}

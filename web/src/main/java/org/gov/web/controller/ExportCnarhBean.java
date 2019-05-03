package org.gov.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.gov.service.ExportCnarhService;
import org.gov.service.ExportCnarhServiceImpl;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

public class ExportCnarhBean extends Controller {

	/**
	 *
	 */
	private static final long serialVersionUID = -3619431046825730245L;

	private transient StreamedContent file;
	private ExportCnarhService exportCnarhService;

	public ExportCnarhBean () {

	}

	public StreamedContent getDownload() {

		exportCnarhService = new ExportCnarhServiceImpl();
		File f = null;

		  InputStream stream = null;

			try {
				f = exportCnarhService.exportCnarhs();

				stream = new FileInputStream(f);
				setFile(new DefaultStreamedContent(stream, "application/CSV", f.getName()));

			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Arquivo não encontrado no servidor ", ""));
			}

			return file;
	}

	public StreamedContent getFile() {
		return file;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}


}

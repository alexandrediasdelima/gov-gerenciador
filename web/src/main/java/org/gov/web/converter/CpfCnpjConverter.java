package org.gov.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class CpfCnpjConverter implements Converter {

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String documento) {

			return documento;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object documento) {

		String doc = (String) documento;

		return doc;
	}

}

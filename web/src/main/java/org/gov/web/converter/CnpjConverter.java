package org.gov.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.gov.web.validator.CNPJUtil;

public class CnpjConverter implements Converter {

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String cnpj) {
		// TODO Auto-generated method stub
		try {
			return CNPJUtil.unFormat(cnpj);
		} catch (Exception e) {
			e.printStackTrace();
			return cnpj;
		}
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {

		return null;
	}

}

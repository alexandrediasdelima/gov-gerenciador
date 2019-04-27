package org.gov.web.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class MesComTrintaUMDiaValidator implements Validator {

	public void validate(FacesContext arg0, UIComponent arg1, Object obj)
			throws ValidatorException {

		Integer dia = (Integer) obj;

		if(dia > 31) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Quantidade maxima permitida são de 31 dias", null
					));
		}


	}



}

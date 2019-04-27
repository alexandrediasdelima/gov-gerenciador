package org.gov.web.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class MesComTrintaDiaValidator implements Validator {

	public void validate(FacesContext arg0, UIComponent arg1, Object obj)
			throws ValidatorException {

		Integer dia = (Integer) obj;

		if(dia < 0 || dia > 30) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Quantidade maxima permitida são de 30 dias", null
					));
		}


	}



}

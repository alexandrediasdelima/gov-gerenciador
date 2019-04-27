package org.gov.web.validator;

import java.math.BigDecimal;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class HoraValidator implements Validator {

	public void validate(FacesContext arg0, UIComponent arg1, Object obj)
			throws ValidatorException {

		BigDecimal numero = (BigDecimal) obj;


		if(numero.compareTo(new BigDecimal(0)) < 0 || numero.compareTo(new BigDecimal(24)) > 0) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Quantidade maxima de horas permitida são de 24 horas", null
					));

		}

	}

}

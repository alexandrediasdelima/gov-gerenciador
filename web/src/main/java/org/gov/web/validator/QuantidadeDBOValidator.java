package org.gov.web.validator;

import java.math.BigDecimal;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class QuantidadeDBOValidator implements Validator {

	public void validate(FacesContext arg0, UIComponent arg1, Object obj)
			throws ValidatorException {

		BigDecimal valor = (BigDecimal) obj;

		if(valor.compareTo(new BigDecimal(7200)) >0) {

			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Quantidade maxima de DBO do efluente bruto é de 7200", null
					));
		}

	}

}

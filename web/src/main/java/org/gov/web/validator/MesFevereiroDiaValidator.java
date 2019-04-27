package org.gov.web.validator;

import java.util.Calendar;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class MesFevereiroDiaValidator implements Validator {

	public void validate(FacesContext arg0, UIComponent arg1, Object obj)
			throws ValidatorException {

		Integer dia = (Integer) obj;

		Calendar calendar = Calendar.getInstance();

		boolean anoBissexto = isAnoBissexto(calendar.get(Calendar.YEAR));

		if (anoBissexto) {

			if(dia > 29) {

				throw new ValidatorException(new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Quantidade maxima permitida são de 29 dias", null));
			}

		} else {

			if (dia > 28) {
				throw new ValidatorException(new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Quantidade maxima permitida são de 28 dias", null));
			}
		}

	}

	public static boolean isAnoBissexto(int ano) {
		if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

}

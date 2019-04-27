package org.gov.web.validator;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class CPFValidador implements Validator {

	private static final CPFValidator CPF_VALIDATOR = new CPFValidator();



	public static String removeZerosEsquerda(String valor) {
	    return valor.replaceFirst("0*", "");
	}

	public void validate(FacesContext arg0, UIComponent arg1, Object obj)
			throws ValidatorException {

		String cpf = (String) obj;

		cpf = cpf.replaceAll(Pattern.quote("."), "").replaceAll("/", "").replace("_", "").replace("-", "");

		if (cpf == null) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "CPF Incorreto", null));

		} else if (!CPF_VALIDATOR.validateCPF(cpf)) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "CPF Incorreto", null));
		}

	}


}

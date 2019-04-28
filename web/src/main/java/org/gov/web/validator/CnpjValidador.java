package org.gov.web.validator;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.gov.web.util.SerasaUtils;

/**
 * Validator para input de CNPJ
 *
 */
public class CnpjValidador implements Validator {

	private static final int NUMBER_QUATORZE = 14;
	private ResourceBundle resourceBundle;

	public CnpjValidador() {

		resourceBundle = ResourceBundle.getBundle("application-error-message",
				new Locale("pt", "BR"));

	}

	public void validate(FacesContext facescontext, UIComponent uicomponent,
			Object obj) {
		String cnpj = (String) obj;

		// TODO verificar a validaÃ§Ã£o com 8 digitos aguarando resposta Serasa
		cnpj = cnpj.replaceAll(Pattern.quote("."), "").replaceAll("/", "")
				.replace("_", "").replace("-", "");

		if (cnpj.length() == NUMBER_QUATORZE) {

			try {
				if (!CNPJUtil.isValid(cnpj)) {
					throw new ValidatorException(
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"CNPJ Incorreto", null));
				}

			} catch (IllegalArgumentException e) {
				throw new ValidatorException(new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Erro na aplicação", null));
			}

		} else {
			throw new ValidatorException(new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "CNPJ Incorreto", null));
		}
	}

	public static String removeZerosEsquerda(String valor) {
		return valor.replaceFirst("0*", "");
	}

}

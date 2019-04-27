package org.gov.web.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class EmailValidator implements Validator {

	public void validate(FacesContext arg0, UIComponent arg1, Object obj)
			throws ValidatorException {

		String email = (String) obj;

		if(!validaEmail(email)) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email incorreto", null));
		}


	}

	private Boolean validaEmail(String email) {

	    Pattern p = Pattern.compile(".+@.+\\.[a-z]+");

	      Matcher m = p.matcher(email);

	      if ( !m.matches()) {

	    		return false;
	      }

	return true;
}


}

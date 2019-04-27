package org.gov.web.validator;

import java.util.regex.Pattern;
import org.gov.web.validator.*;

/**
 * Classe util para documento CNPJ.
 *
 */
public final class CNPJUtil {

	private CNPJUtil() {

	}

	private static Pattern			pattern	= Pattern.compile("([\\d]{2})([\\d]{3})([\\d]{3})([\\d]{4})([\\d]{2})");

	public static String format(String cnpj) throws Exception {
		if (cnpj == null) {
			throw new Exception("CNPJ nulo");
		}
		return pattern.matcher(cnpj).replaceAll("$1.$2.$3/$4-$5");
	}

	public static String unFormat(String cnpj) throws Exception {

		String cnpjRetorno = cnpj;

		if (cnpjRetorno == null) {
			throw new Exception("CNPJ esta nulo");
		}

		cnpjRetorno = cnpjRetorno.replaceAll("[\\./-]", "").replaceAll("_", "");

		return cnpjRetorno ;
	}

	public static boolean isValid(String cnpj) {

		CNPJValidator cnpjValidator = new CNPJValidator();

	return cnpjValidator.validaCNPJCompleto(cnpj);

	}
}

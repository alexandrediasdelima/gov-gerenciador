package org.gov.web.util;

public final class SerasaUtils {

	private SerasaUtils() {

	}

	private static final int NUMBER_TREZE = 13;
	private static final int NUMBER_ONZE = 11;
	private static final int NUMBER_QUATRO = 4;
	private static final int NUMBER_CINCO = 5;
	private static final int NUMBER_OITO = 8;
	private static final int NUMBER_SEIS = 6;
	private static final int NUMBER_DEZ = 10;
	private static final int NUMBER_NOVE = 9;
	private static final int NUMBER_SETE = 7;
	private static final int NUMBER_DOIS = 2;
	private static final int NUMBER_UM = 1;
	private static final int NUMBER_DOZE = 12;
	private static final int NUMBER_QUATORZE = 14;
	private static final int PAD_LIMIT = 8192;

	public static String getCnpjCompleto(String cnpj) {

		String cnpjRetorno = cnpj;

		if(cnpjRetorno.equals("0")) {
			cnpjRetorno = "00000000";
		}

		org.gov.web.validator.CNPJValidator cnpjValidator = new org.gov.web.validator.CNPJValidator();

		if(cnpjValidator.validaCNPJCompleto(cnpj)) {
			return cnpj;
		}

		return cnpjRetorno+"0001"+SerasaUtils.cnpjCalculaDigito(cnpjRetorno+"0001");
	}

	   public static boolean isBlank(String str) {
	    	if (str == null) {
	    		return true;
	    	}
	    	int strLen = str.length();
	        if (strLen == 0) {
	            return true;
	        }
	        for (int i = 0; i < strLen; i++) {
	            if (!(Character.isWhitespace(str.charAt(i)))) {
	                return false;
	            }
	        }
	        return true;
	    }

	    public static String leftPad(String str, int size, String padStr) {
	        if (str == null) {
	            return null;
	        }

	        int padLen = padStr.length();
	        int strLen = str.length();
	        int pads = size - strLen;
	        if (pads <= 0) {
	            return str; // returns original String when possible
	        }
	        if (padLen == NUMBER_UM && pads <= PAD_LIMIT) {
	            return leftPad(str, size, padStr.charAt(0));
	        }

	        if (pads == padLen) {
	            return padStr.concat(str);
	        } else if (pads < padLen) {
	            return padStr.substring(0, pads).concat(str);
	        } else {
	            char[] padding = new char[pads];
	            char[] padChars = padStr.toCharArray();
	            for (int i = 0; i < pads; i++) {
	                padding[i] = padChars[i % padLen];
	            }
	            return new String(padding).concat(str);
	        }
	    }

	    public static String leftPad(String str, int size, char padChar) {
	        if (str == null) {
	            return null;
	        }
	        int pads = size - str.length();
	        if (pads <= 0) {
	            return str; // returns original String when possible
	        }
	        if (pads > PAD_LIMIT) {
	            return leftPad(str, size, String.valueOf(padChar));
	        }
	        return padding(pads, padChar).concat(str);
	    }

	    public static String padding(int repeat, char padChar) {
	        if (repeat < 0) {
	            throw new IndexOutOfBoundsException("Cannot pad a negative amount: " + repeat);
	        }
	        final char[] buf = new char[repeat];
	        for (int i = 0; i < buf.length; i++) {
	            buf[i] = padChar;
	        }
	        return new String(buf);
	    }


	private static String cnpjCalculaDigito(String cnpj) {
        int a = 0;
        int b = 0;
        int x = 0;
        int y = 0;

        String cnpjRetorno = cnpj;

        char cAux[];
        int nAux[] = new int[NUMBER_QUATORZE];

        int dig[] = new int[NUMBER_QUATORZE];
        int digTot1 = 0;
        int digTot2 = 0;
        int digTot3 = 0;

        if (cnpjRetorno.trim().length() == NUMBER_QUATORZE) {
        	cnpjRetorno = cnpjRetorno.trim().substring(0, NUMBER_DOZE); // pega só o corpo do CNPJ
        }else  if (cnpjRetorno.trim().length() > NUMBER_DOZE) {
                 return ("");
        }
        cnpjRetorno = ajustaTamanhoZeros(cnpjRetorno.trim(), NUMBER_DOZE); // se for preciso completa
                                                                                                                                                                                     // com zeros a esquerda

        cAux = cnpjRetorno.toCharArray();

        for (x = NUMBER_UM; x <= NUMBER_DOZE; x++) {
            nAux[x - NUMBER_UM] = Character.getNumericValue(cAux[x - NUMBER_UM]);
        }

        // Calculo do 1o. digito verificador.

        for (x = NUMBER_UM; x <= NUMBER_SETE; x += NUMBER_DOIS) {
                        a = nAux[x - NUMBER_UM];
                        b = a * NUMBER_DOIS;

                        if (b > NUMBER_NOVE) {
                            dig[x - NUMBER_UM] = (b - NUMBER_DEZ + NUMBER_UM);
                        } else {
                            dig[x - NUMBER_UM] = b;
                        }

                        digTot1 += dig[x - NUMBER_UM];
        }

        for (x = NUMBER_DOIS; x <= NUMBER_SEIS; x += NUMBER_DOIS) {
                        dig[x - NUMBER_UM] = nAux[x - NUMBER_UM];
                        digTot1 += dig[x - NUMBER_UM];
        }

        a = (digTot1 / NUMBER_DEZ);
        b = (digTot1 - (a * NUMBER_DEZ));

        if (b == 0 || b == NUMBER_UM) {
            dig[NUMBER_OITO - NUMBER_UM] = 0;
        }else {
            dig[NUMBER_OITO - NUMBER_UM] = (NUMBER_DEZ - b);
        }

        dig[NUMBER_OITO - NUMBER_UM] = nAux[NUMBER_OITO - NUMBER_UM];

        // Cßlculo do 2o. digito verificador.
        y = NUMBER_SEIS;

        for (x = NUMBER_NOVE; x <= NUMBER_DOZE; x++) {
                        y = (y - NUMBER_UM);
                        a = nAux[x - NUMBER_UM];
                        dig[x - NUMBER_UM] = (a * y);
                        digTot2 += dig[x - NUMBER_UM];
        }

        digTot2 += (dig[NUMBER_OITO - NUMBER_UM] * NUMBER_SEIS);
        y = NUMBER_DEZ;

        for (x = NUMBER_CINCO; x <= NUMBER_SETE; x++) {
                        y = (y - NUMBER_UM);
                        a = nAux[x - NUMBER_UM];
                        dig[x - NUMBER_UM] = (a * y);
                        digTot2 += dig[x - NUMBER_UM];
        }

        y = NUMBER_SEIS;

        for (x = NUMBER_UM; x <= NUMBER_QUATRO; x++) {
                        y = (y - NUMBER_UM);
                        a = nAux[x - NUMBER_UM];
                        dig[x - NUMBER_UM] = (a * y);
                        digTot2 += dig[x - NUMBER_UM];
        }

        a = (digTot2 / NUMBER_ONZE);
        b = (digTot2 - (a * NUMBER_ONZE));

        if (b == 0 || b == NUMBER_UM) {
            dig[NUMBER_TREZE - NUMBER_UM] = 0;
        }else {
            dig[NUMBER_TREZE - NUMBER_UM] = (NUMBER_ONZE - b);
        }

        // Calculo do 3o. DÝgito Verificador
        digTot3 += (dig[NUMBER_TREZE - NUMBER_UM] * NUMBER_DOIS);
        y = NUMBER_SETE;

        for (x = NUMBER_NOVE; x <= NUMBER_DOZE; x++) {
                        y = (y - NUMBER_UM);
                        a = nAux[x - NUMBER_UM];
                        dig[x - NUMBER_UM] = (a * y);
                        digTot3 += dig[x - NUMBER_UM];
        }

        digTot3 += (dig[NUMBER_OITO - NUMBER_UM] * NUMBER_SETE);
        y = NUMBER_DEZ;

        for (x = NUMBER_SEIS; x <= NUMBER_SETE; x++) {
                        y = (y - NUMBER_UM);
                        a = nAux[x - NUMBER_UM];
                        dig[x - NUMBER_UM] = (a * y);
                        digTot3 += dig[x - NUMBER_UM];
        }

        y = NUMBER_SETE;
        for (x = NUMBER_UM; x <= NUMBER_CINCO; x++) {
                        y = (y - NUMBER_UM);
                        a = nAux[x - NUMBER_UM];
                        dig[x - NUMBER_UM] = (a * y);
                        digTot3 += dig[x - NUMBER_UM];
        }

        a = digTot3 / NUMBER_ONZE;
        b = (digTot3 - (a * NUMBER_ONZE));

        if (b == 0 || b == NUMBER_UM) {
            dig[NUMBER_QUATORZE - NUMBER_UM] = 0;
        } else {
            dig[NUMBER_QUATORZE - NUMBER_UM] = (NUMBER_ONZE - b);
        }

        return (String.valueOf(dig[NUMBER_TREZE - NUMBER_UM]) + String.valueOf(dig[NUMBER_QUATORZE - NUMBER_UM]));
	}

	public static String geraDigitoCnpj(String documento) {
		return cnpjCalculaDigito(documento);
	}

	public static String ajustaTamanhoZeros(String campo, int tamanho) {
        String retorno = "";

        String campoRetorno = campo;

        if (campoRetorno == null) {
            campoRetorno = "";
        }

        if (campoRetorno.length() == tamanho) {
                        retorno = campoRetorno;
        } else {
                        if (campoRetorno.length() > tamanho) {
                                        retorno = campoRetorno.substring(NUMBER_UM, tamanho);
                        } else {
                                        while (campoRetorno.length() < tamanho) {
                                                       campoRetorno = "0" + campoRetorno;
                                        }
                                        retorno = campoRetorno;
                        }
        }

        return retorno;
	}

}
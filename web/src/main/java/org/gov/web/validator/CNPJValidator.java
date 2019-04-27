package org.gov.web.validator;

import java.util.Arrays;
import java.util.List;

public class CNPJValidator
  implements CNPJValidation
{
  private boolean validate = false;
  private long cnpjValido = 0L;
  private long[] arrayCnpj = new long[8];
  private long[] digito = new long[8];
  private long digitoUm = 0L;
  private long digitoDois = 0L;
  private long resultado = 0L;
  private int[] multiplicador = { 5, 6, 7, 8, 9, 2, 3, 4, 5, 6, 7, 8, 9 };
  public static final int CNPJ_DIGITS = 14;

  public boolean validaCNPJ(String cnpj)
  {
    if (cnpj != null)
    {
      if ((!cnpj.equals("00000000")) && (!cnpj.trim().equals("")) && (cnpj.length() >= 8) && (cnpj.length() <= 8))
      {
        this.cnpjValido = Long.parseLong(cnpj);

        for (int i = 0; i <= 7; i++) {
          this.arrayCnpj[i] = (long)(this.cnpjValido / Math.pow(10.0D, 7 - i));
          this.cnpjValido = (long)(this.cnpjValido % Math.pow(10.0D, 7 - i));
        }

        for (int j = 0; j < this.arrayCnpj.length; j += 2)
        {
          this.resultado = (this.arrayCnpj[j] * 2L);

          if (this.resultado > 9L)
            this.digito[j] = (this.resultado - 9L);
          else {
            this.digito[j] = this.resultado;
          }

          this.digitoDois += this.digito[j];
        }

        for (int k = 1; k < this.arrayCnpj.length; k += 2) {
          this.digitoDois += this.arrayCnpj[k];
        }

        this.resultado = (this.digitoDois - this.digitoDois / 10L * 10L);

        if ((this.resultado == 0L) || (this.resultado == 1L))
          this.digito[7] = 0L;
        else {
          this.digito[7] = (10L - this.resultado);
        }

        if (this.digito[7] == this.arrayCnpj[7]) {
          this.validate = true;
        }
      }
    }

    return this.validate;
  }

  public boolean validaCNPJCompleto(String cnpjCompleto)
  {
    this.validate = false;

    if (cnpjCompleto != null)
    {
      if ((!cnpjCompleto.equals("00000000000000")) && (!cnpjCompleto.trim().equals("")) && (cnpjCompleto.length() >= 14) && (cnpjCompleto.length() <= 14))
      {
        int[] resultado = getDigitDocumentCPNJ(cnpjCompleto);

        if ((Integer.parseInt(cnpjCompleto.substring(12, 13)) == resultado[0]) && (Integer.parseInt(cnpjCompleto.substring(13, 14)) == resultado[1]) && (!validateInvalidCNPJ(cnpjCompleto.substring(0, 8))))
        {
          this.validate = true;
        }
      }

    }

    return this.validate;
  }

  public int[] getDigitDocumentCPNJ(String value)
  {
    this.digitoUm = 0L;
    this.digitoDois = 0L;

    if (value.length() < 12) {
      throw new IllegalArgumentException("Tamanho de argumento diverge do esperado!");
    }

    if (validateInvalidCNPJ(value.substring(0, 8)) == true) {
      throw new IllegalArgumentException("Documento Invalido!");
    }

    String cnpjCompleto = value.substring(0, 12);

    char[] array = cnpjCompleto.toCharArray();

    int[] arrayInt = new int[array.length + 1];

    for (int i = 0; i < array.length; i++) {
      arrayInt[i] = Integer.parseInt(String.valueOf(array[i]));
    }

    for (int j = 0; j < 12; j++) {
      this.resultado = (arrayInt[j] * this.multiplicador[(j + 1)]);
      this.digitoUm += this.resultado;
    }

    this.digitoUm %= 11L;

    if ((this.digitoUm == 10L) || (this.digitoUm == 11L)) {
      this.digitoUm = 0L;
    }

    arrayInt[12] = (int)this.digitoUm;

    for (int j = 0; j < 13; j++) {
      this.resultado = (arrayInt[j] * this.multiplicador[j]);
      this.digitoDois += this.resultado;
    }

    this.digitoDois %= 11L;

    if ((this.digitoDois == 10L) || (this.digitoDois == 11L)) {
      this.digitoDois = 0L;
    }

    int[] result = { (int)this.digitoUm, (int)this.digitoDois };

    return result;
  }

  private boolean validateInvalidCNPJ(String value)
  {
    boolean retorno = false;

    String[] invalidCNPJ = { "11111111", "22222222", "33333333", "44444444", "55555555", "66666666", "77777777", "88888888", "99999999" };

    if (Arrays.asList(invalidCNPJ).contains(value)) {
      retorno = true;
    }

    return retorno;
  }

  public boolean validateBaseDocument(int[] value)
  {
    boolean validate = false;

    long resultPar = 0L;
    long total = 0L;
    long result = 0L;

    for (int j = 0; j < 8; j++)
    {
      if (j % 2 == 0) {
        resultPar = value[j] * 2;
        total += (resultPar > 9L ? resultPar - 9L : resultPar);
      } else {
        total += value[j];
      }
    }

    result = total % 10L;

    if (value[7] == (int)result) {
      validate = true;
    }
    return validate;
  }
}
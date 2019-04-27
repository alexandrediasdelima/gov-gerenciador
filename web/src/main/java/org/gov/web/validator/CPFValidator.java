package org.gov.web.validator;

import java.util.Arrays;
import java.util.List;

public class CPFValidator
{
  public boolean validateCPF(String value)
  {
    boolean validate = false;

    if ((value != null) && (value.length() == 11))
    {
      int[] digitos = getDigitDocument(value.substring(0, 9));

      String document = value.substring(0, 9) + digitos[0] + digitos[1];

      if (value.equals(document)) {
        validate = true;
      }
    }
    if (validateInvalidCPF(value)) {
      validate = false;
    }

    return validate;
  }

  public int[] getDigitDocument(String value)
  {
    int digito1 = 0;
    int digito2 = 0;

    if (value.length() < 9)
    {
      throw new IllegalArgumentException("Invalid Parameter Length");
    }

    long cpf = Long.parseLong(value);
    for (int i = 1; i <= 9; i++) {
      long x = cpf % (long)Math.pow(10.0D, 10 - i);
      long y = x / (long)Math.pow(10.0D, 9 - i);
      digito1 = (int)(digito1 + y * i);
    }
    digito1 = digito1 % 11 % 10;

    cpf = Long.parseLong(value + digito1);
    for (int i = 1; i <= 10; i++) {
      long x = cpf % (long)Math.pow(10.0D, 11 - i);
      long y = x / (long)Math.pow(10.0D, 10 - i);
      digito2 = (int)(digito2 + y * (i - 1));
    }
    digito2 = digito2 % 11 % 10;

    return new int[] { digito1, digito2 };
  }

  private boolean validateInvalidCPF(String value)
  {
    boolean retorno = false;

    String[] invalidCPF = { "11111111111", "22222222222", "33333333333", "44444444444", "55555555555", "66666666666", "77777777777", "88888888888", "99999999999", "00000000000" };

    if (Arrays.asList(invalidCPF).contains(value)) {
      retorno = true;
    }

    return retorno;
  }
}
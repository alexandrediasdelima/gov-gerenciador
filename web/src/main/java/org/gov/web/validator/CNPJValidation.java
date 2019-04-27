package org.gov.web.validator;

public abstract interface CNPJValidation
{
  public static final int TAM_NUM_INSCRICAO = 8;
  public static final int TAM_CNPJ_COMPLETO = 14;

  public abstract boolean validaCNPJ(String paramString);

  public abstract boolean validaCNPJCompleto(String paramString);
}
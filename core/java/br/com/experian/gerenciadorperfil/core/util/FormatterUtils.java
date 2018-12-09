package br.com.experian.gerenciadorperfil.core.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import br.com.experian.gerenciadorperfil.core.exception.GerenciadorPerfilServiceException;

public final class FormatterUtils {

	private FormatterUtils() {
		//classe utilitaria
	}
	
	public static String formatCnpj(String cnpj) throws GerenciadorPerfilServiceException {
		String c = null;
		
		if(cnpj.contains(";")){
			throw new GerenciadorPerfilServiceException("Formato de entrada do documento para cliente direto inválido!");				
		}
		
		if (StringUtils.isBlank(cnpj)) {
			throw new GerenciadorPerfilServiceException("Não é permitido informar um CNPJ vazio!");
		}
		
		if (cnpj.length() > 8) {
			throw new GerenciadorPerfilServiceException("CNPJ com mais de 8 caracteres: " + cnpj);
		} else {
			c = StringUtils.leftPad(cnpj, 8, '0');
		}
		
		return validateCnpj(c);
	}
	
	public static String validateCnpj(String cnpj) throws GerenciadorPerfilServiceException {
		if (NumberUtils.isDigits(cnpj)) {
			return cnpj;
		} else {
			throw new GerenciadorPerfilServiceException("CNPJ inválido: " + cnpj);
		}
	}
	
	public static String formatCnpjLogon(String cnpjLogon) throws GerenciadorPerfilServiceException {
		String c = null;
		
		if (!StringUtils.isBlank(cnpjLogon)) {
			
			if(!cnpjLogon.contains(";")){
				throw new GerenciadorPerfilServiceException("Formato de entrada do documento para cliente indireto inválido!");				
			}
						
			String[]cnpjLogonAuxiliar = cnpjLogon.split(";");
			String cnpj = cnpjLogonAuxiliar[0];
			String logon = cnpjLogonAuxiliar[1];
			
			if (StringUtils.isBlank(cnpj)) {
				throw new GerenciadorPerfilServiceException("Não é permitido informar um CNPJ vazio!");
			}
			
			if (cnpj.length() > 8) {
				throw new GerenciadorPerfilServiceException("CNPJ com mais de 8 caracteres: " + cnpj);
			} else {
				c = StringUtils.leftPad(cnpj, 8, '0');
			}
						
			validateCnpj(c);
			
			if (StringUtils.isBlank(logon)) {
				throw new GerenciadorPerfilServiceException("Não é permitido informar um Logon vazio!");
			}
			
			if(logon.length() > 8){
				throw new GerenciadorPerfilServiceException("Logon com mais de 8 caracteres: " + logon);
			}
			
			//INC1502809 - Atribuir zeros a esquerda quando os CNPJs forem menores que 8 digitos;
			cnpjLogon = String.format("%s;%s", c, logon);
			
		}else{
			throw new GerenciadorPerfilServiceException("Não é permitido informar um CNPJ e Logon vazio!");
		}
		
		return cnpjLogon ;
	}
	
}

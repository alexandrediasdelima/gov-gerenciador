package br.com.experian.gerenciadorperfil.core.service.common;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;

import org.apache.commons.lang3.ArrayUtils;

public class ArquivoUploadDownload implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	public static final char TIPO_EXCEL = Character.valueOf('0');

	public static final String CONTENT_TYPE_EXCEL = "application/vnd.ms-excel";

	private String nome;

	private Character tipo;

	private String contentType;

	private byte[] bytes;

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the tipo
	 */
	public Character getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * @return the bytes
	 */
	public byte[] getBytes() {
		return ArrayUtils.nullToEmpty(this.bytes);
	}

	/**
	 * @param bytes the bytes to set
	 */
	public void setBytes(byte[] bytes) {
		this.bytes = ArrayUtils.nullToEmpty(bytes);
	}

	public int getLength() {
		return this.bytes.length;
	}

	public InputStream toInputStream() {
		return new ByteArrayInputStream(this.bytes);
	}

	@Override
	public ArquivoUploadDownload clone() throws CloneNotSupportedException {
		return (ArquivoUploadDownload) super.clone();
	}
}

package br.com.experian.gerenciadorperfil.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PC_GEP_IMAGEM_BOOK")
@SequenceGenerator(name = "SEQ_PC_GEP_IMAGEM_BOOK", sequenceName = "SEQ_PC_GEP_IMAGEM_BOOK", allocationSize = 1, initialValue = 1)
public class ImagemBook implements Serializable {

	private static final long serialVersionUID = -7081234553414665612L;

	public static final char AREA_CI = 'C';
	public static final char AREA_BI = 'B';
	
	public static final char CATEGORIA_FUNDO = 'F';
	public static final char CATEGORIA_TEXTO = 'T';
	public static final char CATEGORIA_BOTAO = 'B';
	
	public static final char TIPO_OFERTA = 'O';
	public static final char TIPO_CARONA = 'C';
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PC_GEP_IMAGEM_BOOK")
	@Column(name = "PK_PC_GEP_IMAGEM_BOOK")
	private long id;
	
	@Column(name = "DS_NOME")
	private String nome;
	
	@Column(name = "DS_AREA")
	private char area;
	
	@Column(name = "DS_CATEGORIA")
	private char categoria;
	
	@Column(name = "DS_TIPO")
	private char tipo;
	
	@Column(name = "DS_URL")
	private String url;

	@Column(name = "DT_CRIACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	
	@Column(name = "DS_LOGON_CRIACAO")
	private String logonCriacao;
	
	@Column(name = "DT_ALTERACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAlteracao;
	
	@Column(name = "DS_LOGON_ALTERACAO")
	private String logonAlteracao;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getArea() {
		return area;
	}

	public void setArea(char area) {
		this.area = area;
	}

	public char getCategoria() {
		return categoria;
	}

	public void setCategoria(char categoria) {
		this.categoria = categoria;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getLogonCriacao() {
		return logonCriacao;
	}

	public void setLogonCriacao(String logonCriacao) {
		this.logonCriacao = logonCriacao;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public String getLogonAlteracao() {
		return logonAlteracao;
	}

	public void setLogonAlteracao(String logonAlteracao) {
		this.logonAlteracao = logonAlteracao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImagemBook other = (ImagemBook) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ImagemBook [id=" + id + ", nome=" + nome + ", area=" + area + ", categoria=" + categoria + ", tipo="
				+ tipo + ", url=" + url + "]";
	}

}

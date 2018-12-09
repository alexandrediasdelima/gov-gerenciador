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

import org.apache.commons.lang3.StringUtils;

@Entity
@Table(name = "PC_GEP_USUARIO")
@SequenceGenerator(name = "SEQ_PC_GEP_USUARIO", sequenceName = "SEQ_PC_GEP_USUARIO", allocationSize = 1, initialValue = 1)
public class Usuario extends EntityBase implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static final int TAMANHO_CPF = 11;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PC_GEP_USUARIO")
	@Column(name = "PK_PC_GEP_USUARIO")
	private Long id;

	@Column(name = "DS_CPF")
	private String cpf;

	@Column(name = "DS_LOGIN_CRIACAO")
	private String loginCriacao;

	@Column(name = "DT_CRIACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		if (StringUtils.isNotBlank(cpf)) {
			this.cpf = StringUtils.leftPad(cpf, Usuario.TAMANHO_CPF, '0');
		} else {
			this.cpf = null;
		}
	}

	/**
	 * @return the loginCriacao
	 */
	public String getLoginCriacao() {
		return loginCriacao;
	}

	/**
	 * @param loginCriacao the loginCriacao to set
	 */
	public void setLoginCriacao(String loginCriacao) {
		this.loginCriacao = loginCriacao;
	}

	/**
	 * @return the dataCriacao
	 */
	public Date getDataCriacao() {
		if (dataCriacao != null) {
			return new Date(dataCriacao.getTime());
		} else {
			return null;
		}
	}

	/**
	 * @param dataCriacao the dataCriacao to set
	 */
	public void setDataCriacao(Date dataCriacao) {
		if (dataCriacao != null) {
			this.dataCriacao = new Date(dataCriacao.getTime());
		} else {
			this.dataCriacao = null;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return hashCode(id);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

}

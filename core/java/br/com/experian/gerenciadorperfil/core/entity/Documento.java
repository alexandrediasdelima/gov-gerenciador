package br.com.experian.gerenciadorperfil.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;


@Entity
@Table(name = "PC_GEP_DOCUMENTO")
@SequenceGenerator(name = "SEQ_PC_GEP_DOCUMENTO", sequenceName = "SEQ_PC_GEP_DOCUMENTO", allocationSize = 1, initialValue = 1)
public class Documento implements Serializable {

	private static final long serialVersionUID = 2035323910542586104L;

	public static final int TAMANHO_CNPJ = 9;

	@Id
	@Column(name = "PK_PC_GEP_DOCUMENTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PC_GEP_DOCUMENTO")
	private Long id;

	@Column(name = "DS_CNPJ")
	private String cnpj;

	@ManyToOne
	@JoinColumn(name = "FK_PC_GEP_CAMPANHA", referencedColumnName="PK_PC_GEP_CAMPANHA")
	private CampanhaGratuidade campanhaGratuidade;

	@Column(name = "DS_LOGON")
	private String login;
	 
	

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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		if (cnpj != null) {
			this.cnpj = StringUtils.leftPad(cnpj, 8, '0');
		} else {
			this.cnpj = null;
		}
	}

	/**
	 * @return the campanhaGratuidade
	 */
	public CampanhaGratuidade getCampanhaGratuidade() {
		return campanhaGratuidade;
	}

	/**
	 * @param campanhaGratuidade the campanhaGratuidade to set
	 */
	public void setCampanhaGratuidade(CampanhaGratuidade campanhaGratuidade) {
		this.campanhaGratuidade = campanhaGratuidade;
	}
	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((campanhaGratuidade == null) ? 0 : campanhaGratuidade
						.hashCode());
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		return result;
	}

	/**
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
		Documento other = (Documento) obj;
		if (campanhaGratuidade == null) {
			if (other.campanhaGratuidade != null) {
				return false;
			}
		} else if (!campanhaGratuidade.equals(other.campanhaGratuidade)) {
			return false;
		}
		if (cnpj == null) {
			if (other.cnpj != null) {
				return false;
			}
		} else if (!cnpj.equals(other.cnpj)) {
			return false;
		}
		
		if (login == null) {
			if (other.login != null) {
				return false;
			}
		} else if (!login.equals(other.login)) {
			return false;
		}
		return true;
	}
}


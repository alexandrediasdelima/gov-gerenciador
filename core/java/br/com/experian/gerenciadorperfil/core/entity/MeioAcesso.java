package br.com.experian.gerenciadorperfil.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PC_GEP_MEIO_ACESSO")
public class MeioAcesso extends EntityBase implements Serializable, Cloneable {

	private static final long serialVersionUID = 2035323910542586104L;


	@Id
	@Column(name = "PK_PC_GEP_MEIO_ACESSO")
	private Long id;

	@Column(name = "DS_TIPO_MEIO_ACESSO")
	private String descricaoMeioAcesso;

	
	
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

	public String getDescricaoMeioAcesso() {
		return descricaoMeioAcesso;
	}

	public void setDescricaoMeioAcesso(String descricaoMeioAcesso) {
		this.descricaoMeioAcesso = descricaoMeioAcesso;
	}

	
}
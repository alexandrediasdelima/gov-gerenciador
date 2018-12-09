package br.com.experian.gerenciadorperfil.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PC_GEP_CLIENTE")
public class Cliente extends EntityBase implements Serializable, Cloneable {

	private static final long serialVersionUID = 2035323910542586104L;


	@Id
	@Column(name = "PK_PC_GEP_CLIENTE")
	private Long id;

	@Column(name = "DS_TIPO_CLIENTE ")
	private String descricaoTipoCliente;

	
	
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

	public String getDescricaoTipoCliente() {
		return descricaoTipoCliente;
	}

	public void setDescricaoTipoCliente(String descricaoTipoCliente) {
		this.descricaoTipoCliente = descricaoTipoCliente;
	}

	
	
}
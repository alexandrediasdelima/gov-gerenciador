package br.com.experian.gerenciadorperfil.core.entity;

import java.io.Serializable;

public class EntityBase implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * @see java.lang.Object#hashCode()
	 */

	public int hashCode(Long id) {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public int hashCode(Integer id) {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


}

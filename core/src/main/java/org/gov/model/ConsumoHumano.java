package org.gov.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_consumo_humano")
public class ConsumoHumano implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ch_int_pfk")
	private int id = 172954;

	@Column(name = "cam_pop_urb_estimada")
	private Integer estimativaPopulacionalUrbana;

	@Column(name = "cam_pop_rural_estimada")
	private Integer estimativaPopulacionalRural;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getEstimativaPopulacionalUrbana() {
		return estimativaPopulacionalUrbana;
	}

	public void setEstimativaPopulacionalUrbana(
			Integer estimativaPopulacionalUrbana) {
		this.estimativaPopulacionalUrbana = estimativaPopulacionalUrbana;
	}

	public Integer getEstimativaPopulacionalRural() {
		return estimativaPopulacionalRural;
	}

	public void setEstimativaPopulacionalRural(
			Integer estimativaPopulacionalRural) {
		this.estimativaPopulacionalRural = estimativaPopulacionalRural;
	}


}

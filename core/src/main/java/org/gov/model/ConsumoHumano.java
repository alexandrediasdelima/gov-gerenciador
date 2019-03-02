package org.gov.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_consumo_humano")
public class ConsumoHumano implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="ch_int_pfk", nullable=false)
	@Id
	private Integer ch_int_pfk;

	@Column(name="cam_pop_urb_estimada")
	private Integer cam_pop_urb_estimada;

	@Column(name="cam_pop_rural_estimada")
	private Integer cam_pop_rural_estimada;

	public Integer getCh_int_pfk() {
		return ch_int_pfk;
	}

	public void setCh_int_pfk(Integer ch_int_pfk) {
		this.ch_int_pfk = ch_int_pfk;
	}

	public Integer getCam_pop_urb_estimada() {
		return cam_pop_urb_estimada;
	}

	public void setCam_pop_urb_estimada(Integer cam_pop_urb_estimada) {
		this.cam_pop_urb_estimada = cam_pop_urb_estimada;
	}

	public Integer getCam_pop_rural_estimada() {
		return cam_pop_rural_estimada;
	}

	public void setCam_pop_rural_estimada(Integer cam_pop_rural_estimada) {
		this.cam_pop_rural_estimada = cam_pop_rural_estimada;
	}

}

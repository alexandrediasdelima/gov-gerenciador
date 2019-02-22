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
	private int ch_int_pfk;

	@Column(name="cam_pop_urb_estimada")
	private int cam_pop_urb_estimada;

	@Column(name="cam_pop_rural_estimada")
	private int cam_pop_rural_estimada;

	public int getCh_int_pfk() {
		return ch_int_pfk;
	}

	public void setCh_int_pfk(int ch_int_pfk) {
		this.ch_int_pfk = ch_int_pfk;
	}

	public int getCam_pop_urb_estimada() {
		return cam_pop_urb_estimada;
	}

	public void setCam_pop_urb_estimada(int cam_pop_urb_estimada) {
		this.cam_pop_urb_estimada = cam_pop_urb_estimada;
	}

	public int getCam_pop_rural_estimada() {
		return cam_pop_rural_estimada;
	}

	public void setCam_pop_rural_estimada(int cam_pop_rural_estimada) {
		this.cam_pop_rural_estimada = cam_pop_rural_estimada;
	}

}

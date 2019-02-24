package org.gov.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.gov.util.PostgreSQLEnumType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@Entity
@Table(name= "tb_asbcarac")
@TypeDef(
	    name = "pgsql_enum",
	    typeClass = PostgreSQLEnumType.class)
public class Asbcarac implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Column(name ="asb_int_pfk")
	@Id
	private int id;

	@Column(name ="asb_nu_cotaterreno")
	private BigDecimal altitudeTerreno;

	@Column(name ="asb_nu_alturabocatubo")
	private BigDecimal altitudeBocaTubulacao;

	@Column(name ="asb_aqp_cd")
	private BigDecimal identificadorAquiferoPonto;

	@Column(name ="asb_dt_instalacao", columnDefinition="timestamp without time zone")
	private Date dataInstalacaoPoco;

	@Column(name ="asb_nu_diametroperfuracao")
	private BigDecimal diametroPerfuracao;

	@Column(name ="asb_nu_diametrofiltro")
	private BigDecimal diametroFiltro;

	@Column(name ="asb_nu_base")
	private BigDecimal profundidadeBaseMedidaApartirSuperficie;

	@Column(name ="asb_nu_topo")
	private BigDecimal profundidadeTopoMedidaApartirSuperficie;

	@Enumerated(EnumType.STRING)
	@Column(name ="asb_tnp_cd", columnDefinition="asb_tnp_enum")
	@Type(type = "pgsql_enum")
	private Asb_tnp_cd codigoIdentificador;

	@Enumerated(EnumType.STRING)
	@Column(name ="asb_tpn_cd", columnDefinition="asb_tpn_enum")
	@Type(type = "pgsql_enum")
	private Asb_tpn_cd tipoPenetracaoAquifero;

	@Enumerated(EnumType.STRING)
	@Column(name ="asb_tca_cd", columnDefinition="asb_tca_enum")
	@Type(type = "pgsql_enum")
	private Asb_tca_cd condicaoAquifero;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getAltitudeTerreno() {
		return altitudeTerreno;
	}

	public void setAltitudeTerreno(BigDecimal altitudeTerreno) {
		this.altitudeTerreno = altitudeTerreno;
	}

	public BigDecimal getAltitudeBocaTubulacao() {
		return altitudeBocaTubulacao;
	}

	public void setAltitudeBocaTubulacao(BigDecimal altitudeBocaTubulacao) {
		this.altitudeBocaTubulacao = altitudeBocaTubulacao;
	}

	public BigDecimal getIdentificadorAquiferoPonto() {
		return identificadorAquiferoPonto;
	}

	public void setIdentificadorAquiferoPonto(BigDecimal identificadorAquiferoPonto) {
		this.identificadorAquiferoPonto = identificadorAquiferoPonto;
	}

	public Date getDataInstalacaoPoco() {
		return dataInstalacaoPoco;
	}

	public void setDataInstalacaoPoco(Date dataInstalacaoPoco) {
		this.dataInstalacaoPoco = dataInstalacaoPoco;
	}

	public BigDecimal getDiametroPerfuracao() {
		return diametroPerfuracao;
	}

	public void setDiametroPerfuracao(BigDecimal diametroPerfuracao) {
		this.diametroPerfuracao = diametroPerfuracao;
	}

	public BigDecimal getDiametroFiltro() {
		return diametroFiltro;
	}

	public void setDiametroFiltro(BigDecimal diametroFiltro) {
		this.diametroFiltro = diametroFiltro;
	}


	public BigDecimal getProfundidadeBaseMedidaApartirSuperficie() {
		return profundidadeBaseMedidaApartirSuperficie;
	}

	public void setProfundidadeBaseMedidaApartirSuperficie(
			BigDecimal profundidadeBaseMedidaApartirSuperficie) {
		this.profundidadeBaseMedidaApartirSuperficie = profundidadeBaseMedidaApartirSuperficie;
	}

	public BigDecimal getProfundidadeTopoMedidaApartirSuperficie() {
		return profundidadeTopoMedidaApartirSuperficie;
	}

	public void setProfundidadeTopoMedidaApartirSuperficie(
			BigDecimal profundidadeTopoMedidaApartirSuperficie) {
		this.profundidadeTopoMedidaApartirSuperficie = profundidadeTopoMedidaApartirSuperficie;
	}

	public Asb_tnp_cd getCodigoIdentificador() {
		return codigoIdentificador;
	}

	public void setCodigoIdentificador(Asb_tnp_cd codigoIdentificador) {
		this.codigoIdentificador = codigoIdentificador;
	}

	public Asb_tpn_cd getTipoPenetracaoAquifero() {
		return tipoPenetracaoAquifero;
	}

	public void setTipoPenetracaoAquifero(Asb_tpn_cd tipoPenetracaoAquifero) {
		this.tipoPenetracaoAquifero = tipoPenetracaoAquifero;
	}

	public Asb_tca_cd getCondicaoAquifero() {
		return condicaoAquifero;
	}

	public void setCondicaoAquifero(Asb_tca_cd condicaoAquifero) {
		this.condicaoAquifero = condicaoAquifero;
	}

}
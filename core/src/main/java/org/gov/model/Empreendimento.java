package org.gov.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "tb_empreendimento")
public class Empreendimento implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="emp_id")
	@Id
	@GeneratedValue
	private Integer id;

	@Column(name="emp_nm_empreendimento")
	private String nomeEmpreendimento;

	@Column(name="cam_ar_total")
	private BigDecimal areaTotalPropriedade;

	@Column(name="cam_ar_total_uni")
	private String unidadeAreaTotalPropriedade;

	@Column(name="cam_end_propriedade")
	private String enderecoEmpreendimento;

	@Column(name="cam_tp_logradouro")
	private String tipoLogradouroEmpreendimento;

	@Column(name="cam_nm_logradouro")
	private String nomeLogradouroEmpreendimento;

	@Column(name="cam_nu_endereco")
	private String numeroLogradouroEmpreendimento;

	@Column(name="cam_complemento_end")
	private String complementoLogradouroEmpreendimento;

	@Column(name="cam_acesso_principal_end")
	private String nomeAcessoPrincipalEmpreendimento;

	@Column(name="apa_local")
	private String localEmpreendimento;

	@Column(name="cam_caixapostal_end")
	private String numeroCaixaPostalEmpreendimento;

	@Column(name="cam_cep_end")
	private String cepEmpreendimento;

	@Column(name="apa_muni_empreendimento")
	private String nomeMunicipioEmpreendimento;

	@Column(name="ing_nu_ibgemunicipio")
	private String ibgeMunicipioLocalizadaInterferencia;

	@Column(name="out_nu_processo_ana")
	private String numeroOutorga;

	@Column(name="usuario_id")
	private Integer idUsuario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeEmpreendimento() {
		return nomeEmpreendimento;
	}

	public void setNomeEmpreendimento(String nomeEmpreendimento) {
		this.nomeEmpreendimento = nomeEmpreendimento;
	}

	public BigDecimal getAreaTotalPropriedade() {
		return areaTotalPropriedade;
	}

	public void setAreaTotalPropriedade(BigDecimal areaTotalPropriedade) {
		this.areaTotalPropriedade = areaTotalPropriedade;
	}

	public String getUnidadeAreaTotalPropriedade() {
		return unidadeAreaTotalPropriedade;
	}

	public void setUnidadeAreaTotalPropriedade(
			String unidadeAreaTotalPropriedade) {
		this.unidadeAreaTotalPropriedade = unidadeAreaTotalPropriedade;
	}

	public String getEnderecoEmpreendimento() {
		return enderecoEmpreendimento;
	}

	public void setEnderecoEmpreendimento(String enderecoEmpreendimento) {
		this.enderecoEmpreendimento = enderecoEmpreendimento;
	}

	public String getTipoLogradouroEmpreendimento() {
		return tipoLogradouroEmpreendimento;
	}

	public void setTipoLogradouroEmpreendimento(
			String tipoLogradouroEmpreendimento) {
		this.tipoLogradouroEmpreendimento = tipoLogradouroEmpreendimento;
	}

	public String getNomeLogradouroEmpreendimento() {
		return nomeLogradouroEmpreendimento;
	}

	public void setNomeLogradouroEmpreendimento(
			String nomeLogradouroEmpreendimento) {
		this.nomeLogradouroEmpreendimento = nomeLogradouroEmpreendimento;
	}

	public String getNumeroLogradouroEmpreendimento() {
		return numeroLogradouroEmpreendimento;
	}

	public void setNumeroLogradouroEmpreendimento(
			String numeroLogradouroEmpreendimento) {
		this.numeroLogradouroEmpreendimento = numeroLogradouroEmpreendimento;
	}

	public String getComplementoLogradouroEmpreendimento() {
		return complementoLogradouroEmpreendimento;
	}

	public void setComplementoLogradouroEmpreendimento(
			String complementoLogradouroEmpreendimento) {
		this.complementoLogradouroEmpreendimento = complementoLogradouroEmpreendimento;
	}

	public String getNomeAcessoPrincipalEmpreendimento() {
		return nomeAcessoPrincipalEmpreendimento;
	}

	public void setNomeAcessoPrincipalEmpreendimento(
			String nomeAcessoPrincipalEmpreendimento) {
		this.nomeAcessoPrincipalEmpreendimento = nomeAcessoPrincipalEmpreendimento;
	}

	public String getLocalEmpreendimento() {
		return localEmpreendimento;
	}

	public void setLocalEmpreendimento(String localEmpreendimento) {
		this.localEmpreendimento = localEmpreendimento;
	}

	public String getNumeroCaixaPostalEmpreendimento() {
		return numeroCaixaPostalEmpreendimento;
	}

	public void setNumeroCaixaPostalEmpreendimento(
			String numeroCaixaPostalEmpreendimento) {
		this.numeroCaixaPostalEmpreendimento = numeroCaixaPostalEmpreendimento;
	}

	public String getCepEmpreendimento() {
		return cepEmpreendimento;
	}

	public void setCepEmpreendimento(String cepEmpreendimento) {
		this.cepEmpreendimento = cepEmpreendimento;
	}

	public String getNomeMunicipioEmpreendimento() {
		return nomeMunicipioEmpreendimento;
	}

	public void setNomeMunicipioEmpreendimento(
			String nomeMunicipioEmpreendimento) {
		this.nomeMunicipioEmpreendimento = nomeMunicipioEmpreendimento;
	}

	public String getIbgeMunicipioLocalizadaInterferencia() {
		return ibgeMunicipioLocalizadaInterferencia;
	}

	public void setIbgeMunicipioLocalizadaInterferencia(
			String ibgeMunicipioLocalizadaInterferencia) {
		this.ibgeMunicipioLocalizadaInterferencia = ibgeMunicipioLocalizadaInterferencia;
	}

	public String getNumeroOutorga() {
		return numeroOutorga;
	}

	public void setNumeroOutorga(String numeroOutorga) {
		this.numeroOutorga = numeroOutorga;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

}

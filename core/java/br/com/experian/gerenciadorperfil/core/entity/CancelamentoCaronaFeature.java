package br.com.experian.gerenciadorperfil.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PC_GEP_CANCEL_CAMPANHA_DESC")
@SequenceGenerator(name = "SEQ_PC_GEP_CANCEL_CAMP_DESC", sequenceName = "SEQ_PC_GEP_CANCEL_CAMP_DESC", allocationSize = 1, initialValue = 1)
public class CancelamentoCaronaFeature extends EntityBase implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	public static final Character INTERNO = 'I';
	public static final Character EXTERNO = 'E';
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PC_GEP_CANCEL_CAMP_DESC")
	@Column(name = "PK_PC_GEP_CANCEL_CAMPANHA_DESC")
	private Long id;
	
	@Column(name = "DS_LOGON_CANCELAMENTO")
	private String logonCancelamento;
	
	@Column(name = "TP_CANCELAMENTO")
	private Character tipoCancelamento;
	
	@Column(name = "DT_CANCELAMENTO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCancelamento;
	
	@OneToOne
	@JoinColumn(name = "FK_PC_GEP_DOC_CAMPANHA_DESC", referencedColumnName = "PK_PC_GEP_DOC_CAMPANHA_DESC")
	private DocumentoCaronaFeature documentoCaronaFeature;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogonCancelamento() {
		return logonCancelamento;
	}

	public void setLogonCancelamento(String logonCancelamento) {
		this.logonCancelamento = logonCancelamento;
	}

	public Character getTipoCancelamento() {
		return tipoCancelamento;
	}

	public void setTipoCancelamento(Character tipoCancelamento) {
		this.tipoCancelamento = tipoCancelamento;
	}

	public Date getDataCancelamento() {
		return dataCancelamento;
	}

	public void setDataCancelamento(Date dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CancelamentoCaronaFeature other = (CancelamentoCaronaFeature) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CancelamentoCaronaFeature [id=" + id + ", logonCancelamento=" + logonCancelamento
				+ ", tipoCancelamento=" + tipoCancelamento + ", dataCancelamento=" + dataCancelamento + "]";
	}

	public DocumentoCaronaFeature getDocumentoCaronaFeature() {
		return documentoCaronaFeature;
	}

	public void setDocumentoCaronaFeature(DocumentoCaronaFeature documentoCaronaFeature) {
		this.documentoCaronaFeature = documentoCaronaFeature;
	}
}

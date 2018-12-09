package br.com.experian.gerenciadorperfil.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PC_GEP_ACEITE_CAMPANHA_DESC")
@SequenceGenerator(name = "SEQ_PC_GEP_ACEITE_CAMP_DESC", sequenceName = "SEQ_PC_GEP_ACEITE_CAMP_DESC", allocationSize = 1, initialValue = 1)
public class RespostaCaronaFeature extends EntityBase implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	
	public static final Character SIM = 'S';
	public static final Character NAO = 'N';
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PC_GEP_ACEITE_CAMP_DESC")
	@Column(name = "PK_PC_GEP_ACEITE_CAMPANHA_DESC")
	private Long id;
	
	@Column(name = "DT_APRESENTACAO_BANNER")
	private Date dataApresentacaoBanner;
	
	@Column(name = "DS_RESPOSTA")
	private Character resposta;
	
	@Column(name = "DT_RESPOSTA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataResposta;
	
	@Column(name = "DS_LOGON_RESPOSTA")
	private String logonResposta;
	
	@ManyToOne
	@JoinColumn(name = "FK_PC_GEP_DOC_CAMPANHA_DESC", referencedColumnName = "PK_PC_GEP_DOC_CAMPANHA_DESC")
	private DocumentoCaronaFeature documentoCaronaFeature;
	
	@OneToOne(mappedBy = "respostaCaronaFeature")
	private CienciaCaronaFeaturesOptout cienciaCaronaFeaturesOptout;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataApresentacaoBanner() {
		return dataApresentacaoBanner;
	}

	public void setDataApresentacaoBanner(Date dataApresentacaoBanner) {
		this.dataApresentacaoBanner = dataApresentacaoBanner;
	}

	public Character getResposta() {
		return resposta;
	}

	public void setResposta(Character resposta) {
		this.resposta = resposta;
	}

	public Date getDataResposta() {
		return dataResposta;
	}

	public void setDataResposta(Date dataResposta) {
		this.dataResposta = dataResposta;
	}

	public String getLogonResposta() {
		return logonResposta;
	}

	public void setLogonResposta(String logonResposta) {
		this.logonResposta = logonResposta;
	}

	public DocumentoCaronaFeature getDocumentoCaronaFeature() {
		return documentoCaronaFeature;
	}

	public void setDocumentoCaronaFeature(
			DocumentoCaronaFeature documentoCaronaFeature) {
		this.documentoCaronaFeature = documentoCaronaFeature;
	}	

	public CienciaCaronaFeaturesOptout getCienciaCaronaFeaturesOptout() {
		return cienciaCaronaFeaturesOptout;
	}

	public void setCienciaCaronaFeaturesOptout(CienciaCaronaFeaturesOptout cienciaCaronaFeaturesOptout) {
		this.cienciaCaronaFeaturesOptout = cienciaCaronaFeaturesOptout;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RespostaCaronaFeature other = (RespostaCaronaFeature) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RespostaCaronaFeature [id=" + id + ", dataApresentacaoBanner=" + dataApresentacaoBanner
				+ ", resposta=" + resposta + ", dataResposta=" + dataResposta + ", logonResposta=" + logonResposta + "]";
	}

	
}

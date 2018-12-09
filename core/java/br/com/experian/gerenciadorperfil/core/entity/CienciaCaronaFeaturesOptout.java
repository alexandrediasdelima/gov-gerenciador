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
@Table(name = "PC_GEP_CIENCIA_ACEITE_DESC")
@SequenceGenerator(name = "SEQ_PC_GEP_CIENCIA_ACEITE_DESC", sequenceName = "SEQ_PC_GEP_CIENCIA_ACEITE_DESC", allocationSize = 1, initialValue = 1)
public class CienciaCaronaFeaturesOptout extends EntityBase implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PC_GEP_CIENCIA_ACEITE_DESC")
	@Column(name = "PK_PC_GEP_CIENCIA_ACEITE_DESC")
	private Long id;	
	
	@Column(name = "DT_ACEITE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAceite;
	
	@Column(name = "DS_LOGON_ACEITE")
	private String logonAceite;
	
	@OneToOne
	@JoinColumn(name = "FK_PC_GEP_ACEITE_CAMPANHA_DESC", referencedColumnName = "PK_PC_GEP_ACEITE_CAMPANHA_DESC")
	private RespostaCaronaFeature respostaCaronaFeature;
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CienciaCaronaFeaturesOptout other = (CienciaCaronaFeaturesOptout) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RespostaCaronaFeature [id=" + id + ", dataCiencia=" + this.dataAceite +", logonAceite=" + this.logonAceite + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataAceite() {
		return dataAceite;
	}

	public void setDataAceite(Date dataAceite) {
		this.dataAceite = dataAceite;
	}

	public String getLogonAceite() {
		return logonAceite;
	}

	public void setLogonAceite(String logonAceite) {
		this.logonAceite = logonAceite;
	}

	public RespostaCaronaFeature getRespostaCaronaFeature() {
		return respostaCaronaFeature;
	}

	public void setRespostaCaronaFeature(RespostaCaronaFeature respostaCaronaFeature) {
		this.respostaCaronaFeature = respostaCaronaFeature;
	}

	
	
}

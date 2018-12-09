package br.com.experian.gerenciadorperfil.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PC_GEP_FEATURE_DESC")
@SequenceGenerator(name = "SEQ_PC_GEP_FEATURE_DESC", sequenceName = "SEQ_PC_GEP_FEATURE_DESC", initialValue = 1, allocationSize = 1)
public class FeatureDesconto extends EntityBase implements Serializable, Cloneable {

	private static final long serialVersionUID = -8095117230587080017L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PC_GEP_FEATURE_DESC")
	@Column(name = "PK_PC_GEP_FEATURE_DESC")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "FK_PC_GEP_FEATURE", referencedColumnName="PK_PC_GEP_FEATURE")
	private Feature feature;
	
	@Column(name = "DS_TRANSACAO_DESC")
	private String transacao;	

	public FeatureDesconto() {}
	
	public FeatureDesconto(Feature feature) {
		this.feature = feature;
	}
	
	public FeatureDesconto(Feature feature, String transacao) {
		this(feature);
		this.transacao = transacao;
	}	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Feature getFeature() {
		return feature;
	}

	public void setFeature(Feature feature) {
		this.feature = feature;
	}

	public String getTransacao() {
		return transacao;
	}

	public void setTransacao(String transacao) {
		this.transacao = transacao;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FeatureDesconto other = (FeatureDesconto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FeatureDesconto [id=" + id + ", feature=" + (feature != null ? feature.getTransacao() : null)
				+ ", transacao=" + transacao + "]";
	}
	
}

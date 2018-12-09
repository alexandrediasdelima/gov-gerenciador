package br.com.experian.gerenciadorperfil.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.experian.gerenciadorperfil.core.service.common.SimNao;
import br.com.experian.gerenciadorperfil.core.util.enumeration.EnumTipoAssociacao;

@Entity
@Table(name = "PC_GEP_FEATURE")
@SequenceGenerator(name = "SEQ_PC_GEP_FEATURE", sequenceName = "SEQ_PC_GEP_FEATURE", initialValue = 1, allocationSize = 1)
public class Feature extends EntityBase implements Serializable, Cloneable {

	private static final long serialVersionUID = -6831198201662383898L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PC_GEP_FEATURE")
	@Column(name = "PK_PC_GEP_FEATURE")
	private Integer id;

	@Column(name = "DS_TRANSACAO")
	private String transacao;

	@Column(name = "NO_NOME")
	private String nome;

	@ManyToOne
	@JoinColumn(name = "FK_PC_GEP_PRODUTO", referencedColumnName="PK_PC_GEP_PRODUTO")
	private Produto produto;

	@Column(name = "NU_NOVO")
	private Integer novo = SimNao.NAO;

	@Column(name = "DS_LOGIN_CRIACAO")
	private String loginCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DT_CRIACAO")
	private Date dataCriacao;

	@Column(name = "DS_LOGIN_ALTERACAO")
	private String loginAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DT_ATUALIZACAO")
	private Date dataAlteracao;

	@ManyToOne
	@JoinColumn(name = "FK_PC_GEP_FEATURE", referencedColumnName="PK_PC_GEP_FEATURE")
	private Feature feature;
	
	@OneToMany(mappedBy = "feature", fetch=FetchType.EAGER)
	private List<Feature> associacoes;

	@OneToOne(mappedBy = "feature", cascade = CascadeType.ALL)
	private FeatureDesconto featureDesconto;
	
	@Column(name = "TP_ASSOCIACAO")
	private String tipoAssociacao;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTransacao() {
		return transacao;
	}

	public void setTransacao(String transacao) {
		this.transacao = transacao;
	}

	@Override
	protected Feature clone() throws CloneNotSupportedException {
		return (Feature) super.clone();
	}

	@Override
	public int hashCode() {
		return hashCode(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Feature)) {
			return false;
		}
		Feature other = (Feature) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getNovo() {
		return novo;
	}

	public void setNovo(Integer novo) {
		this.novo = novo;
	}

	public String getLoginCriacao() {
		return loginCriacao;
	}

	public void setLoginCriacao(String loginCriacao) {
		this.loginCriacao = loginCriacao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getLoginAlteracao() {
		return loginAlteracao;
	}

	public void setLoginAlteracao(String loginAlteracao) {
		this.loginAlteracao = loginAlteracao;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public Feature getFeature() {
		return feature;
	}

	public void setFeature(Feature feature) {
		this.feature = feature;
	}

	public FeatureDesconto getFeatureDesconto() {
		return featureDesconto;
	}

	public void setFeatureDesconto(FeatureDesconto featureDesconto) {
		this.featureDesconto = featureDesconto;
	}

	public String getTipoAssociacao() {
		return tipoAssociacao;
	}

	public void setTipoAssociacao(String tipoAssociacao) {
		this.tipoAssociacao = tipoAssociacao;
	}

	public List<Feature> getAssociacoes() {
		return associacoes;
	}

	public void setAssociacoes(List<Feature> associacoes) {
		this.associacoes = associacoes;
	}
	
	public Feature getReciprocidade(){
		if(!associacoes.isEmpty()){
			for(Feature feature : associacoes){
				if(EnumTipoAssociacao.RECIPROCIDADE.getTipo().equals(feature.getTipoAssociacao())){
					return feature;
				}
			}
		}
		return null;
	}
}

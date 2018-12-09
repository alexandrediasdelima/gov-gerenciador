package br.com.experian.gerenciadorperfil.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PC_GEP_DOC_CAMPANHA_DESC")
@SequenceGenerator(name = "SEQ_PC_GEP_DOC_CAMPANHA_DESC", sequenceName = "SEQ_PC_GEP_DOC_CAMPANHA_DESC", allocationSize = 1, initialValue = 1)
public class DocumentoCaronaFeature extends EntityBase implements Serializable, Cloneable {

	private static final long serialVersionUID = 3290571660394874712L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PC_GEP_DOC_CAMPANHA_DESC")
	@Column(name = "PK_PC_GEP_DOC_CAMPANHA_DESC")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "FK_PC_GEP_CAMPANHA_DESC", referencedColumnName = "PK_PC_GEP_CAMPANHA_DESC")
	private CaronaFeature caronaFeature;
	
	@OneToMany(mappedBy = "documentoCaronaFeature")
	private List<RespostaCaronaFeature> respostasCaronaFeature;
	
	@OneToOne(mappedBy = "documentoCaronaFeature")
	private CancelamentoCaronaFeature cancelamentoCaronaFeature;

	@Column(name = "DS_CNPJ")
	private String cnpj;
	
	@Column(name = "DS_LOGON")
	private String login;

	public DocumentoCaronaFeature() {
	}

	public DocumentoCaronaFeature(Long id, String cnpj, String login, Long idCampanha, String nomeCampanha, Date dataInicioCampanha, Date dataFimCampanha) {
		this.id = id;
		this.cnpj = cnpj;
		this.login = login;
		this.caronaFeature = new CaronaFeature();
		this.caronaFeature.setId(idCampanha);
		this.caronaFeature.setNome(nomeCampanha);
		this.caronaFeature.setDataInicio(dataInicioCampanha);
		this.caronaFeature.setDataFim(dataFimCampanha);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CaronaFeature getCaronaFeature() {
		return caronaFeature;
	}

	public void setCaronaFeature(CaronaFeature caronaFeature) {
		this.caronaFeature = caronaFeature;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public List<RespostaCaronaFeature> getRespostasCaronaFeature() {
		return respostasCaronaFeature;
	}

	public void setRespostasCaronaFeature(
			List<RespostaCaronaFeature> respostasCaronaFeature) {
		this.respostasCaronaFeature = respostasCaronaFeature;
	}

	public CancelamentoCaronaFeature getCancelamentoCaronaFeature() {
		return cancelamentoCaronaFeature;
	}

	public void setCancelamentoCaronaFeature(
			CancelamentoCaronaFeature cancelamentoCaronaFeature) {
		this.cancelamentoCaronaFeature = cancelamentoCaronaFeature;
	}

	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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
		DocumentoCaronaFeature other = (DocumentoCaronaFeature) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DocumentoCaronaFeature [id=" + id + ", cnpj=" + cnpj + "]";
	}

}

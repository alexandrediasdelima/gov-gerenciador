package br.com.experian.gerenciadorperfil.core.service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.experian.gerenciadorperfil.core.dao.AvisoDeAlertaDAO;
import br.com.experian.gerenciadorperfil.core.entity.AvisoDeAlerta;
import br.com.experian.gerenciadorperfil.core.entity.HistoricoAceite;
import br.com.experian.gerenciadorperfil.core.entity.HistoricoAlteracaoAlerta;
import br.com.experian.gerenciadorperfil.core.entity.HistoricoAvisoDeAlerta;
import br.com.experian.gerenciadorperfil.core.entity.Produto;
import br.com.experian.gerenciadorperfil.core.entity.filter.AvisoDeAlertaFilter;
import br.com.experian.gerenciadorperfil.core.exception.GerenciadorPerfilServiceException;
import br.com.experian.gerenciadorperfil.core.util.DateCompare;

@Service
public class AvisoDeAlertaServiceImpl extends AbstractService<AvisoDeAlerta, Integer, AvisoDeAlertaFilter, AvisoDeAlertaDAO> implements AvisoDeAlertaService {

	@Autowired
	private HistoricoAvisoDeAlertaService historicoAvisoDeAlertaService;

	@Autowired
	public AvisoDeAlertaServiceImpl(AvisoDeAlertaDAO avisoDeAlertaDao) {
		super(avisoDeAlertaDao);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public AvisoDeAlerta obterPorProduto(Produto produto) {

		AvisoDeAlertaFilter avisoDeAlertaFilter = new AvisoDeAlertaFilter().setIdProdutoEquals(produto.getId());

		List<AvisoDeAlerta> avisosDeAlerta = getDao().listar(avisoDeAlertaFilter);

		if (avisosDeAlerta.isEmpty()) {
			return null;
		}

		return avisosDeAlerta.get(0);
	}

	private void validar(AvisoDeAlerta avisoDeAlerta) throws GerenciadorPerfilServiceException {

		if (avisoDeAlerta.getProduto() == null) {
			throw new GerenciadorPerfilServiceException("Produto é requerido para criação");
		}

		if (avisoDeAlerta.getDiasParaEmissao() == null || avisoDeAlerta.getDiasParaEmissao() < 0) {
			throw new GerenciadorPerfilServiceException("Quantidade de dias inválido");
		}

		if (avisoDeAlerta.getDataInicio() == null) {
			throw new GerenciadorPerfilServiceException("Data de Início Obrigatória");
		}
		
		if (DateCompare.after(avisoDeAlerta.getDataInicio(), DateCompare.DATE_PLUS_100_YEARS)) {
			throw new GerenciadorPerfilServiceException("Data de Início inválida");
		}

		if (StringUtils.isBlank(avisoDeAlerta.getTexto())) {
			throw new GerenciadorPerfilServiceException("Texto é requerido");
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void remover(AvisoDeAlerta avisoDeAlerta) throws GerenciadorPerfilServiceException {
		//historicoAvisoDeAlertaService.removerPorProduto(avisoDeAlerta.getProduto());
		
		AvisoDeAlerta avisoDeAlertaClonado = (AvisoDeAlerta) SerializationUtils.clone(avisoDeAlerta);
		avisoDeAlertaClonado.setDataAlteracao(new Date());
		avisoDeAlertaClonado = super.atualizar(avisoDeAlertaClonado);
		HistoricoAvisoDeAlerta historicoAvisoDeAlerta = getHistoricoAvisoDeAlerta(avisoDeAlerta, avisoDeAlertaClonado.getDataAlteracao(),HistoricoAvisoDeAlerta.DELETE);
		historicoAvisoDeAlertaService.adicionar(historicoAvisoDeAlerta);
		
		super.remover(avisoDeAlerta);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public AvisoDeAlerta adicionar(AvisoDeAlerta avisoDeAlerta) throws GerenciadorPerfilServiceException {

		validar(avisoDeAlerta);

		AvisoDeAlerta avisoDeAlertaClonado = (AvisoDeAlerta) SerializationUtils.clone(avisoDeAlerta);
		avisoDeAlertaClonado.setId(avisoDeAlertaClonado.getProduto().getId());
		avisoDeAlertaClonado.setDataCriacao(new Date());

		HistoricoAvisoDeAlerta historicoAvisoDeAlerta = getHistoricoAvisoDeAlerta(avisoDeAlerta, avisoDeAlertaClonado.getDataCriacao(),HistoricoAvisoDeAlerta.INSERT);
		historicoAvisoDeAlertaService.adicionar(historicoAvisoDeAlerta);

		return super.adicionar(avisoDeAlertaClonado);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public AvisoDeAlerta atualizar(AvisoDeAlerta avisoDeAlerta) throws GerenciadorPerfilServiceException {

		validar(avisoDeAlerta);

		if (avisoDeAlerta.getLoginAlteracao() == null) {
			throw new GerenciadorPerfilServiceException("Login de alteração é requerido, entre em contato com o suporte");
		}

		AvisoDeAlerta avisoDeAlertaClonado = (AvisoDeAlerta) SerializationUtils.clone(avisoDeAlerta);
		avisoDeAlertaClonado.setDataAlteracao(new Date());
		avisoDeAlertaClonado = super.atualizar(avisoDeAlertaClonado);
		HistoricoAvisoDeAlerta historicoAvisoDeAlerta = getHistoricoAvisoDeAlerta(avisoDeAlerta, avisoDeAlertaClonado.getDataAlteracao(),HistoricoAvisoDeAlerta.UPDATE);

		historicoAvisoDeAlertaService.adicionar(historicoAvisoDeAlerta);

		return avisoDeAlertaClonado;
	}

	private HistoricoAvisoDeAlerta getHistoricoAvisoDeAlerta(AvisoDeAlerta avisoDeAlerta, Date data, String operacao) {
		HistoricoAvisoDeAlerta historicoAvisoDeAlerta = new HistoricoAvisoDeAlerta();

		historicoAvisoDeAlerta.setProdutoHistorico(avisoDeAlerta.getProduto());
		historicoAvisoDeAlerta.setTextoHistorico(avisoDeAlerta.getTexto());
		historicoAvisoDeAlerta.setTextoOutrosIdiomasHistorico(avisoDeAlerta.getTextoOutrosIdiomas());
		historicoAvisoDeAlerta.setLoginCriacaoHistorico(avisoDeAlerta.getLoginAlteracao());
		historicoAvisoDeAlerta.setDataCriacaoHistorico(data);
		historicoAvisoDeAlerta.setAcao(operacao);
		return historicoAvisoDeAlerta;
	}

	/**
	 * @param historicoAvisoDeAlertaService the historicoAvisoDeAlertaService to set
	 */
	public void setHistoricoAvisoDeAlertaService(HistoricoAvisoDeAlertaService historicoAvisoDeAlertaService) {
		this.historicoAvisoDeAlertaService = historicoAvisoDeAlertaService;
	}

	public List<HistoricoAceite> obterHistoricoDeAceite(Produto produto, Date dataInicio) {

		Timestamp time = convertTime(dataInicio);
		return super.getDao().gerarExcelHistoricoDeAceite(produto, time);

	}


	public List<HistoricoAlteracaoAlerta> obterHistoricoDeAlteracaoAlerta(Produto produto,	Date dataInicio) {
		Timestamp time = convertTime(dataInicio);
		return super.getDao().gerarExcelHistoricoDeAlteracaoAlerta(produto, time);
	}

	private Timestamp convertTime(Date dataInicio) {
		Timestamp time = null;
		Calendar c = Calendar.getInstance();

		if (dataInicio != null){
			c.setTime(dataInicio);
			c.set(Calendar.HOUR_OF_DAY, 0);
			c.set(Calendar.MINUTE, 0);
			c.set(Calendar.SECOND, 0);
			time = new Timestamp(c.getTimeInMillis());
		}
		return time;
	}

}

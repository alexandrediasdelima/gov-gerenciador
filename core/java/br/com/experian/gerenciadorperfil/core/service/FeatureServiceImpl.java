package br.com.experian.gerenciadorperfil.core.service;

import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.experian.commons.strings.gm53.bean.ProtocoloGM53;
import br.com.experian.commons.strings.gm53.bean.RetornoGM53;
import br.com.experian.gerenciadorperfil.core.dao.FeatureDAO;
import br.com.experian.gerenciadorperfil.core.entity.BookURL;
import br.com.experian.gerenciadorperfil.core.entity.CampanhaGratuidade;
import br.com.experian.gerenciadorperfil.core.entity.Feature;
import br.com.experian.gerenciadorperfil.core.entity.FeatureDesconto;
import br.com.experian.gerenciadorperfil.core.entity.Oferta;
import br.com.experian.gerenciadorperfil.core.entity.Produto;
import br.com.experian.gerenciadorperfil.core.entity.filter.FeatureFilter;
import br.com.experian.gerenciadorperfil.core.exception.BookURLServiceException;
import br.com.experian.gerenciadorperfil.core.exception.GerenciadorPerfilServiceException;
import br.com.experian.gerenciadorperfil.core.util.CoreUtils;

@Service
public class FeatureServiceImpl extends AbstractService<Feature, Integer, FeatureFilter, FeatureDAO> implements FeatureService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FeatureServiceImpl.class);
	
	private static final Locale LOCALE_PT_BR = new Locale("pt", "BR");

	private static final int TAMANHO_NOME_FEATURE = 4;

	@Autowired
	private CampanhaGratuidadeService campanhaGratuidadeService;
	
	@Autowired
	private OfertaService ofertaService;

	@Autowired
	public FeatureServiceImpl(FeatureDAO featureDAO) {
		super(featureDAO);
	}

	/**
	 * @param campanhaGratuidadeService the campanhaGratuidadeService to set
	 */
	public void setCampanhaGratuidadeService(CampanhaGratuidadeService campanhaGratuidadeService) {
		this.campanhaGratuidadeService = campanhaGratuidadeService;
	}
	
	public void setOfertaService(OfertaService ofertaService) {
		this.ofertaService = ofertaService;
	}

	private void validarDadosComum(Feature feature) throws GerenciadorPerfilServiceException {

		if (StringUtils.isBlank(feature.getNome())) {
			throw new GerenciadorPerfilServiceException("Nome da feature é requerido");
		}

		if (StringUtils.isBlank(feature.getTransacao()) || feature.getTransacao().trim().length() != TAMANHO_NOME_FEATURE) {
			throw new GerenciadorPerfilServiceException("Transação deve possuir exatos 4 caracteres");
		}

		if (!feature.getTransacao().matches("[a-zA-Z0-9]{4}")) {
			throw new GerenciadorPerfilServiceException("Transação só pode ter caracteres entre A-Z e 0-9");
		}

		if (feature.getProduto() == null) {
			throw new GerenciadorPerfilServiceException("Produto é requerido");
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Feature adicionar(Feature feature) throws GerenciadorPerfilServiceException {

		validarDadosComum(feature);

		Feature featureClonada = (Feature) SerializationUtils.clone(feature);

		featureClonada.setTransacao(featureClonada.getTransacao().toUpperCase(LOCALE_PT_BR));
		featureClonada.setNome(featureClonada.getNome().trim());

		Feature featureExistente = getDao().obterPorTransacaoEmProduto(featureClonada.getTransacao(), featureClonada.getProduto());

		if (featureExistente != null) {
			throw new GerenciadorPerfilServiceException("Já existe uma feature com esta transação cadastrado no produto " + featureClonada.getProduto().getNome());
		}

		featureExistente = getDao().obterPorNomeEmProduto(feature.getNome(), feature.getProduto());

		if (featureExistente != null) {
			throw new GerenciadorPerfilServiceException("Já existe uma feature com este nome cadastrado no produto " + featureClonada.getProduto().getNome());
		}

		return super.adicionar(featureClonada);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Feature atualizar(Feature feature) throws GerenciadorPerfilServiceException {

		validarDadosComum(feature);

		Feature featureClonada = (Feature) SerializationUtils.clone(feature);

		featureClonada.setTransacao(featureClonada.getTransacao().toUpperCase(LOCALE_PT_BR));
		featureClonada.setNome(featureClonada.getNome().trim());

		Feature featureExistente = getDao().obterPorTransacaoEmProduto(featureClonada.getTransacao(), featureClonada.getProduto());

		if (featureExistente != null && !featureExistente.equals(featureClonada)) {
			throw new GerenciadorPerfilServiceException("Já existe uma feature com esta transação cadastrada no produto " + featureClonada.getProduto().getNome());
		}

		featureExistente = getDao().obterPorNomeEmProduto(feature.getNome(), feature.getProduto());

		if (featureExistente != null && !featureExistente.equals(featureClonada)) {
			throw new GerenciadorPerfilServiceException("Já existe uma feature com este nome cadastrado no produto " + featureClonada.getProduto().getNome());
		}

		return super.atualizar(featureClonada);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void remover(Feature feature) throws GerenciadorPerfilServiceException {
		
		List<Feature> featEspelho = obterFeatureEspelho(feature.getId());
		if (featEspelho != null && !featEspelho.isEmpty()) {
			throw new GerenciadorPerfilServiceException("Não é possível remover uma Feature que contenha transações associadas.");
		}

		List<CampanhaGratuidade> campanhasGratuidade = campanhaGratuidadeService.listarQueContenhamFeature(feature);
		if (!campanhasGratuidade.isEmpty()) {
			throw new GerenciadorPerfilServiceException("Não é possível remover uma Feature que contenha campanhas associadas.");
		}
		
		List<Oferta> ofertas = ofertaService.buscarOfertaProduto(feature.getProduto());
		if (!ofertas.isEmpty()) {
			throw new GerenciadorPerfilServiceException("Não é possível remover uma Feature que contenha ofertas associadas ao seu produto.");
		}
		
		super.remover(feature);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Feature> obterPorProduto(Produto produto) {
		FeatureFilter featureFilter = new FeatureFilter()
			.setIdProdutoEquals(produto.getId());

		return listar(featureFilter);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Feature> obterFeaturesNaoAssociadoPorProduto(Produto produto) {
		FeatureFilter featureFilter = new FeatureFilter()
			.setIdProdutoEquals(produto.getId()).setTransacaoAssociadaIsNull(true);

		return listar(featureFilter);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Feature> obterFeatureEspelho(Integer pkPrincipal){
		return getDao().obterFeatureEspelho(pkPrincipal);
	}

	public FeatureDesconto obterFeatureDesconto(Feature feature) throws GerenciadorPerfilServiceException {
		
		if(feature != null && StringUtils.isNotBlank(feature.getTransacao())) {
			
			ProtocoloGM53 protEnvio = new ProtocoloGM53();
			protEnvio.setLogonConsulta(CoreUtils.safeGetApplicationUser().getUserLogin());
			protEnvio.setFuncaoConsulta(ProtocoloGM53.FUNCAO_CONSULTA_DE);
			protEnvio.setTransacaoDe(feature.getTransacao());
			
			try {
			
				RetornoGM53 retorno = getDao().obterFeatureDesconto(protEnvio);
				if(retorno != null) {
					if(retorno.getCodigoRetorno().intValue() == 0 && StringUtils.isNotBlank(retorno.getTransacaoPara())) {
						LOGGER.info("Transacao de desconto {} encontrada para a transacao {}.", retorno.getTransacaoPara(), retorno.getTransacaoDe());
						return new FeatureDesconto(feature, retorno.getTransacaoPara());
					}else if(retorno.getCodigoRetorno().intValue() == 1){
						LOGGER.info("Nenhuma transacao de desconto cadastrada para a transacao {}.", feature.getTransacao());
					}else{
						LOGGER.error("Ocorreu um erro ao consultar transacao desconto no mainframe: {} - {}", retorno.getCodigoRetorno(), retorno.getMensagem());
					}
				}else{
					LOGGER.error("Ocorreu um erro ao consultar transacao desconto e o mainframe retornou protocolo nulo.");
				}
			} catch (Exception e) {
				throw new GerenciadorPerfilServiceException(e);
			}
		}
		
		return null;
	}

	
	
}

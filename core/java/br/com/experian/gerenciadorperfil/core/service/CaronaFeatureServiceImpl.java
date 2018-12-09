package br.com.experian.gerenciadorperfil.core.service;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import br.com.experian.gerenciadorperfil.core.dao.CaronaFeatureDAO;
import br.com.experian.gerenciadorperfil.core.entity.Banner;
import br.com.experian.gerenciadorperfil.core.entity.CampanhaGratuidade;
import br.com.experian.gerenciadorperfil.core.entity.CaronaFeature;
import br.com.experian.gerenciadorperfil.core.entity.Cliente;
import br.com.experian.gerenciadorperfil.core.entity.DocumentoCaronaFeature;
import br.com.experian.gerenciadorperfil.core.entity.FeatureDesconto;
import br.com.experian.gerenciadorperfil.core.entity.MeioAcesso;
import br.com.experian.gerenciadorperfil.core.entity.Produto;
import br.com.experian.gerenciadorperfil.core.entity.filter.CaronaFeatureFilter;
import br.com.experian.gerenciadorperfil.core.exception.DocumentosCienciaPendenteCaronaFeatureException;
import br.com.experian.gerenciadorperfil.core.exception.DocumentosJaCadastradosEmCaronaFeatureException;
import br.com.experian.gerenciadorperfil.core.exception.GerenciadorPerfilServiceException;
import br.com.experian.gerenciadorperfil.core.service.common.ArquivoUploadDownload;
import br.com.experian.gerenciadorperfil.core.util.CoreUtils;
import br.com.experian.gerenciadorperfil.core.util.FormatterUtils;

@Service
public class CaronaFeatureServiceImpl extends AbstractService<CaronaFeature, Long, CaronaFeatureFilter, CaronaFeatureDAO> implements CaronaFeatureService {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CampanhaGratuidadeService campanhaGratuidadeService;
	
	
	@Autowired
	private DocumentoCaronaFeatureService documentoService;
	
	@Autowired
	public CaronaFeatureServiceImpl(CaronaFeatureDAO caronaFeatureDAO) {
		super(caronaFeatureDAO);
	}	
	
	@Autowired
	private MeioAcessoService meioAcessoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = GerenciadorPerfilServiceException.class)
	public CaronaFeature adicionar(CaronaFeature caronaFeature, ArquivoUploadDownload arquivoUpload, Banner banner, String transacaoDescontoMF) throws GerenciadorPerfilServiceException {

		logger.info("> CaronaFeatureServiceImpl.adicionar()");
		
		if(caronaFeature.getCampanhaGratuidade() != null){
			caronaFeature.getCampanhaGratuidade().setBannerPJ(caronaFeature.getCampanhaGratuidade().getBanner());
			caronaFeature.getCampanhaGratuidade().setBannerPosGratuidadePJ(caronaFeature.getCampanhaGratuidade().getBannerPosGratuidade());
			caronaFeature.getCampanhaGratuidade().setBannerUltimoDiaPJ(caronaFeature.getCampanhaGratuidade().getBannerUltimoDia());
		}
		
		MeioAcesso meioAcesso = meioAcessoService.buscarMeioAcessoPorNome("Web");
		if(caronaFeature.getTipoCliente().getDescricaoTipoCliente() == null || caronaFeature.getTipoCliente().getDescricaoTipoCliente() == ""){
			caronaFeature.getTipoCliente().setDescricaoTipoCliente("Direto");
		}
		Cliente cliente = clienteService.buscarClientePorNome(caronaFeature.getTipoCliente().getDescricaoTipoCliente());
		caronaFeature.setMeioAcesso(meioAcesso);
		caronaFeature.setTipoCliente(cliente);
		
		if (caronaFeature.getId() == null) {
			
			validarDadosLightbox(caronaFeature, banner);
			List<DocumentoCaronaFeature> documentos = validarDocumentosUpload(arquivoUpload, caronaFeature);
			consultarStringMainframe(caronaFeature, transacaoDescontoMF);
			
			if(caronaFeature.getCampanhaGratuidade() != null) {
				if(caronaFeature.getCampanhaGratuidade().getId() == null) {
					caronaFeature.getCampanhaGratuidade().setStatus(CampanhaGratuidade.STATUS_PROCESSANDO);
				}
				caronaFeature.getCampanhaGratuidade().setMeioAcesso(meioAcesso);
				caronaFeature.getCampanhaGratuidade().setTipoCliente(cliente);
				CampanhaGratuidade campanhaGratuidadeAdicionada = campanhaGratuidadeService.adicionar(caronaFeature.getCampanhaGratuidade(), arquivoUpload);
				caronaFeature.setCampanhaGratuidade(campanhaGratuidadeAdicionada);
				caronaFeature.setStatus(CaronaFeature.STATUS_PROCESSANDO);
			} else {
				caronaFeature.setStatus(CaronaFeature.STATUS_PROCESSADA_COM_SUCESSO);
			}
			
			logger.info("Adicionando carona de features...");
			getDao().adicionar(caronaFeature);
			
			inserirCampanhaPersistidaDocumentos(documentos, caronaFeature);
			documentoService.adicionar(documentos);

			return caronaFeature;
		
		} else {
			
			logger.info("Atualizando carona de features...");
			
			validarDadosLightbox(caronaFeature, banner);
			
			if(caronaFeature.getCampanhaGratuidade() != null) {
				if(caronaFeature.getCampanhaGratuidade().getId() == null) {
					caronaFeature.getCampanhaGratuidade().setStatus(CampanhaGratuidade.STATUS_PROCESSANDO);
					CampanhaGratuidade campanhaGratuidadeAdicionada = campanhaGratuidadeService.adicionar(caronaFeature.getCampanhaGratuidade(), arquivoUpload);
					caronaFeature.setCampanhaGratuidade(campanhaGratuidadeAdicionada);
					caronaFeature.setStatus(CaronaFeature.STATUS_PROCESSANDO);
				} else {					
					campanhaGratuidadeService.atualizar(caronaFeature.getCampanhaGratuidade());
				}
			}
			
			return getDao().atualizar(caronaFeature);
		}
	}

	public List<CaronaFeature> buscarDescontoProduto(Produto produto) {
		CaronaFeatureFilter caronaFeatureFilter = new CaronaFeatureFilter().setIdProdutoEquals(produto.getId());
		return getDao().listar(caronaFeatureFilter);
	}
	
	public String getStringHtmlOferta(Banner banner, CampanhaGratuidade campanha) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("urlImgBackground", banner.getUrlImagemFundo());
		params.put("urlImgTexto",      banner.getUrlTexto());
		params.put("urlBtnAfirmativo", banner.getUrlBotaoSim());
		params.put("urlBtnNegativo",   banner.getUrlBotaoNao());
		params.put("txtObservacao",    replaceDataFimGratuidade(banner.getObservacoesLightbox(), campanha));
		
		return CoreUtils.processarFTL("caronaFeature.ftl", params, CaronaFeatureServiceImpl.class.getClassLoader(), "/LIGHTBOX");
	}
	
	public String getStringHtmlJuridico(Banner banner, CampanhaGratuidade campanha) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("urlImgBackground",	banner.getUrlImagemFundo());
		params.put("urlImgTexto",		banner.getUrlTexto());
		params.put("urlBtnCiencia",		banner.getUrlBotaoCiencia());
		params.put("txtObservacao",		replaceDataFimGratuidade(banner.getObservacoesLightbox(), campanha));
		
		return CoreUtils.processarFTL("juridicoCaronaFeature.ftl", params, CaronaFeatureServiceImpl.class.getClassLoader(), "/LIGHTBOX");
	}
	
	public String getStringHtmlInformativo(Banner banner, CampanhaGratuidade campanha) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("urlImgBackground",	banner.getUrlImagemFundoInformativo());
		params.put("urlImgTexto",		banner.getUrlTextoInformativo());
		params.put("urlBtnCiencia",		banner.getUrlBotaoCienciaInformativo());
		params.put("txtObservacao",		replaceDataFimGratuidade(banner.getObservacoesLightboxInformativo(), campanha));
		
		return CoreUtils.processarFTL("informativoCaronaFeature.ftl", params, CaronaFeatureServiceImpl.class.getClassLoader(), "/LIGHTBOX");
	}
	
	private String replaceDataFimGratuidade(String obs, CampanhaGratuidade campanha){
		
		if(campanha != null && campanha.getDataFimGratuidade() != null && obs.contains(Banner.REPLACE_DATA_FIM_GRATUIDADE)){
			 return obs.replace(Banner.REPLACE_DATA_FIM_GRATUIDADE, new SimpleDateFormat("dd/MM/yyyy").format(campanha.getDataFimGratuidade()));
		}
		return obs;
	}
	
	private List<DocumentoCaronaFeature> obterDocumentos(Set<String> cnpjsValidos, CaronaFeature caronaFeatureClonada) {

		List<DocumentoCaronaFeature> documentos = new ArrayList<DocumentoCaronaFeature>();

		for (String cnpj : cnpjsValidos) {
			DocumentoCaronaFeature documento = new DocumentoCaronaFeature();
			documento.setCaronaFeature(caronaFeatureClonada);
			if(caronaFeatureClonada.getTipoCliente() != null && caronaFeatureClonada.getTipoCliente().getId() == 2){
				String[]cnpjLogon = cnpj.split(";");
				documento.setCnpj(cnpjLogon[0]);
				documento.setLogin(cnpjLogon[1].toUpperCase());
			}else{
				documento.setCnpj(cnpj);
			}
			documentos.add(documento);
		}

		return documentos;
	}
	
	private Set<String> obterCnpjsValidos(ArquivoUploadDownload arquivoUpload) throws GerenciadorPerfilServiceException {

		List<String> conteudo = Collections.emptyList();

		if (arquivoUpload != null) {

			InputStream inputStream = arquivoUpload.toInputStream();

			try {
				conteudo = CoreUtils.readLines(inputStream);
			} catch (Exception e) {
				throw new GerenciadorPerfilServiceException("Erro ao efetuar leitura do arquivo: " + e.getMessage());
			}
		}

		Set<String> cnpjsValidos = new LinkedHashSet<String>(conteudo.size());
		
		for (String linha : conteudo) {
			cnpjsValidos.add(FormatterUtils.formatCnpj(linha));
		}

		return cnpjsValidos;
	}

	private Set<String> obterCnpjsDistribuidorValidos(ArquivoUploadDownload arquivoUpload) throws GerenciadorPerfilServiceException{
		
		List<String> conteudo = Collections.emptyList();

		if (arquivoUpload != null) {

			InputStream inputStream = arquivoUpload.toInputStream();

			try {
				conteudo = CoreUtils.readLines(inputStream);
			} catch (Exception e) {
				throw new GerenciadorPerfilServiceException("Erro ao efetuar leitura do arquivo: " + e.getMessage());
			}
		}

		Set<String> cnpjsValidos = new LinkedHashSet<String>(conteudo.size());
		
		for (String linha : conteudo) {
			cnpjsValidos.add(FormatterUtils.formatCnpjLogon(linha));
		}

		return cnpjsValidos;

	}
	
	public void verificarExistenciaDeCampanhaImpeditiva(List<DocumentoCaronaFeature> documentos, CaronaFeature caronaFeature) throws GerenciadorPerfilServiceException {
		
		Date inicio = caronaFeature.getDataInicio();
		Date fim = caronaFeature.getDataFim();
		
		if(caronaFeature.getCampanhaGratuidade() != null && caronaFeature.getCampanhaGratuidade().getDataFimPosGratuidade() != null)
		{
			fim = caronaFeature.getCampanhaGratuidade().getDataFimPosGratuidade();
		}
		
		CaronaFeatureFilter filter = new CaronaFeatureFilter().setIdNotEquals(caronaFeature.getId())
																	.setIdProdutoEquals(caronaFeature.getFeature().getProduto().getId())
																	.setNaoCancelada(true)
																	.setGreatherEqualsThanDataInicio(fim)
																	.setLowerEqualsThanDataFim(inicio);
		
		List<CaronaFeature> campanhas = listar(filter);
		if(!CollectionUtils.isEmpty(campanhas)) {
			for(CaronaFeature campanha : campanhas) {

				if( (!verificaSeUmaCampanhaTurbo(campanha, caronaFeature)) ) {
//					if( validaDuasCampanhasTurbo(campanha, caronaFeature) ){

						List<DocumentoCaronaFeature> docs = documentoService.listarPorCaronaFeature(campanha);
						List<DocumentoCaronaFeature> docsCoincidentes = verificarDocumentosCoincidentes(documentos, docs);
						if(!CollectionUtils.isEmpty(docsCoincidentes)) {
							throwDocumentoCadastradoException(docsCoincidentes);
						}

//					}
				}

			}
		}
	}
	
	public void verificarDocumentosComAceiteDesconto(CaronaFeature caronaFeature, Set<String> documentos) throws DocumentosJaCadastradosEmCaronaFeatureException {
		
		List<DocumentoCaronaFeature> docs = new ArrayList<DocumentoCaronaFeature>();
		
		List<String> cnpjs = new ArrayList<String>();
		List<String> logons = new ArrayList<String>();
		
		//INC1689488 - Bonilho - 15/05/2018 - Recuperar CNPJ quando for distribuidor		
		if(caronaFeature.getTipoCliente().getId() != null && caronaFeature.getTipoCliente().getId() == 1){
			cnpjs.addAll(documentos);
			//INC1709536 - Efetuar o bloqueio por CNPJ + Logon que possui a feature ativa.
			logons = null;
		}
		else{
			for(String cnpjLogon : documentos){
				cnpjs.add(cnpjLogon.split(";")[0]);
				logons.add(cnpjLogon.split(";")[1]);
			}
		}
		
		for(int i = 0; i < (documentos.size() / 1000) + 1; i++) {
			if(!CollectionUtils.isEmpty(cnpjs)) {
				//INC1709536 - Efetuar o bloqueio por CNPJ + Logon que possui a feature ativa.
				docs.addAll(documentoService.listarPorCampanhaAceitaSemCancelamento(caronaFeature.getFeature(), CoreUtils.getAmountFromList(cnpjs, 1000), CoreUtils.getAmountFromList(logons, 1000)));
			}
		}
		
		if(!CollectionUtils.isEmpty(docs)) {
			throwDocumentoCaronaFeatureAceite(docs);
		}else{
			logger.info("Lista não possui documentos com campanha aceita sem cancelamento.");
		}
	}
	
	public void verificarDocumentosCienciaPendente(Set<String> documentos, String produto) throws DocumentosCienciaPendenteCaronaFeatureException {
		
		List<DocumentoCaronaFeature> docs = new ArrayList<DocumentoCaronaFeature>();
		
		List<String> cnpjs = new ArrayList<String>();
		cnpjs.addAll(documentos);
		
		for(int i = 0; i < (documentos.size() / 1000) + 1; i++) {
			if(!CollectionUtils.isEmpty(cnpjs)) {
				docs.addAll(documentoService.listarDocumentosCienciaPendente(CoreUtils.getAmountFromList(cnpjs, 1000), produto));
			}
		}
		
		if(!CollectionUtils.isEmpty(docs)) {
			throwDocumentosCienciaPendente(docs);
		}else{
			logger.info("Lista não possui documentos com pendencia de ciencia para campanhas do tipo OPT-OUT.");
		}
	}
	
	private List<DocumentoCaronaFeature> verificarDocumentosCoincidentes(List<DocumentoCaronaFeature> documentos1, List<DocumentoCaronaFeature> documentos2) {
		
		List<DocumentoCaronaFeature> docsCoincidentes = new ArrayList<DocumentoCaronaFeature>();
		
		for (DocumentoCaronaFeature documento2 : documentos2) {
			for (DocumentoCaronaFeature documento1 : documentos1) {
				if(documento1.getLogin() != null){
					if (documento1.getCnpj().equals(documento2.getCnpj()) && documento1.getLogin().equals(documento2.getLogin())) {
						docsCoincidentes.add(documento2);
					}
				}else{
					if(documento1.getCnpj().equals(documento2.getCnpj())){
						docsCoincidentes.add(documento2);
					}
				}
			}
		}
		
		return docsCoincidentes;
	}
	
	private void throwDocumentoCadastradoException(List<DocumentoCaronaFeature> docs) throws DocumentosJaCadastradosEmCaronaFeatureException {
		
		DocumentosJaCadastradosEmCaronaFeatureException e = new DocumentosJaCadastradosEmCaronaFeatureException("Para alguns(s) do(s) CNPJ(s) informado(s), já existe pelo menos uma ação do tipo carona de features cadastrada, com intersecção para o período informado.");
		e.setDocumentos(docs);
		
		throw e;
	}
	
	private void throwDocumentosCienciaPendente(List<DocumentoCaronaFeature> docs) throws DocumentosCienciaPendenteCaronaFeatureException {
		
		DocumentosCienciaPendenteCaronaFeatureException e = new DocumentosCienciaPendenteCaronaFeatureException("Os documentos abaixo não registraram ciência de carona de features do tipo OPT-OUT para esse produto.");
		e.setDocumentos(docs);
		
		throw e;
	}
	
private void throwDocumentoCaronaFeatureAceite(List<DocumentoCaronaFeature> docs) throws DocumentosJaCadastradosEmCaronaFeatureException {
		
		DocumentosJaCadastradosEmCaronaFeatureException e = new DocumentosJaCadastradosEmCaronaFeatureException("Os documentos abaixo já possuem aceite de uma carona de features para esse produto e feature.");
		e.setDocumentos(docs);
		
		throw e;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = GerenciadorPerfilServiceException.class)
	public void remover(CaronaFeature caronaFeature) throws GerenciadorPerfilServiceException {

		logger.info(">CaronaFeatureServiceImpl.remover()");
		
		if(caronaFeature.getCampanhaGratuidade() != null) {
			
			campanhaGratuidadeService.cancelar(caronaFeature.getCampanhaGratuidade());
			
			if(CampanhaGratuidade.STATUS_CANCELADA == caronaFeature.getCampanhaGratuidade().getStatus()) {
				caronaFeature.setStatus(CaronaFeature.STATUS_CANCELADA_COM_SUCESSO);
			}else{
				caronaFeature.setStatus(CaronaFeature.STATUS_CANCELANDO);
			}
		} else {
			caronaFeature.setStatus(CaronaFeature.STATUS_CANCELADA_COM_SUCESSO);	
		}
		
		if(caronaFeature.getId() != null) {
			getDao().remover(caronaFeature);
		} else {
			throw new GerenciadorPerfilServiceException("A Campanha de Desconto que está sendo cancelada não possui um ID!");
		}
	}

	private void consultarStringMainframe(CaronaFeature caronaFeature, String transacaoDescontoMF) {
		
		if(caronaFeature.getFeature().getFeatureDesconto() == null) {
			caronaFeature.getFeature().setFeatureDesconto(new FeatureDesconto(caronaFeature.getFeature(), transacaoDescontoMF));
		} 
	}
	
	private void validarDadosLightbox(CaronaFeature caronaFeature, Banner banner) throws GerenciadorPerfilServiceException {

		if( !caronaFeature.isTurbo() ){

			// Validações do banner de carona
			if (StringUtils.isBlank(banner.getUrlImagemFundo())) {
				throw new GerenciadorPerfilServiceException("A url da Imagem de Fundo não pode ser nula");
			}

		if (StringUtils.isBlank(banner.getUrlTexto())) {
				throw new GerenciadorPerfilServiceException("A url da Imagem do Texto não pode ser nula");
		}		
		if (caronaFeature.isOptIn() && StringUtils.isBlank(banner.getUrlBotaoNao())) {
			throw new GerenciadorPerfilServiceException("A url da Imagem do Botão Negativo não pode ser nula");
		}
		
		if (caronaFeature.isOptOut() && StringUtils.isBlank(banner.getUrlBotaoCiencia())) {
			throw new GerenciadorPerfilServiceException("A url da Imagem do Botão de Ciência não pode ser nula");
		}
		
		if (StringUtils.isBlank(banner.getObservacoesLightbox())) {
			throw new GerenciadorPerfilServiceException("O campo observações do lightbox não pode ser nulo");
		}
		
		if(caronaFeature.isOptIn()){
			caronaFeature.setHtmlBanner(getStringHtmlOferta(banner, caronaFeature.getCampanhaGratuidade()));
		}else{
			caronaFeature.setHtmlBanner(getStringHtmlJuridico(banner, caronaFeature.getCampanhaGratuidade()));
		}

			if (caronaFeature.isOptIn() && StringUtils.isBlank(banner.getUrlBotaoSim())) {
				throw new GerenciadorPerfilServiceException("A url da Imagem do Botão Afirmativo não pode ser nula");
			}

			if (caronaFeature.isOptIn() && StringUtils.isBlank(banner.getUrlBotaoNao())) {
				throw new GerenciadorPerfilServiceException("A url da Imagem do Botão Negativo não pode ser nula");
			}

			if (caronaFeature.isOptOut() && StringUtils.isBlank(banner.getUrlBotaoCiencia())) {
				throw new GerenciadorPerfilServiceException("A url da Imagem do Botão de Ciência não pode ser nula");
			}

			if (StringUtils.isBlank(banner.getObservacoesLightbox())) {
				throw new GerenciadorPerfilServiceException("O campo observações do lightbox não pode ser nulo");
			}

			if(caronaFeature.isOptIn()){
				caronaFeature.setHtmlBanner(getStringHtmlOferta(banner, caronaFeature.getCampanhaGratuidade()));
			}else{
				caronaFeature.setHtmlBanner(getStringHtmlJuridico(banner, caronaFeature.getCampanhaGratuidade()));
			}

			if(caronaFeature.isContemInformativo()) {

				// Validações do lightbox do informativo da carona
				if (StringUtils.isBlank(banner.getUrlImagemFundoInformativo())) {
					throw new GerenciadorPerfilServiceException("A url da imagem de fundo do Informativo de Carona de Features deve ser preenchida");
				}

				if (StringUtils.isBlank(banner.getUrlTextoInformativo())) {
					throw new GerenciadorPerfilServiceException("A url da imagem do texto do Informativo de Carona de Features deve ser preenchida");
				}

				if (StringUtils.isBlank(banner.getUrlBotaoCienciaInformativo())) {
					throw new GerenciadorPerfilServiceException("A url da imagem do botão de ciência do Informativo de Carona de Features deve ser preenchida");
				}

				if (StringUtils.isBlank(banner.getObservacoesLightboxInformativo())) {
					throw new GerenciadorPerfilServiceException("O campo observações do lightbox do Informativo de Carona de Features deve ser preenchido");
				}	

				caronaFeature.setHtmlInformativo(getStringHtmlInformativo(banner, caronaFeature.getCampanhaGratuidade()));

			}else{
				caronaFeature.setHtmlInformativo(null);
			}
		}
	}
	
	private List<DocumentoCaronaFeature> validarDocumentosUpload(ArquivoUploadDownload arquivoUpload, CaronaFeature caronaFeature) throws GerenciadorPerfilServiceException {
		
		List<DocumentoCaronaFeature> documentos = null;
		
		if (!(arquivoUpload.getBytes().length > 0)) {
			throw new GerenciadorPerfilServiceException("O arquivo de documentos deve ser informado!");
		}

		Set<String> cnpjsValidos = null;
		
		if(caronaFeature.getTipoCliente().getId() != null && caronaFeature.getTipoCliente().getId() == 1){
			cnpjsValidos = obterCnpjsValidos(arquivoUpload);
		}else{
			cnpjsValidos = obterCnpjsDistribuidorValidos(arquivoUpload);
		}
		
		if (cnpjsValidos.size() == 0) {
			throw new GerenciadorPerfilServiceException("Deve haver ao menos um CNPJ válido no arquivo informado");
		}
		
		CaronaFeature caronaFeatureClonada = (CaronaFeature) SerializationUtils.clone(caronaFeature);
		documentos = obterDocumentos(cnpjsValidos, caronaFeatureClonada);
		
		verificarExistenciaDeCampanhaImpeditiva(documentos, caronaFeatureClonada);
		
		verificarDocumentosComAceiteDesconto(caronaFeature, cnpjsValidos); 

		if (caronaFeature.getTipoOferta().equals(CaronaFeature.TIPO_OFERTA_OPTOUT)) {
			verificarDocumentosCienciaPendente(cnpjsValidos, caronaFeature.getFeature().getProduto().getNome());
		}
		
		return documentos;
	}
	
	private void inserirCampanhaPersistidaDocumentos(List<DocumentoCaronaFeature> documentos, CaronaFeature caronaFeature) {
		for(DocumentoCaronaFeature documento : documentos) {
			documento.setCaronaFeature(caronaFeature);
		}
	}

	public boolean validaDuasCampanhasTurbo(CaronaFeature campanha, CaronaFeature caronaFeature) {

		if( caronaFeature.getTipoOferta().equals("T") && campanha.getTipoOferta().equals("T") ) {
			if( caronaFeature.getFeature().getTransacao().equals(campanha.getFeature().getTransacao()) ){
				return true;
			}
		}

		return false;
	}

	public boolean verificaSeUmaCampanhaTurbo(CaronaFeature campanha, CaronaFeature caronaFeature) {

		if( (caronaFeature.getTipoOferta().equals("T") || campanha.getTipoOferta().equals("T")) && !(caronaFeature.getTipoOferta().equals("T") && campanha.getTipoOferta().equals("T")) ){
			return true;
		}

		return false;
	}

}
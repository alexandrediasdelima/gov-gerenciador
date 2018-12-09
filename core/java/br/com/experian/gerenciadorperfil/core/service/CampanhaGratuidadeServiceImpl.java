package br.com.experian.gerenciadorperfil.core.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.experian.gerenciadorperfil.core.dao.CampanhaGratuidadeDAO;
import br.com.experian.gerenciadorperfil.core.entity.CampanhaGratuidade;
import br.com.experian.gerenciadorperfil.core.entity.Cliente;
import br.com.experian.gerenciadorperfil.core.entity.Documento;
import br.com.experian.gerenciadorperfil.core.entity.Feature;
import br.com.experian.gerenciadorperfil.core.entity.MeioAcesso;
import br.com.experian.gerenciadorperfil.core.entity.Produto;
import br.com.experian.gerenciadorperfil.core.entity.filter.CampanhaGratuidadeFilter;
import br.com.experian.gerenciadorperfil.core.exception.DocumentosJaCadastradosEmCampanhaGratuidadeException;
import br.com.experian.gerenciadorperfil.core.exception.GerenciadorPerfilRuntimeException;
import br.com.experian.gerenciadorperfil.core.exception.GerenciadorPerfilServiceException;
import br.com.experian.gerenciadorperfil.core.exception.LancamentoGratuidadeInterseccaoException;
import br.com.experian.gerenciadorperfil.core.service.common.ArquivoUploadDownload;
import br.com.experian.gerenciadorperfil.core.util.CoreUtils;
import br.com.experian.gerenciadorperfil.core.util.DateCompare;
import br.com.experian.gerenciadorperfil.core.util.FormatterUtils;

@Service
public class CampanhaGratuidadeServiceImpl extends AbstractService<CampanhaGratuidade, Long, CampanhaGratuidadeFilter, CampanhaGratuidadeDAO> implements CampanhaGratuidadeService {

	public static final String DOC_PADRAO_LANCAMENTO = "99999999";

	@Autowired
	private DocumentoService documentoService;

	@Autowired
	private MeioAcessoService meioAcessoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	public CampanhaGratuidadeServiceImpl(CampanhaGratuidadeDAO campanhaGratuidadeDAO) {
		super(campanhaGratuidadeDAO);
	}
	

	/**
	 * @param documentoService the documentoService to set
	 */
	public void setDocumentoService(DocumentoService documentoService) {
		this.documentoService = documentoService;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, timeout = 300)
	public CampanhaGratuidade adicionar(CampanhaGratuidade campanhaGratuidade) throws GerenciadorPerfilServiceException {
		throw new GerenciadorPerfilRuntimeException("Metodo não implementado");
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = GerenciadorPerfilServiceException.class)
	public CampanhaGratuidade atualizar(CampanhaGratuidade campanhaGratuidade) throws GerenciadorPerfilServiceException {

		validarCampanhaGratuidade(campanhaGratuidade);

		CampanhaGratuidade campanhaGratuidadeDoBanco = obter(campanhaGratuidade.getId());

		boolean mudouDatafimPosGratuidade;

		if (campanhaGratuidade.getDataFimPosGratuidade()==null && campanhaGratuidadeDoBanco.getDataFimPosGratuidade() == null) {
			mudouDatafimPosGratuidade = false;
		}
		else if (campanhaGratuidade.getDataFimPosGratuidade()!=null) {
			mudouDatafimPosGratuidade = !campanhaGratuidade.getDataFimPosGratuidade().equals(campanhaGratuidadeDoBanco.getDataFimPosGratuidade());
		}
		else {
			mudouDatafimPosGratuidade = true;
		}

		boolean mudouData = !campanhaGratuidade.getDataInicioGratuidade().equals(campanhaGratuidadeDoBanco.getDataInicioGratuidade()) || !campanhaGratuidade.getDataFimGratuidade().equals(campanhaGratuidadeDoBanco.getDataFimGratuidade()) || mudouDatafimPosGratuidade;

		CampanhaGratuidade campanhaGratuidadeClonada = (CampanhaGratuidade) SerializationUtils.clone(campanhaGratuidade);

		if (mudouData) {

			List<Documento> documentos = (CampanhaGratuidade.TIPO_CAMPANHA_LANCAMENTO.equals(campanhaGratuidadeClonada.getTipo())) ? null : documentoService.listarPorCampanhaGratuidade(campanhaGratuidadeClonada);
			verificaExistenciaDeCampanhaVigenteImpeditiva(campanhaGratuidadeClonada, documentos);

		}
		
		//INC1197535 Correção para manter o estado o Lightbox Juridico
		if(!campanhaGratuidade.isLigthboxJuridico()){
			campanhaGratuidadeClonada.setTipoComportamentoPerfil(CampanhaGratuidade.TIPO_COMPORTAMENTO_SALVAR_FEATURES_SEM_JURIDICO);
		}

		if (campanhaGratuidade.getStatus() == CampanhaGratuidade.STATUS_RETORNO_COM_ERRO){
			campanhaGratuidade.setStatus(CampanhaGratuidade.STATUS_PROCESSANDO);
		}

		campanhaGratuidadeClonada.setDataAlteracao(new Date());

		return super.atualizar(campanhaGratuidadeClonada);
	}

	public CampanhaGratuidade cancelar(CampanhaGratuidade campanhaGratuidade) throws GerenciadorPerfilServiceException {

		defineStatusCancelado(campanhaGratuidade);
		return this.atualizar(campanhaGratuidade);

	}

	private void defineStatusCancelado(CampanhaGratuidade campanhaGratuidade) {

		if (CampanhaGratuidade.STATUS_PROCESSANDO == campanhaGratuidade.getStatus() ||	CampanhaGratuidade.STATUS_RETORNO_COM_ERRO == campanhaGratuidade.getStatus() || CampanhaGratuidade.STATUS_CANCELAMENTO_ENVIADO_MF == campanhaGratuidade.getStatus()) {
			campanhaGratuidade.setStatus(CampanhaGratuidade.STATUS_CANCELADA);
		}else if (CampanhaGratuidade.STATUS_PROCESSADA_COM_SUCESSO == campanhaGratuidade.getStatus()){
			Calendar c = Calendar.getInstance();
			if (DateCompare.after(c.getTime(), campanhaGratuidade.getDataFimGratuidade())){
				campanhaGratuidade.setStatus(CampanhaGratuidade.STATUS_CANCELADA);
			}else{
				campanhaGratuidade.setStatus(CampanhaGratuidade.STATUS_CANCELANDO);
			}
		}else{
			campanhaGratuidade.setStatus(CampanhaGratuidade.STATUS_CANCELANDO);
		}
	}

	public void verificaExistenciaDeCampanhaVigenteImpeditiva(CampanhaGratuidade campanhaGratuidade, List<Documento> documentos) throws GerenciadorPerfilServiceException {

		Date dataFinal;

		if (campanhaGratuidade.getDataFimPosGratuidade() != null) {
			dataFinal = campanhaGratuidade.getDataFimPosGratuidade();
		}
		else {
			dataFinal = campanhaGratuidade.getDataFimGratuidade();
		}

		verificaCampanhaLancamentoImpeditiva(campanhaGratuidade, dataFinal);

		verificaCampanhaPadraoImpeditiva(campanhaGratuidade, dataFinal, documentos);

	}

	private void verificaCampanhaPadraoImpeditiva(CampanhaGratuidade campanhaGratuidade, Date dataFinal, List<Documento> documentos) throws GerenciadorPerfilServiceException {

		CampanhaGratuidadeFilter campanhasPadraoFilter = new CampanhaGratuidadeFilter()	.setIdNotEquals(campanhaGratuidade.getId())
																						.setIdProdutoEquals(campanhaGratuidade.getProduto().getId())
																						.setTipo(CampanhaGratuidade.TIPO_CAMPANHA_PADRAO)
																						.setNaoCancelada(true)
																						.setGreatherEqualsThanDataInicio(dataFinal)
																						.setLowerEqualsThanDataFim(campanhaGratuidade.getDataInicioGratuidade());

		List<CampanhaGratuidade> listaPadroes = listar(campanhasPadraoFilter);

		if (listaPadroes.size() > 0) {

			if (CampanhaGratuidade.TIPO_CAMPANHA_LANCAMENTO.equals(campanhaGratuidade.getTipo())) {
				throw new GerenciadorPerfilServiceException("Existe outra campanha com período contendo intersecção com o período informado");
			}
			else { //Campanha tipo PADRAO

				for (CampanhaGratuidade campanhaEncontrada : listaPadroes) {
					
					List<Documento> documentosCampanhaEncontrada = documentoService.listarPorCampanhaGratuidade(campanhaEncontrada);
					Documento documentoCoincidente = verificaDocumentosCoincidentes(documentos, documentosCampanhaEncontrada);
					
					if (documentoCoincidente != null) {
						throwDocumentoCadastradoException(documentoCoincidente);
					}
					
				}
			}
		}
		

		//agora serah verificado se existe alguma campanha padrão vigente que contenha feature(s) e documento(s) coincidentes. Caso exista,
		//deve ser lançada uma excecao, pois os dados "feature vs cnpj" da nova campanha sobrescreveriam os da campanha vigente no MF
		CampanhaGratuidadeFilter campanhasPadraoVigentes = new CampanhaGratuidadeFilter()	.setIdNotEquals(campanhaGratuidade.getId())
																							.setIdProdutoEquals(campanhaGratuidade.getProduto().getId())
																							.setTipo(CampanhaGratuidade.TIPO_CAMPANHA_PADRAO)
																							.setNaoCancelada(true)
																							.setVigente(true);

		List<CampanhaGratuidade> listaCampsPadraoVigentes = listar(campanhasPadraoVigentes);
		
		if (listaCampsPadraoVigentes.size() > 0) {
		
			Iterator<CampanhaGratuidade> itCampsPadraoVigentes = listaCampsPadraoVigentes.iterator();
			
			while (itCampsPadraoVigentes.hasNext()) {
			
				CampanhaGratuidade campanhaPadraoVigente = itCampsPadraoVigentes.next();
				
				Iterator<Feature> itFeatures = campanhaPadraoVigente.getFeatures().iterator();
				
				while (itFeatures.hasNext()) {
				
					Feature feature = itFeatures.next();
					
					//verifica se existem features coincidentes entre as campanhas campanhaGratuidade e campanhaPadraoVigente 
					if (campanhaGratuidade.getFeatures().contains(feature)) {
						
						//Verifica se existem documentos coincidentes entre as campanhas campanhaGratuidade e campanhaPadraoVigente
						List<Documento> documentosCampanhaPadraoVigente = documentoService.listarPorCampanhaGratuidade(campanhaPadraoVigente);
						Documento documentoCoincidente = verificaDocumentosCoincidentes(documentos, documentosCampanhaPadraoVigente);
						
						if (documentoCoincidente != null) {
							throw new GerenciadorPerfilServiceException("Existe uma campanha do tipo Padrão vigente - id " + campanhaPadraoVigente.getId() + " para a feature " + feature.getNome() + " contendo algun(s) do(s) CNPJ(s) informado(s)");
						}
					}
				}
			}
		}
	}

	private Documento verificaDocumentosCoincidentes(List<Documento> listaDocumentos1, List<Documento> listaDocumentos2) {
		
		for (Documento documentoLista2 : listaDocumentos2) {
			for (Documento documentoLista1 : listaDocumentos1) {
				if(documentoLista1.getLogin() != null){
					if (documentoLista1.getCnpj().equals(documentoLista2.getCnpj()) && documentoLista1.getLogin().equals(documentoLista2.getLogin())) {
						return documentoLista2;
					}
				}
				else{
					if (documentoLista1.getCnpj().equals(documentoLista2.getCnpj())) {
						return documentoLista2;
					}
				}
			}
		}
		
		return null;
	}

	private void throwDocumentoCadastradoException(Documento documentoJahExistente) throws DocumentosJaCadastradosEmCampanhaGratuidadeException {
		List<Documento> documentosDuplicados = new ArrayList<Documento>();
		documentosDuplicados.add(documentoJahExistente);
		DocumentosJaCadastradosEmCampanhaGratuidadeException documentosJaCadastradosEmCampanhaGratuidadeException = new DocumentosJaCadastradosEmCampanhaGratuidadeException("Existe campanha do tipo Padrão com período intersectando o informado, contendo pelo menos um dos CNPJs informados");
		documentosJaCadastradosEmCampanhaGratuidadeException.setDocumentos(documentosDuplicados);
		throw documentosJaCadastradosEmCampanhaGratuidadeException;
	}

	private void verificaCampanhaLancamentoImpeditiva(CampanhaGratuidade campanhaGratuidade, Date dataFinal) throws GerenciadorPerfilServiceException {

		CampanhaGratuidadeFilter campanhasLancamentoFilter = new CampanhaGratuidadeFilter()	.setIdNotEquals(campanhaGratuidade.getId())
																							.setIdProdutoEquals(campanhaGratuidade.getProduto().getId())
																							.setTipo(CampanhaGratuidade.TIPO_CAMPANHA_LANCAMENTO)
																							.setNaoCancelada(true)
																							.setGreatherEqualsThanDataInicio(dataFinal)
																							.setLowerEqualsThanDataFim(campanhaGratuidade.getDataInicioGratuidade());

		List<CampanhaGratuidade> listaLancamentos = listar(campanhasLancamentoFilter);

		if (listaLancamentos.size() > 0) {
			throw new LancamentoGratuidadeInterseccaoException("Existe uma campanha do tipo Lançamento com período contendo intersecção com o período informado");
		}
		

		//agora serah verificado se existe alguma campanha lançamento vigente que contenha feature(s) coincidente(s). Caso exista,
		//deve ser lançada uma excecao, pois os dados de gratuidade da nova campanha sobrescreveriam os da campanha vigente no MF
		CampanhaGratuidadeFilter campanhasVigentes = new CampanhaGratuidadeFilter()	.setIdNotEquals(campanhaGratuidade.getId())
																							.setIdProdutoEquals(campanhaGratuidade.getProduto().getId())
																							.setTipo(CampanhaGratuidade.TIPO_CAMPANHA_LANCAMENTO)
																							.setNaoCancelada(true)
																							.setVigente(true);

		List<CampanhaGratuidade> listaLancsVigentes = listar(campanhasVigentes);

		if (listaLancsVigentes.size() > 0) {
			
			Iterator<CampanhaGratuidade> itCampsLancamtoVigentes = listaLancsVigentes.iterator();
			
			while (itCampsLancamtoVigentes.hasNext()) {
				
				CampanhaGratuidade campanhaLancamtoVigente = itCampsLancamtoVigentes.next();
				
				Iterator<Feature> itFeatures = campanhaLancamtoVigente.getFeatures().iterator();
				
				while (itFeatures.hasNext()) {
					
					Feature feature = itFeatures.next();

					//verifica se existem features coincidentes entre as campanhas campanhaGratuidade e campanhaPadraoVigente 
					if (campanhaGratuidade.getFeatures().contains(feature)) {
						throw new GerenciadorPerfilServiceException("Existe uma campanha do tipo Lançamento vigente - id " + campanhaLancamtoVigente.getId() + " para a feature " + feature.getNome());
					}
					
				}
				
			}
			
		}

	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<CampanhaGratuidade> listarPorProduto(Produto produto) {

		CampanhaGratuidadeFilter campanhaGratuidadeFilter = new CampanhaGratuidadeFilter()
			.setIdProdutoEquals(produto.getId());

		return listar(campanhaGratuidadeFilter);
	}

	private void validarCampanhaGratuidade(CampanhaGratuidade campanhaGratuidade) throws GerenciadorPerfilServiceException {

		if (StringUtils.isBlank(campanhaGratuidade.getNome())) {
			throw new GerenciadorPerfilServiceException("O Nome da Campanha deve ser informado");
		}

		if (campanhaGratuidade.getTipo() == null || campanhaGratuidade.getTipo() == 0) {
			throw new GerenciadorPerfilServiceException("O Tipo da Campanha - Padrão ou Lançamento - deve ser informado");
		}

		if (campanhaGratuidade.getDataInicioGratuidade() == null) {
			throw new GerenciadorPerfilServiceException("A Data de Início da Gratuidade deve ser informada");
		}

		if (campanhaGratuidade.getDataFimGratuidade() == null) {
			throw new GerenciadorPerfilServiceException("A Data Fim da Gratuidade deve ser informada");
		}

		if (DateCompare.after(campanhaGratuidade.getDataInicioGratuidade(), DateCompare.DATE_PLUS_100_YEARS)) {
			throw new GerenciadorPerfilServiceException("Data de Início da Gratuidade inválida");
		}

		if (DateCompare.after(campanhaGratuidade.getDataFimGratuidade(), DateCompare.DATE_PLUS_100_YEARS)) {
			throw new GerenciadorPerfilServiceException("Data Fim da Gratuidade inválida");
		}

		if (campanhaGratuidade.getDataInicioGratuidade().after(campanhaGratuidade.getDataFimGratuidade())) {
			throw new GerenciadorPerfilServiceException("A Data Fim não pode ser anterior à Data Início da Gratuidade");
		}
		if (campanhaGratuidade.getDataFimPosGratuidade() != null){
			if (!campanhaGratuidade.getDataFimPosGratuidade().after(campanhaGratuidade.getDataFimGratuidade())) {
				throw new GerenciadorPerfilServiceException("A Data Fim da Pós-Gratuidade deve ser maior do que a Data Fim da Gratuidade");
			}

			if (DateCompare.after(campanhaGratuidade.getDataFimPosGratuidade(), DateCompare.DATE_PLUS_100_YEARS)) {
				throw new GerenciadorPerfilServiceException("Data Fim da Pós-Gratuidade inválida");
			}
		}

		if (StringUtils.isBlank(campanhaGratuidade.getBanner()) && StringUtils.isBlank(campanhaGratuidade.getBannerPJ())) {
			throw new GerenciadorPerfilServiceException("Pelo menos um dos Banners - PF ou PJ - deve ser preenchido");
		}

		if (campanhaGratuidade.getFeatures().size() == 0) {
			throw new GerenciadorPerfilServiceException("Deve haver pelo menos uma feature selecionada");
		}

	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = GerenciadorPerfilServiceException.class)
	public CampanhaGratuidade adicionar(CampanhaGratuidade campanhaGratuidade, ArquivoUploadDownload arquivoUpload)	throws GerenciadorPerfilServiceException {

		validarCampanhaGratuidade(campanhaGratuidade);
		MeioAcesso meioAcesso = meioAcessoService.buscarMeioAcessoPorNome(campanhaGratuidade.getMeioAcesso().getDescricaoMeioAcesso());
		Cliente cliente = clienteService.buscarClientePorNome(campanhaGratuidade.getTipoCliente().getDescricaoTipoCliente());
		campanhaGratuidade.setMeioAcesso(meioAcesso);
		campanhaGratuidade.setTipoCliente(cliente);
		
		if (CampanhaGratuidade.TIPO_CAMPANHA_PADRAO.equals(campanhaGratuidade.getTipo()) && arquivoUpload == null) {
			throw new GerenciadorPerfilServiceException("O arquivo de documentos deve ser informado para o tipo de campanha Padrão!");
		}
		Set<String>cnpjsValidos = null;
		if(campanhaGratuidade.getTipoCliente().getId() != null && campanhaGratuidade.getTipoCliente().getId() == 1){
			cnpjsValidos = obterCnpjsValidos(arquivoUpload);
		}else{
			cnpjsValidos = obterCnpjsDistribuidorValidos(arquivoUpload);
		}

		if (cnpjsValidos.size() == 0 && CampanhaGratuidade.TIPO_CAMPANHA_PADRAO.equals(campanhaGratuidade.getTipo())) {
			throw new GerenciadorPerfilServiceException("Deve haver ao menos um CNPJ válido no arquivo informado");
		}

		
		CampanhaGratuidade campanhaGratuidadeClonada = (CampanhaGratuidade) SerializationUtils.clone(campanhaGratuidade);
		
		List<Documento> documentos = obterDocumentos(cnpjsValidos, campanhaGratuidadeClonada);

		verificaExistenciaDeCampanhaVigenteImpeditiva(campanhaGratuidadeClonada, documentos);

		campanhaGratuidade.setStatus(CampanhaGratuidade.STATUS_PROCESSANDO);

		campanhaGratuidadeClonada.setDataCriacao(new Date());
		
		if(!campanhaGratuidade.isLigthboxJuridico()){
			campanhaGratuidadeClonada.setTipoComportamentoPerfil(CampanhaGratuidade.TIPO_COMPORTAMENTO_SALVAR_FEATURES_SEM_JURIDICO);
		}

		campanhaGratuidadeClonada = super.adicionar(campanhaGratuidadeClonada);

		if(documentos.size() > 0){
			documentoService.adicionar(documentos);
		}

		return campanhaGratuidadeClonada;
	}

	private List<Documento> obterDocumentos(Set<String> cnpjsValidos, CampanhaGratuidade campanhaGratuidadeClonada) {

		List<Documento> documentos = new ArrayList<Documento>();

		if (CampanhaGratuidade.TIPO_CAMPANHA_LANCAMENTO.equals(campanhaGratuidadeClonada.getTipo())) {
			// Campanha de Lançamento vale para todos os clientes. É cadastrado um documento padrao apenas para integração com MainFrame
			Documento documento = new Documento();
			documento.setCampanhaGratuidade(campanhaGratuidadeClonada);
			documento.setCnpj(DOC_PADRAO_LANCAMENTO);
			documentos.add(documento);

		}else{
			for (String cnpj : cnpjsValidos) {
				Documento documento = new Documento();
				documento.setCampanhaGratuidade(campanhaGratuidadeClonada);
				if(campanhaGratuidadeClonada.getTipoCliente() != null && campanhaGratuidadeClonada.getTipoCliente().getId() == 2){
					String[]cnpjLogon = cnpj.split(";");
					documento.setCnpj(cnpjLogon[0]);
					documento.setLogin(cnpjLogon[1].toUpperCase());
				}else{
					documento.setCnpj(cnpj);
				}
				documentos.add(documento);
			}
		}
			
		return documentos;
	}

	private Set<String> obterCnpjsValidos(ArquivoUploadDownload arquivoUpload) throws GerenciadorPerfilServiceException {

		List<String> conteudo = Collections.emptyList();

		if (arquivoUpload != null) {

			InputStream inputStream = arquivoUpload.toInputStream();

			try {
				conteudo = IOUtils.readLines(inputStream);
			} catch (IOException ioException) {
				throw new GerenciadorPerfilServiceException("Erro ao efetuar leitura de arquivo: " + ioException.getMessage());
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

	public List<CampanhaGratuidade> listarQueContenhamFeature(Feature feature) {
		CampanhaGratuidadeFilter campanhaGratuidadeFilter = new CampanhaGratuidadeFilter();
		campanhaGratuidadeFilter.getContainsFeaturesId().add(feature.getId());

		return listar(campanhaGratuidadeFilter);
//		return getDao().listarQueContenhamFeature(feature);
	}

	public List<CampanhaGratuidade> listarPorProdutoSemCaronaFeature(Produto produto) {
		
		CampanhaGratuidadeFilter filter = new CampanhaGratuidadeFilter();
		filter.setIdProdutoEquals(produto.getId());
		filter.setNaoContemCaronaFeatureVinculada(true);

		return listar(filter);
	}

}

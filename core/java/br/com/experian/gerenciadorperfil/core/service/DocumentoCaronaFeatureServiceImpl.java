package br.com.experian.gerenciadorperfil.core.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import br.com.experian.gerenciadorperfil.core.dao.DocumentoCaronaFeatureDAO;
import br.com.experian.gerenciadorperfil.core.entity.CaronaFeature;
import br.com.experian.gerenciadorperfil.core.entity.DocumentoCaronaFeature;
import br.com.experian.gerenciadorperfil.core.entity.filter.DocumentoCaronaFeatureFilter;
import br.com.experian.gerenciadorperfil.core.exception.DocumentosJaCadastradosEmCaronaFeatureException;
import br.com.experian.gerenciadorperfil.core.exception.GerenciadorPerfilServiceException;
import br.com.experian.gerenciadorperfil.core.entity.Feature;

@Service
public class DocumentoCaronaFeatureServiceImpl extends AbstractService<DocumentoCaronaFeature, Long, DocumentoCaronaFeatureFilter, DocumentoCaronaFeatureDAO> implements DocumentoCaronaFeatureService {

	@Autowired
	private CaronaFeatureService caronaFeatureService;

	@Autowired
	public DocumentoCaronaFeatureServiceImpl(DocumentoCaronaFeatureDAO documentoDAO) {
		super(documentoDAO);
	}

	public List<DocumentoCaronaFeature> listarPorCaronaFeature(CaronaFeature caronaFeature) {
		DocumentoCaronaFeatureFilter documentoFilter = new DocumentoCaronaFeatureFilter()
			.setIdCaronaFeatureEquals(caronaFeature.getId());

		return listar(documentoFilter);
	}
	
	public List<DocumentoCaronaFeature> listarPorCampanhaAceitaSemCancelamento(Feature feature, List<String> cnpjs, List<String> logon) {
		return getDao().buscarComAceiteSemCancelamento(feature, cnpjs, logon);
	}
	
	public List<DocumentoCaronaFeature> listarDocumentosCienciaPendente(List<String> cnpjs, String produto) {
		return getDao().listarDocumentosCienciaPendente(cnpjs, produto);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public DocumentoCaronaFeature adicionar(DocumentoCaronaFeature documento) throws GerenciadorPerfilServiceException {
		adicionar(Arrays.asList(documento));
		return documento;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void remover(DocumentoCaronaFeature documento) throws GerenciadorPerfilServiceException {

		CaronaFeature caronaFeature = documento.getCaronaFeature();

		List<DocumentoCaronaFeature> documentos = listarPorCaronaFeature(caronaFeature);

		documentos.remove(documento);

		if (!CollectionUtils.isEmpty(documentos)) {
			throw new GerenciadorPerfilServiceException("Não é permitido excluir o único CNPJ associado a uma campanha de desconto");
		}

		super.remover(documento);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void adicionar(List<DocumentoCaronaFeature> documentosParaCadastrar) throws GerenciadorPerfilServiceException {

		CaronaFeature caronaFeatureQueDocumentosSeraoAdicionados = documentosParaCadastrar.iterator().next().getCaronaFeature();

		/**
		 * Verifica documentos cadastrados anteriormente na mesma campanha
		 */
		List<DocumentoCaronaFeature> documentosJaCadastradosNaMesmaCaronaFeature = listarPorCaronaFeature(caronaFeatureQueDocumentosSeraoAdicionados);

		List<DocumentoCaronaFeature> documentosConflitantesComRegraDeNegocio = new ArrayList<DocumentoCaronaFeature>();

		for (DocumentoCaronaFeature documentoJaCadastradosNaMesmaCaronaFeature : documentosJaCadastradosNaMesmaCaronaFeature) {
			for (DocumentoCaronaFeature documentoParaCadastrar : documentosParaCadastrar) {
				if (documentoJaCadastradosNaMesmaCaronaFeature.getCnpj().equals(documentoParaCadastrar.getCnpj())) {
					documentosConflitantesComRegraDeNegocio.add(documentoJaCadastradosNaMesmaCaronaFeature);
				}
			}
		}

		if (!documentosConflitantesComRegraDeNegocio.isEmpty()) {
			DocumentosJaCadastradosEmCaronaFeatureException documentosJaCadastradosException = new DocumentosJaCadastradosEmCaronaFeatureException("Já existem cnpjs informados nesta mesma campanha");
			documentosJaCadastradosException.setDocumentos(documentosConflitantesComRegraDeNegocio);
			throw documentosJaCadastradosException;
		}

		caronaFeatureService.verificarExistenciaDeCampanhaImpeditiva(documentosParaCadastrar, caronaFeatureQueDocumentosSeraoAdicionados);

		getDao().adicionar(documentosParaCadastrar);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Integer removerPorCaronaFeature(CaronaFeature caronaFeature) throws GerenciadorPerfilServiceException {
		DocumentoCaronaFeatureFilter documentoFilter = new DocumentoCaronaFeatureFilter()
			.setIdCaronaFeatureEquals(caronaFeature.getId());

		return getDao().remover(documentoFilter);
	}

	/**
	 * @param caronaFeatureService the campanhaDescontoService to set
	 */
	public void setCaronaFeatureService(CaronaFeatureService caronaFeatureService) {
		this.caronaFeatureService = caronaFeatureService;
	}


}
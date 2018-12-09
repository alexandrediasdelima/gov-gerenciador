package br.com.experian.gerenciadorperfil.core.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.experian.gerenciadorperfil.core.dao.DocumentoDAO;
import br.com.experian.gerenciadorperfil.core.entity.CampanhaGratuidade;
import br.com.experian.gerenciadorperfil.core.entity.Documento;
import br.com.experian.gerenciadorperfil.core.entity.filter.DocumentoFilter;
import br.com.experian.gerenciadorperfil.core.exception.DocumentosJaCadastradosEmCampanhaGratuidadeException;
import br.com.experian.gerenciadorperfil.core.exception.GerenciadorPerfilServiceException;

@Service
public class DocumentoServiceImpl extends AbstractService<Documento, Long, DocumentoFilter, DocumentoDAO> implements DocumentoService {

	@Autowired
	private CampanhaGratuidadeService campanhaGratuidadeService;

	@Autowired
	public DocumentoServiceImpl(DocumentoDAO documentoDAO) {
		super(documentoDAO);
	}

	public List<Documento> listarPorCampanhaGratuidade(CampanhaGratuidade campanhaGratuidade) {
		DocumentoFilter documentoFilter = new DocumentoFilter()
			.setIdCampanhaGratuidadeEquals(campanhaGratuidade.getId());

		return listar(documentoFilter);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Documento adicionar(Documento documento) throws GerenciadorPerfilServiceException {
		adicionar(Arrays.asList(documento));
		return documento;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void remover(Documento documento) throws GerenciadorPerfilServiceException {

		CampanhaGratuidade campanhaGratuidade = documento.getCampanhaGratuidade();

		List<Documento> documentos = listarPorCampanhaGratuidade(campanhaGratuidade);

		documentos.remove(documento);

		if (documentos.size()==0 && CampanhaGratuidade.TIPO_CAMPANHA_PADRAO.equals(campanhaGratuidade.getTipo())) {
			throw new GerenciadorPerfilServiceException("Não é permitido excluir o único CNPJ associado a uma campanha do tipo Padrão");
		}

		super.remover(documento);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void adicionar(List<Documento> documentosParaCadastrar) throws GerenciadorPerfilServiceException {

		CampanhaGratuidade campanhaGratuidadeQueDocumentosSeraoAdicionados = documentosParaCadastrar.iterator().next().getCampanhaGratuidade();

		/**
		 * verifica documentos cadastrados anteriormente na mesma campanha
		 */
		List<Documento> documentosJaCadastradosNaMesmaCampanhaGratuidade = listarPorCampanhaGratuidade(campanhaGratuidadeQueDocumentosSeraoAdicionados);

		List<Documento> documentosConflitantesComRegraDeNegocio = new ArrayList<Documento>();

		for (Documento documentoJaCadastradosNaMesmaCampanhaGratuidade : documentosJaCadastradosNaMesmaCampanhaGratuidade) {
			for (Documento documentoParaCadastrar : documentosParaCadastrar) {
				if (documentoJaCadastradosNaMesmaCampanhaGratuidade.getCnpj().equals(documentoParaCadastrar.getCnpj())) {
					documentosConflitantesComRegraDeNegocio.add(documentoJaCadastradosNaMesmaCampanhaGratuidade);
				}
			}
		}

		if (!documentosConflitantesComRegraDeNegocio.isEmpty()) {
			DocumentosJaCadastradosEmCampanhaGratuidadeException documentosJaCadastradosEmCampanhaGratuidadeException = new DocumentosJaCadastradosEmCampanhaGratuidadeException("Já existem cpfs informados nesta mesma campanha");
			documentosJaCadastradosEmCampanhaGratuidadeException.setDocumentos(documentosConflitantesComRegraDeNegocio);
			throw documentosJaCadastradosEmCampanhaGratuidadeException;
		}

		campanhaGratuidadeService.verificaExistenciaDeCampanhaVigenteImpeditiva(campanhaGratuidadeQueDocumentosSeraoAdicionados, documentosParaCadastrar);

		getDao().adicionar(documentosParaCadastrar);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Integer removerPorCampanhaGratuidade(CampanhaGratuidade campanhaGratuidade) throws GerenciadorPerfilServiceException {
		DocumentoFilter documentoFilter = new DocumentoFilter()
			.setIdCampanhaGratuidadeEquals(campanhaGratuidade.getId());

		return getDao().remover(documentoFilter);
	}

	/**
	 * @param campanhaGratuidadeService the campanhaGratuidadeService to set
	 */
	public void setCampanhaGratuidadeService(CampanhaGratuidadeService campanhaGratuidadeService) {
		this.campanhaGratuidadeService = campanhaGratuidadeService;
	}
}
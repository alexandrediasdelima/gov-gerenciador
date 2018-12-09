package br.com.experian.gerenciadorperfil.core.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.experian.gerenciadorperfil.core.dao.PerfilDAO;
import br.com.experian.gerenciadorperfil.core.entity.Perfil;
import br.com.experian.gerenciadorperfil.core.entity.PerfilDocumento;
import br.com.experian.gerenciadorperfil.core.entity.Produto;
import br.com.experian.gerenciadorperfil.core.entity.filter.PerfilFilter;
import br.com.experian.gerenciadorperfil.core.exception.GerenciadorPerfilServiceException;
import br.com.experian.gerenciadorperfil.core.service.common.ArquivoUploadDownload;
import br.com.experian.gerenciadorperfil.core.util.FormatterUtils;

@Service
public class PerfilServiceImpl extends AbstractService<Perfil, Long, PerfilFilter, PerfilDAO> implements PerfilService {

	@Autowired
	private PerfilDocumentoService perfilDocumentoService;

	@Autowired
	public PerfilServiceImpl(PerfilDAO perfilDAO) {
		super(perfilDAO);

	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Perfil obterPorCnpjEProduto(String cnpj, Produto produto) throws GerenciadorPerfilServiceException {

		List<Perfil> perfis = listarPorProduto(produto);
		List<PerfilDocumento> docs = perfilDocumentoService.listarPorCNPJ(cnpj);
		Perfil perfil = null;
		for(PerfilDocumento doc: docs){
			if (perfis.contains(doc.getPerfil())){
				perfil = doc.getPerfil();
				break;
			}
		}

		return perfil;
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Perfil> listarPorProduto(Produto produto) {
		PerfilFilter perfilFilter = new PerfilFilter()
		.setIdProdutoEquals(produto.getId());

		return listar(perfilFilter);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Perfil> listarPorTipoAntigo() {
		PerfilFilter perfilFilter = new PerfilFilter()
		.setTipoEquals(Perfil.CLIENTE_ANTIGO);

		return listar(perfilFilter);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Perfil> listarPorTipoPreClicado() {
		PerfilFilter perfilFilter = new PerfilFilter()
		.setTipoEquals(Perfil.CLIENTE_PRECLICADO);

		return listar(perfilFilter);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Perfil> listarPorTipoWhitelist() {
		PerfilFilter perfilFilter = new PerfilFilter()
		.setTipoEquals(Perfil.CLIENTE_WHITELIST);

		return listar(perfilFilter);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Perfil adicionar(Perfil perfil, List<PerfilDocumento> documentos) throws GerenciadorPerfilServiceException {
		perfil = adicionar(perfil);
		for(PerfilDocumento pd: documentos){
			pd.setPerfil(perfil);
			perfilDocumentoService.adicionar(pd);
		}

		return perfil;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Perfil atualizar(Perfil perfil, List<PerfilDocumento> documentos) throws GerenciadorPerfilServiceException {
		perfil = atualizar(perfil);
		perfilDocumentoService.removerPorPerfil(perfil);
		for(PerfilDocumento pd: documentos){
			pd.setPerfil(perfil);
			pd.setId(null);
			perfilDocumentoService.adicionar(pd);
		}

		return perfil;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = GerenciadorPerfilServiceException.class)
	public Perfil adicionar(Perfil perfil, ArquivoUploadDownload arquivoUpload) throws GerenciadorPerfilServiceException {

		if (perfil == null || perfil.getNome() == null || "".equals(perfil.getNome()) || perfil.getTipo() == '\u0000') {
			throw new GerenciadorPerfilServiceException("Devem ser informados no minimo o nome e o tipo do perfil");
		}

		if (arquivoUpload == null) {
			throw new GerenciadorPerfilServiceException("O arquivo para upload deve ser informado!");
		}

		List<String> conteudo = Collections.emptyList();

		InputStream inputStream = arquivoUpload.toInputStream();

		try {
			conteudo = IOUtils.readLines(inputStream);
		} catch (IOException ioException) {
			throw new GerenciadorPerfilServiceException("Erro ao efetuar leitura de arquivo: " + ioException.getMessage());
		}

		Set<String> cnpjsValidos = new LinkedHashSet<String>(conteudo.size());

		for (String linha : conteudo) {
			cnpjsValidos.add(FormatterUtils.formatCnpj(linha));
		}

		if (cnpjsValidos.size() == 0) {
			throw new GerenciadorPerfilServiceException("Deve haver pelo menos um cnpj válido no arquivo informado");
		}

		perfil = adicionar(perfil);

		List<PerfilDocumento> documentos = new ArrayList<PerfilDocumento>();

		for (String cnpj : cnpjsValidos) {
			PerfilDocumento documento = new PerfilDocumento();
			documento.setPerfil(perfil);
			documento.setCnpj(cnpj);
			documentos.add(documento);
		}

		perfilDocumentoService.adicionar(documentos);

		return perfil;
	}

}

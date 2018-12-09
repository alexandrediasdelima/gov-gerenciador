package br.com.experian.gerenciadorperfil.core.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.experian.gerenciadorperfil.core.dao.ProdutoDAO;
import br.com.experian.gerenciadorperfil.core.entity.AvisoDeAlerta;
import br.com.experian.gerenciadorperfil.core.entity.CampanhaGratuidade;
import br.com.experian.gerenciadorperfil.core.entity.Feature;
import br.com.experian.gerenciadorperfil.core.entity.Oferta;
import br.com.experian.gerenciadorperfil.core.entity.Perfil;
import br.com.experian.gerenciadorperfil.core.entity.PerfilDocumento;
import br.com.experian.gerenciadorperfil.core.entity.Produto;
import br.com.experian.gerenciadorperfil.core.entity.filter.ProdutoFilter;
import br.com.experian.gerenciadorperfil.core.exception.AssociacaoPerfilProdutoException;
import br.com.experian.gerenciadorperfil.core.exception.GerenciadorPerfilServiceException;
import br.com.experian.gerenciadorperfil.produto.enumeration.EnumProduto;

@Service
public class ProdutoServiceImpl extends AbstractService<Produto, Integer, ProdutoFilter, ProdutoDAO> implements ProdutoService {

	private FeatureService 				featureService;
	private PerfilDocumentoService 		perfilDocumentoService;
	private CampanhaGratuidadeService 	campanhaGratuidadeService;
	private AvisoDeAlertaService		avisoDeAlertaService;
	private OfertaService				ofertaService;

	@Autowired
	public ProdutoServiceImpl(FeatureService featureService,
			ProdutoDAO produtoDAO,
			PerfilDocumentoService perfilDocumentoService,
			CampanhaGratuidadeService campanhaGratuidadeService,
			AvisoDeAlertaService avisoDeAlertaService,
			OfertaService ofertaService) {

		super(produtoDAO);

		this.featureService = featureService;
		this.perfilDocumentoService = perfilDocumentoService;
		this.campanhaGratuidadeService = campanhaGratuidadeService;
		this.avisoDeAlertaService = avisoDeAlertaService;
		this.ofertaService = ofertaService;

	}

	private void validarDadosDeEntradaComum(Produto produto) throws GerenciadorPerfilServiceException {

		if (StringUtils.isBlank(produto.getNome())) {
			throw new GerenciadorPerfilServiceException("Nome é requerido");
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Produto adicionar(Produto produto) throws GerenciadorPerfilServiceException {

		validarDadosDeEntradaComum(produto);

		Produto produtoCadastrado = buscaProdutoPorNome(produto.getNome());

		if (produtoCadastrado != null) {
			throw new GerenciadorPerfilServiceException("Já existe um produto cadastrado com este nome");
		}

		Produto produtoClonado = (Produto) SerializationUtils.clone(produto);

		produtoClonado.setDataCriacao(new Date());

		return super.adicionar(produtoClonado);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Produto atualizar(Produto produto) throws GerenciadorPerfilServiceException {

		validarDadosDeEntradaComum(produto);

		Produto produtoCadastrado = buscaProdutoPorNomeExcetoComId(produto.getNome(), produto.getId());

		if (produtoCadastrado != null) {
			throw new GerenciadorPerfilServiceException("Já existe outro produto cadastrado com este nome");
		}

		Produto produtoClonado = (Produto) SerializationUtils.clone(produto);

		produtoClonado.setDataAlteracao(new Date());

		return super.atualizar(produtoClonado);
	}

	private Produto buscaProdutoPorNomeExcetoComId(String nome, Integer id) {

		ProdutoFilter produtoFilter = new ProdutoFilter()
			.setNomeEquals(nome)
			.setIdNotEquals(id);

		List<Produto> produtos = getDao().listar(produtoFilter);

		if (produtos.isEmpty()) {
			return null;
		}

		return produtos.get(0);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Produto buscaProdutoPorNome(String nome) {

		ProdutoFilter produtoFilter = new ProdutoFilter()
			.setNomeEquals(nome);

		List<Produto> produtos = getDao().listar(produtoFilter);

		if (produtos.isEmpty()) {
			return null;
		}

		return produtos.get(0);
	}

	public List<String> obterNomesProduto() {
		List<String> nomes = new ArrayList<String>();
		for (EnumProduto e : EnumProduto.values()) {
			nomes.add(e.name());
		}
		return nomes;
	}

	public List<String> obterNomesProdutosAindaNaoCriados() {

		List<String> produtosDisponiveis = obterNomesProduto();

		List<Produto> produtosCriados = listar();

		for (Produto produto : produtosCriados) {
			produtosDisponiveis.remove(produto.getNome());
		}

		return produtosDisponiveis;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void remover(Produto produto) throws GerenciadorPerfilServiceException {
		
		if (!produto.getPerfis().isEmpty()) {
			throw new GerenciadorPerfilServiceException("Não é possivel excluir produtos com perfis associados");
		}

		List<Feature> features = featureService.obterPorProduto(produto);
		if (!features.isEmpty()) {
			throw new GerenciadorPerfilServiceException("Não é possivel excluir produtos com features associadas");
		}

		List<CampanhaGratuidade> campanhasGratuidade = campanhaGratuidadeService.listarPorProduto(produto);
		if (!campanhasGratuidade.isEmpty()) {
			throw new GerenciadorPerfilServiceException("Não é possivel excluir produtos com campanhas associadas");
		}
		
		List<Oferta> ofertas = ofertaService.buscarOfertaProduto(produto);
		if (!ofertas.isEmpty()) {
			throw new GerenciadorPerfilServiceException("Não é possivel excluir produtos com ofertas associadas");
		}
		
		AvisoDeAlerta avisoDeAlerta = avisoDeAlertaService.obterPorProduto(produto);
		if (avisoDeAlerta != null) {
			throw new GerenciadorPerfilServiceException("Não é possivel excluir produtos com aviso de alerta associado");
		}

		super.remover(produto);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	private void atualizarPerfisAssociados(Produto produto, List<Perfil> perfis) throws GerenciadorPerfilServiceException {

		List<String> duplicados = new ArrayList<String>();

		List<PerfilDocumento> perfilDocumentosDuplicados = new ArrayList<PerfilDocumento>();

		if (!perfis.isEmpty()){
			perfilDocumentosDuplicados = perfilDocumentoService.listarDuplicadosPorListaDePerfis(perfis);
		}

		if (perfilDocumentosDuplicados.isEmpty()) {

			for (Perfil perfil: perfis) {
				perfil.getProdutos().add(produto);
			}

			produto.setPerfis(new HashSet<Perfil>(perfis));

		} else {
			for (PerfilDocumento perfilDocumento: perfilDocumentosDuplicados) {
				duplicados.add(perfilDocumento.getCnpj() +" - " + perfilDocumento.getPerfil().getNome());
			}
			throw new AssociacaoPerfilProdutoException("Foram encontrados CNPJ's em mais de uma lista. Altera\u00e7\u00e3o N\u00c3O efetuada! Verifique a lista de CNPJs duplicados abaixo.", duplicados);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = GerenciadorPerfilServiceException.class)
	public Produto adicionarProdutoPerfisAssociados(Produto produto, List<Perfil> perfis) throws GerenciadorPerfilServiceException {
		this.atualizarPerfisAssociados(produto, perfis);
		return this.adicionar(produto);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = GerenciadorPerfilServiceException.class)
	public Produto atualizarProdutoPerfisAssociados(Produto produto, List<Perfil> perfis) throws GerenciadorPerfilServiceException {
		this.atualizarPerfisAssociados(produto, perfis);
		return this.atualizar(produto);
	}

}

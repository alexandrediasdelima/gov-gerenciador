package br.com.experian.gerenciadorperfil.core.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.experian.gerenciadorperfil.core.dao.BookUrlDAO;
import br.com.experian.gerenciadorperfil.core.entity.BookURL;
import br.com.experian.gerenciadorperfil.core.entity.Feature;
import br.com.experian.gerenciadorperfil.core.entity.Produto;
import br.com.experian.gerenciadorperfil.core.entity.filter.BookUrlFilter;
import br.com.experian.gerenciadorperfil.core.exception.BookURLServiceException;
import br.com.experian.gerenciadorperfil.core.exception.GerenciadorPerfilServiceException;
import br.com.experian.gerenciadorperfil.core.util.CoreUtils;

@Service
public class BookURLServiceImpl extends AbstractService<BookURL, Integer, BookUrlFilter, BookUrlDAO> implements BookURLService {

	private FeatureService 				featureService;
	private ProdutoService				produtoService;

	@Autowired
	public BookURLServiceImpl(FeatureService featureService,
			BookUrlDAO bookUrlDAO,
			ProdutoService produtoService) {

		super(bookUrlDAO);

		this.featureService = featureService;
		this.produtoService = produtoService;
		
	}

	private void validarDadosDeEntradaComum(BookURL bookURL) throws GerenciadorPerfilServiceException {

		if (StringUtils.isBlank(bookURL.getNome())) {
			throw new GerenciadorPerfilServiceException("Nome é requerido");
		}
		if (StringUtils.isBlank(bookURL.getBanner()) &&  StringUtils.isBlank(bookURL.getBannerPosGratuidade() ) 
				&& StringUtils.isBlank(bookURL.getBannerUltimoDia())  && StringUtils.isBlank(bookURL.getUrlImagemFundoInformativo())
				&& StringUtils.isBlank(bookURL.getUrlImagemFundoInformativo())  && StringUtils.isBlank(bookURL.getUrlTextoInformativo())
				&& StringUtils.isBlank(bookURL.getUrlBotaoCienciaInformativo())  && StringUtils.isBlank(bookURL.getUrlImagemFundoInformativo())
				&& StringUtils.isBlank(bookURL.getUrlTextoLigthBoxCarona())  && StringUtils.isBlank(bookURL.getUrlBotaoSimCarona())
				&& StringUtils.isBlank(bookURL.getUrlBotaoNaoCarona())  
				) {
			throw new GerenciadorPerfilServiceException("Preencha uma opção de Banner ou LIGHTBOX ");
		}
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public BookURL adicionar(BookURL bookURL) throws GerenciadorPerfilServiceException {

		validarDadosDeEntradaComum(bookURL);

		BookURL BookURLCadastrado = buscarBookURLPorNome(bookURL.getNome());

		if (BookURLCadastrado != null) {
			throw new GerenciadorPerfilServiceException("Já existe um Book de URL cadastrado com este nome");
		}

		BookURL bookURLClonado = (BookURL) SerializationUtils.clone(bookURL);

		bookURLClonado.setDataCriacao(new Date());

		return super.adicionar(bookURLClonado);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public BookURL atualizar(BookURL bookURL) throws GerenciadorPerfilServiceException {

		validarDadosDeEntradaComum(bookURL);

		
		BookURL bookURLClonado = (BookURL) SerializationUtils.clone(bookURL);
		bookURL.setLoginAlteracao("");
		bookURLClonado.setDataAlteracao(new Date());

		return super.atualizar(bookURLClonado);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<BookURL>buscar() throws BookURLServiceException{

		BookUrlFilter bookUrlFilter = new BookUrlFilter();
		

		List<BookURL> books = getDao().listar(bookUrlFilter);

		if (books.isEmpty()) {
			return null;
		}

		return books;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	private BookURL buscaPorId(Integer id) {

		BookUrlFilter bookUrlFilter = new BookUrlFilter();
		bookUrlFilter.setIdNotEquals(id);

		List<BookURL> books = getDao().listar(bookUrlFilter);

		if (books.isEmpty()) {
			return null;
		}

		return books.get(0);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public BookURL buscarBookURLPorNome(String nome) {

		BookUrlFilter bookUrlFilter = new BookUrlFilter();
		bookUrlFilter.setNomeEquals(nome);

		List<BookURL> books= getDao().listar(bookUrlFilter);

		if (books.isEmpty()) {
			return null;
		}

		return books.get(0);
	}

	public List<String> obterNomesBookURL() {
		List<String> nomes = new ArrayList<String>();
		
		List<BookURL>books =  listar();
		for (Iterator<BookURL> iterator = books.iterator(); iterator.hasNext();) {
			BookURL bookURL = (BookURL) iterator.next();
			nomes.add(bookURL.getNome());
		}
		return nomes;
	}

	public List<BookURL> obterBookURLPorProduto(Produto produto) {
		
		
		BookUrlFilter bookUrlFilter = new BookUrlFilter();
		if(produto !=null){
			bookUrlFilter.setProdutoEquals(produto);
		}
		
		List<BookURL> books =  listar(bookUrlFilter);
		
		return books;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void remover(BookURL bookURL) throws GerenciadorPerfilServiceException {

		super.remover(bookURL);
	}
	
	public String getStringHtmlTela(String urlImagemFundo, String urlTexto, String urlBotaoSim, String urlBotaoNao, String observacao) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("urlImgBackground", urlImagemFundo);
		params.put("urlImgTexto",      urlTexto);
		params.put("urlBtnAfirmativo", urlBotaoSim);
		params.put("urlBtnNegativo",   urlBotaoNao);
		params.put("txtObservacao",    observacao);
		
		return CoreUtils.processarFTL("caronaFeature.ftl", params, CaronaFeatureServiceImpl.class.getClassLoader(), "/LIGHTBOX");
		
	}

	public String getStringHtmlTelaInformativo(String urlImagemFundo, String urlTexto,	String urlBotaoCiencia, String observacao) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("urlImgBackground",	urlImagemFundo);
		params.put("urlImgTexto",		urlTexto);
		params.put("urlBtnCiencia",		urlBotaoCiencia);
		params.put("txtObservacao",		observacao);
		
		return CoreUtils.processarFTL("informativoCaronaFeature.ftl", params, CaronaFeatureServiceImpl.class.getClassLoader(), "/LIGHTBOX");

	}

	public List<BookURL> obterBookURLAcaoEstrategica(String acaoEstrategica) {
		
		BookUrlFilter bookUrlFilter = new BookUrlFilter();
		if(acaoEstrategica !=null){
			bookUrlFilter.setAcaoEstategicaEquals(acaoEstrategica); 
		}
		
		List<BookURL> books =  listar(bookUrlFilter);
		
		return books;
	}

	public List<BookURL> obterBookURLAcaoEstrategica(Produto produto,String acaoEstrategica){
		BookUrlFilter bookUrlFilter = new BookUrlFilter();
		if(acaoEstrategica !=null){
			bookUrlFilter.setAcaoEstategicaEquals(acaoEstrategica); 
		}
		
		if(produto !=null){
			bookUrlFilter.setProdutoEquals(produto);
		}
	
		List<BookURL> books =  listar(bookUrlFilter);
	
		return books;
	}


}

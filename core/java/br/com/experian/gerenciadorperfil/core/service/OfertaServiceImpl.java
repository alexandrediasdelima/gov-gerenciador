package br.com.experian.gerenciadorperfil.core.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.experian.gerenciadorperfil.core.dao.OfertaDAO;
import br.com.experian.gerenciadorperfil.core.entity.BookURL;
import br.com.experian.gerenciadorperfil.core.entity.Oferta;
import br.com.experian.gerenciadorperfil.core.entity.Produto;
import br.com.experian.gerenciadorperfil.core.entity.filter.OfertaFilter;
import br.com.experian.gerenciadorperfil.core.exception.BookURLServiceException;
import br.com.experian.gerenciadorperfil.core.exception.GerenciadorPerfilServiceException;
import br.com.experian.gerenciadorperfil.core.util.DateCompare;

@Service
public class OfertaServiceImpl extends AbstractService<Oferta, Integer, OfertaFilter, OfertaDAO> implements OfertaService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	public OfertaServiceImpl(OfertaDAO ofertaDAO) {
		super(ofertaDAO);
	}

	private void validarDadosDeEntradaComum(Oferta oferta) throws GerenciadorPerfilServiceException {

		if (oferta == null) {
			throw new GerenciadorPerfilServiceException("A Oferta não pode ser nula");
		}

		if (oferta.getDataInicio() == null) {
			throw new GerenciadorPerfilServiceException("A Data Inicio não pode ser nula");
		}

		if (oferta.getDataFim() == null) {
			throw new GerenciadorPerfilServiceException("A Data Fim não pode ser nula");
		}
		
		if (DateCompare.after(oferta.getDataInicio(), DateCompare.DATE_PLUS_100_YEARS)) {
			throw new GerenciadorPerfilServiceException("Data Inicio inválida");
		}
		
		if (DateCompare.after(oferta.getDataFim(), DateCompare.DATE_PLUS_100_YEARS)) {
			throw new GerenciadorPerfilServiceException("Data Fim inválida");
		}
		
		if (oferta.getDataInicio().after(oferta.getDataFim())) {
			throw new GerenciadorPerfilServiceException("A Data Início não pode ser posterior a data fim");
		}

		if (oferta.getTipo() == '\u0000') {
			throw new GerenciadorPerfilServiceException("O Tipo não pode ser nulo");
		}
		
		if (StringUtils.isBlank(oferta.getNome())) {
			throw new GerenciadorPerfilServiceException("O Nome não pode ser nulo");
		}

		if (oferta.getProduto() == null) {
			throw new GerenciadorPerfilServiceException("Oferta deve estar associada a um produto");
		}

		if (oferta.getFeature() == null) {
			throw new GerenciadorPerfilServiceException("Oferta deve estar associada a uma feature");
		}
		
		if (oferta.getDiasParaReexibicao() == null || oferta.getDiasParaReexibicao() < 0) {
			throw new GerenciadorPerfilServiceException("Deve ser informado um número maior ou igual a 0 para a quantidade de dias para reexibição");
		}
	}
	
	private void validarDadosDeEntradaInclusao(Oferta oferta, String urlImagemFundo, String urlTexto, String urlBotaoSim, String urlBotaoNao) throws GerenciadorPerfilServiceException {
		if (oferta.getId() == null) { //soh valida se estiver cadastrando uma campanha nova
			if (StringUtils.isBlank(urlImagemFundo)) {
				throw new GerenciadorPerfilServiceException("A url da Imagem de Fundo não pode ser nula");
			}
	
			if (StringUtils.isBlank(urlTexto)) {
				throw new GerenciadorPerfilServiceException("A url da Imagem do Texto não pode ser nula");
			}
	
			if (StringUtils.isBlank(urlBotaoSim)) {
				throw new GerenciadorPerfilServiceException("A url da Imagem do Botão Afirmativo não pode ser nula");
			}
	
			if (StringUtils.isBlank(urlBotaoNao)) {
				throw new GerenciadorPerfilServiceException("A url da Imagem do Botão Negativo não pode ser nula");
			}
		}
	}

	public Oferta adicionar(Oferta oferta, String urlImagemFundo, String urlTexto, String urlBotaoSim, String urlBotaoNao) throws GerenciadorPerfilServiceException {
		logger.info(">OfertaServiceImpl.adicionar()");
		
		validarDadosDeEntradaComum(oferta);
		validarDadosDeEntradaInclusao(oferta, urlImagemFundo, urlTexto, urlBotaoSim, urlBotaoNao);

		if (existeOfertaVigentePorProdutoETipo(oferta)) {
			throw new GerenciadorPerfilServiceException(String.format("Ja existe Oferta de P%s vigente neste período para o produto selecionado", oferta.getTipo()));
		}

		if (oferta.getId() == null) {
			oferta.setHtmlTela(getStringHtmlTela(urlImagemFundo, urlTexto, urlBotaoSim, urlBotaoNao));
			logger.info("Adicionando oferta com o html: [{}]", oferta.getHtmlTela());
			return adicionar(oferta);
		} else {
			logger.info("Atualizando oferta com o html: [{}]", oferta.getHtmlTela());
			return atualizar(oferta);
		}

	}

	private boolean existeOfertaVigentePorProdutoETipo(Oferta oferta) {
		OfertaFilter ofertaFilter = new OfertaFilter()
				.setIdProdutoEquals(oferta.getProduto().getId())
				.setTipoEquals(oferta.getTipo())
				.setAtiva(true)
				.setDataInicio(oferta.getDataInicio())
				.setDataFim(oferta.getDataFim());
		
		if (oferta.getId() != null) {
			ofertaFilter.setIdOfertaNotEquals(oferta.getId());
		}

		List<Oferta> ofertas = getDao().listar(ofertaFilter);

		if (ofertas.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Oferta> buscarOfertaProduto(Produto produto) {
		OfertaFilter ofertaFilter = new OfertaFilter().setIdProdutoEquals(produto.getId());
		return getDao().listar(ofertaFilter);
	}

	public String getStringHtmlTela(String urlImagemFundo, String urlTexto, String urlBotaoSim, String urlBotaoNao) {

		return ""
		+ "<div style=\"position: absolute; top: 0px; left: 0px; visibility: hidden;\" id=\"textarea_simulator\"></div>"
		+ "<div class=\"blockUI\" style=\"display:none\"></div> "
		+ "<div class=\"blockUI blockOverlay\" style=\"z-index: 1000; border: medium none; margin: 0px; padding: 0px; width: 100%; height: 100%; top: 0px; left: 0px; background-color: rgb(0, 0, 0); filter: alpha(opacity=80); opacity: 0.8; position: fixed;\"></div>"
		+ "<div id=\"popupOferta\" class=\"blockUI blockMsg blockPage\" style=\"z-index: 1011; position: fixed; margin: 0px; top: 12%; left: 20%; right: 50%; cursor: pointer; width: 760px;\"> "
        + ""
		+ "	<style>"
		+ "		h1{"
		+ "			color: #ffffff;"
		+ "			font-size: 23px;"
		+ "		}"
        + ""
		+ "		body{"
		+ "			color: #666;"
		+ "			font-size: 11px;"
		+ "			padding:0;"
		+ "			margin:0;"
		+ "			background: #F5F5F5;"
		+ "			font-family: Arial, Verdana, Tahoma, Sans;"
		+ "		}"
        + ""
		+ "		a{"
		+ "			text-decoration: none;"
		+ "		}"
        + ""
		+ "		.banner_background{"
		+ "			width: 780px;"
		+ "			float: left;"
		+ "			margin: 0px;"
		+ "			background: url('" + urlImagemFundo + "') no-repeat scroll 0% 0% transparent;"
		+ "			height: 426px;"
		+ "		}"
        + ""
		+ "		.banner_conteudo{"
		+ "			float: right;"
		+ "			margin: 40px 0 0;"
		+ "		}"
        + ""
		+ "		#banner_container{"
		+ "			width: 780px;"
		+ "			margin: 0 auto;"
		+ "			display:table;"
		+ "		}"
        + ""
		+ "		#banner_botoes{"
		+ "			float: left;"
		+ "			margin: 70px 0 0 70px;"
		+ "			width: 650px;"
		+ "		}"
        + ""
		+ "		.banner_botoes_1{"
		+ "			float:left;"
		+ "		}"
        + ""
		+ "		.banner_botoes_2{"
		+ "			float:right;"
		+ "		}"
		+ "	</style>"
        + ""
		+ "	<div id=\"dhtmltooltip\"></div>"
		+ "	<div id=\"banner_container\">"
		+ "		<div class=\"banner_background\">"
		+ "			<div class=\"banner_conteudo\">"
		+ "				<img src=\"" + urlTexto + "\" alt=\"\" title=\"\"/>"
		+ "			</div>"
		+ "			<div id=\"banner_botoes\">"
		+ "				<div class=\"banner_botoes_1\">"
		+ "					<input type=\"image\" src=\"" + urlBotaoNao + "\" onclick=\"document.getElementById('radRespostaNaoPopupOferta').checked=true; document.getElementById('idFromSumitButton').click(); return false;\" />"
		+ "				</div>"
        + ""
		+ "				<div class=\"banner_botoes_2\">"
		+ "					<input type=\"image\" src=\"" + urlBotaoSim + "\" onclick=\"document.getElementById('radRespostaSimPopupOferta').checked=true; document.getElementById('idFromSumitButton').click(); return false;\" />"
		+ "				</div>"
		+ "			</div>"
		+ "		</div>"
		+ "	</div>"
		+ "	<input type=\"radio\" id=\"radRespostaSimPopupOferta\" name=\"radRespostaPopupOferta\" value=\"yes\" style=\"display: none;\" />"
		+ "	<input type=\"radio\" id=\"radRespostaNaoPopupOferta\" name=\"radRespostaPopupOferta\" value=\"no\" style=\"display: none;\" />"
		+ "</div>";

	}

	public List<BookURL> buscar() throws BookURLServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}

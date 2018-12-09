package br.com.experian.gerenciadorperfil.core.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.experian.gerenciadorperfil.core.entity.HistoricoOferta;
import br.com.experian.gerenciadorperfil.core.entity.Oferta;
import br.com.experian.gerenciadorperfil.core.entity.filter.OfertaFilter;

@Component
public class OfertaDAOImpl extends AbstractDAO<Oferta, Integer, OfertaFilter> implements OfertaDAO {

	private static final String SELECT = "SELECT o from Oferta o ";
	private transient final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private HistoricoOfertaDAO historicoOfertaDAO;

	public OfertaDAOImpl() {
		super(Oferta.class, OfertaFilter.class);
	}

	@Override
	public Oferta adicionar(Oferta entity) {

		logger.info("oferta id [{}]", entity==null?"null":entity.getId());

		Oferta ofertaAdicionada = super.adicionar(entity);

		logger.info("ofertaAdicionada id [{}]", ofertaAdicionada.getId());

		HistoricoOferta historicoOferta = new HistoricoOferta(ofertaAdicionada, HistoricoOferta.INSERT);

		logger.info("historicoOferta id [{}]", historicoOferta.getId());

		historicoOfertaDAO.adicionar(historicoOferta);

		return ofertaAdicionada;

	}

	@Override
	public Oferta atualizar(Oferta entity) {

		Oferta ofertaAtualizada = super.atualizar(entity);
		HistoricoOferta historicoOferta = new HistoricoOferta(ofertaAtualizada, HistoricoOferta.UPDATE);

		historicoOfertaDAO.adicionar(historicoOferta);

		return ofertaAtualizada;

	}

	@Override
	public void remover(Oferta entity) {
		//Oferta nao deve ser removida nunca
	}

	@Override
	protected void applyFilter(Query query, OfertaFilter ofertaFilter) {

		super.applyFilter(query, ofertaFilter);

		if (ofertaFilter.getIdProdutoEquals() != null) {
			query.setParameter(OfertaFilter.ID_PRODUTO_EQUALS, ofertaFilter.getIdProdutoEquals());
		}

		if (ofertaFilter.getDateBetweenInicioAndFim() != null) {
			query.setParameter(OfertaFilter.DATE_BETWEEN_INICIO_AND_FIM, ofertaFilter.getDateBetweenInicioAndFim());
		}

		if (ofertaFilter.getTipoEquals() != '\u0000') {
			query.setParameter(OfertaFilter.TIPO_EQUALS, ofertaFilter.getTipoEquals());
		}
		
		if (ofertaFilter.getIdOfertaNotEquals() != null) {
			query.setParameter(OfertaFilter.ID_OFERTA_NOT_EQUALS, ofertaFilter.getIdOfertaNotEquals());
		}
		
		if (ofertaFilter.getDataInicio() != null && ofertaFilter.getDataFim() != null) {
			query.setParameter(OfertaFilter.DATA_INICIO, ofertaFilter.getDataInicio());
			query.setParameter(OfertaFilter.DATA_FIM, ofertaFilter.getDataFim());
		}

	}

	@Override
	protected String createSqlQuery(OfertaFilter ofertaFilter) {

		StringBuilder sql = new StringBuilder(SELECT);

		List<String> wheres = new ArrayList<String>();

		if (ofertaFilter.getDateBetweenInicioAndFim() != null) {
			wheres.add("o.dataInicio <= :" + OfertaFilter.DATE_BETWEEN_INICIO_AND_FIM + " AND o.dataFim >= :" + OfertaFilter.DATE_BETWEEN_INICIO_AND_FIM);
		}

		if (ofertaFilter.getTipoEquals() != '\u0000') {
			wheres.add("o.tipo = :" + OfertaFilter.TIPO_EQUALS);
		}

		if (ofertaFilter.getIdProdutoEquals() != null) {
			wheres.add("o.produto.id = :" + OfertaFilter.ID_PRODUTO_EQUALS);
		}

		if (ofertaFilter.isAtiva()) {
			wheres.add("o.cancelamento is null");
		}
		
		if (ofertaFilter.getIdOfertaNotEquals() != null) {
			wheres.add("o.id != :" + OfertaFilter.ID_OFERTA_NOT_EQUALS);
		}
		
		if (ofertaFilter.getDataInicio() != null && ofertaFilter.getDataFim() != null) {
			wheres.add(":" + OfertaFilter.DATA_FIM + " >= o.dataInicio AND o.dataFim >= :" + OfertaFilter.DATA_INICIO);
		}

		if (!wheres.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(StringUtils.join(wheres, " AND "));
		}
		
		sql.append(" ORDER BY o.id DESC ");

		return sql.toString();
	}
}

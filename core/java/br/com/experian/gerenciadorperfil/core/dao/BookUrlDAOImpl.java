package br.com.experian.gerenciadorperfil.core.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.experian.gerenciadorperfil.core.entity.BookURL;
import br.com.experian.gerenciadorperfil.core.entity.filter.BookUrlFilter;


@Component
public class BookUrlDAOImpl extends AbstractDAO<BookURL, Integer, BookUrlFilter> implements BookUrlDAO {

	private static final String SQL = "SELECT b FROM BookURL b ";

	public BookUrlDAOImpl() {
		super(BookURL.class, BookUrlFilter.class);
	}

	@Override
	protected void applyFilter(Query typedQuery, BookUrlFilter bookUrlFilter) {
		super.applyFilter(typedQuery, bookUrlFilter);
		if (bookUrlFilter.getNomeLikeRight() != null) {
			typedQuery.setParameter(BookUrlFilter.NOME_LIKE_RIGHT, bookUrlFilter.getNomeLikeRight().toUpperCase() + "%");
		}
		if (bookUrlFilter.getNomeEquals() != null) {
			typedQuery.setParameter(BookUrlFilter.NOME_EQUALS, bookUrlFilter.getNomeEquals().toUpperCase());
		}
		if (bookUrlFilter.getIdNotEquals() != null) {
			typedQuery.setParameter(BookUrlFilter.ID_NOT_EQUALS, bookUrlFilter.getIdNotEquals());
		}
		if (bookUrlFilter.getIdEquals() != null) {
			typedQuery.setParameter(BookUrlFilter.ID_EQUALS, bookUrlFilter.getIdEquals());
		}
		if (bookUrlFilter.getProdutoEquals() != null) {
			typedQuery.setParameter(BookUrlFilter.PRODUTO_EQUALS, bookUrlFilter.getProdutoEquals());
		}
		if (bookUrlFilter.getAcaoEstategicaEquals() != null) {
			typedQuery.setParameter(BookUrlFilter.ACAO_ESTRATEGICA_EQUALS, bookUrlFilter.getAcaoEstategicaEquals());
		}		

	}

	@Override
	protected String createSqlQuery(BookUrlFilter bookUrlFilter) {

		StringBuilder sql = new StringBuilder(SQL);

		List<String> where = new ArrayList<String>();

		if (bookUrlFilter.getNomeLikeRight() != null) {
			where.add("UPPER(b.nome) LIKE :" + BookUrlFilter.NOME_LIKE_RIGHT);
		}

		if (bookUrlFilter.getNomeEquals() != null) {
			where.add("UPPER(b.nome) = :" + BookUrlFilter.NOME_EQUALS);
		}

		if (bookUrlFilter.getIdNotEquals() != null) {
			where.add("b.id <> :" + BookUrlFilter.ID_NOT_EQUALS);
		}

		if (bookUrlFilter.getIdEquals() != null) {
			where.add("b.id = :" + BookUrlFilter.ID_EQUALS);
		}
		
		if (bookUrlFilter.getProdutoEquals() != null) {
			where.add("b.produto = :" + BookUrlFilter.PRODUTO_EQUALS);
		}
		if(bookUrlFilter.getAcaoEstategicaEquals()!= null){
			where.add("b.tipoEstrategia = :" + BookUrlFilter.ACAO_ESTRATEGICA_EQUALS);
		}
				


		if (!where.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(StringUtils.join(where, " AND "));
		}

		if (bookUrlFilter.isOrderByIdDesc()) {
			sql.append(" ORDER BY b.id DESC ");
		} else if (bookUrlFilter.isOrderByName()) {
			sql.append(" ORDER BY lower(b.nome) ");
		}

		return sql.toString();
	}
}

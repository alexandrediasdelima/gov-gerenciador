package br.com.experian.gerenciadorperfil.core.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.experian.gerenciadorperfil.core.entity.Produto;
import br.com.experian.gerenciadorperfil.core.entity.filter.ProdutoFilter;

@Component
public class ProdutoDAOImpl extends AbstractDAO<Produto, Integer, ProdutoFilter> implements ProdutoDAO {

	private static final String SQL = "SELECT p FROM Produto p ";

	public ProdutoDAOImpl() {
		super(Produto.class, ProdutoFilter.class);
	}

	@Override
	protected void applyFilter(Query typedQuery, ProdutoFilter produtoFilter) {
		super.applyFilter(typedQuery, produtoFilter);
		if (produtoFilter.getNomeLikeRight() != null) {
			typedQuery.setParameter(ProdutoFilter.NOME_LIKE_RIGHT, produtoFilter.getNomeLikeRight().toUpperCase() + "%");
		}
		if (produtoFilter.getNomeEquals() != null) {
			typedQuery.setParameter(ProdutoFilter.NOME_EQUALS, produtoFilter.getNomeEquals().toUpperCase());
		}
		if (produtoFilter.getIdNotEquals() != null) {
			typedQuery.setParameter(ProdutoFilter.ID_NOT_EQUALS, produtoFilter.getIdNotEquals());
		}
		if (produtoFilter.getIdEquals() != null) {
			typedQuery.setParameter(ProdutoFilter.ID_EQUALS, produtoFilter.getIdEquals());
		}
	}

	@Override
	protected String createSqlQuery(ProdutoFilter produtoFilter) {

		StringBuilder sql = new StringBuilder(SQL);

		List<String> where = new ArrayList<String>();

		if (produtoFilter.getNomeLikeRight() != null) {
			where.add("UPPER(p.nome) LIKE :" + ProdutoFilter.NOME_LIKE_RIGHT);
		}

		if (produtoFilter.getNomeEquals() != null) {
			where.add("UPPER(p.nome) = :" + ProdutoFilter.NOME_EQUALS);
		}

		if (produtoFilter.getIdNotEquals() != null) {
			where.add("p.id <> :" + ProdutoFilter.ID_NOT_EQUALS);
		}

		if (produtoFilter.getIdEquals() != null) {
			where.add("p.id = :" + ProdutoFilter.ID_EQUALS);
		}

		if (!where.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(StringUtils.join(where, " AND "));
		}

		if (produtoFilter.isOrderByIdDesc()) {
			sql.append(" ORDER BY p.id DESC ");
		} else if (produtoFilter.isOrderByName()) {
			sql.append(" ORDER BY lower(p.nome) ");
		}

		return sql.toString();
	}
}

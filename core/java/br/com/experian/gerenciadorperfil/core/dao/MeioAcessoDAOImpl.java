package br.com.experian.gerenciadorperfil.core.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;


import br.com.experian.gerenciadorperfil.core.entity.MeioAcesso;

import br.com.experian.gerenciadorperfil.core.entity.filter.MeioAcessoFilter;


@Component
public class MeioAcessoDAOImpl extends AbstractDAO<MeioAcesso, Integer, MeioAcessoFilter> implements MeioAcessoDAO {

	private static final String SQL = "SELECT m FROM MeioAcesso m ";

	public MeioAcessoDAOImpl() {
		super(MeioAcesso.class, MeioAcessoFilter.class);
	}

	@Override
	protected void applyFilter(Query typedQuery, MeioAcessoFilter meioAcessoFilter) {
		super.applyFilter(typedQuery, meioAcessoFilter);
		if (meioAcessoFilter.getNomeLikeRight() != null) {
			typedQuery.setParameter(meioAcessoFilter.NOME_LIKE_RIGHT, meioAcessoFilter.getNomeLikeRight().toUpperCase() + "%");
		}
		if (meioAcessoFilter.getNomeEquals() != null) {
			typedQuery.setParameter(meioAcessoFilter.NOME_EQUALS, meioAcessoFilter.getNomeEquals().toUpperCase());
		}
		if (meioAcessoFilter.getIdNotEquals() != null) {
			typedQuery.setParameter(meioAcessoFilter.ID_NOT_EQUALS, meioAcessoFilter.getIdNotEquals());
		}
		if (meioAcessoFilter.getIdEquals() != null) {
			typedQuery.setParameter(meioAcessoFilter.ID_EQUALS, meioAcessoFilter.getIdEquals());
		}
	}

	@Override
	protected String createSqlQuery(MeioAcessoFilter meioAcessoFilter) {

		StringBuilder sql = new StringBuilder(SQL);

		List<String> where = new ArrayList<String>();

		if (meioAcessoFilter.getNomeLikeRight() != null) {
			where.add("UPPER(m.descricaoMeioAcesso) LIKE :" + meioAcessoFilter.NOME_LIKE_RIGHT);
		}

		if (meioAcessoFilter.getNomeEquals() != null) {
			where.add("UPPER(m.descricaoMeioAcesso) = :" + meioAcessoFilter.NOME_EQUALS);
		}

		if (meioAcessoFilter.getIdNotEquals() != null) {
			where.add("m.id <> :" + meioAcessoFilter.ID_NOT_EQUALS);
		}

		if (meioAcessoFilter.getIdEquals() != null) {
			where.add("m.id = :" + meioAcessoFilter.ID_EQUALS);
		}

		if (!where.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(StringUtils.join(where, " AND "));
		}

		if (meioAcessoFilter.isOrderByIdAsc()) {
			sql.append(" ORDER BY m.id ASC ");
		} else if (meioAcessoFilter.isOrderByIdDesc()) {
			sql.append(" ORDER BY m.id DESC ");
		} else if (meioAcessoFilter.isOrderByName()) {
			sql.append(" ORDER BY lower(m.descricaoMeioAcesso) ");
		}

		return sql.toString();
	}
}

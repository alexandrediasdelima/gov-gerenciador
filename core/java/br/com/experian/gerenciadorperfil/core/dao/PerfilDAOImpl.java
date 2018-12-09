package br.com.experian.gerenciadorperfil.core.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.experian.gerenciadorperfil.core.entity.Perfil;
import br.com.experian.gerenciadorperfil.core.entity.filter.PerfilFilter;

@Component
public class PerfilDAOImpl extends AbstractDAO<Perfil, Long, PerfilFilter> implements PerfilDAO {

	private static final String SELECT = "SELECT p from Perfil p ";

	public PerfilDAOImpl() {
		super(Perfil.class, PerfilFilter.class);
	}

	@Override
	protected void applyFilter(Query query, PerfilFilter perfilFilter) {

		super.applyFilter(query, perfilFilter);

		if (StringUtils.isNotBlank(perfilFilter.getNomeLikeRight())) {
			query.setParameter(PerfilFilter.NOME_LIKE_RIGHT, perfilFilter.getNomeLikeRight() + "%");
		}

		if (perfilFilter.getIdProdutoEquals() != null) {
			query.setParameter(PerfilFilter.ID_PRODUTO_EQUALS, perfilFilter.getIdProdutoEquals());
		}

		if (perfilFilter.getTipoEquals() != '\u0000') {
			query.setParameter(PerfilFilter.TIPO_EQUALS, perfilFilter.getTipoEquals());
		}
	}

	@Override
	protected String createSqlQuery(PerfilFilter perfilFilter) {

		StringBuilder sql = new StringBuilder(SELECT);

		if (perfilFilter.getIdProdutoEquals() != null) {
			sql.append(" JOIN p.produtos AS prd ");
		}

		List<String> wheres = new ArrayList<String>();

		if (StringUtils.isNotBlank(perfilFilter.getNomeLikeRight())) {
			wheres.add("p.nome LIKE :" + PerfilFilter.NOME_LIKE_RIGHT);
		}

		if (perfilFilter.getIdProdutoEquals() != null) {
			wheres.add("prd.id = :" + PerfilFilter.ID_PRODUTO_EQUALS);
		}
		
		if (perfilFilter.getTipoEquals() != '\u0000') {
			wheres.add("p.tipo = :" + PerfilFilter.TIPO_EQUALS);
		}


		if (!wheres.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(StringUtils.join(wheres, " AND "));
		}

		if (perfilFilter.isOrderByIdDesc()) {
			sql.append(" ORDER BY p.id DESC ");
		} else if (perfilFilter.isOrderByName()) {
			sql.append(" ORDER BY lower(p.nome) ");
		}

		return sql.toString();
	}
}

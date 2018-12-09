package br.com.experian.gerenciadorperfil.core.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.experian.gerenciadorperfil.core.entity.Cliente;
import br.com.experian.gerenciadorperfil.core.entity.filter.ClienteFilter;


@Component
public class ClienteDAOImpl extends AbstractDAO<Cliente, Integer, ClienteFilter> implements ClienteDAO {

	private static final String SQL = "SELECT c FROM Cliente c ";

	public ClienteDAOImpl() {
		super(Cliente.class, ClienteFilter.class);
	}

	@Override
	protected void applyFilter(Query typedQuery, ClienteFilter clienteFilter) {
		super.applyFilter(typedQuery, clienteFilter);
		if (clienteFilter.getNomeLikeRight() != null) {
			typedQuery.setParameter(clienteFilter.NOME_LIKE_RIGHT, clienteFilter.getNomeLikeRight().toUpperCase() + "%");
		}
		if (clienteFilter.getNomeEquals() != null) {
			typedQuery.setParameter(clienteFilter.NOME_EQUALS, clienteFilter.getNomeEquals().toUpperCase());
		}
		if (clienteFilter.getIdNotEquals() != null) {
			typedQuery.setParameter(clienteFilter.ID_NOT_EQUALS, clienteFilter.getIdNotEquals());
		}
		if (clienteFilter.getIdEquals() != null) {
			typedQuery.setParameter(clienteFilter.ID_EQUALS, clienteFilter.getIdEquals());
		}
	}

	@Override
	protected String createSqlQuery(ClienteFilter clienteFilter) {

		StringBuilder sql = new StringBuilder(SQL);

		List<String> where = new ArrayList<String>();

		if (clienteFilter.getNomeLikeRight() != null) {
			where.add("UPPER(c.descricaoTipoCliente) LIKE :" + clienteFilter.NOME_LIKE_RIGHT);
		}

		if (clienteFilter.getNomeEquals() != null) {
			where.add("UPPER(c.descricaoTipoCliente) = :" + clienteFilter.NOME_EQUALS);
		}

		if (clienteFilter.getIdNotEquals() != null) {
			where.add("c.id <> :" + clienteFilter.ID_NOT_EQUALS);
		}

		if (clienteFilter.getIdEquals() != null) {
			where.add("c.id = :" + clienteFilter.ID_EQUALS);
		}

		if (!where.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(StringUtils.join(where, " AND "));
		}

		if (clienteFilter.isOrderByIdDesc()) {
			sql.append(" ORDER BY b.id DESC ");
		} else if (clienteFilter.isOrderByName()) {
			sql.append(" ORDER BY lower(c.descricaoTipoCliente) ");
		}

		return sql.toString();
	}
}

package br.com.experian.gerenciadorperfil.core.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.experian.gerenciadorperfil.core.entity.Usuario;
import br.com.experian.gerenciadorperfil.core.entity.filter.UsuarioFilter;

@Component
public class UsuarioDAOImpl extends AbstractDAO<Usuario, Long, UsuarioFilter> implements UsuarioDAO {

	private static final String SELECT = "SELECT u FROM Usuario u";

	public UsuarioDAOImpl() {
		super(Usuario.class, UsuarioFilter.class);
	}

	@Override
	protected String createSqlQuery(UsuarioFilter usuarioFilter) {

		StringBuilder sql = new StringBuilder(SELECT);

		List<String> wheres = new ArrayList<String>();

		if (StringUtils.isNotBlank(usuarioFilter.getCpfLikeBoth())) {
			wheres.add("u.cpf LIKE :" + UsuarioFilter.CPF_LIKE_BOTH);
		}

		if (StringUtils.isNotBlank(usuarioFilter.getCpfEquals())) {
			wheres.add("u.cpf = :" + UsuarioFilter.CPF_EQUALS);
		}

		if (!wheres.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(StringUtils.join(wheres, " AND "));
		}
		
		sql.append(" ORDER BY u.id DESC ");

		return sql.toString();
	}

	@Override
	protected void applyFilter(Query query, UsuarioFilter usuarioFilter) {

		super.applyFilter(query, usuarioFilter);

		if (StringUtils.isNotBlank(usuarioFilter.getCpfLikeBoth())) {
			query.setParameter(UsuarioFilter.CPF_LIKE_BOTH, "%" + usuarioFilter.getCpfLikeBoth() + "%");
		}

		if (StringUtils.isNotBlank(usuarioFilter.getCpfEquals())) {
			query.setParameter(UsuarioFilter.CPF_EQUALS, usuarioFilter.getCpfEquals());
		}
	}
}

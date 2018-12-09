package br.com.experian.gerenciadorperfil.core.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import br.com.experian.gerenciadorperfil.core.entity.CampanhaGratuidade;
import br.com.experian.gerenciadorperfil.core.entity.filter.CampanhaGratuidadeFilter;
import br.com.experian.gerenciadorperfil.core.util.DateCompare;

@Component
public class CampanhaGratuidadeDAOImpl extends AbstractDAO<CampanhaGratuidade, Long, CampanhaGratuidadeFilter> implements CampanhaGratuidadeDAO {

	private static final String SQL = "SELECT c FROM CampanhaGratuidade c ";

	public CampanhaGratuidadeDAOImpl() {
		super(CampanhaGratuidade.class, CampanhaGratuidadeFilter.class);
	}

	@Override
	protected void applyFilter(Query typedQuery, CampanhaGratuidadeFilter campanhaGratuidadeFilter) {

		super.applyFilter(typedQuery, campanhaGratuidadeFilter);

		if (campanhaGratuidadeFilter.getIdProdutoEquals() != null) {
			typedQuery.setParameter(CampanhaGratuidadeFilter.ID_PRODUTO_EQUALS, campanhaGratuidadeFilter.getIdProdutoEquals());
		}

		if (StringUtils.isNotBlank(campanhaGratuidadeFilter.getContemCNPJ())) {
			typedQuery.setParameter(CampanhaGratuidadeFilter.CONTEM_CNPJ, campanhaGratuidadeFilter.getContemCNPJ());
		}

		if (campanhaGratuidadeFilter.getDataBetween() != null) {
			typedQuery.setParameter(CampanhaGratuidadeFilter.DATA_BETWEEN, new java.sql.Date(campanhaGratuidadeFilter.getDataBetween().getTime()));
		}

		if (campanhaGratuidadeFilter.getTipo() != null) {
			typedQuery.setParameter(CampanhaGratuidadeFilter.TIPO, campanhaGratuidadeFilter.getTipo());
		}

		if (campanhaGratuidadeFilter.getNaoContemCNPJ() != null) {
			typedQuery.setParameter(CampanhaGratuidadeFilter.NAO_CONTEM_CNPJ, campanhaGratuidadeFilter.getNaoContemCNPJ());
		}

		if (campanhaGratuidadeFilter.getGreatherEqualsThanDataInicio() != null) {
			typedQuery.setParameter(CampanhaGratuidadeFilter.GREATHER_EQUALS_THAN_DATA_INICIO, campanhaGratuidadeFilter.getGreatherEqualsThanDataInicio());
		}

		if (campanhaGratuidadeFilter.getLowerEqualsThanDataFim() != null) {
			typedQuery.setParameter(CampanhaGratuidadeFilter.LOWER_EQUALS_THAN_DATA_FIM, campanhaGratuidadeFilter.getLowerEqualsThanDataFim());
		}

		if (campanhaGratuidadeFilter.getIdNotEquals() != null) {
			typedQuery.setParameter(CampanhaGratuidadeFilter.ID_NOT_EQUALS, campanhaGratuidadeFilter.getIdNotEquals());
		}

		if (!campanhaGratuidadeFilter.getContainsFeaturesId().isEmpty()) {
			typedQuery.setParameter(CampanhaGratuidadeFilter.CONTAINS_FEATURE_ID, campanhaGratuidadeFilter.getContainsFeaturesId());
		}
		
		if (campanhaGratuidadeFilter.getNaoVencida()) {
			typedQuery.setParameter(CampanhaGratuidadeFilter.TODAY, DateCompare.getToday());
		}

		if (campanhaGratuidadeFilter.getVigente()) {
			typedQuery.setParameter(CampanhaGratuidadeFilter.TODAY, DateCompare.getToday());
		}
	}

	@Override
	protected String createSqlQuery(CampanhaGratuidadeFilter campanhaGratuidadeFilter) {

		StringBuilder sql = new StringBuilder(SQL);

		if (StringUtils.isNotBlank(campanhaGratuidadeFilter.getContemCNPJ())) {
			sql.append(" JOIN c.documentos AS d ");
		}

		if (!campanhaGratuidadeFilter.getContainsFeaturesId().isEmpty()) {
			sql.append(" JOIN c.features AS f ");
		}

		List<String> where = new ArrayList<String>();

		if (campanhaGratuidadeFilter.getIdProdutoEquals() != null) {
			where.add("c.produto.id = :" + CampanhaGratuidadeFilter.ID_PRODUTO_EQUALS);
		}

		if (campanhaGratuidadeFilter.getNaoCancelada()) {
			where.add("c.status != 7");
		}

		if(campanhaGratuidadeFilter.isNaoContemCaronaFeatureVinculada()) {
			where.add("NOT EXISTS (SELECT cd FROM CaronaFeature cd WHERE cd.campanhaGratuidade.id = c.id)");
		}
		
		if (StringUtils.isNotBlank(campanhaGratuidadeFilter.getContemCNPJ())) {
			where.add("d.cnpj = :" + CampanhaGratuidadeFilter.CONTEM_CNPJ);
		}

		if (campanhaGratuidadeFilter.getDataBetween() != null) {
			where.add(" :"+CampanhaGratuidadeFilter.DATA_BETWEEN + " between c.dataInicioGratuidade and coalesce(c.dataFimPosGratuidade,c.dataFimGratuidade) ");
		}

		if (campanhaGratuidadeFilter.getTipo() != null) {
			where.add("c.tipo = :" + CampanhaGratuidadeFilter.TIPO);
		}

		if (campanhaGratuidadeFilter.getGreatherEqualsThanDataInicio() != null) {
			where.add(":"+CampanhaGratuidadeFilter.GREATHER_EQUALS_THAN_DATA_INICIO + " >= c.dataInicioGratuidade");
		}

		if (campanhaGratuidadeFilter.getLowerEqualsThanDataFim() != null) {
			where.add(":"+CampanhaGratuidadeFilter.LOWER_EQUALS_THAN_DATA_FIM + " <= coalesce(c.dataFimPosGratuidade,c.dataFimGratuidade)");
		}

		if (campanhaGratuidadeFilter.getNaoVencida()) {
			where.add(":"+CampanhaGratuidadeFilter.TODAY + " <= coalesce(c.dataFimPosGratuidade,c.dataFimGratuidade)");
		}

		if (campanhaGratuidadeFilter.getVigente()) {
			where.add(":"+CampanhaGratuidadeFilter.TODAY + " between c.dataInicioGratuidade and c.dataFimGratuidade");
		}

		if (campanhaGratuidadeFilter.getIdNotEquals() != null) {
			where.add("c.id <> :" + CampanhaGratuidadeFilter.ID_NOT_EQUALS);
		}

		if (!campanhaGratuidadeFilter.getContainsFeaturesId().isEmpty()) {
			where.add("f.id IN (:" + CampanhaGratuidadeFilter.CONTAINS_FEATURE_ID + ")");
		}

		if (campanhaGratuidadeFilter.getNaoContemCNPJ() != null) {

			StringBuilder sqlSub = new StringBuilder("c.id not in ( select c1.id from CampanhaGratuidade c1  JOIN c1.documentos AS d1 ");
			List<String> whereSub = new ArrayList<String>();

			if (campanhaGratuidadeFilter.getNaoContemCNPJ() != null) {
				whereSub.add("d1.cnpj = :" + CampanhaGratuidadeFilter.NAO_CONTEM_CNPJ);
			}

			if (campanhaGratuidadeFilter.getIdProdutoEquals() != null) {
				whereSub.add("c1.produto.id = :" + CampanhaGratuidadeFilter.ID_PRODUTO_EQUALS);
			}

			if (campanhaGratuidadeFilter.getNaoCancelada()) {
				whereSub.add("c1.status != 7");
			}

			if (campanhaGratuidadeFilter.getDataBetween() != null) {
				whereSub.add(" :"+CampanhaGratuidadeFilter.DATA_BETWEEN + " between c1.dataInicioGratuidade and coalesce(c1.dataFimPosGratuidade,c1.dataFimGratuidade) ");
			}

			if (!whereSub.isEmpty()) {
				sqlSub.append(" WHERE ");
				sqlSub.append(StringUtils.join(whereSub, " AND "));
			}

			sqlSub.append(")");
			where.add(sqlSub.toString());

		}

		if (!where.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(StringUtils.join(where, " AND "));
		}

		sql.append(" ORDER BY c.id DESC");

		return sql.toString();
	}

}

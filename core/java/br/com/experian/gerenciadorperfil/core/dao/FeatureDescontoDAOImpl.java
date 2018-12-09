package br.com.experian.gerenciadorperfil.core.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import br.com.experian.gerenciadorperfil.core.entity.Feature;
import br.com.experian.gerenciadorperfil.core.entity.FeatureDesconto;
import br.com.experian.gerenciadorperfil.core.entity.filter.FeatureDescontoFilter;
import br.com.experian.gerenciadorperfil.core.entity.filter.FeatureFilter;

@Component
public class FeatureDescontoDAOImpl extends AbstractDAO<FeatureDesconto, Integer, FeatureDescontoFilter> implements FeatureDescontoDAO {

	private static final String SELECT = "SELECT f from FeatureDesconto f";
	
	public FeatureDescontoDAOImpl() {
		super(FeatureDesconto.class, FeatureDescontoFilter.class);
	}
	
	public void salvar(FeatureDesconto featureDescMF){
		
		FeatureDesconto featureDescBD = obterPorTransacaoMaisFeature(featureDescMF.getTransacao(), featureDescMF.getFeature().getId());
		
		if(featureDescBD == null){
			super.adicionar(featureDescMF);
			return;
		}
		
		if(!featureDescMF.getTransacao().equals(featureDescBD.getTransacao())){
			featureDescBD.setTransacao(featureDescMF.getTransacao());
			super.atualizar(featureDescBD);
		}
	}

	public FeatureDesconto obterPorTransacaoMaisFeature(String transacao, Integer id) {

		FeatureDescontoFilter filter = new FeatureDescontoFilter();
		filter.setTransacaoEquals(transacao);
		filter.setIdFeatureEquals(id);

		List<FeatureDesconto> features = listar(filter);

		if (CollectionUtils.isEmpty(features)) {
			return null;
		}

		return features.get(0);
	}

	public FeatureDesconto obterPorFeature(Feature feature) {
		
		FeatureDescontoFilter filter = new FeatureDescontoFilter();
		filter.setIdFeatureEquals(feature.getId());

		List<FeatureDesconto> features = listar(filter);

		if (CollectionUtils.isEmpty(features)) {
			return null;
		}

		return features.get(0);
	}

	@Override
	protected void applyFilter(Query query, FeatureDescontoFilter filter) {
		
		super.applyFilter(query, filter);

		if (filter.getIdFeatureEquals() != null) {
			query.setParameter(FeatureDescontoFilter.ID_FEATURE_EQUALS, filter.getIdFeatureEquals());
		}

		if (StringUtils.isNotBlank(filter.getTransacaoLikeRight())) {
			query.setParameter(FeatureFilter.TRANSACAO_LIKE_RIGHT, filter.getTransacaoLikeRight().toUpperCase() + "%");
		}

		if (StringUtils.isNotBlank(filter.getTransacaoEquals())) {
			query.setParameter(FeatureFilter.TRANSACAO_EQUALS, filter.getTransacaoEquals().toUpperCase());
		}
	}
	
	@Override
	protected String createSqlQuery(FeatureDescontoFilter filter) {

		StringBuilder sql = new StringBuilder(SELECT);

		List<String> wheres = new ArrayList<String>();

		if (filter.getIdFeatureEquals() != null) {
			wheres.add("f.feature.id = :" + FeatureDescontoFilter.ID_FEATURE_EQUALS);
		}

		if (StringUtils.isNotBlank(filter.getTransacaoLikeRight())) {
			wheres.add("UPPER(f.transacao) LIKE :" + FeatureDescontoFilter.TRANSACAO_LIKE_RIGHT);
		}

		if (StringUtils.isNotBlank(filter.getTransacaoEquals())) {
			wheres.add("UPPER(f.transacao) = :" + FeatureDescontoFilter.TRANSACAO_EQUALS);
		}

		if (!wheres.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(StringUtils.join(wheres, " AND "));
		}

		return sql.toString();
	}

}

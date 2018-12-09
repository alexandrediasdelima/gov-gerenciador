package br.com.experian.gerenciadorperfil.core.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import br.com.experian.commons.strings.gm53.bean.ProtocoloGM53;
import br.com.experian.commons.strings.gm53.bean.RetornoGM53;
import br.com.experian.commons.strings.gm53.exception.GM53Exception;
import br.com.experian.commons.strings.gm53.repository.GM53RepositoryImpl;
import br.com.experian.gerenciadorperfil.core.entity.Feature;
import br.com.experian.gerenciadorperfil.core.entity.Produto;
import br.com.experian.gerenciadorperfil.core.entity.filter.FeatureFilter;
import br.com.experian.gerenciadorperfil.core.util.CoreUtils;
import br.com.experian.gerenciadorperfil.core.util.EntityUtils;

@Component
public class FeatureDAOImpl extends AbstractDAO<Feature, Integer, FeatureFilter> implements FeatureDAO {

	private static final String SELECT = "SELECT f from Feature f";
	
	public FeatureDAOImpl() {
		super(Feature.class, FeatureFilter.class);
	}

	@Override
	protected void applyFilter(Query query, FeatureFilter featureFilter) {

		super.applyFilter(query, featureFilter);

		if (featureFilter.getIdProdutoEquals() != null) {
			query.setParameter(FeatureFilter.ID_PRODUTO_EQUALS, featureFilter.getIdProdutoEquals());
		}

		if (StringUtils.isNotBlank(featureFilter.getNomeLikeRight())) {
			query.setParameter(FeatureFilter.NOME_LIKE_RIGHT, EntityUtils.replaceAllSpecialCharacters(featureFilter.getNomeLikeRight().toUpperCase()) + "%");
		}

		if (StringUtils.isNotBlank(featureFilter.getNomeEquals())) {
			query.setParameter(FeatureFilter.NOME_EQUALS, EntityUtils.replaceAllSpecialCharacters(featureFilter.getNomeEquals().toUpperCase()));
		}

		if (StringUtils.isNotBlank(featureFilter.getTransacaoLikeRight())) {
			query.setParameter(FeatureFilter.TRANSACAO_LIKE_RIGHT, featureFilter.getTransacaoLikeRight().toUpperCase() + "%");
		}

		if (StringUtils.isNotBlank(featureFilter.getTransacaoEquals())) {
			query.setParameter(FeatureFilter.TRANSACAO_EQUALS, featureFilter.getTransacaoEquals().toUpperCase());
		}
	}

	@Override
	protected String createSqlQuery(FeatureFilter featureFilter) {

		StringBuilder sql = new StringBuilder(SELECT);

		List<String> wheres = new ArrayList<String>();

		if (featureFilter.getIdProdutoEquals() != null) {
			wheres.add("f.produto.id = :" + FeatureFilter.ID_PRODUTO_EQUALS);
		}

		if (StringUtils.isNotBlank(featureFilter.getNomeLikeRight())) {
			wheres.add("UPPER(f.nome) LIKE :" + FeatureFilter.NOME_LIKE_RIGHT);
		}

		if (StringUtils.isNotBlank(featureFilter.getNomeEquals())) {
			wheres.add("UPPER(f.nome) = :" + FeatureFilter.NOME_EQUALS);
		}

		if (StringUtils.isNotBlank(featureFilter.getTransacaoLikeRight())) {
			wheres.add("UPPER(f.transacao) LIKE :" + FeatureFilter.TRANSACAO_LIKE_RIGHT);
		}

		if (StringUtils.isNotBlank(featureFilter.getTransacaoEquals())) {
			wheres.add("UPPER(f.transacao) = :" + FeatureFilter.TRANSACAO_EQUALS);
		}

		if(featureFilter.isTransacaoAssociadaIsNull()){
			wheres.add("f.feature = null");
		}

		if (!wheres.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(StringUtils.join(wheres, " AND "));
		}
		
		sql.append(" ORDER BY lower(f.nome) ");

		return sql.toString();
	}

	public Feature obterPorTransacaoEmProduto(String transacao, Produto produto) {

		FeatureFilter featureFilter = new FeatureFilter()
			.setTransacaoEquals(transacao)
			.setIdProdutoEquals(produto.getId());

		List<Feature> features = listar(featureFilter);

		if (features.isEmpty()) {
			return null;
		}

		return features.get(0);
	}

	public Feature obterPorNomeEmProduto(String nome, Produto produto) {

		FeatureFilter featureFilter = new FeatureFilter()
			.setNomeEquals(nome)
			.setIdProdutoEquals(produto.getId());

		List<Feature> features = listar(featureFilter);

		if (features.isEmpty()) {
			return null;
		}

		return features.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<Feature> obterFeatureEspelho(Integer pkPrincipal){
		StringBuilder sql = new StringBuilder(SELECT);
		sql.append(" WHERE f.feature.id = ").append(pkPrincipal);
		return getEntityManager().createQuery(sql.toString()).getResultList();
	}

	public RetornoGM53 obterFeatureDesconto(ProtocoloGM53 protEnvio) throws GM53Exception {
		
		try {
			
			ProtocoloGM53 protRet = new GM53RepositoryImpl(CoreUtils.safeGetApplicationUser()).consultar(protEnvio);
			if(protRet != null && !CollectionUtils.isEmpty(protRet.getRetorno())) {
				return protRet.getRetorno().get(0);
			}
		} catch (Exception e) {
			throw new GM53Exception(e);
		}
		
		return null;
	}
	
}

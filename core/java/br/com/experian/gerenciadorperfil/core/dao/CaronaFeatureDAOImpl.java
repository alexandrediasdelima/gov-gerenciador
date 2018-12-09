package br.com.experian.gerenciadorperfil.core.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.experian.gerenciadorperfil.core.entity.CaronaFeature;
import br.com.experian.gerenciadorperfil.core.entity.HistoricoCaronaFeature;
import br.com.experian.gerenciadorperfil.core.entity.filter.CaronaFeatureFilter;
import br.com.experian.gerenciadorperfil.core.util.DateCompare;

@Component
public class CaronaFeatureDAOImpl extends AbstractDAO<CaronaFeature, Long, CaronaFeatureFilter> implements CaronaFeatureDAO {

	private static final String SQL = "SELECT c FROM CaronaFeature c ";
	private transient final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private HistoricoCaronaFeatureDAO historicoCaronaFeatureDAO;
	
	@Autowired
	private FeatureDAO featureDAO;
	
	public CaronaFeatureDAOImpl() {
		super(CaronaFeature.class, CaronaFeatureFilter.class);
	}
	
	@Override
	public List<CaronaFeature> listar(CaronaFeatureFilter caronaFeatureFilter) {
		
		List<CaronaFeature> listaCaronaFeature = super.listar(caronaFeatureFilter);
		carregarDatasCampanhasCanceladas(listaCaronaFeature);
		
		return listaCaronaFeature;
	}
	
	@Override
	public CaronaFeature adicionar(CaronaFeature entity) {

		logger.info("Adicionando uma Carona de Features... -- ID: [{}]", entity==null?"null":entity.getId());
		
		if(entity != null) {
		
			featureDAO.atualizar(entity.getFeature());
			super.adicionar(entity);

			HistoricoCaronaFeature historicoCaronaFeature = new HistoricoCaronaFeature(entity, entity.getLogonOperacao(), HistoricoCaronaFeature.INSERT);
			historicoCaronaFeatureDAO.adicionar(historicoCaronaFeature);

			logger.info("Histórico da Carona de Features Gravada! -- ID: [{}]", historicoCaronaFeature.getId());
			
		}

		return entity;
	}
	
	@Override
	public CaronaFeature atualizar(CaronaFeature entity) {
		
		logger.info("Atualizando a Carona de Features... -- ID: [{}]", entity==null?"null":entity.getId());
		
		CaronaFeature caronaFeatureAtualizada = null;
		
		if(entity != null) {
		
			featureDAO.atualizar(entity.getFeature());
			caronaFeatureAtualizada = super.atualizar(entity);
			
			HistoricoCaronaFeature historicoCaronaFeature = new HistoricoCaronaFeature(caronaFeatureAtualizada, caronaFeatureAtualizada.getLogonOperacao(), HistoricoCaronaFeature.UPDATE);
			historicoCaronaFeatureDAO.adicionar(historicoCaronaFeature);

			logger.info("Histórico da Carona de Features Gravada! -- ID: [{}]", historicoCaronaFeature.getId());
			
		}
		
		return caronaFeatureAtualizada;
	}
	
	@Override
	public void remover(CaronaFeature entity) {
		
		logger.info("Cancelando a Carona de Features... -- Id: [{}]", entity==null?"null":entity.getId());
		
		CaronaFeature caronaFeatureCancelada = super.atualizar(entity);
		
		HistoricoCaronaFeature historicoCaronaFeature = new HistoricoCaronaFeature(caronaFeatureCancelada, caronaFeatureCancelada.getLogonOperacao(), HistoricoCaronaFeature.DELETE);
		historicoCaronaFeatureDAO.adicionar(historicoCaronaFeature);
		
		logger.info("Histórico da Carona de Features gravada! -- Id: [{}]", historicoCaronaFeature.getId());
	}
	
	private void carregarDatasCampanhasCanceladas(List<CaronaFeature> listaCaronaFeature) {
		
		for(CaronaFeature cd : listaCaronaFeature) {
			
			if(cd.getStatus() == CaronaFeature.STATUS_CANCELADA_COM_SUCESSO) {
				
				for(HistoricoCaronaFeature hcd : historicoCaronaFeatureDAO.carregarHistoricoCaronaFeatureStatus(cd.getId(), cd.getStatus())) {
					cd.setDataCancelamento(hcd.getDataOperacao());
				}
			}
		}
	}

	@Override
	protected void applyFilter(Query typedQuery, CaronaFeatureFilter filter) {

		super.applyFilter(typedQuery, filter);

		if (filter.getIdProdutoEquals() != null) {
			typedQuery.setParameter(CaronaFeatureFilter.ID_PRODUTO_EQUALS, filter.getIdProdutoEquals());
		}

		if (filter.getIdFeatureEquals() != null) {
			typedQuery.setParameter(CaronaFeatureFilter.ID_FEATURE_EQUALS, filter.getIdFeatureEquals());
		}

		if (StringUtils.isNotBlank(filter.getContemCNPJ())) {
			typedQuery.setParameter(CaronaFeatureFilter.CONTEM_CNPJ, filter.getContemCNPJ());
		}

		if (filter.getDataBetween() != null) {
			typedQuery.setParameter(CaronaFeatureFilter.DATA_BETWEEN, new java.sql.Date(filter.getDataBetween().getTime()));
		}

		if (filter.getTipoOferta() != null) {
			typedQuery.setParameter(CaronaFeatureFilter.TIPO_OFERTA, filter.getTipoOferta());
		}

		if (filter.getNaoContemCNPJ() != null) {
			typedQuery.setParameter(CaronaFeatureFilter.NAO_CONTEM_CNPJ, filter.getNaoContemCNPJ());
		}

		if (filter.getGreatherEqualsThanDataInicio() != null) {
			typedQuery.setParameter(CaronaFeatureFilter.GREATHER_EQUALS_THAN_DATA_INICIO, filter.getGreatherEqualsThanDataInicio());
		}

		if (filter.getLowerEqualsThanDataFim() != null) {
			typedQuery.setParameter(CaronaFeatureFilter.LOWER_EQUALS_THAN_DATA_FIM, filter.getLowerEqualsThanDataFim());
		}

		if (filter.getIdNotEquals() != null) {
			typedQuery.setParameter(CaronaFeatureFilter.ID_NOT_EQUALS, filter.getIdNotEquals());
		}

		if (filter.getNaoVencida()) {
			typedQuery.setParameter(CaronaFeatureFilter.TODAY, DateCompare.getToday());
		}

		if (filter.getVigente()) {
			typedQuery.setParameter(CaronaFeatureFilter.TODAY, DateCompare.getToday());
		}
	}

	@Override
	protected String createSqlQuery(CaronaFeatureFilter filter) {

		StringBuilder sql = new StringBuilder(SQL);

		if (StringUtils.isNotBlank(filter.getContemCNPJ())) {
			sql.append(" JOIN c.documentos AS d ");
		}

		List<String> where = new ArrayList<String>();

		if (filter.getIdProdutoEquals() != null) {
			where.add("c.feature.produto.id = :" + CaronaFeatureFilter.ID_PRODUTO_EQUALS);
		}

		if (filter.getIdFeatureEquals() != null) {
			where.add("c.feature.id = :" + CaronaFeatureFilter.ID_FEATURE_EQUALS);
		}

		if (filter.getNaoCancelada()) {
			where.add("c.status != 5");
		}

		if (StringUtils.isNotBlank(filter.getContemCNPJ())) {
			where.add("d.cnpj = :" + CaronaFeatureFilter.CONTEM_CNPJ);
		}

		if (filter.getDataBetween() != null) {
			where.add(" :"+CaronaFeatureFilter.DATA_BETWEEN + " between c.dataInicio and c.dataFim");
		}

		if (filter.getTipoOferta() != null) {
			where.add("c.tipoOferta = :" + CaronaFeatureFilter.TIPO_OFERTA);
		}

		if (filter.getGreatherEqualsThanDataInicio() != null) {
			where.add(":"+CaronaFeatureFilter.GREATHER_EQUALS_THAN_DATA_INICIO + " >= c.dataInicio");
		}

		if (filter.getLowerEqualsThanDataFim() != null) {
			where.add(":"+CaronaFeatureFilter.LOWER_EQUALS_THAN_DATA_FIM + " <= c.dataFim");
		}

		if (filter.getNaoVencida()) {
			where.add(":"+CaronaFeatureFilter.TODAY + " <= c.dataFim");
		}

		if (filter.getVigente()) {
			where.add(":"+CaronaFeatureFilter.TODAY + " between c.dataInicio and c.dataFim");
		}

		if (filter.getIdNotEquals() != null) {
			where.add("c.id <> :" + CaronaFeatureFilter.ID_NOT_EQUALS);
		}

		if (filter.getNaoContemCNPJ() != null) {

			StringBuilder sqlSub = new StringBuilder("c.id not in ( select c1.id from CaronaFeature c1 JOIN c1.documentos AS d1 ");
			List<String> whereSub = new ArrayList<String>();

			if (filter.getNaoContemCNPJ() != null) {
				whereSub.add("d1.cnpj = :" + CaronaFeatureFilter.NAO_CONTEM_CNPJ);
			}

			if (filter.getIdProdutoEquals() != null) {
				whereSub.add("c1.feature.produto.id = :" + CaronaFeatureFilter.ID_PRODUTO_EQUALS);
			}

			if (filter.getNaoCancelada()) {
				whereSub.add("c1.status != 5");
			}

			if (filter.getDataBetween() != null) {
				whereSub.add(" :"+CaronaFeatureFilter.DATA_BETWEEN + " between c1.dataInicio and c1.dataFim");
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

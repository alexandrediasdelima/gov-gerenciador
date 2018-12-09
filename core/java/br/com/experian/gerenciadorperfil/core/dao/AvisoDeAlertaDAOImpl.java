package br.com.experian.gerenciadorperfil.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Component;

import br.com.experian.gerenciadorperfil.core.entity.AvisoDeAlerta;
import br.com.experian.gerenciadorperfil.core.entity.HistoricoAceite;
import br.com.experian.gerenciadorperfil.core.entity.HistoricoAlteracaoAlerta;
import br.com.experian.gerenciadorperfil.core.entity.Produto;
import br.com.experian.gerenciadorperfil.core.entity.filter.AvisoDeAlertaFilter;

@Component
public class AvisoDeAlertaDAOImpl extends AbstractDAO<AvisoDeAlerta, Integer, AvisoDeAlertaFilter> implements AvisoDeAlertaDAO {

	private static final String SELECT = "SELECT a FROM AvisoDeAlerta a";
	private static final String FILTER_PRODUTO = " AND P.PK_PC_GEP_PRODUTO = ? ";

	public AvisoDeAlertaDAOImpl() {
		super(AvisoDeAlerta.class, AvisoDeAlertaFilter.class);
	}

	@Override
	protected String createSqlQuery(AvisoDeAlertaFilter avisoDeAlertaFilter) {

		StringBuilder sql = new StringBuilder(SELECT);

		List<String> wheres = new ArrayList<String>();

		if (avisoDeAlertaFilter.getIdProdutoEquals() != null) {
			wheres.add("a.produto.id = :" + AvisoDeAlertaFilter.ID_PRODUTO_EQUALS);
		}

		if (!wheres.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(StringUtils.join(wheres, " AND "));
		}

		return sql.toString();
	}

	@Override
	protected void applyFilter(Query query, AvisoDeAlertaFilter avisoDeAlertaFilter) {

		super.applyFilter(query, avisoDeAlertaFilter);

		if (avisoDeAlertaFilter.getIdProdutoEquals() != null) {
			query.setParameter(AvisoDeAlertaFilter.ID_PRODUTO_EQUALS, avisoDeAlertaFilter.getIdProdutoEquals());
		}
	}

	public List<HistoricoAceite> gerarExcelHistoricoDeAceite(final Produto produto, final Date dataInicio) {
		Session session = (Session) getEntityManager().getDelegate();
		final List<HistoricoAceite> aceites = new ArrayList<HistoricoAceite>();
		final String SQL = "SELECT H.DS_LOGIN LOGIN,H.DS_CNPJ CNPJ, H.DS_PRODUTO PRODUTO, H.DT_CONSULTA DATA, H.DS_IP IP, AV.DS_TEXTO TEXTO"+
					 " FROM PC_GEP_CONSULTA_ALERTA_HIST H, PC_GEP_PRODUTO P, PC_GEP_HIST_AVISO_ALE AV "+
					" WHERE P.PK_PC_GEP_PRODUTO = AV.FK_PC_GEP_PRODUTO "+
					  " AND H.DS_PRODUTO = P.NO_NOME "+
					  " AND AV.DT_CRIACAO = (SELECT MAX(AV2.DT_CRIACAO) FROM PC_GEP_HIST_AVISO_ALE AV2 "+
											" WHERE AV2.FK_PC_GEP_PRODUTO = AV.FK_PC_GEP_PRODUTO "+
                           					  " AND AV2.DT_CRIACAO < H.DT_CONSULTA)";

		final String FILTER_DATA_ACEITE = " AND H.DT_CONSULTA > ? ";
		final String ORDER_BY_ACEITE = " ORDER BY H.DS_PRODUTO, H.DS_LOGIN, H.DT_CONSULTA";

		session.doWork(new Work() {
			public void execute(Connection connection) throws SQLException {

				String sql = SQL + (produto!=null? FILTER_PRODUTO : "") + (dataInicio != null? FILTER_DATA_ACEITE : "") + ORDER_BY_ACEITE;
				int i = 0;
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				if (produto!=null){
					preparedStatement.setLong(++i, produto.getId());
				}
				if (dataInicio!=null){
					preparedStatement.setTimestamp(++i, new Timestamp(dataInicio.getTime()));
				}

				ResultSet rs = preparedStatement.executeQuery();

				while(rs.next()){
					HistoricoAceite ha = new HistoricoAceite();
					ha.setCnpj(rs.getString("CNPJ"));
					ha.setLogin(rs.getString("LOGIN"));
					ha.setData(new Date(rs.getTimestamp("DATA").getTime()));
					ha.setIp(rs.getString("IP"));
					ha.setProduto(rs.getString("PRODUTO"));
					ha.setTexto(rs.getString("TEXTO"));

					aceites.add(ha);
				}


			}
		});

		return aceites;
	}

	public List<HistoricoAlteracaoAlerta> gerarExcelHistoricoDeAlteracaoAlerta(final Produto produto, final Date dataInicio) {
		Session session = (Session) getEntityManager().getDelegate();
		final List<HistoricoAlteracaoAlerta> alteracoes = new ArrayList<HistoricoAlteracaoAlerta>();
		final String SQL = "SELECT P.NO_NOME PRODUTO, H.DS_LOGIN_CRIACAO LOGON, H.DT_CRIACAO DATA, " +
								 " DECODE(H.DS_ACAO, 'I','INCLUSÃO','D','EXCLUSÃO','U','ATUALIZAÇÃO') ACAO,H.DS_TEXTO TEXTO "+
							" FROM PC_GEP_PRODUTO P, PC_GEP_HIST_AVISO_ALE H "+
						   " WHERE P.PK_PC_GEP_PRODUTO = H.FK_PC_GEP_PRODUTO ";
		final String FILTER_DATA = " AND H.DT_CRIACAO > ? ";
		final String ORDER_BY = " ORDER BY P.NO_NOME, H.DT_CRIACAO";
		session.doWork(new Work() {
			public void execute(Connection connection) throws SQLException {

				String sql = SQL + (produto!=null? FILTER_PRODUTO : "") + (dataInicio != null? FILTER_DATA : "") + ORDER_BY;
				int i = 0;
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				if (produto!=null){
					preparedStatement.setLong(++i, produto.getId());
				}
				if (dataInicio!=null){
					preparedStatement.setTimestamp(++i, new Timestamp(dataInicio.getTime()));
				}

				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()){
					HistoricoAlteracaoAlerta ha = new HistoricoAlteracaoAlerta();
					ha.setAcao(rs.getString("ACAO"));
					ha.setLogin(rs.getString("LOGON"));
					ha.setData(new Date(rs.getTimestamp("DATA").getTime()));
					ha.setProduto(rs.getString("PRODUTO"));
					ha.setTexto(rs.getString("TEXTO"));

					alteracoes.add(ha);
				}


			}
		});
		return alteracoes;
	}
}

package br.com.experian.gerenciadorperfil.core.dao;

import java.util.Date;
import java.util.List;

import br.com.experian.gerenciadorperfil.core.entity.AvisoDeAlerta;
import br.com.experian.gerenciadorperfil.core.entity.HistoricoAceite;
import br.com.experian.gerenciadorperfil.core.entity.HistoricoAlteracaoAlerta;
import br.com.experian.gerenciadorperfil.core.entity.Produto;
import br.com.experian.gerenciadorperfil.core.entity.filter.AvisoDeAlertaFilter;

public interface AvisoDeAlertaDAO extends DAO<AvisoDeAlerta, Integer, AvisoDeAlertaFilter> {

	List<HistoricoAceite> gerarExcelHistoricoDeAceite(Produto produto, Date dataInicio);

	List<HistoricoAlteracaoAlerta> gerarExcelHistoricoDeAlteracaoAlerta(Produto produto, Date dataInicio);
}

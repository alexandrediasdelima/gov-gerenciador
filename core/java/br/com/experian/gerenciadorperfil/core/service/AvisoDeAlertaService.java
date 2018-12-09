package br.com.experian.gerenciadorperfil.core.service;

import java.util.Date;
import java.util.List;

import br.com.experian.gerenciadorperfil.core.entity.AvisoDeAlerta;
import br.com.experian.gerenciadorperfil.core.entity.HistoricoAceite;
import br.com.experian.gerenciadorperfil.core.entity.HistoricoAlteracaoAlerta;
import br.com.experian.gerenciadorperfil.core.entity.Produto;
import br.com.experian.gerenciadorperfil.core.entity.filter.AvisoDeAlertaFilter;

public interface AvisoDeAlertaService extends Service<AvisoDeAlerta, Integer, AvisoDeAlertaFilter> {

	AvisoDeAlerta obterPorProduto(Produto produto);

	List<HistoricoAceite> obterHistoricoDeAceite(Produto produto, Date dataInicio);

	List<HistoricoAlteracaoAlerta> obterHistoricoDeAlteracaoAlerta(Produto produto, Date dataInicio);
}

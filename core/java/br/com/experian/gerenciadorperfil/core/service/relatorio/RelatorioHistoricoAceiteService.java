package br.com.experian.gerenciadorperfil.core.service.relatorio;

import java.util.Date;

import br.com.experian.gerenciadorperfil.core.entity.Produto;
import br.com.experian.gerenciadorperfil.core.service.common.ArquivoUploadDownload;

public interface RelatorioHistoricoAceiteService extends RelatorioService {

	ArquivoUploadDownload gerar(Produto produto, Date dataInicio) throws RelatorioServiceException;
}

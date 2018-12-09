package br.com.experian.gerenciadorperfil.core.dao;

import java.util.List;

import br.com.experian.gerenciadorperfil.core.entity.PerfilDocumento;
import br.com.experian.gerenciadorperfil.core.entity.filter.PerfilDocumentoFilter;

public interface PerfilDocumentoDAO extends DAO<PerfilDocumento, Long, PerfilDocumentoFilter>{

	void adicionar(List<PerfilDocumento> documentos);

}

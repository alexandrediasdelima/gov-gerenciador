package br.com.experian.gerenciadorperfil.core.dao;

import java.util.List;

import br.com.experian.gerenciadorperfil.core.entity.Documento;
import br.com.experian.gerenciadorperfil.core.entity.filter.DocumentoFilter;

public interface DocumentoDAO extends DAO<Documento, Long, DocumentoFilter> {

	void adicionar(List<Documento> documento);
}

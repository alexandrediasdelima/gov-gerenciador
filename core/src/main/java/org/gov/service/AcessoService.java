package org.gov.service;

import java.io.Serializable;
import java.util.List;

import org.gov.model.Livro;
import org.gov.model.Acesso;

public interface AcessoService extends Serializable {

	public boolean verificarAcesso(Acesso acesso);

}

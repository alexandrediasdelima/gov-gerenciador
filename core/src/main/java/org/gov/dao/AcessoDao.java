package org.gov.dao;

import java.io.Serializable;

import org.gov.model.Acesso;

public interface AcessoDao extends Serializable {

		public boolean verificarAcesso(Acesso acesso);

}

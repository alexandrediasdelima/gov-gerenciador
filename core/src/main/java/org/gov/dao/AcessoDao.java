package org.gov.dao;

import java.io.Serializable;
import java.util.List;

import org.gov.model.Acesso;
import org.gov.model.Apac;

public interface AcessoDao extends Serializable {

	public boolean acesso(Acesso acesso);

}

package org.gov.dao;

import java.io.Serializable;
import java.util.List;

import org.gov.model.ExportCnarh;

public interface Export_CnarhDao extends Serializable {

	public List<ExportCnarh> exportCnarhs();


}

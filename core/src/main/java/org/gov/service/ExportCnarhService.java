package org.gov.service;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import org.gov.model.ExportCnarh;

public interface ExportCnarhService extends Serializable {

	public File exportCnarhs() throws IOException;

}

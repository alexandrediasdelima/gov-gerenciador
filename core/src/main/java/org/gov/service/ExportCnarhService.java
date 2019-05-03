package org.gov.service;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public interface ExportCnarhService extends Serializable {

	public File exportCnarhs() throws IOException;

}

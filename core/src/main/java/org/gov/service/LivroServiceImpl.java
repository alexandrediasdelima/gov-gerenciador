package org.gov.service;

import org.gov.dao.LivroDao;
import org.gov.dao.LivroDaoImpl;
import org.gov.model.Livro;


public class LivroServiceImpl implements LivroService{

	/**
	 *
	 */
	private static final long serialVersionUID = -342339714679052686L;

	private LivroDao livroDao;

	public String gravar(Livro livro) {

		livroDao = new LivroDaoImpl();
		livroDao.gravar(livro);
		return null;
	}





}

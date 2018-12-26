package org.gov.service;

import java.util.List;

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
		return livroDao.gravar(livro);
	}

	public List<Livro> livros() {
		livroDao = new LivroDaoImpl();
		return livroDao.livros();
	}

	public String remover(int id) {
		livroDao = new LivroDaoImpl();
		return livroDao.remover(id);
	}

	public String editar(Livro livro) {

		livroDao = new LivroDaoImpl();
		return livroDao.editar(livro);
	}

}

package org.gov.dao;

import java.util.ArrayList;
import java.util.List;

import org.gov.model.Livro;

public class LivroDaoImpl implements LivroDao {

	/**
	 *
	 */
	private static final long serialVersionUID = -5779326521469749102L;

	public String gravar(Livro livro) {

		return null;
	}

	public List<Livro> livros() {


		Livro livro = new Livro();

		livro.setAutor("Alexandre");
		livro.setData("27/01/1991");
		livro.setPreco(100);
		livro.setTitulo("Aventura do Dom");


		Livro livroDois = new Livro();

		livroDois.setAutor("Teste");
		livroDois.setData("29/10/1991");
		livroDois.setPreco(50);
		livroDois.setTitulo("Mundial");

		List<Livro> livros = new ArrayList<Livro>();

		livros.add(livro);
		livros.add(livroDois);


		return livros;
	}

}

package org.gov.web.controller;

import java.io.Serializable;

public class LivroController implements Serializable {


	/**
	 *
	 */
	private static final long serialVersionUID = -8848447789491900839L;

	public String actionSalvarAdicionar() {

		System.out.println("passou");

		return"index.xhtml";
	}

}

package org.gov.web.controller;

import java.util.ArrayList;
import java.util.List;
import org.gov.model.Fornecedor;
import org.gov.model.Interferencia;
import org.gov.model.Usuario;
import org.gov.service.FornecedorService;
import org.gov.service.FornecedorServiceImpl;





public class FornecedorBean extends Controller  {


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	private Fornecedor fornecedor;
	private FornecedorService fornecedorService;
	private List<Fornecedor> fornecedores;
	private List<Integer> idsUsuarios;
	
	public FornecedorBean() {

		setFornecedor(new Fornecedor());
		fornecedorService = new FornecedorServiceImpl();
		setFornecedores(new ArrayList<Fornecedor>());
		fornecedores();
	}

	public String fornecedores() {
		setFornecedores(fornecedorService.fornecedores());
		setView(LIST);
		return eval(index());
	}
	
	public String adicionarNovo() {
		setView(ADD);
		limparForm();
		this.setIdsUsuarios(fornecedorService.ids());
		return eval(index());
	}
	
	public String telaEditar(Fornecedor fornecedor) {

		this.fornecedor = fornecedor;
		setView(EDIT);
		return eval(index());
	}

	public String gravar() {

		fornecedorService.gravar(fornecedor);
		fornecedores();

		return eval(index());
	}
	
	public String editar() {

		fornecedorService.editar(fornecedor);
		fornecedores();

		return eval(index());
	}
	
	public String deletar() {
		fornecedorService.remover(fornecedor.getForn_id());
		fornecedores();
		return eval(index());
	}
	
	public String index() {
		return "/fornecedor/index";
	}

	private void limparForm() {
//		this.fornecedor.setAreaTotalPropriedade(null);
//		this.fornecedor.setCepEmpreendimento(null);
//		this.fornecedor.setComplementoLogradouroEmpreendimento(null);
//		this.fornecedor.setEnderecoEmpreendimento(null);
//		this.fornecedor.setIbgeMunicipioLocalizadaInterferencia(null);
//		this.fornecedor.setId(null);
//		//this.fornecedor.setIdUsuario(null);
//		this.fornecedor.setLocalEmpreendimento(null);
//		this.fornecedor.setNomeAcessoPrincipalEmpreendimento(null);
//		this.fornecedor.setNomeEmpreendimento(null);
//		this.fornecedor.setNomeLogradouroEmpreendimento(null);
//		this.fornecedor.setNomeMunicipioEmpreendimento(null);
//		this.fornecedor.setNumeroCaixaPostalEmpreendimento(null);
//		this.fornecedor.setNumeroLogradouroEmpreendimento(null);
//		this.fornecedor.setNumeroOutorga(null);
//		this.fornecedor.setTipoLogradouroEmpreendimento(null);
//		this.fornecedor.setUnidadeAreaTotalPropriedade(null);


	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public List<Integer> getIdsUsuarios() {
		return idsUsuarios;
	}

	public void setIdsUsuarios(List<Integer> idsUsuarios) {
		this.idsUsuarios = idsUsuarios;
	}

	

}

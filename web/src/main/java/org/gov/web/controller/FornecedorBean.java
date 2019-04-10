package org.gov.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.gov.model.Fornecedor;
import org.gov.service.FornecedorService;
import org.gov.service.FornecedorServiceImpl;
import org.primefaces.context.RequestContext;





public class FornecedorBean extends Controller  {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Fornecedor fornecedor;
	private FornecedorService fornecedorService;
	private FacesContext facesContext;
	
	public FornecedorBean() {
		fornecedorService = new FornecedorServiceImpl();
	}

	public String redirecionarTelaCadastro(int id) {
		fornecedor = new Fornecedor();
		this.fornecedor.setUsuario_id(id);

		Fornecedor forn = fornecedorService.pesquisar(id);
		setView(ADD);

		if(forn != null) {
			this.fornecedor = forn;
			setView(EDIT);
		}

		return eval(index());
	}
	
	public String gravar() throws IOException {
		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(fornecedorService.gravar(fornecedor))){
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravado com sucesso", null));
			
			setView(EDIT);
			//facesContext.getExternalContext().redirect(facesContext.getExternalContext().getRequestContextPath() + "/usuario/index.xhtml");
		}
		return eval(index());
	}

	public String alterar() throws IOException {

		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(fornecedorService.editar(fornecedor))){
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alterado com sucesso", null));
			
			setView(EDIT);
			//facesContext.getExternalContext().redirect(facesContext.getExternalContext().getRequestContextPath() + "/usuario/index.xhtml");
		}
		return eval(index());
	}
	
	public String deletar() throws IOException {
		facesContext = FacesContext.getCurrentInstance();

		if("ok".equals(fornecedorService.remover(fornecedor.getForn_id()))){
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Deletado com sucesso", null));
			setView(ADD);
			
			//facesContext.getExternalContext().redirect(facesContext.getExternalContext().getRequestContextPath() + "/usuario/index.xhtml");
		} else {
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Dados não encontrado para excluir", null));
			setView(ADD);
		}

		limparForm();
		return eval(index());
	}

	public String voltar() {
		return eval("/usuario/index");
	}
	
	public String index() {
		return "/fornecedor/index";
	}	
	
	
//	private List<Fornecedor> fornecedores;
//	private List<Integer> idsUsuarios;
	
//	public FornecedorBean() {
//
//		setFornecedor(new Fornecedor());
//		fornecedorService = new FornecedorServiceImpl();
//		setFornecedores(new ArrayList<Fornecedor>());
//		fornecedores();
//	}

//	public String fornecedores() {
//		setFornecedores(fornecedorService.fornecedores());
//		setView(LIST);
//		return eval(index());
//	}
//	
//	public String adicionarNovo() {
//		setView(ADD);
//		limparForm();
//		this.setIdsUsuarios(fornecedorService.ids());
//		return eval(index());
//	}
//	
//	public String telaEditar(Fornecedor fornecedor) {
//
//		this.fornecedor = fornecedor;
//		setView(EDIT);
//		return eval(index());
//	}
//
//	public String gravar() {
//
//		fornecedorService.gravar(fornecedor);
//		fornecedores();
//
//		return eval(index());
//	}
//	
//	public String editar() {
//
//		fornecedorService.editar(fornecedor);
//		fornecedores();
//
//		return eval(index());
//	}
//	
//	public String deletar() {
//		fornecedorService.remover(fornecedor.getForn_id());
//		fornecedores();
//		return eval(index());
//	}
//	
//	public String index() {
//		return "/fornecedor/index";
//	}
//
//	public String voltar() {
//		return "/fornecedor/index";
//	}
//	

	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public FornecedorService getFornecedorService() {
		return fornecedorService;
	}

	public void setFornecedorService(FornecedorService fornecedorService) {
		this.fornecedorService = fornecedorService;
	}

	public FacesContext getFacesContext() {
		return facesContext;
	}

	public void setFacesContext(FacesContext facesContext) {
		this.facesContext = facesContext;
	}	

}

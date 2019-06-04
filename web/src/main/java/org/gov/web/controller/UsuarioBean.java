package org.gov.web.controller;

import java.util.ArrayList;
import java.util.List;
import org.gov.model.Regiao;
import org.gov.model.Usuario;
import org.gov.service.UsuarioService;
import org.gov.service.UsuarioServiceImpl;

public class UsuarioBean extends Controller  {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private UsuarioService usuarioService;
	private List<Usuario> usuarios;
	private List<Regiao> regioes;
	private String tipoDocumento = "cpf";
	private List<Usuario> filteredUsuarios;
	private Usuario objSelecionado;

	public UsuarioBean() {

		setUsuario(new Usuario());
		usuarioService = new UsuarioServiceImpl();
		usuarios = new ArrayList<Usuario>();
		usuarios();
		
	}

	public String usuarios() {
		
		usuarios = usuarioService.usuarios();
		setView(LIST);
		return eval(index());

	}	
	
	public String gravar() {
		setView(LIST);
		usuarioService.gravar(usuario);
		usuarios();
		
		return eval(index());
	}

	public void atualizarMunicipios() {
		setRegioes(usuarioService.buscarMunicipios(usuario.getEmp_ds_uf()));
	}

	public void atualizarIbge() {
		usuario.setEmp_cd_codigoibgecorrespondencia(usuarioService.buscarIbge(usuario.getApa_muni_correspondencia()));
	}

	public void atualizaTipoDocumento() {
		if("cnpj".equals(this.tipoDocumento)) {
			this.tipoDocumento = "cnpj";
		}else {
			this.tipoDocumento = "cpf";
		}
	}

	public String adicionarNovo() {
		setView(ADD);
		limparForm();
		this.setRegioes(usuarioService.buscarMunicipios(usuario.getEmp_ds_uf()));
		
		return eval(index());
	}

	public String telaEditar(Usuario usuario) {
		setView(EDIT);		
		this.usuario = usuario;
		this.setRegioes(usuarioService.buscarMunicipios(usuario.getEmp_ds_uf()));
		
		return eval(index());
	}

	public String editar() {
		setView(LIST);
		usuarioService.editar(usuario);
		usuarios();
		
		return eval(index());
	}

	public String deletar() {
		usuarioService.remover(objSelecionado.getUsuario_id());
		usuarios();
		return eval(index());
	}

	public String redirecionarTelaCadastro(int id) {
		usuario = new Usuario();
		this.usuario.setUsuario_id(id);

		Usuario usr = usuarioService.pesquisar(id);

		if(usr == null) {
			setView(ADD);
		} else {
			this.usuario = usr;
			setView(EDIT);
		}
		
		return eval(index());
	}	
	
	private void limparForm() {
		this.usuario = null;
		setUsuario(new Usuario());
		this.usuario.setEmp_nu_tipodocumento("cpf");
	}

	public String voltar() {
		setView(LIST);
		//String x = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath().toString();
		return eval(index());
	}
	
	private String index() {
		return "/usuario/index";
	}
	
	public void resetView() {
		setView(LIST);
	}
	
//	public void onDateSelect(SelectEvent event) {
//    FacesContext facesContext = FacesContext.getCurrentInstance();
//    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//    facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
//}

	
	

	
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public List<Usuario> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}


	public List<Regiao> getRegioes() {
		return regioes;
	}


	public void setRegioes(List<Regiao> regioes) {
		this.regioes = regioes;
	}


	public String getTipoDocumento() {
		return tipoDocumento;
	}


	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}


	public List<Usuario> getFilteredUsuarios() {
		return filteredUsuarios;
	}


	public void setFilteredUsuarios(List<Usuario> filteredUsuarios) {
		this.filteredUsuarios = filteredUsuarios;
	}

	public Usuario getObjSelecionado() {
		return objSelecionado;
	}

	public void setObjSelecionado(Usuario objSelecionado) {
		this.objSelecionado = objSelecionado;
	}



}

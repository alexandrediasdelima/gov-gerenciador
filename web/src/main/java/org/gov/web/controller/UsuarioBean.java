package org.gov.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.gov.model.OutraInfo;
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

	public UsuarioBean() {

		setUsuario(new Usuario());
		usuarioService = new UsuarioServiceImpl();
		usuarios = new ArrayList<Usuario>();
		usuarios();
	}

	public String redirecionarTelaCadastro(int id) {

		usuario = new Usuario();
		this.usuario.setUsuario_id(id);

		Usuario usr = usuarioService.pesquisar(id);
		setView(ADD);

		if(usr != null) {
			this.usuario = usr;
			setView(EDIT);
		}

		return eval(index());
	}

	public void resetView() {
		setView(LIST);
	}
	
	public String gravar() {

		usuarioService.gravar(usuario);
		usuarios();

		return eval(index());
	}

	public String usuarios() {

		usuarios = usuarioService.usuarios();
		setView(LIST);
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
		usuarioService.editar(usuario);
		usuarios();
		return eval(index());
	}

	public String deletar() {
		usuarioService.remover(usuario.getUsuario_id());
		usuarios();
		return eval(index());
	}

	 private void limparForm() {
		 this.usuario.setEmp_nm_usuario(null);
		 this.usuario.setEmp_nm_apelido(null);
		 this.usuario.setEmp_nu_cpfcnpj(null);
		 this.usuario.setEmp_nu_tipodocumento(null);
		 this.usuario.setEmp_nu_ddd(null);
		 this.usuario.setEmp_nu_telefone(null);
		 this.usuario.setEmp_ds_emailresponsavel(null);
		 this.usuario.setEmp_ds_tp_logradouro(null);
		 this.usuario.setEmp_ds_nm_logradouro(null);
		 this.usuario.setEmp_ds_logradouro(null);
		 this.usuario.setEmp_nu_logradouro(null);
		 this.usuario.setEmp_ds_complementoendereco(null);
		 this.usuario.setEmp_ds_bairrodistrito(null);
		 this.usuario.setEmp_nu_caixapostal(null);
		 this.usuario.setEmp_nu_cependereco(null);
		 this.usuario.setApa_muni_correspondencia(null);
		 this.usuario.setEmp_cd_codigoibgecorrespondencia(null);
		 this.usuario.setEmp_ds_uf(null);
	}

//	public void onDateSelect(SelectEvent event) {
//	        FacesContext facesContext = FacesContext.getCurrentInstance();
//	        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//	        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
//	    }


	public String voltar() {
		setView(LIST);
		return "/usuario/index";
	}
		
	public String index() {
		return "/usuario/index";
	}

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



}

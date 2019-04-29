package org.gov.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.gov.model.Cnarh;
import org.gov.model.Empreendimento;
import org.gov.model.Regiao;
import org.gov.model.Usuario;
import org.gov.service.EmpreendimentoService;
import org.gov.service.EmpreendimentoServiceImpl;





public class EmpreendimentoBean extends Controller  {


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	private Empreendimento empreendimento;
	private EmpreendimentoService empreendimentoService;
	private List<Empreendimento> empreendimentos;
	private List<Usuario> usuarios;
	private List<Regiao> regioes;
	private List<Empreendimento> filteredEmpreendimentos;

	public EmpreendimentoBean() {

		setEmpreendimento(new Empreendimento());
		empreendimentoService = new EmpreendimentoServiceImpl();
		setEmpreendimentos(new ArrayList<Empreendimento>());
		usuarios = new ArrayList<Usuario>();
		empreendimentos();
	}
	
	public String redirecionarTelaCadastro(int id) {

		empreendimento = new Empreendimento();
		this.empreendimento.setId(id);

		Empreendimento usr = empreendimentoService.pesquisar(id);
		setView(ADD);

		if(usr != null) {
			this.empreendimento = usr;
			setView(EDIT);
		}

		return eval(index());
	}

	public void resetView() {
		//setView(LIST);
	}

	public String adicionarNovo() {
		setView(ADD);
		limparForm();
		this.setUsuarios(empreendimentoService.usuarios());
		this.setRegioes(empreendimentoService.buscarMunicipios("PE"));
		return eval(index());
	}

	public String telaEditar(Empreendimento empreendimento) {
		setView(EDIT);
		this.empreendimento = empreendimento;
		this.setRegioes(empreendimentoService.buscarMunicipios("PE"));
		return eval(index());
	}

	public String gravar() {
		setView(LIST);
		empreendimento.setUnidadeAreaTotalPropriedade("Hectare");
		empreendimentoService.gravar(empreendimento);
		empreendimentos();

		return eval(index());
	}

	public String editar() {
		setView(LIST);
		empreendimentoService.editar(empreendimento);
		empreendimentos();

		return eval(index());
	}

	public String deletar() {
		setView(LIST);
		empreendimentoService.remover(empreendimento.getId());
		empreendimentos();
		return eval(index());
	}

	public String index() {
		return "/empreendimento/index";
	}

	public String voltar() {
		setView(LIST);
		return "/empreendimento/index";
	}

	private void limparForm() {
		this.empreendimento.setAreaTotalPropriedade(null);
		this.empreendimento.setCepEmpreendimento(null);
		this.empreendimento.setComplementoLogradouroEmpreendimento(null);
		this.empreendimento.setEnderecoEmpreendimento(null);
		this.empreendimento.setIbgeMunicipioLocalizadaInterferencia(null);
		this.empreendimento.setId(null);
		this.empreendimento.setIdUsuario(null);
		this.empreendimento.setLocalEmpreendimento(null);
		this.empreendimento.setNomeAcessoPrincipalEmpreendimento(null);
		this.empreendimento.setNomeEmpreendimento(null);
		this.empreendimento.setNomeLogradouroEmpreendimento(null);
		this.empreendimento.setNomeMunicipioEmpreendimento(null);
		this.empreendimento.setNumeroCaixaPostalEmpreendimento(null);
		this.empreendimento.setNumeroLogradouroEmpreendimento(null);
		this.empreendimento.setNumeroOutorga(null);
		this.empreendimento.setTipoLogradouroEmpreendimento(null);
		this.empreendimento.setUnidadeAreaTotalPropriedade(null);


	}

	public String empreendimentos() {
		setEmpreendimentos(empreendimentoService.empreendimentos());
		setView(LIST);
		return eval(index());
	}

	public void atualizarMunicipios() {
		setRegioes(empreendimentoService.buscarMunicipios("PE"));
	}

	public void atualizarIbge() {
		empreendimento.setIbgeMunicipioLocalizadaInterferencia(empreendimentoService.buscarIbge(empreendimento.getNomeMunicipioEmpreendimento()));
	}

	public Empreendimento getEmpreendimento() {
		return empreendimento;
	}

	public void setEmpreendimento(Empreendimento empreendimento) {
		this.empreendimento = empreendimento;
	}

	public List<Empreendimento> getEmpreendimentos() {
		return empreendimentos;
	}

	public void setEmpreendimentos(List<Empreendimento> empreendimentos) {
		this.empreendimentos = empreendimentos;
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

	public List<Empreendimento> getFilteredEmpreendimentos() {
		return filteredEmpreendimentos;
	}

	public void setFilteredEmpreendimentos(List<Empreendimento> filteredEmpreendimentos) {
		this.filteredEmpreendimentos = filteredEmpreendimentos;
	}



}

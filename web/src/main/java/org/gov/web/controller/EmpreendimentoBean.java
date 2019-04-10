package org.gov.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.gov.model.Empreendimento;
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

	public EmpreendimentoBean() {

		setEmpreendimento(new Empreendimento());
		empreendimentoService = new EmpreendimentoServiceImpl();
		setEmpreendimentos(new ArrayList<Empreendimento>());
		usuarios = new ArrayList<Usuario>();
		empreendimentos();
	}

	public String adicionarNovo() {
		setView(ADD);
		limparForm();
		this.setUsuarios(empreendimentoService.usuarios());
		return eval(index());
	}

	public String telaEditar(Empreendimento empreendimento) {

		this.empreendimento = empreendimento;
		setView(EDIT);
		return eval(index());
	}

	public String gravar() {

		empreendimentoService.gravar(empreendimento);
		empreendimentos();

		return eval(index());
	}

	public String editar() {

		empreendimentoService.editar(empreendimento);
		empreendimentos();

		return eval(index());
	}

	public String deletar() {

		empreendimentoService.remover(empreendimento.getId());
		empreendimentos();
		return eval(index());
	}

	public String index() {
		return "/empreendimento/index";
	}
	
	public String voltar() {
		return "/empreendimento/index";
	}

	private void limparForm() {
		this.empreendimento.setAreaTotalPropriedade(null);
		this.empreendimento.setCepEmpreendimento(null);
		this.empreendimento.setComplementoLogradouroEmpreendimento(null);
		this.empreendimento.setEnderecoEmpreendimento(null);
		this.empreendimento.setIbgeMunicipioLocalizadaInterferencia(null);
		this.empreendimento.setId(null);
		//this.empreendimento.setIdUsuario(null);
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


}

package br.com.experian.gerenciadorperfil.core.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.com.experian.gerenciadorperfil.core.dao.MeioAcessoDAO;
import br.com.experian.gerenciadorperfil.core.dao.MeioAcessoDAOImpl;
import br.com.experian.gerenciadorperfil.core.entity.MeioAcesso;
import br.com.experian.gerenciadorperfil.core.entity.filter.MeioAcessoFilter;
import br.com.experian.gerenciadorperfil.core.exception.GerenciadorPerfilServiceException;

@Service
public class MeioAcessoServiceImpl extends AbstractService<MeioAcesso, Integer, MeioAcessoFilter, MeioAcessoDAO> implements MeioAcessoService {


	@Autowired
	public MeioAcessoServiceImpl(MeioAcessoDAO meioAcessoDAO) {

		super(meioAcessoDAO);

		
	}

	private void validarDadosDeEntradaComum(MeioAcesso meioAcesso) throws GerenciadorPerfilServiceException {

		if (StringUtils.isBlank(meioAcesso.getDescricaoMeioAcesso())) {
			throw new GerenciadorPerfilServiceException("Descrição é requerida");
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public MeioAcesso adicionar(MeioAcesso meioAcesso) throws GerenciadorPerfilServiceException {

		validarDadosDeEntradaComum(meioAcesso);

		MeioAcesso meioAcessoCadastrado = buscarMeioAcessoPorNome(meioAcesso.getDescricaoMeioAcesso());

		if (meioAcessoCadastrado != null) {
			throw new GerenciadorPerfilServiceException("Já existe um Meio Acesso cadastrado com este nome");
		}

		MeioAcesso meioAcessoClonado = (MeioAcesso) SerializationUtils.clone(meioAcesso);

		

		return super.adicionar(meioAcessoClonado);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public MeioAcesso atualizar(MeioAcesso meioAcesso) throws GerenciadorPerfilServiceException {

		validarDadosDeEntradaComum(meioAcesso);

		
		MeioAcesso clienteClonado = (MeioAcesso) SerializationUtils.clone(meioAcesso);
		
		return super.atualizar(clienteClonado);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<MeioAcesso>buscar() {

		MeioAcessoFilter meioAcessoFilter = new MeioAcessoFilter();
		meioAcessoFilter.setOrderByIdAsc(true);

		List<MeioAcesso> meiosAcesso = getDao().listar(meioAcessoFilter);

		if (meiosAcesso.isEmpty()) {
			return null;
		}

		return meiosAcesso;
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	private MeioAcesso buscaPorId(Integer id) {

		MeioAcessoFilter meioAcessoFilter = new MeioAcessoFilter();
		meioAcessoFilter.setIdNotEquals(id);

		List<MeioAcesso> meiosAcesso = getDao().listar(meioAcessoFilter);

		if (meiosAcesso.isEmpty()) {
			return null;
		}

		return meiosAcesso.get(0);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public MeioAcesso buscarMeioAcessoPorNome(String nome) {

		MeioAcessoFilter meioAcessoFilter = new MeioAcessoFilter();
		meioAcessoFilter.setNomeEquals(nome);

		List<MeioAcesso> meiosAcesso= getDao().listar(meioAcessoFilter);

		if (meiosAcesso.isEmpty()) {
			return null;
		}

		return meiosAcesso.get(0);
	}

	public List<String> obterNomesMeiosAcesso() {
		List<String> meiosAcessoNome = new ArrayList<String>();
		
		List<MeioAcesso>meiosAcesso =  listar();
		for (Iterator<MeioAcesso> iterator = meiosAcesso.iterator(); iterator.hasNext();) {
			MeioAcesso meioAcesso = (MeioAcesso) iterator.next();
			meiosAcessoNome.add(meioAcesso.getDescricaoMeioAcesso());
		}
		return meiosAcessoNome;
	}




	@Transactional(propagation = Propagation.REQUIRED)
	public void remover(MeioAcesso cliente) throws GerenciadorPerfilServiceException {

		super.remover(cliente);
	}





}

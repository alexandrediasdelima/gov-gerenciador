package br.com.experian.gerenciadorperfil.core.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.experian.gerenciadorperfil.core.dao.UsuarioDAO;
import br.com.experian.gerenciadorperfil.core.entity.Usuario;
import br.com.experian.gerenciadorperfil.core.entity.filter.UsuarioFilter;
import br.com.experian.gerenciadorperfil.core.exception.GerenciadorPerfilServiceException;

@Service
public class UsuarioServiceImpl extends AbstractService<Usuario, Long, UsuarioFilter, UsuarioDAO> implements UsuarioService {

	@Autowired
	public UsuarioServiceImpl(UsuarioDAO usuarioDAO) {
		super(usuarioDAO);
	}

	private void validar(Usuario usuario) throws GerenciadorPerfilServiceException {

		if (StringUtils.isBlank(usuario.getCpf())) {
			throw new GerenciadorPerfilServiceException("Cpf é requerido");
		}

		if (StringUtils.isBlank(usuario.getLoginCriacao())) {
			throw new GerenciadorPerfilServiceException("Login de criação é requerido");
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Usuario adicionar(Usuario usuario) throws GerenciadorPerfilServiceException {

		validar(usuario);

		Usuario usuarioClonado = (Usuario) SerializationUtils.clone(usuario);
		usuarioClonado.setDataCriacao(new Date());

		Usuario usuarioCadastrado = obterPorCpf(usuarioClonado.getCpf());

		if (usuarioCadastrado != null) {
			throw new GerenciadorPerfilServiceException("Já existe um usuario com o cpf informado");
		}

		return super.adicionar(usuarioClonado);
	}

	public Usuario obterPorCpf(String cpf) {
		UsuarioFilter usuarioFilter = new UsuarioFilter()
			.setCpfEquals(cpf);

		List<Usuario> usuarios = listar(usuarioFilter);

		Usuario usuario = null;

		if (!usuarios.isEmpty()) {
			usuario = usuarios.get(0);
		}

		return usuario;
	}
}

package br.com.experian.gerenciadorperfil.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.experian.gerenciadorperfil.core.dao.ImagemBookDAO;
import br.com.experian.gerenciadorperfil.core.entity.ImagemBook;
import br.com.experian.gerenciadorperfil.core.entity.filter.ImagemBookFilter;
import br.com.experian.gerenciadorperfil.core.exception.GerenciadorPerfilServiceException;

@Service
public class ImagemBookServiceImpl extends AbstractService<ImagemBook, Long, ImagemBookFilter, ImagemBookDAO> implements ImagemBookService {

	@Autowired
	public ImagemBookServiceImpl(ImagemBookDAO imagemBookDAO) {
		super(imagemBookDAO);
	}

	private void validar(ImagemBook imagemBook) throws GerenciadorPerfilServiceException {

		/*if (StringUtils.isBlank(usuario.getCpf())) {
			throw new GerenciadorPerfilServiceException("Cpf é requerido");
		}

		if (StringUtils.isBlank(usuario.getLoginCriacao())) {
			throw new GerenciadorPerfilServiceException("Login de criação é requerido");
		}*/
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public ImagemBook adicionar(ImagemBook imagemBook) throws GerenciadorPerfilServiceException {

		/*validar(imagemBook);

		Usuario usuarioClonado = (Usuario) SerializationUtils.clone(imagemBook);
		usuarioClonado.setDataCriacao(new Date());

		Usuario usuarioCadastrado = obterPorCpf(usuarioClonado.getCpf());

		if (usuarioCadastrado != null) {
			throw new GerenciadorPerfilServiceException("Já existe um usuario com o cpf informado");
		}
*/
		return super.adicionar(imagemBook);
	}

	/*public Usuario obterPorCpf(String cpf) {
		UsuarioFilter usuarioFilter = new UsuarioFilter()
			.setCpfEquals(cpf);

		List<Usuario> usuarios = listar(usuarioFilter);

		Usuario usuario = null;

		if (!usuarios.isEmpty()) {
			usuario = usuarios.get(0);
		}

		return usuario;
	}*/
}

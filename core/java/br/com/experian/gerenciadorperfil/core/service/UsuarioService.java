package br.com.experian.gerenciadorperfil.core.service;

import br.com.experian.gerenciadorperfil.core.entity.Usuario;
import br.com.experian.gerenciadorperfil.core.entity.filter.UsuarioFilter;

public interface UsuarioService extends Service<Usuario, Long, UsuarioFilter> {

	Usuario obterPorCpf(String cpf);
}

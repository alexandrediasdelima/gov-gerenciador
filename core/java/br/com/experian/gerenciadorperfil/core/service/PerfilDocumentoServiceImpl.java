package br.com.experian.gerenciadorperfil.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.experian.gerenciadorperfil.core.dao.PerfilDocumentoDAO;
import br.com.experian.gerenciadorperfil.core.entity.Perfil;
import br.com.experian.gerenciadorperfil.core.entity.PerfilDocumento;
import br.com.experian.gerenciadorperfil.core.entity.filter.PerfilDocumentoFilter;
import br.com.experian.gerenciadorperfil.core.exception.GerenciadorPerfilServiceException;
import br.com.experian.gerenciadorperfil.core.util.FormatterUtils;

@Service
public class PerfilDocumentoServiceImpl extends AbstractService<PerfilDocumento, Long, PerfilDocumentoFilter, PerfilDocumentoDAO> implements PerfilDocumentoService {

	@Autowired
	public PerfilDocumentoServiceImpl(PerfilDocumentoDAO perfilDocumentoDAO) {
		super(perfilDocumentoDAO);

	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<PerfilDocumento> listarPorPerfil(Perfil perfil) {
		PerfilDocumentoFilter perfilDocumentoFilter = new PerfilDocumentoFilter()
		.setIdPerfilEquals(perfil.getId());

		return listar(perfilDocumentoFilter);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<PerfilDocumento> listarPorCNPJ(String cnpj) throws GerenciadorPerfilServiceException {
		PerfilDocumentoFilter perfilDocumentoFilter = new PerfilDocumentoFilter()
		.setContainsDocumentoCnpj(FormatterUtils.formatCnpj(cnpj));

		return listar(perfilDocumentoFilter);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List<PerfilDocumento> listarDuplicadosPorListaDePerfis(List<Perfil> perfis) {
		List<Long> idsPerfis = new ArrayList<Long>();
		for(Perfil perfil: perfis){
			idsPerfis.add(perfil.getId());
		}

		PerfilDocumentoFilter perfilDocumentoFilter = new PerfilDocumentoFilter()
		.setIdPerfilIn(idsPerfis)
		.setIdPerfilInSubSelect(idsPerfis);

		return getDao().listarDuplicidades(perfilDocumentoFilter);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void adicionar(List<PerfilDocumento> documentos) {
		getDao().adicionar(documentos);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public PerfilDocumento adicionar(PerfilDocumento doc) throws GerenciadorPerfilServiceException {
		doc.setCnpj(FormatterUtils.formatCnpj(doc.getCnpj()));
		return getDao().adicionar(doc);
	}


	public void removerPorPerfil(Perfil perfil) {
		PerfilDocumentoFilter perfilDocumentoFilter = new PerfilDocumentoFilter()
			.setIdPerfilEquals(perfil.getId());
		getDao().remover(perfilDocumentoFilter);
	}
}

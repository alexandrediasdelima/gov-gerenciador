package br.com.experian.gerenciadorperfil.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.experian.gerenciadorperfil.core.dao.FeatureDescontoDAO;
import br.com.experian.gerenciadorperfil.core.entity.FeatureDesconto;
import br.com.experian.gerenciadorperfil.core.entity.filter.FeatureDescontoFilter;

@Service
public class FeatureDescontoServiceImpl extends AbstractService<FeatureDesconto, Integer, FeatureDescontoFilter, FeatureDescontoDAO> implements FeatureDescontoService {

	@Autowired
	public FeatureDescontoServiceImpl(FeatureDescontoDAO featureDAO) {
		super(featureDAO);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void salvar(FeatureDesconto feature) {
		getDao().salvar(feature);
	}

	
}
package br.com.experian.gerenciadorperfil.core.dao;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import br.com.experian.gerenciadorperfil.core.entity.ImagemBook;
import br.com.experian.gerenciadorperfil.core.entity.filter.ImagemBookFilter;

@Component
public class ImagemBookDAOImpl extends AbstractDAO<ImagemBook, Long, ImagemBookFilter> implements ImagemBookDAO {

	private static final String SELECT = "SELECT i FROM ImagemBook i";
	private transient final Logger logger = LoggerFactory.getLogger(getClass());

	public ImagemBookDAOImpl() {
		super(ImagemBook.class, ImagemBookFilter.class);
	}

	@Override
	protected String createSqlQuery(ImagemBookFilter imagemBookFilter) {

		StringBuilder sql = new StringBuilder(SELECT);

		/*List<String> wheres = new ArrayList<String>();

		if (StringUtils.isNotBlank(imagemBookFilter.getCpfLikeBoth())) {
			wheres.add("u.cpf LIKE :" + UsuarioFilter.CPF_LIKE_BOTH);
		}

		if (StringUtils.isNotBlank(imagemBookFilter.getCpfEquals())) {
			wheres.add("u.cpf = :" + UsuarioFilter.CPF_EQUALS);
		}

		if (!wheres.isEmpty()) {
			sql.append(" WHERE ");
			sql.append(StringUtils.join(wheres, " AND "));
		}
		
		sql.append(" ORDER BY u.id DESC ");*/

		return sql.toString();
	}

	@Override
	protected void applyFilter(Query query, ImagemBookFilter imagemBookFilter) {

		/*super.applyFilter(query, imagemBookFilter);

		if (StringUtils.isNotBlank(imagemBookFilter.getCpfLikeBoth())) {
			query.setParameter(UsuarioFilter.CPF_LIKE_BOTH, "%" + imagemBookFilter.getCpfLikeBoth() + "%");
		}

		if (StringUtils.isNotBlank(imagemBookFilter.getCpfEquals())) {
			query.setParameter(UsuarioFilter.CPF_EQUALS, imagemBookFilter.getCpfEquals());
		}*/
	}
	
	@Override
	public ImagemBook adicionar(ImagemBook entity) {

		logger.info("Adicionando uma imagem... -- ID: [{}]", entity==null?"null":entity.getId());
		
		if(entity != null) {			
			super.adicionar(entity);			
		}

		return entity;
	}
	
	@Override
	public ImagemBook atualizar(ImagemBook entity) {
		
		logger.info("Atualizando a Imagem... -- ID: [{}]", entity==null?"null":entity.getId());
		
		ImagemBook imagemBookAtualizada = null;
		
		if(entity != null) {
			imagemBookAtualizada = super.atualizar(entity);
			
		}
		
		return imagemBookAtualizada;
	}
	
	
}

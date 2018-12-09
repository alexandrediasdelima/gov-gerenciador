package br.com.experian.gerenciadorperfil.core.entity.filter;

import org.apache.commons.lang3.StringUtils;
import br.com.experian.gerenciadorperfil.core.entity.ImagemBook;
import br.com.experian.gerenciadorperfil.core.entity.Usuario;

public class ImagemBookFilter extends AbstractEntityFilter<ImagemBook, ImagemBookFilter> {

	public static final String CPF_LIKE_BOTH = "cpfLikeBoth";

	public static final String CPF_EQUALS = "cpfEquals";

	private String cpfLikeBoth;

	private String cpfEquals;

	public ImagemBookFilter() {
		super(ImagemBookFilter.class);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -6429329621664769491L;

	/**
	 * @return the cpfLikeBoth
	 */
	public String getCpfLikeBoth() {
		return cpfLikeBoth;
	}

	/**
	 * @param cpfLikeBoth the cpfLikeBoth to set
	 */
	public ImagemBookFilter setCpfLikeBoth(String cpfLikeBoth) {
		this.cpfLikeBoth = cpfLikeBoth;
		return this;
	}

	/**
	 * @return the cpfEquals
	 */
	public String getCpfEquals() {
		return cpfEquals;
	}

	/**
	 * @param cpfEquals the cpfEquals to set
	 */
	public ImagemBookFilter setCpfEquals(String cpfEquals) {
		if (StringUtils.isNotBlank(cpfEquals)) {
			this.cpfEquals = StringUtils.leftPad(cpfEquals, Usuario.TAMANHO_CPF, "0");
		} else {
			this.cpfEquals = null;
		}
		return this;
	}
}

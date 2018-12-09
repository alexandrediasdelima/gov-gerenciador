package br.com.experian.gerenciadorperfil.core.entity.filter;

import org.apache.commons.lang3.StringUtils;

import br.com.experian.gerenciadorperfil.core.entity.Usuario;

public class UsuarioFilter extends AbstractEntityFilter<Usuario, UsuarioFilter> {

	public static final String CPF_LIKE_BOTH = "cpfLikeBoth";

	public static final String CPF_EQUALS = "cpfEquals";

	private String cpfLikeBoth;

	private String cpfEquals;

	public UsuarioFilter() {
		super(UsuarioFilter.class);
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
	public UsuarioFilter setCpfLikeBoth(String cpfLikeBoth) {
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
	public UsuarioFilter setCpfEquals(String cpfEquals) {
		if (StringUtils.isNotBlank(cpfEquals)) {
			this.cpfEquals = StringUtils.leftPad(cpfEquals, Usuario.TAMANHO_CPF, "0");
		} else {
			this.cpfEquals = null;
		}
		return this;
	}
}

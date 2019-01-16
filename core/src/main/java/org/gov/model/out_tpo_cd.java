package org.gov.model;

public enum out_tpo_cd {

	DEREITO_DE_USO ("Direito de Uso"),
	PREVENTIVA("Preventiva"),
	DRDH("DRDH"),
	CERTOH("CERTOH"),
	LICENCA_AUTORIZACAO_PERFURACAO_POCOS("Licença ou autorização para perfuração de poços"),
	ANUENCIA_PREVIA("Anuência prévia"),
	CADASTRO("Cadastro"),
	OUTRA("Outra");

	private String descricao;

		out_tpo_cd(String desc) {
			this.descricao = desc;

	}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

}

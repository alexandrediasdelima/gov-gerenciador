package org.gov.model;

public enum Out_tpo_cd {

	DIREITO_DE_USO("Direito de Uso"),
	PREVENTIVA("Preventiva"),
	DRDH("DRDH"),
	CERTOH("CERTOH"),
	LICENCA_AUTORIZACAO_PERFURACAO_POCOS("Licença ou autorização para perfuração de poços"),
	ANUENCIA_PREVIA("Anuência prévia"),
	CADASTRO("Cadastro"),
	OUTRA("Outra");

	private String descricao;

		Out_tpo_cd(String desc) {
			this.descricao = desc;

	}

		public String getDescricao() {
			return descricao.toUpperCase();
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

}

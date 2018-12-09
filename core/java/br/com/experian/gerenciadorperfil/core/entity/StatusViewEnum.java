package br.com.experian.gerenciadorperfil.core.entity;

public enum StatusViewEnum {
	
		PROCESSANDO(1,"EM PROCESSAMENTO"),
		ERRO(2, "PROCESSAMENTO COM ERRO"),
		ERRO_CANCELAMENTO(3, "CANCELAMENTO COM ERRO"),
		PROGRAMADA(4, "PROGRAMADA"),
		VIGENTE(5, "VIGENTE"),
		FINALIZADA(6, "FINALIZADA"),
		POS_GRATUIDADE(7, "EM PÓS GRATUIDADE"),
		CANCELANDO(8, "CANCELANDO"),
		ENVIADO_MF(9, "ENVIADO MF"),
		CANCELAMENTO_ENVIADO_MF(10, "CANCELAMENTO ENVIADO MF"),
		CANCELADA(11, "CANCELADA");		
		
		private int codStatus;
		private String viewStatus;
		
		
		private StatusViewEnum(int codStatus, String viewStatus) {
			this.setViewStatus(viewStatus);
			this.codStatus = codStatus;
		}


		public int getCodStatus() {
			return codStatus;
		}


		public void setCodStatus(int codStatus) {
			this.codStatus = codStatus;
		}


		public String getViewStatus() {
			return viewStatus;
		}


		public void setViewStatus(String viewStatus) {
			this.viewStatus = viewStatus;
		}	
		

};

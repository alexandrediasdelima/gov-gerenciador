package org.gov.util;

import org.gov.model.TipoInterferencia;
import org.gov.model.SubTipoCaptacao;
import org.gov.model.SituacaoInterferencia;
import org.gov.model.TipoOutorga;
import org.gov.model.SituacaoOutorga;
import org.gov.model.TipoFinalidade;
import org.gov.model.TipoOutroUso;
import org.gov.model.TipoIrrigacao;
import org.gov.model.TipoCultura;
import org.gov.model.NaturezaPonto;
import org.gov.model.TipoPenetracaoAquifero;
import org.gov.model.TipoCondicaoAquifero;
import org.gov.model.TipoTesteBombeamento;
import org.gov.model.TipoMetodoInterpretacao;
import org.gov.model.IdentificadorAquiferoPonto;


public final class EnumUtils {

	private EnumUtils() {
		
	}
	
	//ANEXO I – INT_TIN_CD – CÓDIGO IDENTIFICADOR DO TIPO DE INTERFERENCIA
	public static String obterValorTipoInterferencia(int chave) {
    	switch (chave) {
	    	case 1: return TipoInterferencia.CAPTACAO.getValor();
	    	case 2: return TipoInterferencia.LANCAMENTO.getValor();
	    	case 3: return TipoInterferencia.BARRAGEM.getValor();
	    	case 4: return TipoInterferencia.PONTO_REFERENCIA.getValor();
	    	default:
	    		return null;
    	}
	}
	
	//ANEXO 2 – INT_TSU_CD – CÓDIGO IDENTIFICADOR DO SUBTIPO DA CAPTAÇÃO
	public static String obterValorSubTipoCaptacao(int chave) {
    	switch (chave) {
	    	case 1: return SubTipoCaptacao.SUPERFICIAL.getValor();
	    	case 2: return SubTipoCaptacao.SUBTERRANEA.getValor();
	    	default:
	    		return null;
    	}
	}
	
	//ANEXO 3 – INT_TSI_CD – CÓDIGO IDENTIFICADOR DA SITUAÇÃO DA INTERFERÊNCIA
	public static String obterValorSituacaoInterferencia(int chave) {
    	switch (chave) {
	    	case 1: return SituacaoInterferencia.PROJETO.getValor();
	    	case 2: return SituacaoInterferencia.CONSTRUCAO.getValor();
	    	case 3: return SituacaoInterferencia.OPERACAO.getValor();
	    	case 4: return SituacaoInterferencia.DESATIVADA.getValor();
	    	default:
	    		return null;
    	}
	}

	//ANEXO 4 – OUT_TPO_CD – CÓDIGO IDENTIFICADOR DO TIPO DE ATO ADMINISTRATIVO OU INSTRUMENTO DE REGULARIZAÇÃO
	public static String obterValorTipoOutorga(int chave) {
    	switch (chave) {
	    	case 1: return TipoOutorga.DIREITO_DE_USO.getValor();
	    	case 2: return TipoOutorga.PREVENTIVA.getValor();
	    	case 3: return TipoOutorga.DRDH.getValor();
	    	case 4: return TipoOutorga.CERTOH.getValor();
	    	case 5: return TipoOutorga.LICENCA_OU_AUTORIZACAO_PARA_PERFURACAO_DE_POCOS.getValor();
	    	case 6: return TipoOutorga.ANUENCIA_PREVIA.getValor();
	    	case 7: return TipoOutorga.CADASTRO.getValor();
	    	case 99: return TipoOutorga.OUTRA.getValor();
	    	default:
	    		return null;
    	}
	}
	
	//ANEXO 5 – OUT_TSP_CD – CÓDIGO IDENTIFICADOR DO TIPO DE SITUAÇÃO DE ATO ADMINISTRATIVO OU INSTRUMENTO DE REGULARIZAÇÃO
	public static String obterValorSituacaoOutorga(int chave) {
    	switch (chave) {
	    	case 1: return SituacaoOutorga.OUTORGADO.getValor();
	    	case 2: return SituacaoOutorga.NAO_OUTORGAVEL.getValor();
	    	case 3: return SituacaoOutorga.EM_ANALISE.getValor();
	    	case 4: return SituacaoOutorga.USO_INSIGNIFICANTE.getValor();
	    	case 5: return SituacaoOutorga.INDEFERIDO.getValor();
	    	case 6: return SituacaoOutorga.INVALIDO.getValor();
	    	case 8: return SituacaoOutorga.AUTORIZADO_SUBTERRANEA.getValor();
	    	case 99: return SituacaoOutorga.OUTRA.getValor();
	    	default:
	    		return null;
    	}
	}
	
	//ANEXO 6 – FIN_TFN_CD- CÓDIGO IDENTIFICADOR DO TIPO DA FINALIDADE
	public static String obterValorTipoFinalidade(int chave) {
    	switch (chave) {
	    	case 0:  return TipoFinalidade.SEM_FINALIDADE.getValor();
	    	case 1:  return TipoFinalidade.ABASTECIMENTO_PUBLICO.getValor();
	    	case 2:  return TipoFinalidade.ESGOTAMENTO_SANITARIO.getValor();
	    	case 3:  return TipoFinalidade.INDUSTRIA.getValor();
	    	case 4:  return TipoFinalidade.MINERACAO_EXTRACAO.getValor();
	    	case 5:  return TipoFinalidade.IRRIGACAO.getValor();
	    	case 6:  return TipoFinalidade.CRIACAO_ANIMAL.getValor();
	    	case 7:  return TipoFinalidade.AQUICULTURA_EM_TANQUE_ESCAVADO.getValor();
	    	case 8:  return TipoFinalidade.TERMOELETRICA.getValor();
	    	case 9:  return TipoFinalidade.TRANSPOSICAO.getValor();
	    	case 10: return TipoFinalidade.APROVEITAMENTO_HIDROELETRICO.getValor();
	    	case 11: return TipoFinalidade.RESERVATORIO.getValor();
	    	case 12: return TipoFinalidade.CONSUMO_HUMANO.getValor();		
	    	case 13: return TipoFinalidade.MINERACAO_OUTROS.getValor();
	    	case 15: return TipoFinalidade.OBRAS_HIDRAULICAS.getValor();
	    	case 16: return TipoFinalidade.SERVICOS.getValor();
	    	case 18: return TipoFinalidade.AQUICULTURA_EM_TANQUE_REDE.getValor();
	    	case 99: return TipoFinalidade.OUTRAS.getValor();
	    	default:
	    		return null;
    	}
	}	

	//ANEXO 7 – FOU_TOU_CD- CÓDIGO IDENTIFICADOR DO TIPO DE OUTRO USO
	public static String obterValorTipoOutroUso(int chave) {
    	switch (chave) {
	    	case 1:  return TipoOutroUso.ECLUSA.getValor();
	    	case 2:  return TipoOutroUso.RECREACAO.getValor();
	    	case 3:  return TipoOutroUso.SALVAMENTO.getValor();
	    	case 14: return TipoOutroUso.POCO_DE_BOMBEAMENTO_DE_RECUPERACAO_AMBIENTAL.getValor();
	    	case 15: return TipoOutroUso.POCO_DE_MONITORAMENTO.getValor();
	    	case 16: return TipoOutroUso.POCO_DE_INJECAO_PARA_RECUPERACAO_AMBIENTAL.getValor();
	    	case 17: return TipoOutroUso.UMECTACAO_DE_VIAS.getValor();
	    	case 19: return TipoOutroUso.SISTEMA_DE_RESFRIAMENTO.getValor();
	    	case 21: return TipoOutroUso.LAVAGEM_DE_VEICULOS.getValor();
	    	case 22: return TipoOutroUso.CLARIFICACAO_DA_AGUA.getValor();
	    	case 26: return TipoOutroUso.DEPURACAO_DE_EFLUENTES.getValor();
	    	case 27: return TipoOutroUso.DISPOSICAO_DE_REJEITOS.getValor();
	    	case 28: return TipoOutroUso.PESQUISA_MINERAL.getValor();
	    	case 29: return TipoOutroUso.PESQUISA_HIDROGEOLOGICA.getValor();
	    	case 30: return TipoOutroUso.RECIRCULACAO_DE_AGUA.getValor();
	    	case 31: return TipoOutroUso.URBANIZACAO.getValor();
	    	case 32: return TipoOutroUso.REBAIXAMENTO_DE_AQUIFERO.getValor();
	    	case 39: return TipoOutroUso.BALNEARIO_LAZER_E_CLUBE.getValor();
	    	case 44: return TipoOutroUso.LAVANDERIA.getValor();
	    	case 45: return TipoOutroUso.COMBATE_A_INCENDIO.getValor();
	    	case 49: return TipoOutroUso.HORTAS_POMARES_JARDINS_PAISAGISMO.getValor();
	    	case 50: return TipoOutroUso.TESTE_HIDROSTATICO.getValor();
	    	case 51: return TipoOutroUso.ABASTECIMENTO_DE_PULVERIZADORES.getValor();
	    	case 53: return TipoOutroUso.OUTRO.getValor();
	    	case 54: return TipoOutroUso.CONSTRUCAO_CIVIL.getValor();
	    	default:
	    		return null;
    	}
	}
	
	//ANEXO 8 - TNP_CD - CÓDIGO IDENTIFICADOR QUE REPRESENTA O SISTEMA DE IRRIGAÇÃO UTILIZADO PELA INTERFERÊNCIA
	public static String obterValorTipoIrrigacao(int chave) {
    	switch (chave) {
	    	case 1: return TipoIrrigacao.SULCOS_ABERTOS_EM_DESNIVEL.getValor();
	    	case 2: return TipoIrrigacao.INUNDACAO_PERMANENTE_DIQUES_EM_NIVEL.getValor();
	    	case 3: return TipoIrrigacao.ASPERSAO_POR_SISTEMA_CONVENCIONAL.getValor();
	    	case 4: return TipoIrrigacao.ASPERSAO_POR_SISTEMA_AUTOPROPELIDO.getValor();
	    	case 5: return TipoIrrigacao.ASPERSAO_POR_SISTEMA_PIVO_CENTRAL.getValor();
	    	case 6: return TipoIrrigacao.GOTEJAMENTO.getValor();
	    	case 7: return TipoIrrigacao.MICRO_ASPERSAO.getValor();
	    	case 8: return TipoIrrigacao.TUBOS_PERFURADOS_TRIPA.getValor();
	    	case 9: return TipoIrrigacao.SULCOS_INTERLIGADOS_EM_BACIAS.getValor();
	    	case 10: return TipoIrrigacao.SUB_IRRIGACAO.getValor();
	    	case 11: return TipoIrrigacao.ASPERSAO_POR_SISTEMA_PIVO_CENTRAL_COM_LEPA.getValor();
	    	case 12: return TipoIrrigacao.ASPERSAO_POR_CANHAO_HIDRAULICO.getValor();
	    	case 13: return TipoIrrigacao.ASPERSAO_POR_SISTEMA_DESLOCAMENTO_LINEAR.getValor();
	    	case 14: return TipoIrrigacao.ASPERSAO_POR_SISTEMA_EM_MALHA.getValor();
	    	case 15: return TipoIrrigacao.ASPERSAO_POR_SISTEMA_PIVO_CENTRAL_REBOCAVEL.getValor();
	    	case 16: return TipoIrrigacao.CAMINHAO_REGADEIRA.getValor();
	    	case 17: return TipoIrrigacao.GOTEJAMENTO_SUBTERRÂNEO_TUBO_POROSO.getValor();
	    	case 18: return TipoIrrigacao.SULCOS_FECHADOS.getValor();
	    	case 19: return TipoIrrigacao.INUNDACAO_TEMPORARIA_DIQUES_EM_DESNIVEL.getValor();
    		default:
	    		return null;
    	}
	}
	
	//ANEXO 9 - TNP_CD - CÓDIGO IDENTIFICADOR DO TIPO DE CULTURA
	public static String obterValorTipoCultura(int chave) {
    	switch (chave) {
    	case 1: return TipoCultura.BROCOLIS.getValor();
    	case 2: return TipoCultura.COUVE_DE_BRUXELAS.getValor();
    	case 3: return TipoCultura.REPOLHO.getValor();
    	case 4: return TipoCultura.CENOURA.getValor();
    	case 5: return TipoCultura.COUVE_FLOR.getValor();
    	case 6: return TipoCultura.AIPO.getValor();
    	case 7: return TipoCultura.ALHO.getValor();
    	case 8: return TipoCultura.ALFACE.getValor();
    	case 9: return TipoCultura.CEBOLAS_SECAS.getValor();
    	case 10: return TipoCultura.CEBOLAS_VERDES.getValor();
    	case 11: return TipoCultura.CEBOLAS_SEMENTES.getValor();
    	case 12: return TipoCultura.ESPINAFRE.getValor();
    	case 13: return TipoCultura.RABANETE.getValor();
    	case 14: return TipoCultura.BERINGELA.getValor();
    	case 15: return TipoCultura.PIMENTAO.getValor();
    	case 16: return TipoCultura.TOMATE.getValor();
    	case 17: return TipoCultura.MELAO_CANTALOUPE.getValor();
    	case 18: return TipoCultura.PEPINO_COLHEITA_FRESCA.getValor();
    	case 19: return TipoCultura.PEPINO_COLHEITA_MECANICA.getValor();
    	case 20: return TipoCultura.ABOBORA.getValor();
    	case 21: return TipoCultura.ABOBRINHA.getValor();
    	case 22: return TipoCultura.MELOES.getValor();
    	case 23: return TipoCultura.MELANCIAS.getValor();
    	case 24: return TipoCultura.BETERRABAS.getValor();
    	case 25: return TipoCultura.MANDIOCAS_ANO_1.getValor();
    	case 26: return TipoCultura.MANDIOCAS_ANO_2.getValor();
    	case 27: return TipoCultura.PASTINACA_CHIRIVIA.getValor();
    	case 28: return TipoCultura.BATATA.getValor();
    	case 29: return TipoCultura.BATATA_DOCE.getValor();
    	case 30: return TipoCultura.NABO_E_NABO_REDONDO.getValor();
    	case 31: return TipoCultura.BETERRABA_ACUCAREIRA.getValor();
    	case 32: return TipoCultura.FEIJAO_VERDE.getValor();
    	case 33: return TipoCultura.FEIJOES_GRAOS.getValor();
    	case 34: return TipoCultura.GRAO_DE_BICO.getValor();
    	case 35: return TipoCultura.FAVA_COLHEITA_FRESCA.getValor();
    	case 36: return TipoCultura.FAVA_GRAO_SEMENTE.getValor();
    	case 37: return TipoCultura.FEIJAO_CAUPI_E_FEIJAO_MUNGO.getValor();
    	case 38: return TipoCultura.AMENDOIM.getValor();
    	case 39: return TipoCultura.LENTILHA.getValor();
    	case 40: return TipoCultura.ERVILHA_FRESCA.getValor();
    	case 41: return TipoCultura.ERVILHA_SECA_SEMENTE.getValor();
    	case 42: return TipoCultura.SOJA.getValor();
    	case 43: return TipoCultura.ALCACHOFRAS.getValor();
    	case 44: return TipoCultura.ASPARGOS.getValor();
    	case 45: return TipoCultura.HORTELA.getValor();
    	case 46: return TipoCultura.MORANGOS.getValor();
    	case 47: return TipoCultura.ALGODAO.getValor();
    	case 48: return TipoCultura.LINHO.getValor();
    	case 49: return TipoCultura.SISAL.getValor();
    	case 50: return TipoCultura.MAMONA.getValor();
    	case 51: return TipoCultura.COLZA_CANOLA.getValor();
    	case 52: return TipoCultura.CARTAMO.getValor();
    	case 53: return TipoCultura.GEGELIM.getValor();
    	case 54: return TipoCultura.GIRASSOL.getValor();
    	case 55: return TipoCultura.CEVADA.getValor();
    	case 56: return TipoCultura.AVEIA.getValor();
    	case 57: return TipoCultura.TRIGO_PRIMAVERA.getValor();
    	case 58: return TipoCultura.TRIGO_INVERNO.getValor();
    	case 59: return TipoCultura.MILHO_GRAO_E_PIPOCA.getValor();
    	case 60: return TipoCultura.MILHO_DOCE.getValor();
    	case 61: return TipoCultura.MILHETO.getValor();
    	case 62: return TipoCultura.SORGO_GRAO.getValor();
    	case 63: return TipoCultura.SORGO_DOCE.getValor();
    	case 64: return TipoCultura.ARROZ.getValor();
    	case 65: return TipoCultura.ALFAFA_FENO_VARIOS_CORTES_FEITOS_MEDIOS.getValor();
    	case 66: return TipoCultura.ALFAFA_FENO_CICLO_INDIVIDUAL_DE_CORTE.getValor();
    	case 67: return TipoCultura.ALFAFA_PARA_SEMENTE.getValor();
    	case 68: return TipoCultura.CAPIM_BERMUDA_FENO_VARIOS_CORTES_EFEITOS_MEDIOS.getValor();
    	case 69: return TipoCultura.CAPIM_BERMUDA_COLHEITA_DE_PRIMAVERA_PARA_SEMENTE.getValor();
    	case 70: return TipoCultura.TREVO_FENO_VARIOS_CORTES_EFEITOS_MEDIOS.getValor();
    	case 71: return TipoCultura.TREVO_FENO_CICLO_INDIVIDUAL_DE_CORTE.getValor();
    	case 72: return TipoCultura.CAPIM_CENTEIO_FENO_VARIOS_CORTES_EFEITOS_MEDIOS.getValor();
    	case 73: return TipoCultura.CAPIM_SUDAO_ANUAL_FENO_VARIOS_CORTES_EFEITOS_MEDIOS.getValor();
    	case 74: return TipoCultura.CAPIM_SUDAO_ANUAL_FENO_CICLO_INDIVIDUAL_DE_CORTE.getValor();
    	case 75: return TipoCultura.PASTAGEM_PASTOREIO_ROTATIVO.getValor();
    	case 76: return TipoCultura.PASTAGEM_PASTOREIO_EXTENSIVO.getValor();
    	case 77: return TipoCultura.GRAMADOS_ESTACAO_FRIA.getValor();
    	case 78: return TipoCultura.GRAMADOS_ESTACAO_QUENTE.getValor();
    	case 79: return TipoCultura.BANANA_1º_ANO.getValor();
    	case 80: return TipoCultura.BANANA_2º_ANO.getValor();
    	case 81: return TipoCultura.CACAU.getValor();
    	case 82: return TipoCultura.CAFE_POUCA_COBERTURA_DE_CHAO.getValor();
    	case 83: return TipoCultura.CAFE_COM_ERVAS.getValor();
    	case 84: return TipoCultura.TAMAREIRA_TAMARAS.getValor();
    	case 85: return TipoCultura.PALMEIRA.getValor();
    	case 86: return TipoCultura.ABACAXI_SOLO_LIMPO.getValor();
    	case 87: return TipoCultura.ABACAXI_COM_COBERTURA_DE_GRAMINEAS.getValor();
    	case 88: return TipoCultura.SERINGUEIRA.getValor();
    	case 89: return TipoCultura.CHA_SEM_SOMBREAMENTO.getValor();
    	case 90: return TipoCultura.CHA_COM_ARVORES_DE_SOMBREAMENTO.getValor();
    	case 91: return TipoCultura.AMORA_MIRTILO_ARBUSTOS.getValor();
    	case 92: return TipoCultura.UVAS_MESA_OU_PASSAS.getValor();
    	case 93: return TipoCultura.UVAS_VINHO.getValor();
    	case 94: return TipoCultura.LUPULO.getValor();
    	case 95: return TipoCultura.AMENDOAS_SEM_COBERTURA_DE_CHAO.getValor();
    	case 96: return TipoCultura.MACAS_CEREJAS_E_PERAS_SEM_COBERTURA_DE_CHAO_COM_GEADAS.getValor();
    	case 97: return TipoCultura.MACAS_CEREJAS_E_PERAS_SEM_COBERTURA_DE_CHAO_SEM_GEADAS.getValor();
    	case 98: return TipoCultura.MACAS_CEREJAS_E_PERAS_COBERTURA_DE_CHAO_ATIVA_COM_GEADAS.getValor();
    	case 99: return TipoCultura.MACAS_CEREJAS_E_PERAS_COBERTURA_DE_CHAO_ATIVA_SEM_GEADAS.getValor();
    	case 100: return TipoCultura.DAMASCOS_PESSEGOS_SEM_COBERTURA_DE_CHAO_COM_GEADAS.getValor();
    	case 101: return TipoCultura.DAMASCOS_PESSEGOS_SEM_COBERTURA_DE_CHAO_SEM_GEADAS.getValor();
    	case 102: return TipoCultura.DAMASCOS_PESSEGOS_COBERTURA_DE_CHAO_ATIVA_COM_GEADAS.getValor();
    	case 103: return TipoCultura.DAMASCOS_PESSEGOS_COBERTURA_DE_CHAO_ATIVA_SEM_GEADAS.getValor();
    	case 104: return TipoCultura.ABACATE_SEM_COBERTURA_DE_CHAO.getValor();
    	case 105: return TipoCultura.CITRUS_SEM_COBERTURA_DE_CHAO_70_DE_DOSSEL.getValor();
    	case 106: return TipoCultura.CITRUS_SEM_COBERTURA_DE_CHAO_50_DE_DOSSEL.getValor();
    	case 107: return TipoCultura.CITRUS_SEM_COBERTURA_DE_CHAO_20_DE_DOSSEL.getValor();
    	case 108: return TipoCultura.CITRUS_COBERTURA_DE_CHAO_ATIVA_OU_INVASORAS_70_DE_DOSSEL.getValor();
    	case 109: return TipoCultura.CITRUS_COBERTURA_DE_CHAO_ATIVA_OU_INVASORAS_50_DE_DOSSEL.getValor();
    	case 110: return TipoCultura.CITRUS_COBERTURA_DE_CHAO_ATIVA_OU_INVASORAS_20_DE_DOSSEL.getValor();
    	case 111: return TipoCultura.KIWI.getValor();
    	case 112: return TipoCultura.OLIVEIRA_40_A_60_DE_COBERTURA_DO_SOLO_PELO_DOSSEL.getValor();
    	case 113: return TipoCultura.PISTACHE_SEM_COBERTURA_DO_SOLO.getValor();
    	case 114: return TipoCultura.NOGUEIRA_POMARES.getValor();
    	case 115: return TipoCultura.CONIFERAS.getValor();
    	case 116: return TipoCultura.BANHADOS_COM_TABOAS_JUNCOS_COM_GEADAS.getValor();
    	case 117: return TipoCultura.BANHADOS_COM_TABOAS_JUNCOS_SEM_GEADAS.getValor();
    	case 118: return TipoCultura.BANHADOS_VEGETACAO_BAIXA_SEM_GEADAS.getValor();
    	case 119: return TipoCultura.PANTANO_BANHADOS_AGUA_ESTAGNADA.getValor();
    	case 120: return TipoCultura.PANTANO_BANHADO_SOLO_UMIDO.getValor();
    	case 121: return TipoCultura.CANA_DE_ACUCAR.getValor();
    	case 130: return TipoCultura.TRIGO.getValor();
    	case 1004: return TipoCultura.ABIU.getValor();
    	case 1005: return TipoCultura.ACAI.getValor();
    	case 1006: return TipoCultura.ACEROLA.getValor();
    	case 1007: return TipoCultura.AMEIXA.getValor();
    	case 1008: return TipoCultura.ARACA.getValor();
    	case 1009: return TipoCultura.ATEMOIA.getValor();
    	case 1013: return TipoCultura.BURITI.getValor();
    	case 1014: return TipoCultura.BURITIBA.getValor();
    	case 1015: return TipoCultura.CAJU.getValor();
    	case 1016: return TipoCultura.CAQUI.getValor();
    	case 1017: return TipoCultura.CARAMBOLA.getValor();
    	case 1018: return TipoCultura.CAJA.getValor();
    	case 1019: return TipoCultura.CAJAMANGA.getValor();
    	case 1020: return TipoCultura.COCO_VERDE.getValor();
    	case 1021: return TipoCultura.CUPUACU.getValor();
    	case 1022: return TipoCultura.FIGO.getValor();
    	case 1023: return TipoCultura.GOIABA.getValor();
    	case 1024: return TipoCultura.GRAVIOLA.getValor();
    	case 1025: return TipoCultura.JABOTICABA.getValor();
    	case 1026: return TipoCultura.JACA.getValor();
    	case 1027: return TipoCultura.JAMBO.getValor();
    	case 1028: return TipoCultura.JENIPAPO.getValor();
    	case 1029: return TipoCultura.JUCARA.getValor();
    	case 1031: return TipoCultura.LICHIA.getValor();
    	case 1034: return TipoCultura.MANGABA.getValor();
    	case 1035: return TipoCultura.MANGOSTAO.getValor();
    	case 1036: return TipoCultura.MAMAO.getValor();
    	case 1037: return TipoCultura.MANGA.getValor();
    	case 1038: return TipoCultura.MARACUJA.getValor();
    	case 1039: return TipoCultura.MURICI.getValor();
    	case 1040: return TipoCultura.NECTARINA.getValor();
    	case 1041: return TipoCultura.NOZ_MACADAMIA.getValor();
    	case 1042: return TipoCultura.PEQUI.getValor();
    	case 1043: return TipoCultura.PESSEGO.getValor();
    	case 1044: return TipoCultura.PINHA.getValor();
    	case 1045: return TipoCultura.PITANGA.getValor();
    	case 1046: return TipoCultura.PUPUNHA.getValor();
    	case 1047: return TipoCultura.RAMBUTAN.getValor();
    	case 1048: return TipoCultura.ROMA.getValor();
    	case 1049: return TipoCultura.SAPOTI.getValor();
    	case 1050: return TipoCultura.SERIGUELA.getValor();
    	case 1051: return TipoCultura.TAMARINDO.getValor();
    	case 1052: return TipoCultura.TANGERINA.getValor();
    	case 1054: return TipoCultura.UMBU.getValor();
    	case 1062: return TipoCultura.AIPIM.getValor();
    	case 1068: return TipoCultura.BATATINHA.getValor();
    	case 1071: return TipoCultura.CANELA.getValor();
    	case 1074: return TipoCultura.CHUCHU.getValor();
    	case 1075: return TipoCultura.COENTRO.getValor();
    	case 1076: return TipoCultura.COMINHO.getValor();
    	case 1079: return TipoCultura.INHAME.getValor();
    	case 1086: return TipoCultura.QUIABO.getValor();
    	case 1090: return TipoCultura.PIMENTA.getValor();
    	case 1092: return TipoCultura.MAXIXE.getValor();
    	case 1093: return TipoCultura.CARA.getValor();
    	case 1094: return TipoCultura.COUVE_OU_COUVE_SIMPLES.getValor();
    	case 1099: return TipoCultura.FEIJAO_VIGNA.getValor();
    	case 1103: return TipoCultura.ALGAROBA.getValor();
    	case 1105: return TipoCultura.FLORES.getValor();
    	case 1108: return TipoCultura.CROTALARIA_ARBUSTO.getValor();
    	case 1113: return TipoCultura.CAJARANA.getValor();
    	case 1115: return TipoCultura.BUCHA.getValor();
    	case 1116: return TipoCultura.VAGEM.getValor();
    	case 1117: return TipoCultura.COGUMELO.getValor();
    	case 1118: return TipoCultura.CEBOLINHA.getValor();
    	case 1119: return TipoCultura.SALSA.getValor();
    	case 1120: return TipoCultura.HORTALICAS.getValor();
    	case 1122: return TipoCultura.COCO_SECO.getValor();
    	case 1123: return TipoCultura.MILHO_VERDE.getValor();
    	case 1126: return TipoCultura.GILO.getValor();
    	case 1127: return TipoCultura.FUMO.getValor();
    	case 1129: return TipoCultura.POMAR.getValor();
    	case 1130: return TipoCultura.EUCALIPITO.getValor();
   		default:
    		return null;
    	}
	}
	
	//ANEXO 10 - TNP_CD- CÓDIGO IDENTIFICADOR DA NATUREZA DO PONTO
	public static String obterValorNaturezaPonto(int chave) {
    	switch (chave) {
	    	case 1: return NaturezaPonto.POCO_ESCAVADO_CACIMBA_CISTERNA.getValor();
	    	case 2: return NaturezaPonto.FONTE_NATURAL.getValor();
	    	case 3: return NaturezaPonto.LAGO.getValor();
	    	case 4: return NaturezaPonto.LAGOA.getValor();
	    	case 5: return NaturezaPonto.NASCENTE.getValor();
	    	case 6: return NaturezaPonto.PIEZOMETRO.getValor();
	    	case 7: return NaturezaPonto.POCO_AMAZONAS.getValor();
	    	case 8: return NaturezaPonto.POCO_COLETOR.getValor();
	    	case 9: return NaturezaPonto.POCO_PONTEIRA.getValor();
	    	case 10: return NaturezaPonto.POCO_TUBULAR.getValor();
	    	case 11: return NaturezaPonto.POCO_DE_MONITORAMENTO.getValor();
    		default:
	    		return null;
    	}
	}
	
	//ANEXO 11 - ASB_TPN_CD - CÓDIGO IDENTIFICADOR DO TIPO DE PENETRAÇÃO NO AQUÍFERO
	public static String obterValorTipoPenetracaoAquifero(int chave) {
    	switch (chave) {
    		case 1: return TipoPenetracaoAquifero.PARCIAL.getValor();
    		case 2: return TipoPenetracaoAquifero.TOTAL.getValor();
    		default:
	    		return null;
    	}
	}
	
	//ANEXO 12 - ASB_TCA_CD - CÓDIGO IDENTIFICADOR DO TIPO DE CONDIÇÃO DO AQUÍFERO
	public static String obterValorTipoCondicaoAquifero(int chave) {
    	switch (chave) {
	    	case 1: return TipoCondicaoAquifero.LIVRE.getValor();
	    	case 2: return TipoCondicaoAquifero.CONFINADO.getValor();
	    	case 3: return TipoCondicaoAquifero.SEMI_LIVRE.getValor();
	    	case 4: return TipoCondicaoAquifero.SEMI_CONFINADO.getValor();
    		default:
	    		return null;
    	}
	}
	
	//ANEXO 13 – TST_TTB_CD - CÓDIGO IDENTIFICADOR DO TIPO DE TESTE DE BOMBEAMENTO
	public static String obterValorTipoTesteBombeamento(int chave) {
    	switch (chave) {
    		case 1: return TipoTesteBombeamento.REBAIXAMENTO.getValor();
    		case 2: return TipoTesteBombeamento.RECARGA.getValor();
    		case 3: return TipoTesteBombeamento.ESCALONADO.getValor();
    		case 4: return TipoTesteBombeamento.RECUPERACAO_RESIDUAL.getValor();
    		case 5: return TipoTesteBombeamento.RECUPERACAO.getValor();
    		case 6: return TipoTesteBombeamento.CONTINUO.getValor();
    		default:
	    		return null;
    	}
	}
	
	//ANEXO 14 - TST_TMI_CD - CÓDIGO IDENTIFICADOR DO TIPO DE MÉTODO DE INTERPRETAÇÃO
	public static String obterValorTipoMetodoInterpretacao(int chave) {
    	switch (chave) {
	    	case 1: return TipoMetodoInterpretacao.ARON_SCOTT.getValor();
	    	case 2: return TipoMetodoInterpretacao.BOULTON.getValor();
	    	case 3: return TipoMetodoInterpretacao.BRUGGEMAN.getValor();
	    	case 4: return TipoMetodoInterpretacao.CHOW.getValor();
	    	case 5: return TipoMetodoInterpretacao.COOPER_JACOB.getValor();
	    	case 6: return TipoMetodoInterpretacao.DE_GLEE.getValor();
	    	case 7: return TipoMetodoInterpretacao.DIETZ.getValor();
	    	case 8: return TipoMetodoInterpretacao.ERNST_THIEM_WALTON.getValor();
	    	case 9: return TipoMetodoInterpretacao.GOSSELIN.getValor();
	    	case 10: return TipoMetodoInterpretacao.HANTUSH.getValor();
	    	case 11: return TipoMetodoInterpretacao.HANTUSH_JACOB.getValor();
	    	case 12: return TipoMetodoInterpretacao.HANTUSH_THEIS.getValor();
	    	case 13: return TipoMetodoInterpretacao.HANTUSH_THOMAS.getValor();
	    	case 14: return TipoMetodoInterpretacao.HUISMAN.getValor();
	    	case 15: return TipoMetodoInterpretacao.HUISMAN_KEMPERMAN.getValor();
	    	case 16: return TipoMetodoInterpretacao.HURR.getValor();
	    	case 17: return TipoMetodoInterpretacao.JACOB.getValor();
	    	case 18: return TipoMetodoInterpretacao.JACOB_LOHMAN.getValor();
	    	case 19: return TipoMetodoInterpretacao.LOGAN.getValor();
	    	case 20: return TipoMetodoInterpretacao.PAPADOPULOS_COOPER.getValor();
	    	case 21: return TipoMetodoInterpretacao.PONTO_DE_CULMINACAO.getValor();
	    	case 22: return TipoMetodoInterpretacao.RECUPERACAO_DE_THEIS.getValor();
	    	case 23: return TipoMetodoInterpretacao.STALLMAN.getValor();
	    	case 24: return TipoMetodoInterpretacao.STENBERG.getValor();
	    	case 25: return TipoMetodoInterpretacao.THEIS.getValor();
	    	case 26: return TipoMetodoInterpretacao.THIEM_DUPUIT.getValor();
	    	case 27: return TipoMetodoInterpretacao.THIEN.getValor();
	    	case 28: return TipoMetodoInterpretacao.ZANGAR.getValor();
    		default:
	    		return null;
    	}
	}
	
	//ANEXO 15 - AQP_CD - CÓDIGO IDENTIFICADOR DO AQUÍFERO PONTO
	public static String obterValorIdentificadorAquiferoPonto(int chave) {
    	switch (chave) {
	    	case 1: return IdentificadorAquiferoPonto.ACU_POROSO_NAO_DEFINIDA.getValor();
	    	case 2: return IdentificadorAquiferoPonto.ACU_POROSO_REGIONAL.getValor();
	    	case 3: return IdentificadorAquiferoPonto.ACUNGUI_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 4: return IdentificadorAquiferoPonto.ALGODOES_POROSO_NAO_DEFINIDA.getValor();
	    	case 5: return IdentificadorAquiferoPonto.ALIANCA_POROSO_NAO_DEFINIDA.getValor();
	    	case 6: return IdentificadorAquiferoPonto.ALTER_DO_CHAO_POROSO_LOCAL.getValor();
	    	case 7: return IdentificadorAquiferoPonto.ALUVIONAR_POROSO_NAO_DEFINIDA.getValor();
	    	case 8: return IdentificadorAquiferoPonto.ALUVIONAR_POROSO_LOCAL.getValor();
	    	case 9: return IdentificadorAquiferoPonto.ALUVIONAR_POROSO_REGIONAL.getValor();
	    	case 10: return IdentificadorAquiferoPonto.ALUVIONAR_POROSO_REGIONAL_LIMITADA.getValor();
	    	case 11: return IdentificadorAquiferoPonto.ANDRELANDIA_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 12: return IdentificadorAquiferoPonto.AQUIDAUANA_POROSO_NAO_DEFINIDA.getValor();
	    	case 13: return IdentificadorAquiferoPonto.AQUIDAUANA_POROSO_LOCAL.getValor();
	    	case 14: return IdentificadorAquiferoPonto.AQUIDAUANA_POROSO_REGIONAL_LIMITADA.getValor();
	    	case 15: return IdentificadorAquiferoPonto.ARAXA_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 16: return IdentificadorAquiferoPonto.ARAXA_FISSURAL_RESTRITO_A_ZONA_FRATURADA.getValor();
	    	case 17: return IdentificadorAquiferoPonto.BAMBUI_CARSTICO_NAO_DEFINIDA.getValor();
	    	case 18: return IdentificadorAquiferoPonto.BAMBUI_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 19: return IdentificadorAquiferoPonto.BAMBUI_POROSO_REGIONAL.getValor();
	    	case 20: return IdentificadorAquiferoPonto.BARBACENA_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 21: return IdentificadorAquiferoPonto.BARBACENA_POROSO_NAO_DEFINIDA.getValor();
	    	case 22: return IdentificadorAquiferoPonto.BARREIRAS_FISSURAL_RESTRITO_A_ZONA_FRATURADA.getValor();
	    	case 23: return IdentificadorAquiferoPonto.BARREIRAS_POROSO_NAO_DEFINIDA.getValor();
	    	case 24: return IdentificadorAquiferoPonto.BARREIRAS_POROSO_RESTRITO_A_ZONA_FRATURADA.getValor();
	    	case 25: return IdentificadorAquiferoPonto.BAURU_POROSO_NAO_DEFINIDA.getValor();
	    	case 26: return IdentificadorAquiferoPonto.BAURU_POROSO_LOCAL.getValor();
	    	case 27: return IdentificadorAquiferoPonto.BAURU_POROSO_REGIONAL.getValor();
	    	case 28: return IdentificadorAquiferoPonto.BAURU_POROSO_REGIONAL_LIMITADA.getValor();
	    	case 29: return IdentificadorAquiferoPonto.BEBEDOURO_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 30: return IdentificadorAquiferoPonto.BEBERIBE_POROSO_NAO_DEFINIDA.getValor();
	    	case 31: return IdentificadorAquiferoPonto.BEBERIBE_POROSO_REGIONAL.getValor();
	    	case 32: return IdentificadorAquiferoPonto.BENEFICIENTE_POROSO_REGIONAL.getValor();
	    	case 33: return IdentificadorAquiferoPonto.BOA_VISTA_POROSO_REGIONAL.getValor();
	    	case 34: return IdentificadorAquiferoPonto.BOTUCATU_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 35: return IdentificadorAquiferoPonto.BOTUCATU_POROSO_NAO_DEFINIDA.getValor();
	    	case 36: return IdentificadorAquiferoPonto.BOTUCATU_POROSO_LOCAL.getValor();
	    	case 37: return IdentificadorAquiferoPonto.BOTUCATU_POROSO_REGIONAL.getValor();
	    	case 38: return IdentificadorAquiferoPonto.BOTUCATU_POROSO_REGIONAL_LIMITADA.getValor();
	    	case 39: return IdentificadorAquiferoPonto.BOTUCATU_POROSO_RESTRITO_A_ZONA_FRATURADA.getValor();
	    	case 40: return IdentificadorAquiferoPonto.BREJO_SANTO_POROSO_NAO_DEFINIDA.getValor();
	    	case 41: return IdentificadorAquiferoPonto.BROTAS_POROSO_NAO_DEFINIDA.getValor();
	    	case 42: return IdentificadorAquiferoPonto.CAATINGA_CARSTICO_NAO_DEFINIDA.getValor();
	    	case 43: return IdentificadorAquiferoPonto.CABOCLO_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 44: return IdentificadorAquiferoPonto.CACAPAVA_POROSO_NAO_DEFINIDA.getValor();
	    	case 45: return IdentificadorAquiferoPonto.CACAPAVA_POROSO_REGIONAL.getValor();
	    	case 46: return IdentificadorAquiferoPonto.CAIUA_POROSO_REGIONAL.getValor();
	    	case 47: return IdentificadorAquiferoPonto.CAIUA_POROSO_REGIONAL_LIMITADA.getValor();
	    	case 48: return IdentificadorAquiferoPonto.CAMBAI_FISSURAL_RESTRITO_A_ZONA_FRATURADA.getValor();
	    	case 49: return IdentificadorAquiferoPonto.CANANEIA_POROSO_REGIONAL.getValor();
	    	case 50: return IdentificadorAquiferoPonto.CANDEIAS_POROSO_NAO_DEFINIDA.getValor();
	    	case 51: return IdentificadorAquiferoPonto.CANUDOS_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 52: return IdentificadorAquiferoPonto.CAPELINHA_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 53: return IdentificadorAquiferoPonto.CAPIM_GROSSO_POROSO_NAO_DEFINIDA.getValor();
	    	case 54: return IdentificadorAquiferoPonto.CARACA_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 55: return IdentificadorAquiferoPonto.CARAIBA_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 56: return IdentificadorAquiferoPonto.CARIRI_POROSO_NAO_DEFINIDA.getValor();
	    	case 57: return IdentificadorAquiferoPonto.CAUABURI_POROSO_REGIONAL.getValor();
	    	case 58: return IdentificadorAquiferoPonto.CAUE_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 59: return IdentificadorAquiferoPonto.CHAPADA_DIAMANTINA_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 60: return IdentificadorAquiferoPonto.CHAPADA_DIAMANTINA_POROSO_NAO_DEFINIDA.getValor();
	    	case 61: return IdentificadorAquiferoPonto.COBERTURA_CENOZOICA_POROSO_NAO_DEFINIDA.getValor();
	    	case 62: return IdentificadorAquiferoPonto.COBERTURA_CENOZOICA_POROSO_LOCAL.getValor();
	    	case 63: return IdentificadorAquiferoPonto.COBERTURA_CENOZOICA_POROSO_REGIONAL.getValor();
	    	case 64: return IdentificadorAquiferoPonto.COBERTURA_CENOZOICA_POROSO_REGIONAL_LIMITADA.getValor();
	    	case 65: return IdentificadorAquiferoPonto.CODO_POROSO_REGIONAL.getValor();
	    	case 66: return IdentificadorAquiferoPonto.COLOMI_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 67: return IdentificadorAquiferoPonto.COLUVIONAR_POROSO_NAO_DEFINIDA.getValor();
	    	case 68: return IdentificadorAquiferoPonto.COLUVIONAR_POROSO_LOCAL.getValor();
	    	case 69: return IdentificadorAquiferoPonto.COLUVIONAR_POROSO_REGIONAL.getValor();
	    	case 70: return IdentificadorAquiferoPonto.COUTO_MAGALHAES_POROSO_REGIONAL.getValor();
	    	case 71: return IdentificadorAquiferoPonto.CUIABA_FISSURAL_RESTRITO_A_ZONA_FRATURADA.getValor();
	    	case 72: return IdentificadorAquiferoPonto.CURUA_FISSURAL_REGIONAL.getValor();
	    	case 73: return IdentificadorAquiferoPonto.DIAMANTINO_POROSO_LOCAL.getValor();
	    	case 74: return IdentificadorAquiferoPonto.ELUVIONAR_POROSO_NAO_DEFINIDA.getValor();
	    	case 75: return IdentificadorAquiferoPonto.ELUVIONAR_POROSO_LOCAL.getValor();
	    	case 76: return IdentificadorAquiferoPonto.ESPINHACO_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 77: return IdentificadorAquiferoPonto.ESPINHACO_FISSURAL_RESTRITO_A_ZONA_FRATURADA.getValor();
	    	case 78: return IdentificadorAquiferoPonto.ESTRADA_NOVA_POROSO_REGIONAL.getValor();
	    	case 79: return IdentificadorAquiferoPonto.ESTRONDO_FISSURAL_RESTRITO_A_ZONA_FRATURADA.getValor();
	    	case 80: return IdentificadorAquiferoPonto.EXU_POROSO_NAO_DEFINIDA.getValor();
	    	case 81: return IdentificadorAquiferoPonto.FACEIRA_POROSO_NAO_DEFINIDA.getValor();
	    	case 82: return IdentificadorAquiferoPonto.FURNAS_POROSO_REGIONAL.getValor();
	    	case 83: return IdentificadorAquiferoPonto.FURNAS_POROSO_REGIONAL_LIMITADA.getValor();
	    	case 84: return IdentificadorAquiferoPonto.GRAO_PARA_FISSURAL_REGIONAL.getValor();
	    	case 85: return IdentificadorAquiferoPonto.GUATA_POROSO_REGIONAL.getValor();
	    	case 86: return IdentificadorAquiferoPonto.GUIANENSE_FISSURAL_REGIONAL.getValor();
	    	case 87: return IdentificadorAquiferoPonto.ILHAS_POROSO_NAO_DEFINIDA.getValor();
	    	case 88: return IdentificadorAquiferoPonto.INAJA_POROSO_NAO_DEFINIDA.getValor();
	    	case 89: return IdentificadorAquiferoPonto.IRAJAI_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 90: return IdentificadorAquiferoPonto.IRATI_POROSO_REGIONAL.getValor();
	    	case 91: return IdentificadorAquiferoPonto.ITABIRA_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 92: return IdentificadorAquiferoPonto.ITAITUBA_POROSO_LOCAL.getValor();
	    	case 93: return IdentificadorAquiferoPonto.ITAPARICA_POROSO_NAO_DEFINIDA.getValor();
	    	case 94: return IdentificadorAquiferoPonto.ITAPECURU_POROSO_LOCAL.getValor();
	    	case 95: return IdentificadorAquiferoPonto.ITAPECURU_POROSO_REGIONAL.getValor();
	    	case 96: return IdentificadorAquiferoPonto.ITARARE_POROSO_NAO_DEFINIDA.getValor();
	    	case 97: return IdentificadorAquiferoPonto.ITARARE_POROSO_LOCAL.getValor();
	    	case 98: return IdentificadorAquiferoPonto.ITARARE_POROSO_REGIONAL.getValor();
	    	case 99: return IdentificadorAquiferoPonto.JACIPARANA_POROSO_REGIONAL_LIMITADA.getValor();
	    	case 100: return IdentificadorAquiferoPonto.JACIPARANA_POROSO_RESTRITO_A_ZONA_FRATURADA.getValor();
	    	case 101: return IdentificadorAquiferoPonto.JACOBINA_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 102: return IdentificadorAquiferoPonto.JAIBARAS_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 103: return IdentificadorAquiferoPonto.JANDAIRA_CARSTICO_NAO_DEFINIDA.getValor();
	    	case 104: return IdentificadorAquiferoPonto.JANDAIRA_CARSTICO_REGIONAL.getValor();
	    	case 105: return IdentificadorAquiferoPonto.JUA_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 106: return IdentificadorAquiferoPonto.JUIZ_DE_FORA_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 107: return IdentificadorAquiferoPonto.MACAUBAS_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 108: return IdentificadorAquiferoPonto.MACAUBAS_POROSO_NAO_DEFINIDA.getValor();
	    	case 109: return IdentificadorAquiferoPonto.MACURURE_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 110: return IdentificadorAquiferoPonto.MAECURU_POROSO_REGIONAL.getValor();
	    	case 111: return IdentificadorAquiferoPonto.MANTIQUEIRA_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 112: return IdentificadorAquiferoPonto.MARIZAL_POROSO_NAO_DEFINIDA.getValor();
	    	case 113: return IdentificadorAquiferoPonto.MASSACARA_POROSO_NAO_DEFINIDA.getValor();
	    	case 114: return IdentificadorAquiferoPonto.MATA_DA_CORDA_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 115: return IdentificadorAquiferoPonto.MATA_DA_CORDA_POROSO_NAO_DEFINIDA.getValor();
	    	case 116: return IdentificadorAquiferoPonto.MAURITI_POROSO_NAO_DEFINIDA.getValor();
	    	case 117: return IdentificadorAquiferoPonto.MIABA_CARSTICO_NAO_DEFINIDA.getValor();
	    	case 118: return IdentificadorAquiferoPonto.MINAS_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 119: return IdentificadorAquiferoPonto.MISSAO_VELHA_POROSO_NAO_DEFINIDA.getValor();
	    	case 120: return IdentificadorAquiferoPonto.MONTE_ALEGRE_POROSO_LOCAL.getValor();
	    	case 121: return IdentificadorAquiferoPonto.MORRO_DO_CHAPEU_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 122: return IdentificadorAquiferoPonto.NOVA_LIMA_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 123: return IdentificadorAquiferoPonto.OLHOS_D_AGUA_CARSTICO_NAO_DEFINIDA.getValor();
	    	case 124: return IdentificadorAquiferoPonto.OURICURI_DO_OURO_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 125: return IdentificadorAquiferoPonto.PALERMO_POROSO_REGIONAL.getValor();
	    	case 126: return IdentificadorAquiferoPonto.PARAGUACU_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 127: return IdentificadorAquiferoPonto.PARAIBA_DO_SUL_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 128: return IdentificadorAquiferoPonto.PARANOA_FISSURAL_RESTRITO_A_ZONA_FRATURADA.getValor();
	    	case 129: return IdentificadorAquiferoPonto.PARAOPEBA_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 130: return IdentificadorAquiferoPonto.PARAOPEBA_CARSTICO_NAO_DEFINIDA.getValor();
	    	case 131: return IdentificadorAquiferoPonto.PARECIS_POROSO_REGIONAL.getValor();
	    	case 132: return IdentificadorAquiferoPonto.PARECIS_POROSO_REGIONAL_LIMITADA.getValor();
	    	case 133: return IdentificadorAquiferoPonto.PASSA_DOIS_POROSO_NAO_DEFINIDA.getValor();
	    	case 134: return IdentificadorAquiferoPonto.PASSA_DOIS_POROSO_LOCAL.getValor();
	    	case 135: return IdentificadorAquiferoPonto.PASSA_DOIS_POROSO_REGIONAL.getValor();
	    	case 136: return IdentificadorAquiferoPonto.PASSA_DOIS_POROSO_REGIONAL_LIMITADA.getValor();
	    	case 137: return IdentificadorAquiferoPonto.PIAUI_FISSURAL_REGIONAL.getValor();
	    	case 138: return IdentificadorAquiferoPonto.PIMENTA_BUENO_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 139: return IdentificadorAquiferoPonto.PIMENTA_BUENO_FISSURAL_RESTRITO_A_ZONA_FRATURADA.getValor();
	    	case 140: return IdentificadorAquiferoPonto.PIRABAS_POROSO_LOCAL.getValor();
	    	case 141: return IdentificadorAquiferoPonto.PIRACICABA_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 142: return IdentificadorAquiferoPonto.PONTA_GROSSA_POROSO_LOCAL.getValor();
	    	case 143: return IdentificadorAquiferoPonto.PONTA_GROSSA_POROSO_REGIONAL_LIMITADA.getValor();
	    	case 144: return IdentificadorAquiferoPonto.PORONGOS_FISSURAL_RESTRITO_A_ZONA_FRATURADA.getValor();
	    	case 145: return IdentificadorAquiferoPonto.RIO_BONITO_POROSO_NAO_DEFINIDA.getValor();
	    	case 146: return IdentificadorAquiferoPonto.RIO_BONITO_POROSO_REGIONAL.getValor();
	    	case 147: return IdentificadorAquiferoPonto.RIO_DA_BATATEIRA_POROSO_NAO_DEFINIDA.getValor();
	    	case 148: return IdentificadorAquiferoPonto.RIO_DAS_VELHAS_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 149: return IdentificadorAquiferoPonto.RIO_DO_RASTRO_POROSO_REGIONAL.getValor();
	    	case 150: return IdentificadorAquiferoPonto.RIO_DO_SUL_POROSO_REGIONAL.getValor();
	    	case 151: return IdentificadorAquiferoPonto.RIO_DOS_REMEDIOS_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 152: return IdentificadorAquiferoPonto.RIO_GUAMA_POROSO_LOCAL.getValor();
	    	case 153: return IdentificadorAquiferoPonto.RIO_PARDO_CARSTICO_NAO_DEFINIDA.getValor();
	    	case 154: return IdentificadorAquiferoPonto.RIO_PRETO_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 155: return IdentificadorAquiferoPonto.ROCHA_CRISTALINA_CARSTICO_NAO_DEFINIDA.getValor();
	    	case 156: return IdentificadorAquiferoPonto.ROCHA_CRISTALINA_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 157: return IdentificadorAquiferoPonto.ROCHA_CRISTALINA_FISSURAL_LOCAL.getValor();
	    	case 158: return IdentificadorAquiferoPonto.ROCHA_CRISTALINA_FISSURAL_REGIONAL.getValor();
	    	case 159: return IdentificadorAquiferoPonto.ROCHA_CRISTALINA_FISSURAL_REGIONAL_LIMITADA.getValor();
	    	case 160: return IdentificadorAquiferoPonto.ROCHA_CRISTALINA_FISSURAL_RESTRITO_A_ZONA_FRATURADA.getValor();
	    	case 161: return IdentificadorAquiferoPonto.ROCHA_SEDIMENTAR_CARSTICO_NAO_DEFINIDA.getValor();
	    	case 162: return IdentificadorAquiferoPonto.ROCHA_SEDIMENTAR_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 163: return IdentificadorAquiferoPonto.ROCHA_SEDIMENTAR_POROSO_NAO_DEFINIDA.getValor();
	    	case 164: return IdentificadorAquiferoPonto.ROCHA_SEDIMENTAR_POROSO_LOCAL.getValor();
	    	case 165: return IdentificadorAquiferoPonto.ROCHA_SEDIMENTAR_POROSO_REGIONAL.getValor();
	    	case 166: return IdentificadorAquiferoPonto.ROCHA_SEDIMENTAR_POROSO_REGIONAL_LIMITADA.getValor();
	    	case 167: return IdentificadorAquiferoPonto.ROCHA_SEDIMENTAR_POROSO_RESTRITO_A_ZONA_FRATURADA.getValor();
	    	case 168: return IdentificadorAquiferoPonto.ROSARIO_DO_SUL_POROSO_REGIONAL_LIMITADA.getValor();
	    	case 169: return IdentificadorAquiferoPonto.SALITRE_CARSTICO_NAO_DEFINIDA.getValor();
	    	case 170: return IdentificadorAquiferoPonto.SALVADOR_POROSO_NAO_DEFINIDA.getValor();
	    	case 171: return IdentificadorAquiferoPonto.SANTA_CRUZ_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 172: return IdentificadorAquiferoPonto.SANTA_HELENA_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 173: return IdentificadorAquiferoPonto.SANTANA_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 174: return IdentificadorAquiferoPonto.SANTO_ONOFRE_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 175: return IdentificadorAquiferoPonto.SAO_PAULO_POROSO_LOCAL.getValor();
	    	case 176: return IdentificadorAquiferoPonto.SAO_PAULO_POROSO_REGIONAL.getValor();
	    	case 177: return IdentificadorAquiferoPonto.SAO_PAULO_POROSO_REGIONAL_LIMITADA.getValor();
	    	case 178: return IdentificadorAquiferoPonto.SAO_SEBASTIAO_POROSO_NAO_DEFINIDA.getValor();
	    	case 179: return IdentificadorAquiferoPonto.SAO_SEBASTIAO_POROSO_REGIONAL_LIMITADA.getValor();
	    	case 180: return IdentificadorAquiferoPonto.SEDIMENTO_COSTEIRO_POROSO_REGIONAL.getValor();
	    	case 181: return IdentificadorAquiferoPonto.SEDIMENTO_COSTEIRO_POROSO_REGIONAL_LIMITADA.getValor();
	    	case 182: return IdentificadorAquiferoPonto.SEDIMENTO_INCONSOLIDADO_POROSO_NAO_DEFINIDA.getValor();
	    	case 183: return IdentificadorAquiferoPonto.SERGI_POROSO_NAO_DEFINIDA.getValor();
	    	case 184: return IdentificadorAquiferoPonto.SERIDO_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 185: return IdentificadorAquiferoPonto.SERRA_DA_BOA_ESPERANCA_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 186: return IdentificadorAquiferoPonto.SERRA_DO_PARAISO_CARSTICO_NAO_DEFINIDA.getValor();
	    	case 187: return IdentificadorAquiferoPonto.SERRA_GERAL_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 188: return IdentificadorAquiferoPonto.SERRA_GERAL_FISSURAL_LOCAL.getValor();
	    	case 189: return IdentificadorAquiferoPonto.SERRA_GERAL_FISSURAL_REGIONAL.getValor();
	    	case 190: return IdentificadorAquiferoPonto.SERRA_GERAL_FISSURAL_REGIONAL_LIMITADA.getValor();
	    	case 191: return IdentificadorAquiferoPonto.SERRA_GERAL_FISSURAL_RESTRITO_A_ZONA_FRATURADA.getValor();
	    	case 192: return IdentificadorAquiferoPonto.SERRA_GERAL_POROSO_RESTRITO_A_ZONA_FRATURADA.getValor();
	    	case 193: return IdentificadorAquiferoPonto.SERRA_GRANDE_POROSO_NAO_DEFINIDA.getValor();
	    	case 194: return IdentificadorAquiferoPonto.SERRA_GRANDE_POROSO_RESTRITO_A_ZONA_FRATURADA.getValor();
	    	case 195: return IdentificadorAquiferoPonto.SERTANIA_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 196: return IdentificadorAquiferoPonto.SETE_LAGOAS_CARSTICO_NAO_DEFINIDA.getValor();
	    	case 197: return IdentificadorAquiferoPonto.SETE_LAGOAS_CARSTICO_REGIONAL_LIMITADA.getValor();
	    	case 198: return IdentificadorAquiferoPonto.SOLIMOES_POROSO_REGIONAL.getValor();
	    	case 199: return IdentificadorAquiferoPonto.SOLIMOES_POROSO_REGIONAL_LIMITADA.getValor();
	    	case 200: return IdentificadorAquiferoPonto.SOUZA_POROSO_NAO_DEFINIDA.getValor();
	    	case 201: return IdentificadorAquiferoPonto.TACARATU_POROSO_NAO_DEFINIDA.getValor();
	    	case 202: return IdentificadorAquiferoPonto.TACARATU_POROSO_REGIONAL.getValor();
	    	case 203: return IdentificadorAquiferoPonto.TAUBATE_POROSO_NAO_DEFINIDA.getValor();
	    	case 204: return IdentificadorAquiferoPonto.TAUBATE_POROSO_REGIONAL.getValor();
	    	case 205: return IdentificadorAquiferoPonto.TAUBATE_POROSO_REGIONAL_LIMITADA.getValor();
	    	case 206: return IdentificadorAquiferoPonto.TOMBADOR_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 207: return IdentificadorAquiferoPonto.TREMEMBE_POROSO_NAO_DEFINIDA.getValor();
	    	case 208: return IdentificadorAquiferoPonto.TRES_MARIAS_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 209: return IdentificadorAquiferoPonto.TRES_MARIAS_POROSO_NAO_DEFINIDA.getValor();
	    	case 210: return IdentificadorAquiferoPonto.TUBARAO_POROSO_NAO_DEFINIDA.getValor();
	    	case 211: return IdentificadorAquiferoPonto.TUBARAO_POROSO_LOCAL.getValor();
	    	case 212: return IdentificadorAquiferoPonto.TUBARAO_POROSO_REGIONAL.getValor();
	    	case 213: return IdentificadorAquiferoPonto.TUBARAO_POROSO_REGIONAL_LIMITADA.getValor();
	    	case 214: return IdentificadorAquiferoPonto.TUPANCIRETA_POROSO_REGIONAL_LIMITADA.getValor();
	    	case 215: return IdentificadorAquiferoPonto.UBAJARA_POROSO_NAO_DEFINIDA.getValor();
	    	case 216: return IdentificadorAquiferoPonto.URUCUIA_POROSO_NAO_DEFINIDA.getValor();
	    	case 217: return IdentificadorAquiferoPonto.URUCUIA_POROSO_REGIONAL.getValor();
	    	case 218: return IdentificadorAquiferoPonto.VARGINHA_GUAXUPE_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 219: return IdentificadorAquiferoPonto.XINGU_FISSURAL_REGIONAL_LIMITADA.getValor();
	    	case 220: return IdentificadorAquiferoPonto.XINGU_POROSO_REGIONAL.getValor();
	    	case 221: return IdentificadorAquiferoPonto.XINGU_POROSO_REGIONAL_LIMITADA.getValor();
	    	case 222: return IdentificadorAquiferoPonto.CABECAS_POROSO_NAO_DEFINIDA.getValor();
	    	case 223: return IdentificadorAquiferoPonto.CASA_NOVA_POROSO_NAO_DEFINIDA.getValor();
	    	case 224: return IdentificadorAquiferoPonto.CORDA_POROSO_NAO_DEFINIDA.getValor();
	    	case 225: return IdentificadorAquiferoPonto.FEIRA_NOVA_POROSO_NAO_DEFINIDA.getValor();
	    	case 226: return IdentificadorAquiferoPonto.GRAJAU_POROSO_NAO_DEFINIDA.getValor();
	    	case 227: return IdentificadorAquiferoPonto.LONGA_POROSO_NAO_DEFINIDA.getValor();
	    	case 228: return IdentificadorAquiferoPonto.MOSQUITO_POROSO_NAO_DEFINIDA.getValor();
	    	case 229: return IdentificadorAquiferoPonto.MOTUCA_POROSO_NAO_DEFINIDA.getValor();
	    	case 230: return IdentificadorAquiferoPonto.NAO_DEFINIDO_POROSO_NAO_DEFINIDA.getValor();
	    	case 231: return IdentificadorAquiferoPonto.PASTOS_BONS_POROSO_NAO_DEFINIDA.getValor();
	    	case 232: return IdentificadorAquiferoPonto.PEDRA_DE_FOGO_POROSO_NAO_DEFINIDA.getValor();
	    	case 233: return IdentificadorAquiferoPonto.PIMENTEIRAS_POROSO_NAO_DEFINIDA.getValor();
	    	case 234: return IdentificadorAquiferoPonto.SAMBAIBA_POROSO_NAO_DEFINIDA.getValor();
	    	case 235: return IdentificadorAquiferoPonto.SANTO_AMARO_POROSO_NAO_DEFINIDA.getValor();
	    	case 236: return IdentificadorAquiferoPonto.SAO_JULIAO_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 237: return IdentificadorAquiferoPonto.SARAIVA_POROSO_NAO_DEFINIDA.getValor();
	    	case 238: return IdentificadorAquiferoPonto.SARDINHA_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 239: return IdentificadorAquiferoPonto.NAO_DEFINIDO_CARSTICO_NAO_DEFINIDA.getValor();
	    	case 240: return IdentificadorAquiferoPonto.NAO_DEFINIDO_FISSURAL_NAO_DEFINIDA.getValor();
	    	case 241: return IdentificadorAquiferoPonto.NAO_DEFINIDO_NAO_DEFINIDO_NAO_DEFINIDA.getValor();
	    	case 242: return IdentificadorAquiferoPonto.BOA_VIAGEM_POROSO_LOCAL.getValor();
	   		default:
	    		return null;
    	}
	}	
	
}

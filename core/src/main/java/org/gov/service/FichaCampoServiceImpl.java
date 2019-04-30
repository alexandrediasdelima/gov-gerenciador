package org.gov.service;

import java.util.List;

import org.gov.dao.FichaCampoDao;
import org.gov.dao.FichaCampoDaoImpl;
import org.gov.model.FichaCampo;
import org.gov.model.Interferencia;
import org.gov.model.SituacaoInterferencia;
import org.gov.model.TipoFinalidade;
import org.gov.model.TipoInterferencia;
import org.gov.model.TipoOutroUso;


public class FichaCampoServiceImpl implements FichaCampoService{

	/**
	 *
	 */

	private FichaCampoDao fichaCampoDao;

	public List<FichaCampo> fichasCampo() {
		fichaCampoDao = new FichaCampoDaoImpl();
		List<FichaCampo> fichasCampo = fichaCampoDao.fichasCampo();
		
//		for (int i=0; i < fichasCampo.size(); i++) {
//			
//			if(fichasCampo.get(i).getInt_tin_cd() != null && !"".equals(fichasCampo.get(i).getInt_tin_cd())) {
//				fichasCampo.get(i).setInt_tin_cd(obterValorTipoInterferencia(Integer.valueOf(fichasCampo.get(i).getInt_tin_cd())));
//			}
//			
//			if(fichasCampo.get(i).getInt_tsi_cd() != null && !"".equals(fichasCampo.get(i).getInt_tsi_cd())) {
//				fichasCampo.get(i).setInt_tsi_cd(obterValorSituacaoInterferencia(Integer.valueOf(fichasCampo.get(i).getInt_tsi_cd())));
//			}
//			
//			if(fichasCampo.get(i).getFou_tou_cd() != null && !"".equals(fichasCampo.get(i).getFou_tou_cd())) {
//				fichasCampo.get(i).setFou_tou_cd(obterValorTipoOutroUso(Integer.valueOf(fichasCampo.get(i).getFou_tou_cd())));
//			}
//			
//			if(fichasCampo.get(i).getFin_tfn_cd() != null && !"".equals(fichasCampo.get(i).getFin_tfn_cd())) {
//				fichasCampo.get(i).setFin_tfn_cd(obterValorTipoFinalidade(Integer.valueOf(fichasCampo.get(i).getFin_tfn_cd())));
//			}
			
//		}
		return fichasCampo;
	}

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
	
	public static String obterValorTipoOutroUso(int chave) {
    	switch (chave) {
    	case 51: return TipoOutroUso.ABASTECIMENTO_DE_PULVERIZADORES.getValor();
    	case 39: return TipoOutroUso.BALNEARIO_LAZER_E_CLUBE.getValor();
    	case 22: return TipoOutroUso.CLARIFICACAO_DA_AGUA.getValor();
    	case 45: return TipoOutroUso.COMBATE_A_INCENDIO.getValor();
    	case 54: return TipoOutroUso.CONSTRUCAO_CIVIL.getValor();
    	case 26: return TipoOutroUso.DEPURACAO_DE_EFLUENTES.getValor();
    	case 27: return TipoOutroUso.DISPOSICAO_DE_REJEITOS.getValor();
    	case 1:  return TipoOutroUso.ECLUSA.getValor();
    	case 49: return TipoOutroUso.HORTAS_POMARES_JARDINS_PAISAGISMO.getValor();
    	case 21: return TipoOutroUso.LAVAGEM_DE_VEICULOS.getValor();
    	case 44: return TipoOutroUso.LAVANDERIA.getValor();
    	case 29: return TipoOutroUso.PESQUISA_HIDROGEOLOGICA.getValor();
    	case 28: return TipoOutroUso.PESQUISA_MINERAL.getValor();
    	case 14: return TipoOutroUso.POCO_DE_BOMBEAMENTO_DE_RECUPERACAO_AMBIENTAL.getValor();
    	case 16: return TipoOutroUso.POCO_DE_INJECAO_PARA_RECUPERACAO_AMBIENTAL.getValor();
    	case 15: return TipoOutroUso.POCO_DE_MONITORAMENTO.getValor();
    	case 32: return TipoOutroUso.REBAIXAMENTO_DE_AQUIFERO.getValor();
    	case 30: return TipoOutroUso.RECIRCULACAO_DE_AGUA.getValor();
    	case 2:  return TipoOutroUso.RECREACAO.getValor();
    	case 3:  return TipoOutroUso.SALVAMENTO.getValor();
    	case 19: return TipoOutroUso.SISTEMA_DE_RESFRIAMENTO.getValor();
    	case 50: return TipoOutroUso.TESTE_HIDROSTATICO.getValor();
    	case 17: return TipoOutroUso.UMECTACAO_DE_VIAS.getValor();
    	case 31: return TipoOutroUso.URBANIZACAO.getValor();
    	case 53: return TipoOutroUso.OUTRO.getValor();
	    	default:
	    		return null;
    	}
	}
	
	public static String obterValorTipoFinalidade(int chave) {
    	switch (chave) {
    	case 1:  return TipoFinalidade.ABASTECIMENTO_PUBLICO.getValor();
    	case 10: return TipoFinalidade.APROVEITAMENTO_HIDROELETRICO.getValor();
    	case 7:  return TipoFinalidade.AQUICULTURA_EM_TANQUE_ESCAVADO.getValor();
    	case 18: return TipoFinalidade.AQUICULTURA_EM_TANQUE_REDE.getValor();
    	case 12: return TipoFinalidade.CONSUMO_HUMANO.getValor();
    	case 6:  return TipoFinalidade.CRIACAO_ANIMAL.getValor();
    	case 2:  return TipoFinalidade.ESGOTAMENTO_SANITARIO.getValor();
    	case 3:  return TipoFinalidade.INDUSTRIA.getValor();
    	case 5:  return TipoFinalidade.IRRIGACAO.getValor();
    	case 4:  return TipoFinalidade.MINERACAO_EXTRACAO.getValor();
    	case 13: return TipoFinalidade.MINERACAO_OUTROS.getValor();
    	case 15: return TipoFinalidade.OBRAS_HIDRAULICAS.getValor();
    	case 11: return TipoFinalidade.RESERVATORIO.getValor();
    	case 0:  return TipoFinalidade.SEM_FINALIDADE.getValor();
    	case 16: return TipoFinalidade.SERVICOS.getValor();
    	case 8:  return TipoFinalidade.TERMOELETRICA.getValor();
    	case 9:  return TipoFinalidade.TRANSPOSICAO.getValor();
    	case 99: return TipoFinalidade.OUTRAS.getValor();
    	default:
    		return null;
    	}
	}
	
	
}

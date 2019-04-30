package org.gov.web.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.gov.model.Apac;
import org.gov.model.Cnarh;
import org.gov.model.Empreendimento;
import org.gov.model.Interferencia;
import org.gov.model.Usuario;
import org.gov.service.ApacServiceImpl;
import org.gov.service.InterferenciaService;
import org.gov.service.InterferenciaServiceImpl;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;




public class InterferenciaBean extends Controller  {


	/**
	 *
	 */
	//private static final long serialVersionUID = 1L;

	private Interferencia interferencia;
	private List<Interferencia> interferencias;
	private InterferenciaService interferenciaService;
	private List<Interferencia> filteredInterferencias;
	private List<Cnarh> cnarhs;
	private List<Apac> processos;
	private List<Empreendimento> empreendimentos;
	private transient UploadedFile fotoCapturaGeral;
	private transient UploadedFile fotoCapturaDetalhe;
	private transient UploadedFile fotoCroqui;
	private boolean isOutroUso;
	
	private transient FileInputStream fis;
	private transient byte[] array;
	
	
	public InterferenciaBean() throws IOException  {
		setInterferencia(new Interferencia());
		interferenciaService = new InterferenciaServiceImpl();
		interferencias = new ArrayList<Interferencia>();
		cnarhs = new ArrayList<Cnarh>();
		processos = new ArrayList<Apac>();
		empreendimentos = new ArrayList<Empreendimento>();
		interferencias();
	}
	
	public String interferencias() throws IOException  {
		interferencias = interferenciaService.interferencias();
		setView(LIST);
		
//		String mimeType = "image/jpg";
//		File file = new File("C:\\import_cad\\imagens\\15564982740071536680806557.jpg");
//		ByteArrayOutputStream out = new ByteArrayOutputStream();
//		setFis(new FileInputStream(file));
//		int b;
//		
//		while((b = getFis().read()) > -1) {
//			out.write(b);
//		}
//		out.close();
//		getFis().close();
//		setArray(out.toByteArray());
		
		return eval(index());
	}

	public String gravar() throws IOException  {
		if(getCnarhs().size() == 0) {
			this.interferencia.setCnarh_id(null);
		}
		if(getProcessos().size() == 0) {
			this.interferencia.setOut_nu_processo(null);
		}

		interferencia.setFot_cap_lanc_geral(gravarArquivoServidor(fotoCapturaGeral));
		interferencia.setFot_cap_lanc_detalhe(gravarArquivoServidor(fotoCapturaDetalhe));
		interferencia.setFot_croqui_localizacao(gravarArquivoServidor(fotoCroqui));

		interferenciaService.gravar(interferencia);
		interferencias();
		return eval(index());
	}

	public String adicionarNovo() {
		setView(ADD);
		limparForm();
		this.setCnarhs(interferenciaService.cnarhs());
		this.setProcessos(interferenciaService.processos());
		this.setEmpreendimentos(interferenciaService.empreendimentos());
		return eval(index());
	}

	public String telaEditar(Interferencia interferencia) {
		this.interferencia = interferencia;
		setView(EDIT);
		return eval(index());
	}

	public String editar() throws IOException  {
		interferenciaService.editar(interferencia);
		interferencias();

		return eval(index());
	}

	public String deletar() throws IOException  {
		interferenciaService.remover(interferencia.getInt_id());
		interferencias();
		return eval(index());
	}

	private void limparForm() {
		this.interferencia.setInt_id(null);
		this.interferencia.setApa_est_hidrologico(null);
		this.interferencia.setFot_cap_lanc_geral(null);
		this.interferencia.setInt_cr_latitude(null);
		this.interferencia.setInt_cr_longitude(null);
		this.interferencia.setFot_cap_lanc_detalhe(null);
		this.interferencia.setFot_croqui_localizacao(null);
		this.interferencia.setApa_curso_barragem(null);
		this.interferencia.setApa_manancial(null);
		this.interferencia.setApa_barragem(null);
		this.interferencia.setApa_cap_maxacumula(null);
		this.interferencia.setApa_bacia(null);
		this.interferencia.setCnarh_id(null);
		this.interferencia.setOut_nu_processo(null);
		this.interferencia.setEmp_id(null);
		this.interferencia.setFin_tfn_cd(null);
		this.interferencia.setFou_tou_cd(null);
		this.interferencia.setInt_tin_cd(null);
		this.interferencia.setFou_tou_tp_outro(null);
		this.interferencia.setInt_tsi_cd(null);
	}

	private String gravarArquivoServidor (UploadedFile file) {

		String nomeArquivo = null;

		if(file != null) {

		    nomeArquivo =  new Date().getTime() + file.getFileName();

        	String caminhoDestinoArquivo = "C:/import_cad/imagens/" + nomeArquivo;

        	boolean transferenciaSucesso = false;
        	try {
				transferenciaSucesso = copyFile(file.getInputstream(), caminhoDestinoArquivo);
			} catch (IOException e) {

				e.printStackTrace();
			}

        	if(transferenciaSucesso) {
        		FacesMessage message = new FacesMessage("Sucesso", file.getFileName() + " Enviado");
        		FacesContext.getCurrentInstance().addMessage(null, message);
        	} else {
        		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao carregar arquivo", ""));
        	}
        }

		return nomeArquivo;
	}


	   private boolean copyFile(InputStream is, String outFile) {

		      OutputStream os = null;
		      byte[] buffer;
		      boolean success = true;
		      try {
		         os = new FileOutputStream(outFile);

		         buffer = new byte[is.available()];
		         is.read(buffer);
		         os.write(buffer);



		      } catch (IOException e) {
		         success = false;
		      } catch (OutOfMemoryError e) {
		         success = false;
		      } finally {
		         try {
		            if (is != null) {
		               is.close();
		            }
		            if (os != null) {
		               os.close();
		            }
		         } catch (IOException e) {}
		      }
		      return success;
		   }

	public void apresentarOutroUso() {
		if ("53".equals(interferencia.getFou_tou_cd())) {
			isOutroUso = true;
		} else {
			isOutroUso = false;
		}
	}

	public String voltar() {
		return "/interferencia/index";
	}

	public String index() {
		return "/interferencia/index";
	}

	public Interferencia getInterferencia() {
		return interferencia;
	}

	public void setInterferencia(Interferencia interferencia) {
		this.interferencia = interferencia;
	}

	public List<Interferencia> getInterferencias() {
		return interferencias;
	}


	public void setInterferencias(List<Interferencia> interferencias) {
		this.interferencias = interferencias;
	}

	public List<Interferencia> getFilteredInterferencias() {
		return filteredInterferencias;
	}

	public void setFilteredInterferencias(List<Interferencia> filteredInterferencias) {
		this.filteredInterferencias = filteredInterferencias;
	}

	public Boolean getIsOutroUso() {
		return isOutroUso;
	}

	public void setIsOutroUso(Boolean isOutroUso) {
		this.isOutroUso = isOutroUso;
	}

	public List<Cnarh> getCnarhs() {
		return cnarhs;
	}

	public void setCnarhs(List<Cnarh> cnarhs) {
		this.cnarhs = cnarhs;
	}

	public List<Apac> getProcessos() {
		return processos;
	}

	public void setProcessos(List<Apac> processos) {
		this.processos = processos;
	}

	public List<Empreendimento> getEmpreendimentos() {
		return empreendimentos;
	}

	public void setEmpreendimentos(List<Empreendimento> empreendimentos) {
		this.empreendimentos = empreendimentos;
	}

	public UploadedFile getFotoCapturaGeral() {
		return fotoCapturaGeral;
	}

	public void setFotoCapturaGeral(UploadedFile fotoCapturaGeral) {
		this.fotoCapturaGeral = fotoCapturaGeral;
	}
	public UploadedFile getFotoCapturaDetalhe() {
		return fotoCapturaDetalhe;
	}

	public void setFotoCapturaDetalhe(UploadedFile fotoCapturaDetalhe) {
		this.fotoCapturaDetalhe = fotoCapturaDetalhe;
	}

	public UploadedFile getFotoCroqui() {
		return fotoCroqui;
	}

	public void setFotoCroqui(UploadedFile fotoCroqui) {
		this.fotoCroqui = fotoCroqui;
	}

	public byte[] getArray() {
		return array;
	}

	public void setArray(byte[] array) {
		this.array = array;
	}

	public FileInputStream getFis() {
		return fis;
	}

	public void setFis(FileInputStream fis) {
		this.fis = fis;
	}

}

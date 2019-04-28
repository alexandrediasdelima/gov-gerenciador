package org.gov.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;


public class FileUploadBean extends Controller {

    /**
	 *
	 */
	private static final long serialVersionUID = -1203061571255511980L;

	private UploadedFile file;

    public void upload() {

        if(file != null) {

        	String nomeArquivo = verificaArquivoComMesmoNome(file.getFileName());

        	String caminhoDestinoArquivo = "C:/import_cad/" + nomeArquivo;

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
    }

	private String verificaArquivoComMesmoNome(String fileName) {


		String arquivo = cortarTrecho(fileName, ".txt");

		File file = new File("C:/import_cad/");

		File[] listFiles = file.listFiles();

		int cont = 1;

		for (File f : listFiles) {

			String arquivoNovo = cortarTrecho(f.getName(), ".txt");

			if (arquivoNovo.equals(arquivo)) {
				arquivo = arquivo + cont;
				cont++;

			}
		}

		return arquivo + ".txt";
	}

	public void handleFileUpload(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("Sucesso", event.getFile().getFileName() + " Enviado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
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

   public static void main(String[] args) {

	   String arq = "documento.txt";

	   String arquivo = cortarTrecho(arq, ".txt");

	   File file = new File("C:/import_cad/");

	   File[] listFiles = file.listFiles();

	   int cont = 1;

		for (File f : listFiles) {

			String arquivoNovo = cortarTrecho(f.getName(), ".txt");

			System.out.println(arquivoNovo);

			if(arquivoNovo.equals(arquivo)) {
				arquivo = arquivo + cont;
				cont ++;

			}
	   }

	}

   public static String cortarTrecho(String nome, String trecho) {

       int index = nome.indexOf(trecho);
       nome = nome.substring(0, index);
       return nome;

   }

}
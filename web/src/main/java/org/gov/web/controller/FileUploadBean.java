package org.gov.web.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

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

        	String caminhoDestinoArquivo = "C:/apac/arquivos/upload/" + new Date().getTime() + file.getFileName();

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


   public static String cortarTrecho(String nome, String trecho) {

       int index = nome.indexOf(trecho);
       nome = nome.substring(0, index);
       return nome;

   }

}
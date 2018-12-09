package br.com.experian.gerenciadorperfil.core.service.relatorio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.experian.gerenciadorperfil.core.entity.HistoricoAlteracaoAlerta;
import br.com.experian.gerenciadorperfil.core.entity.Produto;
import br.com.experian.gerenciadorperfil.core.service.AvisoDeAlertaService;
import br.com.experian.gerenciadorperfil.core.service.common.ArquivoUploadDownload;

@Service
public class RelatorioHistoricoAlteracaoAlertaServiceImpl implements RelatorioHistoricoAlteracaoAlertaService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RelatorioHistoricoAlteracaoAlertaServiceImpl.class);
	
	private static final int COLUMN_WIDTH_4000 = 4000;
	private static final int COLUMN_WIDTH_6000 = 6000;
	private static final int COLUMN_WIDTH_12000 = 12000;
	
	@Autowired
	private AvisoDeAlertaService avisoDeAlertaService;
	
	public ArquivoUploadDownload gerar(final Produto produto, final Date dataInicio) throws RelatorioServiceException {

		List<HistoricoAlteracaoAlerta> historicosDeAlteracaoAlerta = avisoDeAlertaService.obterHistoricoDeAlteracaoAlerta(produto, dataInicio);
		
		String produtoAnt = StringUtils.EMPTY;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		int linha = BigDecimal.ZERO.intValue();
		int coluna = BigDecimal.ZERO.intValue();
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = null;
		HSSFRow row = null;
		HSSFFont font = workbook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

		HSSFCellStyle styleCenterBold = workbook.createCellStyle();
		styleCenterBold.setFont(font);
		styleCenterBold.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		HSSFCellStyle styleCenter = workbook.createCellStyle();
		styleCenter.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		HSSFCellStyle styleLeftBold = workbook.createCellStyle();
		styleLeftBold.setFont(font);
		styleLeftBold.setAlignment(HSSFCellStyle.ALIGN_LEFT);

		HSSFCellStyle styleLeft = workbook.createCellStyle();
		styleLeft.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		sheet = workbook.createSheet();

		if (historicosDeAlteracaoAlerta.isEmpty()) {

			row = sheet.createRow(linha++);
			HSSFHelper.createCell(row, coluna,"NENHUM REGISTRO ENCONTRADO", styleLeftBold);
			sheet.setColumnWidth(coluna, COLUMN_WIDTH_12000);

		}else{

		    row = sheet.createRow(linha++);
		    
		    HSSFHelper.createCell(row, coluna++,"Produto", styleCenterBold);
		    HSSFHelper.createCell(row, coluna++,"Logon", styleCenterBold);
		    HSSFHelper.createCell(row, coluna++,"Data de Alteração", styleCenterBold);
		    HSSFHelper.createCell(row, coluna++,"Ação", styleCenterBold);
		    HSSFHelper.createCell(row, coluna++,"Texto", styleCenterBold);

			coluna = BigDecimal.ZERO.intValue();

			sheet.setColumnWidth(coluna++, COLUMN_WIDTH_4000);
			sheet.setColumnWidth(coluna++, COLUMN_WIDTH_4000);
			sheet.setColumnWidth(coluna++, COLUMN_WIDTH_6000);
			sheet.setColumnWidth(coluna++, COLUMN_WIDTH_4000);
			sheet.setColumnWidth(coluna++, COLUMN_WIDTH_12000);

			for (HistoricoAlteracaoAlerta alteracao: historicosDeAlteracaoAlerta) {
				if (!produtoAnt.equals(alteracao.getProduto()) && linha > BigDecimal.ZERO.intValue()){
					linha++;
					produtoAnt = alteracao.getProduto();
				}

				row = sheet.createRow(linha++);
				coluna = BigDecimal.ZERO.intValue();
				HSSFHelper.createCell(row, coluna++, alteracao.getProduto(), styleCenter);
				HSSFHelper.createCell(row, coluna++, alteracao.getLogin(), styleCenter);
				if (alteracao.getData()!=null){
					HSSFHelper.createCell(row, coluna++, simpleDateFormat.format(alteracao.getData()), styleCenter);
				}else{
					coluna++;
				}
				HSSFHelper.createCell(row, coluna++, alteracao.getAcao(), styleCenter);
				HSSFHelper.createCell(row, coluna++, alteracao.getTexto(), styleLeft);

			}
		}
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		
		try {
			
			workbook.write(byteArrayOutputStream);
			
		} catch (IOException ioException) {
			final String message = "Erro ao gerar relatorio de historico de alteracao de alerta: " + ioException.getMessage();
			LOGGER.error(message, ioException);
			throw new RelatorioServiceException(message, ioException);
		}
		
		ArquivoUploadDownload arquivoUploadDownload = new ArquivoUploadDownload();
		
		arquivoUploadDownload.setTipo(ArquivoUploadDownload.TIPO_EXCEL);
		arquivoUploadDownload.setContentType(ArquivoUploadDownload.CONTENT_TYPE_EXCEL);
		arquivoUploadDownload.setBytes(byteArrayOutputStream.toByteArray());
		arquivoUploadDownload.setNome(StringUtils.uncapitalize(HistoricoAlteracaoAlerta.class.getSimpleName()));
		
		return arquivoUploadDownload;
	}

	public void setAvisoDeAlertaService(AvisoDeAlertaService avisoDeAlertaService) {
		this.avisoDeAlertaService = avisoDeAlertaService;
	}
}

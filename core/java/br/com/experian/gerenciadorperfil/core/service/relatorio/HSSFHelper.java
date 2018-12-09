package br.com.experian.gerenciadorperfil.core.service.relatorio;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;

class HSSFHelper {
	
	private HSSFHelper() {
		
	}
	
	public static HSSFCell createCell(HSSFRow row, int column, String value, HSSFCellStyle style) {
		HSSFCell cell = row.createCell(column);
		cell.setCellValue(value);
		cell.setCellStyle(style);
		return cell;
	}
}

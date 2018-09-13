package excelTestPoi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class excelWriter {
	public static void main(String[] args) {
		//创建excel工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
		//创建第一页
		Sheet sheet = workbook.createSheet("firstSheet");
		//创建第一行
		Row row = sheet.createRow(0);
		//创建第一行上第一个单元格
		Cell cell = row.createCell(0);
		Cell cell1 = row.createCell(1);
		//设置第一个单元格内显示
		cell.setCellValue(false);
		
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		cell1.setCellValue(sdf.format(new Date()));
		OutputStream stream = null;
		try {
			stream = new FileOutputStream("F:\\excelWriterTest.xls");
			try {
				workbook.write(stream);
				System.out.println("Writing excel ends.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

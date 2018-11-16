package excelTestPoi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class excelWriter {
	public static void main(String[] args) {
		File file = new File("excelWriterTest.xls");
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//创建excel工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
		//创建第一页
		Sheet sheet = workbook.createSheet("firstSheet");
		//创建第一行
		Row row = sheet.createRow(0);
		Row row1 = sheet.createRow(1);
		//创建第一行上第一个单元格
		Cell cell1 = row.createCell(0);
		Cell cell2 = row.createCell(1);
		//设置第一个单元格内显示
		cell1.setCellValue("设备名称");
		cell2.setCellValue("设备鉴权信息");
		Cell cell3 = row1.createCell(0);
		Cell cell4 = row1.createCell(1);
		cell3.setCellValue("XXXX");
		cell4.setCellValue("3264XXX83");
		OutputStream stream = null;
		try {
			stream = new FileOutputStream("excelWriterTest.xls");
			try {
				workbook.write(stream);
				System.out.println("Writing excel ends.");
				String url = System.getProperties().getProperty("user.dir");
				final Runtime runtime = Runtime.getRuntime();
				final String cmd = "rundll32 url.dll FileProtocolHandler file://"+url+"//excelWriterTest.xls";
				runtime.exec(cmd);
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

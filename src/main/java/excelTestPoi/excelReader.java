/**
 * 
 */
package excelTestPoi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 * @author pyt
 * 2018-09-12
 */
public class excelReader {
	public static void main(String[] args) throws Exception {
		//获取整个excel文件
		InputStream stream = new  FileInputStream("F:\\excelWriterTest.xls");
		POIFSFileSystem fs = new POIFSFileSystem(stream);
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		//获取excel文件的sheet1
		HSSFSheet sheet = wb.getSheetAt(0);
		if(sheet == null) {
			return;
		}
		//遍历sheet1的行
		for(int rowNum = 0 ; rowNum <= sheet.getLastRowNum() ; rowNum++) {
			HSSFRow row = sheet.getRow(rowNum);
			if(row == null) {
				continue;//此行为空，进入下一行
			}
			//遍历此行的单元格
			for(int cellNum = 0 ; cellNum <= row.getLastCellNum(); cellNum++) {
				HSSFCell cell = row.getCell(cellNum);
				if(cell == null) {
					continue;//此单元格为空，进入下一单元格
				}
				//读取单元格内值
				String val = readCell(cell);
				System.out.println("++++++++" + val + "+++++");
			}
			
		}
	}
	
	
	/**
	 * @param cell
	 * @return
	 */
	public static String readCell(HSSFCell cell) {
		if(cell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
			System.out.println("布尔量");
			return String.valueOf(cell.getBooleanCellValue());
		}else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
			System.out.println("数值型");
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				System.out.println("This is date"); 
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				return sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue())).toString();
			}else {
				int day = (int) cell.getNumericCellValue();
				System.out.println("日期："+day);
				
			}
			return String.valueOf(cell.getNumericCellValue());
		}else {
			System.out.println("String型");
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
			try {
				System.out.println(sdf.parse(cell.getStringCellValue()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return cell.getStringCellValue();
		}
	}
	
	
	
	
	

}

package JProcessBar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author pyt
 * @createTime 2018年11月16日下午5:13:40
 */
public class ExcelUtils{
	public static void exportExcel() {
		File file = new File("cell_link设备导入模板.xls");
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
		Row row2 = sheet.createRow(2);
		//创建第一行上第一个单元格
		Cell cell0 = row.createCell(0);
		Cell cell1 = row.createCell(1);
		Cell cell2 = row.createCell(2);
		//设置第一个单元格内显示
		cell0.setCellValue("编号");
		cell1.setCellValue("设备名称");
		cell2.setCellValue("设备鉴权信息");
		Cell cell10 = row1.createCell(0);
		Cell cell11 = row1.createCell(1);
		Cell cell12 = row1.createCell(2);
		cell10.setCellValue(1);
		cell11.setCellValue("test1");
		cell12.setCellValue("3264XXX83");
		Cell cell20 = row2.createCell(0);
		Cell cell21 = row2.createCell(1);
		Cell cell22 = row2.createCell(2);
		cell20.setCellValue(2);
		cell21.setCellValue("test2");
		cell22.setCellValue("3264XXX84");
		OutputStream stream = null;
		try {
			stream = new FileOutputStream("cell_link设备导入模板.xls");
			try {
				workbook.write(stream);
				String url = System.getProperties().getProperty("user.dir");
				final Runtime runtime = Runtime.getRuntime();
				final String cmd = "rundll32 url.dll FileProtocolHandler file://"+url+"//cell_link设备导入模板.xls";
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
	
	public static JSONObject importExcel(String url) {
		JSONObject objectReturn = new JSONObject();
		JSONArray array = new JSONArray();
		//获取整个excel文件
		InputStream stream;
		POIFSFileSystem fs;
		HSSFWorkbook wb;
		try {
			stream = new  FileInputStream(url);
			fs = new POIFSFileSystem(stream);
			wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			if(sheet == null) {
				return objectReturn;
			}
			//遍历sheet1的行
			for(int rowNum = 1 ; rowNum <= sheet.getLastRowNum() ; rowNum++) {
				JSONObject object = new JSONObject();
				JSONObject content = new JSONObject();
				HSSFRow row = sheet.getRow(rowNum);
				if(row == null) {
					continue;//此行为空，进入下一行
				}
				//遍历此行的单元格
				HSSFCell cell0 = row.getCell(0);
				if(cell0 == null) {
					continue;//此单元格为空，进入下一单元格
				}
				//读取单元格内值
				int id = (int) Float.parseFloat(readCell(cell0));				
				HSSFCell cell1 = row.getCell(1);
				if(cell1 == null) {
					continue;//此单元格为空，进入下一单元格
				}
				//读取单元格内值
				String name = readCell(cell1);					
				HSSFCell cell2= row.getCell(2);
				if(cell2 == null) {
					continue;//此单元格为空，进入下一单元格
				}
				//读取单元格内值
				String device_sn = readCell(cell2);				
				content.put(name, device_sn);
				object.put(id+"", content);
				array.add(object);
			}
			objectReturn.put("result", array);
			return  objectReturn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objectReturn;		
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
				int value = (int) cell.getNumericCellValue();
				System.out.println("数值："+value);
				return String.valueOf(value);
			}
		}else {
			System.out.println("String型");			
			return cell.getStringCellValue();
		}
	}	
}


package JProcessBar;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JProgressBar;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


/**
 * @author pyt
 * @createTime 2018年11月16日下午5:20:22
 */
public class ImportExcel extends Thread{
	private Integer completed_count;
	private Integer sum;
	private static final long serialVersionUID  = 1L;
	private JProgressBar processBar;

	public ImportExcel() {
		super();
	}


	public void handle() {
		String url = "C:\\Users\\26304\\git\\TreeHole\\cell_link设备导入模板.xls";
		completed_count = 0;
		JSONObject objectReturn = importExcel(url);
		JSONArray array = objectReturn.getJSONArray("result");
		int count = 0;
		sum = array.size();
		for(int i=0;i<array.size();i++) {
			JSONObject object  = array.getJSONObject(i);
			Set<String> keys = object.keySet();
			Iterator iterator = keys.iterator();				
			while(iterator.hasNext()) {
				String key = (String) iterator.next();
				JSONObject value = (JSONObject) object.get(key);
				Set<String> names = value.keySet();
				Iterator it = names.iterator();
				while(it.hasNext()) {
					String name = (String) it.next();
					String devicesn = (String) value.get(name);
					if(!StringUtils.isNumeric(devicesn)) {
						count++;
						System.out.println("编号为："+key+"的设备数据鉴权信息包含数字以外字符");
						continue;
					}
					System.out.println("编号为："+key+"的设备数据鉴权信息有效");					
				}				
			}
			completed_count++;
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


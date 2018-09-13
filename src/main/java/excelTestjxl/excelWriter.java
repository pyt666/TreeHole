package excelTestjxl;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * @author pyt
 * 2018-09-13
 */
public class excelWriter {

	public static void main(String[] args) {
		
		try {
			//创建一个工作簿
			WritableWorkbook book = Workbook.createWorkbook(new File("test.xls"));
			WritableSheet sheet = book.createSheet("第一页", 0);
			Label label = new Label(0, 0, "test");
			sheet.addCell(label);
			jxl.write.Number number = new jxl.write.Number(1, 0, 742.33);
			sheet.addCell(number);
			book.write();
			book.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

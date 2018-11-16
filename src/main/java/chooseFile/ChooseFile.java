package chooseFile;

import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author pyt
 * @createTime 2018年11月12日下午2:39:12
 */
public class ChooseFile {
	public static void fileChooser() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("xls", "jpg","gif");
		//设置文件类型
		chooser.setFileFilter(filter);
		//打开选择器面板
		int returnVal = chooser.showSaveDialog(new JPanel());
		//保存文件从这里入手，输出的是文件名
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("你打开的文件夹是："+chooser.getSelectedFile().getPath());
			String path = chooser.getSelectedFile().getPath();
			try {
				File f = new File(path+".xls");
				System.out.println(f.getAbsolutePath());
				f.createNewFile();
				FileOutputStream out = new FileOutputStream(f);
				out.write("aaaaaaaaaaaaa".getBytes());
				out.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		fileChooser();
	}
}


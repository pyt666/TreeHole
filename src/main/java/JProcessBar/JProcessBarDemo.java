package JProcessBar;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

/**
 * @author pyt
 * @createTime 2018年11月16日下午3:58:43
 */
public class JProcessBarDemo extends JFrame {
	private static final long serialVersionUID  = 1L;
	private JProgressBar processBar;
	public JProcessBarDemo(){
		setTitle("进度条使用");		//设置窗体标题
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗体退出的操作
		
		setBounds(100, 100, 250, 100);// 设置窗体的位置和大小
		
		JPanel contentPane = new JPanel();   // 创建内容面板
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// 设置内容面板边框
		
		setContentPane(contentPane);// 应用(使用)内容面板
		
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));// 设置为流式布局
		
		processBar = new JProgressBar();// 创建进度条
		
		processBar.setStringPainted(true);// 设置进度条上的字符串显示，false则不能显示
		
		processBar.setBackground(Color.cyan);
		
		ImportExcel t = new ImportExcel();//创建Thread对象，将对象作为形参传递给Thread的构造方法

	
		// 创建线程显示进度
		new Thread(){
						
			/*public void run(){
		        t.start();//调用start()
				while(t.getSum()!=t.getCompleted_count()) {
					processBar.setValue(t.getCompleted_count());	// 设置进度条数值				
			}
			processBar.setString("升级完成");// 设置提示信息
			}.start(); //  启动进度条线程
		
		contentPane.add(processBar);// 向面板添加进度控件
*/		
			public void run() {
				
				processBar.setString("升级完成");// 设置提示信息
			}
		};
	}
	
	public static void main(String[] args){
		JProcessBarDemo JPBD = new JProcessBarDemo();
		JPBD.setVisible(true);	
	}

	

}


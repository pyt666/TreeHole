package utils;

import java.util.regex.Pattern;

/**
 * @author pyt
 * @createTime 2018年11月15日上午11:02:48
 */
public class StringUtils {
	/**
	 * 判断字符串是否是数字
	 * 整数
	 */
	public static boolean isNumeric(String str) {
		/*for(int i = 0;i<str.length();i++){
			if(!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}*/
		
		for(int i = str.length(); --i>= 0; ){
			if(!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	/**
	 * 使用正则表达式
	 * @param str
	 * @return
	 */
	public static boolean isNumeric1(String str) {
	    Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
	    return pattern.matcher(str).matches();
	}
	
	public static void main(String[] args) {
		System.out.println(isNumeric1("6281218"));
	}

}


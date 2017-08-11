package base.utils;

/**
 * String帮助类
 * @author clam
 *
 */
public class StringUtil {
	/**
	 * 是否为空或者空字符串
	 * @param str 字符串
	 * @return 
	 */
	public static boolean IsNullOrEmpty(String str){
		if(str==null)
			return true;
		if(str.isEmpty())
			return true;
		return false;
	}

	public static String join(String[] arr, String symbol) {
		StringBuffer buff = new StringBuffer();
		for (String str : arr) {
			buff.append(str).append(symbol);
		}
		buff.deleteCharAt(buff.length()-1);
		return buff.toString();
	}
}

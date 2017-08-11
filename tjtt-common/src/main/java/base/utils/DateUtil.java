package base.utils;

import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间辅助
 * 
 * @author libra
 *
 */


public class DateUtil {
	/**
	 * 格式化时间
	 * 
	 * @param date
	 *            时间
	 * @param format
	 *            格式化字符串 yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String format(Date date, String format) {
		if(date==null)
			return "";
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String dateString = formatter.format(date);
		return dateString;
	}
	
	/**
	 * 格式化时间
	 * @param date 时间
	 * @return 格式化结果 默认  yyyy-MM-dd HH:mm:ss
	 */
	public static String format(Date date){
		return format(date,"yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 格式化时间 只格式化 日期部分 yyyy-MM-dd
	 * @param date
	 * @return
	 */

	public static String formatDate(Date date){
		return format(date,"yyyy-MM-dd");
	}
	
	/**
	 * 比较两个字符串时间的大小
	 * @param date1
	 * @param date2
	 * @param dateFormat 传null或空串时默认为：yyyy-MM-dd
	 * @param flag 若大于0，比判断是否date1>date2; 若小于0，比判断是否date1<date2; 若等于0，比判断是否date1=date2;   
	 * @return
	 * @throws Exception
	 */
	public static boolean cmpDate(String date1,String date2,String dateFormat,int flag) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(StringUtils.isBlank(dateFormat)?"yyyy-MM-dd":dateFormat);
		long res = sdf.parse(date1).getTime()-sdf.parse(date2).getTime();
		return flag > 0 ? res > 0 : ( flag < 0 ? res < 0 : res == 0 );
	}
}

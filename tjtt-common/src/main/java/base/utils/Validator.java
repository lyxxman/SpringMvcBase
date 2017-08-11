package base.utils;

import java.util.regex.Pattern;

/**
 * 工具类 验证规则
 * 
 * @author xiaojiang 2017年3月3日
 * @version 1.0
 * @since 1.0 2017年3月3日
 */
public class Validator {
	/**
	 * 验证身份证合法性
	 * 
	 * @param idcard
	 * @return true 正确的
	 * @author xiaojiang 2017年3月3日
	 * @version 1.0
	 * @since 1.0 2017年3月3日
	 */
    public static boolean decideIdcard(String idcard) {
    	boolean flag = true;
    	if(idcard == null || "".equals(idcard)){
    		return flag = false;
    	}else{
    		switch (idcard.length()) {
			case 15:
				if(!Pattern.matches("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$",idcard)){
					flag = false;
				}
				break;
			case 18:
				 if(!Pattern.matches("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([\\d|x|X]{1})$",idcard)){
			    		flag = false;
			    	}
				break;
			default:
				flag = false;
				break;
			}
    		return flag;
    	}
    	
    }
  
}

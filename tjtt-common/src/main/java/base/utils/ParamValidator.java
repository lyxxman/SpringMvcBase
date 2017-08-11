package base.utils;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 参数验证器<br/>
 * 这里提供了一些常用的验证器。若要扩展，继承此类即可
 * @author Eric Lee, 2017-03-06
 */
public class ParamValidator<T>{
	private boolean hasErrors = false;
	private List<String> errorMessages = new ArrayList<String>();

	protected void updateErrorAndMessage(boolean isMatch,String errorMessage){
		if(!hasErrors){
			hasErrors = !isMatch;
		}
		
		if(hasErrors && StringUtils.isNotBlank(errorMessage)){
			 errorMessages.add(errorMessage);
		}
	}
	
	public static ParamValidator<Object> newInstance() {
		return new ParamValidator<Object>();
	}
	
	public boolean hasErrors() {
		return hasErrors;
	}

	public List<String> getErrorMessages() {
		return errorMessages;
	}
	
	
	/********************************************  定义各种验证器 BEGIN  ****************************************/
	
	/**
	 * 验证对象非空
	 * @param target 目标对象
	 * @param errorMessage
	 * @return
	 */
	public ParamValidator<T> isNotNullObj(Object target, String errorMessage){
		if(hasErrors) return this;
		updateErrorAndMessage(target!=null, errorMessage);
		return this;
	}
	
	/**
	 * 验证目标字符串是否为非空串
	 * @param target
	 * @param errorMessage
	 * @return
	 */
	public ParamValidator<T> isNotEmptyStr(String target, String errorMessage){
		if(hasErrors) return this;
		updateErrorAndMessage(StringUtils.isNotEmpty(target), errorMessage);
		return this;
	}
	
	/**
	 * 验证目标字符串是否为空串
	 * @param target
	 * @param errorMessage
	 * @return
	 */
	public ParamValidator<T> isEmptyStr(String target, String errorMessage){
		if(hasErrors) return this;
		updateErrorAndMessage(StringUtils.isEmpty(target), errorMessage);
		return this;
	}

	/**
	 * 验证目标字符串是否为非空白
	 * @param target
	 * @param errorMessage
	 * @return
	 */
	public ParamValidator<T> isNotBlankStr(String target, String errorMessage){
		if(hasErrors) return this;
		updateErrorAndMessage(StringUtils.isNotBlank(target), errorMessage);
		return this;
	}
	
	/**
	 * 验证目标字符串是否为空白
	 * @param target
	 * @param errorMessage
	 * @return
	 */
	public ParamValidator<T> isBlankStr(String target, String errorMessage){
		if(hasErrors) return this;
		updateErrorAndMessage(StringUtils.isBlank(target), errorMessage);
		return this;
	}
	
	/**
	 * 验证传入的布尔型变量是否匹配(即是否为true)
	 * @param isMatch
	 * @param errorMessage
	 * @return
	 */
	public ParamValidator<T> isMatch(boolean isMatch, String errorMessage){
		if(hasErrors) return this;
		updateErrorAndMessage(isMatch, errorMessage);
		return this;
	}
	
	/**
	 * 验证是否满足正则条件
	 * @param target 目标字符串
	 * @param regExp 正则条件
	 * @param errorMessage
	 * @return
	 */
	public ParamValidator<T> pattern(String target, String regExp, String errorMessage){
		if(hasErrors) return this;
		updateErrorAndMessage(Pattern.matches(regExp, target),errorMessage);	
		return this;
	}
	
	/**
	 * 验证整数是否在某个闭区间内
	 * @param target 目标整数
	 * @param from 左闭区间
	 * @param to   右闭区间
	 * @param errorMessage
	 * @return
	 * @throws Exception 当from > to 时，抛出异常
	 */
	public ParamValidator<T> between(Integer target, double from, double to, String errorMessage) throws Exception{
		if(hasErrors) return this;
		if(from > to){
			throw new Exception("The value of the parameter 'from' must be less than 'to' ! ");
		}
		updateErrorAndMessage(target >= from && target <= to, errorMessage); 
		return this;
	}
	
	/**
	 * 验证float是否在某个闭区间内
	 * @param target 目标整数
	 * @param from 左闭区间
	 * @param to   右闭区间
	 * @param errorMessage
	 * @return
	 * @throws Exception 当from > to 时，抛出异常
	 */
	public ParamValidator<T> between(double target, double from, double to, String errorMessage) throws Exception{
		if(hasErrors) return this;
		if(from > to){
			throw new Exception("The value of the parameter 'from' must be less than 'to' ! ");
		}
		updateErrorAndMessage(target >= from && target <= to, errorMessage); 
		return this;
	}
	
	/**
	 * 验证身份证号的合法性
	 * @param idCard 身份证号
	 * @param errorMessage
	 * @return
	 */
	public ParamValidator<T> isLegalIdCard(String idCard, String errorMessage){
		if(hasErrors) return this;
		updateErrorAndMessage(Validator.decideIdcard(idCard), errorMessage);
		return this;
	}
	
	/**
	 * 比较两字符串时间
	 * @param date1
	 * @param date2
	 * @param dateFormat 传null或空串时默认为：yyyy-MM-dd
	 * @param flag 若大于0，比判断是否date1>date2; 若小于0，比判断是否date1<date2; 若等于0，比判断是否date1=date2;   
	 * @param errorMessage
	 * @return
	 * @throws Exception
	 */
	public ParamValidator<T> cmpStrDate(String date1, String date2, String dateFormat, int flag, String errorMessage) throws Exception{
		if(hasErrors) return this;
		updateErrorAndMessage(DateUtil.cmpDate(date1, date2, dateFormat, flag), errorMessage);
		return this;
	}
	
	
	/********************************************  定义各种验证器 END  ****************************************/
	
	public static void main(String[] args) {
		ParamValidator<?> validator = ParamValidator.newInstance()
				.isNotEmptyStr("  ", "is  empty")
				.isNotBlankStr("  d", "is not blank")
				.isMatch(true, "is not match")
				.isLegalIdCard("5105211989072958510", "id card not match");
		System.out.println(validator.hasErrors);
		System.out.println(validator.getErrorMessages());
		System.out.println(Validator.decideIdcard("510521198907295851"));
	}
}

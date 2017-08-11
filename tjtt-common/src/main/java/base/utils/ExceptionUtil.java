package base.utils;

public class ExceptionUtil {
	
	/**
	 * 获取异常堆栈信息
	 * @param ex 异常
	 * @return
	 */
	public static String getExceptionStackString(Exception ex){
		if(ex==null)
			return "";
		
		String line = System.getProperty("line.separator");
		StringBuffer sb = new StringBuffer();
		
		sb.append(ex.toString());
		sb.append("         ");
		sb.append(ex.getMessage());		
		sb.append(line);
		
	    StackTraceElement [] els =	ex.getStackTrace();
	    if(els == null)
	    	els = new StackTraceElement[0];
		
	    for(StackTraceElement el : els){	    	
	    	sb.append("\t at ");
	    	sb.append(el.getClassName());
	    	sb.append(".");
	    	sb.append(el.getMethodName());
	    	sb.append("(");
	    	sb.append(el.getFileName());
	    	sb.append(":");
	    	sb.append(el.getLineNumber());
	    	sb.append(")");
	    	sb.append(line);
	    }
	    
		return sb.toString();
	}
}

package base.dto;

import base.BaseResult;

public class ApiResult<E> extends BaseResult {
	/**
	 * 数据
	 */
	private E data;
	
	/**
	 * 数量
	 */
	private int count;
	
	/**
	 * 拓展提示信息
	 * @return
	 */
	private String extendMessage;
	
	/**
	 * 拓展提示状态信息
	 */
	private String statusMessage;

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getExtendMessage() {
		return extendMessage;
	}

	public void setExtendMessage(String extendMessage) {
		this.extendMessage = extendMessage;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}
	
	
	
	/**
	 * 返回成功对象
	 * @return
	 */
	public static <E> ApiResult<E> onSuccess(E data){
		ApiResult<E> result = new ApiResult<E>();
		result.setSuccess(true);
		result.setMessage("成功");
		result.setStatusCode(200);
		result.setData(data);
		return result;
	}
	
	/**
	 * 返回成功对象
	 * @return
	 */
	public static <E> ApiResult<E> onSuccess(E data, int count){
		ApiResult<E> result = new ApiResult<E>();
		result.setSuccess(true);
		result.setMessage("成功");
		result.setStatusCode(200);
		result.setData(data);
		result.setCount(count);
		return result;
	}
	
	/**
	 * 返回成功对象
	 * @return
	 */
	public static <E> ApiResult<E> onSuccess(E data, int count, String extendMessage){
		ApiResult<E> result = new ApiResult<E>();
		result.setSuccess(true);
		result.setMessage("成功");
		result.setStatusCode(200);
		result.setData(data);
		result.setExtendMessage(extendMessage);
		result.setCount(count);
		return result;
	}
	
	/**
	 * 返回成功对象
	 * @return
	 */
	public static <E> ApiResult<E> onSuccess(E data, int count, String extendMessage, String statusMessage){
		ApiResult<E> result = new ApiResult<E>();
		result.setSuccess(true);
		result.setMessage("成功");
		result.setStatusCode(200);
		result.setData(data);
		result.setExtendMessage(extendMessage);
		result.setStatusMessage(statusMessage);
		result.setCount(count);
		return result;
	}

	/**
	 * 返回失败结果对象
	 * @param status 状态码
	 * @param message 错误提示消息
	 * @return
	 */
	public static <E> ApiResult<E> onError(E data, int status, String message){
		ApiResult<E> result = new ApiResult<E>();
		result.setSuccess(true);
		result.setMessage("成功");
		result.setStatusCode(200);
		result.setData(data);
		return result;
	}
	
	/**
	 * 返回失败结果对象
	 * @param message 提示消息
	 * @return
	 */
	public static <E> ApiResult<E> onError(E data, String message){
		return onError(data,500,message);
	}
}

package base;

/**
 * @Author: luoyi
 * @Description:
 * @Date: 17:46 2017/8/2
 * @Version: 1.0.0
 * @Modified By: xxx
 */
public class BaseResult {
    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 状态码
     */
    private int statusCode;
    /**
     * 消息提示
     */
    private String message;

    /**
     * 返回ID
     */
    private Long returnId;

    public Long getReturnId() {
        return returnId;
    }

    public void setReturnId(Long returnId) {
        this.returnId = returnId;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 返回成功对象
     *
     * @return
     */
    public static BaseResult onSuccess() {
        BaseResult result = new BaseResult();
        result.setSuccess(true);
        result.setMessage("成功");
        result.setStatusCode(200);
        return result;
    }
    /**
     * 返回失败结果对象
     *
     * @param status  状态码
     * @param message 错误提示消息
     * @return
     */
    public static BaseResult onError(int status, String message) {
        BaseResult result = new BaseResult();
        result.setSuccess(false);
        result.setStatusCode(status);
        result.setMessage(message);
        return result;
    }

    /**
     * 返回失败结果对象
     *
     * @param message 提示消息
     * @return
     */
    public static BaseResult onError(String message) {
        return onError(500, message);
    }
}

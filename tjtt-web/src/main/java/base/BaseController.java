package base;

import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Author: luoyi
 * @Description: 基础控制器类，抽象统一处理内容
 * @Date: 10:50 2017/8/11
 * @Version: 1.0.0
 * @Modified By: xxx
 */
public abstract class BaseController {

    @ExceptionHandler
    public String exception(HttpServletRequest request, Exception e) {
        // 根据不同的异常类型进行不同处理
        if(e instanceof SQLException) {
            String s = "数据库异常" ;
            request.setAttribute( "exceptionMessage", s);
            return "error";
        }else if(e instanceof IOException){
            String s = "IO异常";
            request.setAttribute( "exceptionMessage", s);
            return "error";
        }
        else return "error";
    }
}

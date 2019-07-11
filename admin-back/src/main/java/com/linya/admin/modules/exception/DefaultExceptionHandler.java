package com.linya.admin.modules.exception;

import com.linya.admin.modules.api.Api;
import com.linya.admin.modules.api.Code;
import com.linya.admin.modules.api.Sender;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class DefaultExceptionHandler {

    /**
     * 参数验证失败
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Api<String> MethodArgumentNotValidHandler(HttpServletRequest request, MethodArgumentNotValidException exception)
    {
        // 按需重新封装需要返回的错误信息
        String msg = exception.getBindingResult().getFieldError().getDefaultMessage();
        return Sender.fail(Code.FAILURE_VALIDATED, msg);
    }

}

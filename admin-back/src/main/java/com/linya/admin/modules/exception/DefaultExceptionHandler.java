package com.linya.admin.modules.exception;

import com.linya.admin.modules.api.Api;
import com.linya.admin.modules.api.Sender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DefaultExceptionHandler {

    public static Logger LOGGER = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    /**
     * 参数验证失败
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Api<String> requestNotValid(MethodArgumentNotValidException ex) {
        // 按需重新封装需要返回的错误信息
        String message = ex.getBindingResult().getFieldError().getDefaultMessage();
        return Sender.fail(message);
    }

    /**
     * 参数格式不合法
     */
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public Api<String> requestNotReadable(HttpMessageNotReadableException ex) {
        String message = ex.getMessage();
        LOGGER.error("参数格式不合法", message);
        return Sender.fail("参数格式不合法", message);
    }
}

package com.linya.admin.modules.exception;

import com.linya.admin.modules.api.Api;
import com.linya.admin.modules.api.Sender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class DefaultExceptionHandler {

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
        log.warn("参数格式不合法", message);
        return Sender.fail("参数格式不合法", message);
    }

    /**
     * 不支持的方法类型
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public Api<String> request405(HttpRequestMethodNotSupportedException ex) {
        return Sender.fail("接口不支持该请求方法", null);
    }
}

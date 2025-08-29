package com.cloudplus.tool.web.handler;

import com.cloudplus.tool.core.exception.BusinessException;
import com.cloudplus.tool.core.model.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 参数验证异常处理
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        String message = "参数验证失败";
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                message = fieldError.getDefaultMessage();
            }
        }
        return R.failed(message);
    }

    /**
     * 参数绑定异常处理
     */
    @ExceptionHandler(value = BindException.class)
    public R handleValidException(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        String message = "参数绑定失败";
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                message = fieldError.getDefaultMessage();
            }
        }
        return R.failed(message);
    }

    /**
     * 业务异常处理
     */
    @ExceptionHandler(value = BusinessException.class)
    public R handleBusinessException(BusinessException e) {
        return R.failed(e.getMessage());
    }

    /**
     * 其他异常处理
     */
    @ExceptionHandler(value = Exception.class)
    public R handleException(Exception e, HttpServletRequest request) {
        logger.error("Exception: {}", e.getMessage(), e);
        return R.failed("系统繁忙，请稍后再试");
    }
}

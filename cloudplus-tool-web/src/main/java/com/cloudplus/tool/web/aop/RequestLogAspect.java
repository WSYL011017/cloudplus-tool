package com.cloudplus.tool.web.aop;

import com.cloudplus.tool.core.utils.CoreUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 请求日志切面
 */
@Aspect
@Component
public class RequestLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(RequestLogAspect.class);

    @Pointcut("execution(* com.cloudplus..*.controller..*.*(..))")
    public void requestPointcut() {}

    @Around("requestPointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        // 获取请求信息
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();

        // 生成请求ID
        String requestId = CoreUtils.generateTraceId();

        // 记录请求日志
        logger.info("Request Start => ID: {}, URI: {}, Method: {}, IP: {}, Args: {}",
                requestId, request.getRequestURI(), request.getMethod(),
                getClientIp(request), joinPoint.getArgs());

        try {
            Object result = joinPoint.proceed();
            long endTime = System.currentTimeMillis();

            // 记录响应日志
            logger.info("Request End => ID: {}, Time: {}ms, Result: {}",
                    requestId, (endTime - startTime), result);

            return result;
        } catch (Exception e) {
            long endTime = System.currentTimeMillis();

            // 记录异常日志
            logger.error("Request Error => ID: {}, Time: {}ms, Error: {}",
                    requestId, (endTime - startTime), e.getMessage(), e);

            throw e;
        }
    }

    private String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}

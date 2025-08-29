package com.cloudplus.tool.web.config;

import feign.RequestInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Enumeration;

/**
 * Feign配置类
 */
@Configuration
public class FeignConfig {

    /**
     * Feign请求拦截器，用于传递请求头
     */
    @Bean
    public RequestInterceptor requestInterceptor() {
        return template -> {
            ServletRequestAttributes attributes = (ServletRequestAttributes)
                    RequestContextHolder.getRequestAttributes();
            if (attributes != null) {
                HttpServletRequest request = attributes.getRequest();
                // 传递所有请求头
                Enumeration<String> headerNames = request.getHeaderNames();
                while (headerNames.hasMoreElements()) {
                    String name = headerNames.nextElement();
                    String value = request.getHeader(name);
                    template.header(name, value);
                }
            }
        };
    }
}

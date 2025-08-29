package com.cloudplus.tool.security.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 密码加密工具类
 */
@Component
public class PasswordUtil {

    private final PasswordEncoder passwordEncoder;

    public PasswordUtil() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    /**
     * 加密密码
     */
    public String encode(CharSequence rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    /**
     * 验证密码
     */
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}

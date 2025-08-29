package com.cloudplus.tool.starter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置属性类
 */
@ConfigurationProperties(prefix = "cloudplus")
public class CloudPlusProperties {
    private boolean enabled = true;
    private String name = "CloudPlus Tool";

    // Getter和Setter方法
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

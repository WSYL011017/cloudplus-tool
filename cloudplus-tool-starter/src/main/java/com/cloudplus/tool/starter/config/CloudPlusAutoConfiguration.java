package com.cloudplus.tool.starter.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置类
 */
@Configuration
@EnableConfigurationProperties(CloudPlusProperties.class)
public class CloudPlusAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public CloudPlusProperties cloudPlusProperties() {
        return new CloudPlusProperties();
    }
}


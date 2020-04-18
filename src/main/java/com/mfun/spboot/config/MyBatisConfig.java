package com.mfun.spboot.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.mfun.spboot.mapper")
public class MyBatisConfig {

    @Bean
    public ConfigurationCustomizer customizer() {
        return configuration -> {
            configuration.setMapUnderscoreToCamelCase(true);
        };
    }
}

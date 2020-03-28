package com.mfun.spboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 扩展 Spring MVC 的配置
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 添加视图控制器
        // vc 是要设置的路径，success 是目标视图名
        registry.addViewController("/vc").setViewName("success");
    }
}

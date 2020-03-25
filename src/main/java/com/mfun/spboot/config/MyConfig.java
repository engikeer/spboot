package com.mfun.spboot.config;

import com.mfun.spboot.controller.Hello;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public Hello hello() {
        return new Hello();
    }

}

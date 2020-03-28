package com.mfun.spboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@SpringBootApplication
public class SpbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpbootApplication.class, args);
    }

    @Bean
    public ViewResolver myViewResolver() {
        return new MyViewResolver();
    }

}

class MyViewResolver implements ViewResolver {
    @Override
    public View resolveViewName(String viewName, Locale locale) {
        return null;
    }
}
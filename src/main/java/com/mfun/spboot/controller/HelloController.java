package com.mfun.spboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
public class HelloController {

    @GetMapping("/")
    public Object hello() {
        return new Serializable() {
            private String name = "庄颜";
            private String hello = "你好呀";

            public String getName() {
                return name;
            }

            public String getHello() {
                return hello;
            }
        };
    }
}

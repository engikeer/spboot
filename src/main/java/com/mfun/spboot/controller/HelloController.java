package com.mfun.spboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Object hello() {

        return new Serializable() {
            public String getName() {
                return "庄颜";
            }

            public String getHello() {
                return "你好呀";
            }
        };
    }
}

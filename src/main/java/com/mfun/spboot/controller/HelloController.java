package com.mfun.spboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;

@Controller
public class HelloController {

    @ResponseBody
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

    @GetMapping("/success")
    public String success() {
        // 访问模板：classpath:/templates/success.html
        return "success";
    }
}

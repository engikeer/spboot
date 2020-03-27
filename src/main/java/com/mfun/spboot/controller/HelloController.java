package com.mfun.spboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

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
    public String success(Map<String, Object> map) {
        // 将数据放入请求域中
        map.put("hello", "<h3>你好</h3>");
        map.put("users", Arrays.asList("秦琼", "尉迟恭", "红拂女", "李靖"));
        // 访问模板：classpath:/templates/success.html
        return "success";
    }
}

package com.mfun.spboot.controller;

import com.mfun.spboot.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

//@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public String handleException(Exception e, HttpServletRequest request) {
        // 将请求交给 BasicErrorController 处理
        // 注意，请求转发时必须设置状态码，否则默认会是 200
        // 只有正确设置了状态码，才能解析到指定的错误页面
        // BasicErrorController 的 getStatus 方法通过请求中的 javax.servlet.error.status_code 属性获得状态码
        // 所以，要将异常处理的状态码也放入该属性中
        request.setAttribute("javax.servlet.error.status_code", 402);
        // BasicErrorController 通过 errorAttributes.getErrorAttributes 方法得到模型数据
        // 使用自定义 ErrorAttributes 从请求域的 ext 属性中获取要添加的数据
        Map<String, Object> map = new HashMap<>();
        map.put("info", "user.notFound");
        map.put("cause", e.getCause());
        request.setAttribute("ext", map);
        return "forward:/error";
    }

}

package com.mfun.spboot.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

//@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    public MyErrorAttributes() {
        super(true);
    }

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        // 保留默认的模型数据
        Map<String, Object> attributes = super.getErrorAttributes(webRequest, includeStackTrace);
        // 添加固定的数据
        attributes.put("group", "com.mfun");
        // 添加携带的数据：从请求域获取 ext 属性
        Object ext = webRequest.getAttribute("ext", RequestAttributes.SCOPE_REQUEST);
        if (ext != null) {
            attributes.put("ext", ext);
        }
        return attributes;
    }
}

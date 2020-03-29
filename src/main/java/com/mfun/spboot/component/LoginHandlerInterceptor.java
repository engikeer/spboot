package com.mfun.spboot.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser == null) {
            // 未登录
            request.setAttribute("msg", "请先登陆");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        } else {
            // 已登陆
            return true;
        }

    }
}

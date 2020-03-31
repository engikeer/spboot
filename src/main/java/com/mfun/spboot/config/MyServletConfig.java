package com.mfun.spboot.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

//@Configuration
public class MyServletConfig {

    @Bean
    public ServletRegistrationBean<HttpServlet> myServlet() {
        // 传入 servlet 实例，映射路径（可变参数，可传入多个）
        // 将 MyServlet 实例映射到 项目路径/myServlet
        // return new ServletRegistrationBean<>(new MyServlet(), "/myServlet", "/servletOfMine");
        // 可以保存注册对象实例，用它设置注册 servlet 时的其他属性
        HttpServlet myServlet = new MyServlet();
        ServletRegistrationBean<HttpServlet> registration = new ServletRegistrationBean<>(myServlet);
        // 注意，servletRegistrationBean 的 setUrlMappings 需要传入 Collection<String>
        registration.setUrlMappings(Arrays.asList("/myServlet", "/servletOfMine"));
        registration.setLoadOnStartup(1);
        return registration;
    }

    @Bean
    public FilterRegistrationBean<Filter> myFilter() {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new CharacterEncodingFilter());
        registration.addUrlPatterns("/emp/*", "/users/*");
        return registration;
    }

    @Bean
    public ServletListenerRegistrationBean<ServletContextListener> myListener() {
        ServletContextListener listener = new ServletContextListener() {
            @Override
            public void contextInitialized(ServletContextEvent sce) {
                System.out.println("应用启动");
            }
            @Override
            public void contextDestroyed(ServletContextEvent sce) {
                System.out.println("应用退出");
            }
        };
        return new ServletListenerRegistrationBean<>(listener);
    }
}

class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        try (PrintWriter writer = resp.getWriter()) {
            writer.println("<h3>myServlet 哦后后</h3>");
        }
    }
}
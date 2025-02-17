package com.blogsystem.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private static final List<String> EXCLUDE_PATHS = Arrays.asList(
            "/**/*.html",
            "/blog-editormd/**",
            "/css/**",
            "/js/**",
            "/pic/**",
            "/user/login"
    );

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//注册自定义拦截器对象
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")//设置拦截器拦截的请求路径（ /** 表示拦截所有请求）
                .excludePathPatterns(EXCLUDE_PATHS);
    }
}

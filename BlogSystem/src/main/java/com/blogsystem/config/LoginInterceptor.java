package com.blogsystem.config;


import com.blogsystem.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse
            response, Object handler) throws Exception {
//从header中获取token
        String jwtToken = request.getHeader("user_token");
        log.info("从header中获取token:{}",jwtToken);
//验证用户token
        Claims claims = JwtUtil.parseJWT(jwtToken);
        if (claims!=null){
            log.info("令牌验证通过, 放行");
            return true;
        }
        response.setStatus(401);
        return true;
    }
}

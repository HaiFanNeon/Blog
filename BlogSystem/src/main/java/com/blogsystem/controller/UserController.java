package com.blogsystem.controller;


import com.blogsystem.mapper.UserInfoMapper;
import com.blogsystem.model.Result;
import com.blogsystem.model.UserInfo;
import com.blogsystem.service.UserService;
import com.blogsystem.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/user")
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public Result login(String userName, String password) {
        /**
         * 1. 参数校验
         * 2. 密码校验
         * 3. 生成token，并返回
         */
        if (!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)) {
            return Result.fail("用户名或密码不能为空");
        }


        UserInfo userInfo = userService.queryByName(userName);

        if (userInfo == null || userInfo.getId() < 0) {
            return Result.fail("用户不存在");
        }

        if (!password.equals(userInfo.getPassword())) {
            return Result.fail("密码错误");
        }

        Map<String ,Object> claim = new HashMap<>();
        claim.put("id", userInfo.getId());
        claim.put("name", userInfo.getUserName());
        String token = JwtUtil.getToken(claim);
        log.info(token);
        return Result.success(token);

    }

    @RequestMapping("/getUserInfo")
    public UserInfo getUserInfo(HttpServletRequest request){

        String jwtToken = request.getHeader("user_token");

        Claims claims = JwtUtil.parseJWT(jwtToken);
        Integer userId = (Integer) claims.get("id");
        if (userId != null){
            return userService.queryById(userId);
        }
        return null;
    }

    @RequestMapping("/getAuthorInfo")
    public UserInfo getAuthorInfo(Integer blogId) {
        if (blogId == null || blogId < 0) {
            return null;
        }
        return userService.getAuthorInfo(blogId);
    }
}

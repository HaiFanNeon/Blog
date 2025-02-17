package com.blogsystem.controller;


import com.blogsystem.model.BlogInfo;
import com.blogsystem.service.BlogService;
import com.blogsystem.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping("/getList")
    public List<BlogInfo> getBlogList() {
        return blogService.getBlogList();
    }

    @RequestMapping("/getBlogDetail")
    public BlogInfo getBlogDetail(Integer id) {
        return blogService.getBlogDetail(id);
    }

    @RequestMapping("/add")
    public Boolean publishBlog(String title, String content, HttpServletRequest request) {
        BlogInfo blogInfo = new BlogInfo();
        String jwtToken = request.getHeader("user_token");

        Claims claims = JwtUtil.parseJWT(jwtToken);
        Integer userId = (Integer) claims.get("id");

        blogInfo.setUserId(userId);
        blogInfo.setTitle(title);
        blogInfo.setContent(content);
        blogService.insertBlog(blogInfo);
        return true;
    }
}

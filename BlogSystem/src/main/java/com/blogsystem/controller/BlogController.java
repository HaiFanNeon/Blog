package com.blogsystem.controller;


import com.blogsystem.model.BlogInfo;
import com.blogsystem.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

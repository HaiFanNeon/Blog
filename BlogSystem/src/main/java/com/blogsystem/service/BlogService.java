package com.blogsystem.service;


import com.blogsystem.mapper.BlogInfoMapper;
import com.blogsystem.model.BlogInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogInfoMapper blogInfoMapper;

    public List<BlogInfo> getBlogList() {
        List<BlogInfo> blogInfos = blogInfoMapper.queryBlogList();
        return blogInfos;
    }


    public BlogInfo getBlogDetail(Integer blogId) {
        BlogInfo blogInfo = blogInfoMapper.queryById(blogId);
        return blogInfo;
    }

    public void insertBlog(BlogInfo blogInfo) {
        blogInfoMapper.insertBlog(blogInfo);
    }
}

package com.blogsystem.mapper;

import com.blogsystem.model.BlogInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



@Slf4j
@SpringBootTest
class BlogInfoMapperTest {

    @Autowired
    private BlogInfoMapper blogInfoMapper;

    @Test
    void queryBlogList() {
        List<BlogInfo> blogInfos = blogInfoMapper.queryBlogList();
        log.info(blogInfos.toString());
    }

    @Test
    void queryById() {
        BlogInfo blogInfo = blogInfoMapper.queryById(1);
        log.info(blogInfo.toString());
    }

    @Test
    void updateBlog() {

//        @Update("update blog set title = #{title}, content = #{content} where id = #{id}")
//        Integer updateBlog(@Param("blogInfo") BlogInfo blogInfo);

        BlogInfo blogInfo = new BlogInfo();
        blogInfo.setTitle("hello world");
        blogInfo.setContent("hello world");
        blogInfo.setId(1);
        blogInfoMapper.updateBlog(blogInfo);
    }

    @Test
    void deleteBlog() {
        blogInfoMapper.deleteBlog(2);
    }

    @Test
    void insetBlog() {

//        private Integer id;
//        private String title;
//        private String content;
//        private Integer userId;
//        private Integer deleteFlag;
//        private Date createTime;
//        private Date updateTime;

        BlogInfo blogInfo = new BlogInfo();
        blogInfo.setTitle("test");
        blogInfo.setContent("test");
        blogInfo.setUserId(2);
        blogInfo.setDeleteFlag(0);
        blogInfo.setCreateTime(new Date());
        blogInfo.setUpdateTime(new Date());
        blogInfoMapper.insertBlog(blogInfo);
    }
}
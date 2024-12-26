package com.blogsystem.mapper;


import com.blogsystem.model.BlogInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BlogInfoMapper {

    /**
     * 获取博客列表
     * @return
     */
    @Select("select * from blog where delete_flag = 0")
    List<BlogInfo> queryBlogList();


    /**
     * 根据id查询博客
     * @param id
     * @return
     */
    @Select("select * from blog where id = #{id}")
    BlogInfo queryById(@Param("id") Integer id);

    @Update("update blog set title = #{title}, content = #{content} where id = #{id}")
    Integer updateBlog(BlogInfo blogInfo);

    @Update("update blog set delete_flag = 1 where id = #{id}")
    Integer deleteBlog(@Param("id") Integer id);

    @Insert("insert into blog(title, content, user_id) values (#{title}, #{content}, #{userId})")
    Integer insertBlog(BlogInfo blogInfo);
}

package com.blogsystem.mapper;


import com.blogsystem.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {

    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    @Select("select * from user where user_name = #{userName}")
    UserInfo queryByName(@Param("userName") String userName);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    UserInfo queryById(@Param("id") Integer id);
}

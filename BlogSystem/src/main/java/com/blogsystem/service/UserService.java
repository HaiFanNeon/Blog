package com.blogsystem.service;


import com.blogsystem.mapper.BlogInfoMapper;
import com.blogsystem.mapper.UserInfoMapper;
import com.blogsystem.model.BlogInfo;
import com.blogsystem.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private BlogInfoMapper blogInfoMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo queryByName(String userName) {
        UserInfo userInfo = userInfoMapper.queryByName(userName);
        return userInfo;
    }

    public UserInfo queryById(Integer id) {
        return userInfoMapper.queryById(id);
    }

    public UserInfo getAuthorInfo(Integer blogId) {
        BlogInfo blogInfo = blogInfoMapper.queryById(blogId);
        if (blogInfo == null || blogInfo.getUserId() < 0) {
            return null;
        }
        return userInfoMapper.queryById(blogInfo.getUserId());
    }
}

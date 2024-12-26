package com.blogsystem.mapper;

import com.blogsystem.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void queryByName() {
        UserInfo zhangsan = userInfoMapper.queryByName("zhangsan");
        log.info("{}", zhangsan);
    }

    @Test
    void queryById() {
        UserInfo zhangsan = userInfoMapper.queryById(1);
        log.info("{}", zhangsan);
    }
}
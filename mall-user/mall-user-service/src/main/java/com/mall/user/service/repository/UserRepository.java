package com.mall.user.service.repository;

import com.mall.user.model.pojo.User;
import com.mall.user.model.pojo.UserExample;
import com.mall.user.service.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: xiaoxu.nie
 * @date: 2018-07-22 16:47
 */
@Slf4j
@Service
public class UserRepository {

    @Autowired
    private UserMapper userMapper;

    public User findByUserName(String userName) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(userName);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList != null && !userList.isEmpty()) {
            return userList.get(0);
        }
        return null;
    }
}

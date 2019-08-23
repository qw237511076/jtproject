package com.jt.manager.service.impl;

import com.jt.manager.mapper.UserMapper;
import com.jt.manager.pojo.User;
import com.jt.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sumail
 * @date 2019/8/23 0023-${time}
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}

package com.toray.ojt.web.service.impl;

import com.toray.ojt.web.entity.User;
import com.toray.ojt.web.mapper.UserMapper;
import com.toray.ojt.web.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper){
        this.userMapper = userMapper;
    }
    @Override
    public User findByAccountId(String accountId) {
        return userMapper.findByAccountId(accountId);

    }
}

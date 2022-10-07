package com.user.service.Impl;

import com.test.eneity.User;
import com.user.mapper.UserMapper;
import com.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper mapper;

    @Override
    public User getUserById(int uid) {
        System.out.println("Hello world");
        return mapper.getUserById(uid);
    }

    @Override
    public int getRemain(int uid) {
        return mapper.getUserBookRemain(uid);
    }

    @Override
    public boolean setRemain(int uid, int count) {
        return mapper.updateBookCount(uid, count) > 0;
    }
}

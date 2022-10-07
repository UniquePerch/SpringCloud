package com.user.service;


import com.test.eneity.User;

public interface UserService {
    User getUserById(int uid);

    int getRemain(int uid);

    boolean setRemain(int uid, int count);
}

package com.xaeport.cinsight.ui.service;

import com.xaeport.cinsight.ui.data.entity.User;
import com.xaeport.cinsight.ui.data.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/24.
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User getUsersInfo() {
        return  userMapper.findUsersInfo();
    }

    public User getUserInfo(String name){
        return userMapper.findUserInfo(name);
    }
}

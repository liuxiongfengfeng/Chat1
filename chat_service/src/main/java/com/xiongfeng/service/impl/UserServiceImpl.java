package com.xiongfeng.service.impl;

import com.xiongfeng.mapper.UserMapper;
import com.xiongfeng.pojo.User;
import com.xiongfeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 刘雄锋
 * @version 1.0
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(String username,String password) {
        User user = userMapper.findByNameAndPw(username, password);
        if (user != null){
            return true;
        }
        return false;
    }

    @Override
    public boolean register(User user) {
        User byName = userMapper.findByName(user.getUsername());
        if (byName == null){
            int count = userMapper.save(user);
            if (count > 0){
                return true;
            }
        }
        return false;
    }
}

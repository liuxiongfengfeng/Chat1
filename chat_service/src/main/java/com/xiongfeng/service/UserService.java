package com.xiongfeng.service;

import com.xiongfeng.pojo.User;

/**
 * @author 刘雄锋
 * @version 1.0
 */
public interface UserService {

    boolean login(String username,String password);

    boolean register(User user);
}

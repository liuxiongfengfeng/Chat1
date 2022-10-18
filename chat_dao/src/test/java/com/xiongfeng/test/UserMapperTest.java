package com.xiongfeng.test;

import com.xiongfeng.mapper.UserMapper;
import com.xiongfeng.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 刘雄锋
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext-dao.xml","classpath:applicationContext-pojo.xml"})
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

//    @Test
//    public void test01(){
//        User user = new User();
//        user.setUsername("haha");
//        user.setPassword("123456");
//        user.setNickname("xixi");
//        System.out.println(userMapper.save(user));
//    }

    @Test
    public void test02(){
        User byId = userMapper.findById(1);
        System.out.println(byId);
    }

    @Test
    public void test03(){
        List<User> all = userMapper.findAll();
        System.out.println(all);
    }
}

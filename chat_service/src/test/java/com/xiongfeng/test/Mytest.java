package com.xiongfeng.test;

import com.xiongfeng.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author 刘雄锋
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext-dao.xml",
        "classpath:applicationContext-pojo.xml",
        "classpath:applicationContext-service.xml"})
public class Mytest {

    @Autowired
    private UserService userService;
    @Test
    public void test01(){
        boolean haha = userService.login("haha", "123456");
        System.out.println(haha);
    }
}

package com.xiongfeng.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xiongfeng.message.ResultMessage;
import com.xiongfeng.pojo.User;
import com.xiongfeng.service.UserService;
import com.xiongfeng.utils.JWTUtils;
import com.xiongfeng.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
/**
 * @author 刘雄锋
 * @version 1.0
 */
@Controller
@RequestMapping("/user")
@CrossOrigin(origins = "*")
@ResponseBody
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/login")
    public ResultMessage login(@RequestBody User user, HttpSession session){
        String username = user.getUsername();
        String password = user.getPassword();
        System.out.println(user);
        boolean flag = userService.login(username,password);
        ResultMessage resultMessage = new ResultMessage(true, null, StatusCode.OK, true);
        if (!flag){
            resultMessage.setMessage("登录失败");
            resultMessage.setFlag(false);
            return resultMessage;
        }
        String token = JWTUtils.sign(username);
        System.out.println(token);
        resultMessage.setMessage(token);
        session.setAttribute("token",token);
        return resultMessage;
    }


    @RequestMapping("/register")
    public ResultMessage register(@RequestBody User user) throws JsonProcessingException {
        boolean flag = userService.register(user);
        ResultMessage resultMessage = new ResultMessage(true, "注册成功", StatusCode.OK, true);
//        注册失败
        if (!flag){
            resultMessage.setMessage("注册失败");
            resultMessage.setFlag(false);
            return resultMessage;
        }
        return resultMessage;
    }


    @RequestMapping("/test")
    public String test01(){
        return "hahahaha";
    }

}

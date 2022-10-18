package com.xiongfeng.intercept;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiongfeng.message.ResultMessage;
import com.xiongfeng.utils.JWTUtils;
import com.xiongfeng.utils.StatusCode;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 此处拦截器
 */
public class TokenInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("utf-8");
        response.setHeader("content-type","text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        System.out.println(cookies);
        for (Cookie c:cookies) {
            if (c.getName().equals("token")){
                if (JWTUtils.verify(c.getValue())){
                    return true;
                }
                return false;
            }
        }
        PrintWriter writer = response.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        writer.print(objectMapper.writeValueAsString(new ResultMessage(true,"用户未登录", StatusCode.UNAUTHORIZED,false)));
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }

}
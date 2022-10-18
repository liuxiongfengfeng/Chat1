package com.xiongfeng.utils;

/**
 * @author 刘雄锋
 * @version 1.0
 */
public interface StatusCode{
    int OK = 200;
    int CREATED = 201; // 请求建立了新的资源
    int BAD_REQUEST = 400; //请求错误
    int NOT_FOUNT = 404; //
    int SERVER_ERROR = 500;
    int UNAUTHORIZED = 401; //未授权


}

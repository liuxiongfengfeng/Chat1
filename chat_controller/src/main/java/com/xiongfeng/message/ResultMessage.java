package com.xiongfeng.message;

import org.springframework.stereotype.Component;

/**
 * @author 刘雄锋
 * @version 1.0
 */

@Component
public class ResultMessage {

    private boolean isSystem; // 是否系统消息
    private String message; // 消息内容
    private int code; // 响应状态码
    private boolean flag; // 请求是否成功

    public ResultMessage(boolean isSystem, String message, int code, boolean flag) {
        this.isSystem = isSystem;
        this.message = message;
        this.code = code;
        this.flag = flag;
    }

    public ResultMessage() {
    }

    public boolean isSystem() {
        return isSystem;
    }

    public void setSystem(boolean system) {
        isSystem = system;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

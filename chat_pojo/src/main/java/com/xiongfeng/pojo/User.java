package com.xiongfeng.pojo;

import org.springframework.stereotype.Component;

/**
 * @author 刘雄锋
 * @version 1.0
 */

@Component
public class User {
    private int id;
    private String username; //用户名
    private String password; //密码
    private String nickname; //昵称
    private String photo; //头像
    private byte power; //权限

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public byte getPower() {
        return power;
    }

    public void setPower(byte power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", photo='" + photo + '\'' +
                ", power=" + power +
                '}';
    }
}

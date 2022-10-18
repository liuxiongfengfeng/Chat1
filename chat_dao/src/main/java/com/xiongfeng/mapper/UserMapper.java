package com.xiongfeng.mapper;

import com.xiongfeng.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 刘雄锋
 * @version 1.0
 */

public interface UserMapper {

    @Insert({"<script>",
            "insert into user(id,username,password",
            "<if test='nickname != null'>,nickname</if>",
            "<if test='photo != null'>,photo</if>",
            "<if test='power != null'>,power</if>",
            ") values(#{id},#{username},#{password}",
            "<if test='nickname != null'>,#{nickname}</if>",
            "<if test='photo != null'>,#{photo}</if>",
            "<if test='power != null'>,#{power}</if>",
            ")",
            "</script>"})
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int save(User user);

    @Select("select * from user where id=#{id}")
    User findById(int id);

    @Select("select * from user where username=#{username}")
    User findByName(String username);

    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where username=#{username} and password=#{password}")
    User findByNameAndPw(@Param("username") String username, @Param("password")String password);

}

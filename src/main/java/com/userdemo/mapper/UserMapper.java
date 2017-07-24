package com.userdemo.mapper;

import com.userdemo.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: wAiXi
 * @Date: 2017/7/21
 * @Time: 15:55
 * @Description:
 */
@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> findAll();

    @Insert("INSERT into user" +
            " (userName,userAge) VALUES" +
            " (#{userName},#{userAge})")
    void add(User user);

    @Delete("delete from user where userId=#{id}")
    void delete(@Param("id") int id);

    //这里的SQL语句可以分行，但是空格不能少！！因此建议每次分行的时候在关键字前面加空格
    @Update("update user set userName=#{userName},userAge=#{userAge}" +
            " where userId=#{userId}")
    void update(User user);
}

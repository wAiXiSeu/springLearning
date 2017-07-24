package com.userdemo.mapper;

import com.userdemo.model.User;

import java.util.List;

/**
 * @author: wAiXi
 * @Date: 2017/7/21
 * @Time: 15:55
 * @Description:
 */
public interface UserMapper {
    List<User> findAll();
    void add(User user);
    void delete(int id);
    void update(User user);
}

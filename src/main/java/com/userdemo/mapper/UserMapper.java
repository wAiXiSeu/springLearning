package com.userdemo.mapper;

import com.userdemo.model.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author: wAiXi
 * @Date: 2017/7/21
 * @Time: 15:55
 * @Description:
 */
@Configuration
@ComponentScan(basePackageClasses = com.userdemo.model.User.class)
public interface UserMapper {
    List<User> findAll();
    void add(User user);
    void delete(int id);
    void update(User user);
}

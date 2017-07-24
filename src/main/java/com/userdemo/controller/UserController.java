package com.userdemo.controller;

import com.userdemo.mapper.UserMapper;
import com.userdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: wAiXi
 * @Date: 2017/7/21
 * @Time: 15:55
 * @Description:
 */
@Controller
public class UserController {
    @Autowired
    UserMapper userMapper;

    @Autowired
    User user;

    @RequestMapping("/")
    public String welcome() {
        return "index";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<User> findAllUsers() {
        return userMapper.findAll();
    }

    @RequestMapping("/add")
    @ResponseBody
    public List<User> add(@RequestParam("name") String userName, @RequestParam("age") int userAge) {
        user.setUserName(userName);
        user.setUserAge(userAge);
        userMapper.add(user);
        return userMapper.findAll();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public List<User> delete(@RequestParam("id") int userId) {
        userMapper.delete(userId);
        return userMapper.findAll();
    }

    @RequestMapping("/update")
    @ResponseBody
    public List<User> update(@RequestParam("id") String userId, @RequestParam("name") String userName, @RequestParam("age") int userAge) {
        if (userId.equals("")) {
            add(userName, userAge);
        } else {
            user.setUserId(Integer.parseInt(userId));
            user.setUserName(userName);
            user.setUserAge(userAge);
            userMapper.update(user);
        }
        return userMapper.findAll();
    }

    @RequestMapping("/search")
    @ResponseBody
    public List<User> search(@RequestParam("content") String content){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(content);
        if (!isNum.matches()) {
            return userMapper.findByName("%" + content + "%");
        } else {
            return userMapper.findByAge("%" + content + "%");
        }
    }
}

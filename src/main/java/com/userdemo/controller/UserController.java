package com.userdemo.controller;

import com.userdemo.mapper.UserMapper;
import com.userdemo.model.User;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @RequestMapping("/")
    public String welcome(){
        return "index";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<User> findAllUsers(){
        return userMapper.findAll();
    }

    @RequestMapping("/add")
    @ResponseBody
    public List<User> add(@RequestParam("name") String userName,@RequestParam("age") int userAge){
        User user = new User();
        user.setUserName(userName);
        user.setUserAge(userAge);
        userMapper.add(user);
        return userMapper.findAll();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public List<User> delete(@RequestParam("id") int userId){
        userMapper.delete(userId);
        return userMapper.findAll();
    }

    @RequestMapping("/update")
    @ResponseBody
    public List<User> update(HttpServletRequest request,@RequestParam("name") String userName, @RequestParam("age") int userAge) {
        String userId = request.getParameter("id");
        if (userId == null || userId.equals("")) {
            add(userName, userAge);
        }else{
            User user = new User(Integer.parseInt(userId), userName, userAge);
            userMapper.update(user);
        }
        return userMapper.findAll();
    }
}

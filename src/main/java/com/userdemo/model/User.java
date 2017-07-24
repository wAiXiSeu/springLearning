package com.userdemo.model;

import org.springframework.stereotype.Component;

/**
 * @author: wAiXi
 * @Date: 2017/7/21
 * @Time: 15:56
 * @Description:
 */
@Component
public class User {
    private int userId;
    private String userName;
    private int userAge;

    public User(){}

    public User(int userId, String userName, int userAge) {
        this.userId = userId;
        this.userName = userName;
        this.userAge = userAge;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }
}

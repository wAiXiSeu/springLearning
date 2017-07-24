package com.userdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: wAiXi
 * @Date: 2017/7/21
 * @Time: 15:48
 * @Description:
 */
@SpringBootApplication
@MapperScan("com.userdemo.mapper")
public class UserApp {
    public static void main(String[] args){
        SpringApplication.run(UserApp.class, args);
    }
}

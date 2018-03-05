package com.lcz.dubbo.controller;

import com.lcz.dubbo.model.User;
import com.lcz.dubbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by luchunzhou on 2018/3/5.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User queryUser(@PathVariable("id") Integer id){
        return userService.queryUser(id);
    }

    @GetMapping("/list")
    public List<User> queryUserList(){
        return userService.queryUserList();
    }
}

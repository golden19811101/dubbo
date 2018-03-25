package com.lcz.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lcz.dubbo.model.User;
import com.lcz.dubbo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by luchunzhou on 2018/3/5.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Reference(version = "1.0.0")
    private UserService userService;

    @GetMapping("/{id}")
    public User queryUser(@PathVariable("id") Integer id){
        return userService.queryUser(id);
    }

    @GetMapping("/list")
    public List<User> queryUserList(){
        return userService.queryUserList();
    }

    @PostMapping("/save")
    public void saveUser(@RequestBody User user){
        userService.saveUser(user);
    }

    @PostMapping("/update")
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @GetMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id")String id){
        userService.deleteUser(id);
    }
}

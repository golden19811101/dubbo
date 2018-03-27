package com.lcz.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lcz.dubbo.model.User;
import com.lcz.dubbo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return userService.queryUserList(new HashMap<>(0));
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
    public String deleteUser(@PathVariable("id")Integer id){
        User user = userService.queryUser(id);
        if(null != user){
            userService.deleteUser(id);
            return "delete success";
        }else{
            return "delete failure";
        }

    }
}

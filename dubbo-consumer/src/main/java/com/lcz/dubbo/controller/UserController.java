package com.lcz.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lcz.dubbo.core.aop.annotation.SysLog;
import com.lcz.dubbo.core.util.R;
import com.lcz.dubbo.model.User;
import com.lcz.dubbo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public R queryUser(@PathVariable("id") Integer id){
        User user = userService.queryUser(id);
        return R.ok().put("user", user);
    }

    @GetMapping("/list")
    public R queryUserList(){
        List<User> userList = userService.queryUserList(new HashMap<>(0));
        return R.ok().put("userList",userList);
    }

    @SysLog("保存用户")
    @PostMapping("/save")
    public R saveUser(@RequestBody User user){
        userService.saveUser(user);
        return R.ok("保存成功");
    }

    @SysLog("更新用户")
    @PostMapping("/update")
    public R updateUser(@RequestBody User user){
        userService.updateUser(user);
        return R.ok("更新成功");
    }

    @SysLog("删除用户")
    @GetMapping("/delete/{id}")
    public R deleteUser(@PathVariable("id")Integer id){
        User user = userService.queryUser(id);
        if(null != user){
            userService.deleteUser(id);
            return R.ok("删除成功");
        }else{
            return R.error("删除失败");
        }

    }
}

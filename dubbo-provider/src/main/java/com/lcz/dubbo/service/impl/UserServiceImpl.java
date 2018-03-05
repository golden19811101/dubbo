package com.lcz.dubbo.service.impl;

import com.lcz.dubbo.dao.UserDao;
import com.lcz.dubbo.model.User;
import com.lcz.dubbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:luchunzhou
 * @date:2018/1/10
 * @time:16:43
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 查询对象
     * @param id
     * @return
     */
    @Override
    public User queryUser(Integer id) {
        return userDao.queryObject(id);
    }

    /**
     * 查询集合
     * @return
     */
    @Override
    public List<User> queryUserList() {
        return userDao.queryList();
    }
}
package com.lcz.dubbo.service;

import com.lcz.dubbo.model.User;

import java.util.List;
import java.util.Map;

/**
 * @author:luchunzhou
 * @date:2018/3/5
 * @time:11:02
 */
public interface UserService {

    /**
     * 查询对象
     * @param id
     * @return
     */
    User queryUser(Integer id);

    /**
     * 查询集合
     * @return
     */
    List<User> queryUserList(Map<String, Object> map);

    /**
     * 保存对象
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新对象
     * @param user
     */
    int updateUser(User user);

    /**
     * 删除对象
     * @param id
     */
    int deleteUser(Integer id);
}
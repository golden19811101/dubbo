package com.lcz.dubbo.dao;

import com.lcz.dubbo.model.User;
import java.util.List;

/**
 * @author:luchunzhou
 * @date:2018/3/5
 * @time:11:02
 */
public interface UserDao {

    /**
     * 查询对象
     * @param id
     * @return
     */
    User queryObject(Integer id);

    /**
     * 查询集合
     * @return
     */
    List<User> queryList();
}
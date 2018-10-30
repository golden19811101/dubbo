package com.lcz.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lcz.dubbo.core.exception.CCException;
import com.lcz.dubbo.core.lock.DistributedLock;
import com.lcz.dubbo.core.util.DistributedLockUtil;
import com.lcz.dubbo.dao.UserDao;
import com.lcz.dubbo.model.User;
import com.lcz.dubbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author:luchunzhou
 * @date:2018/1/10
 * @time:16:43
 */
@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {
    private DistributedLock lock = null;

    @Autowired
    private UserDao userDao;

    /**
     * 查询对象
     *
     * @param id
     * @return
     */
    @Override
    public User queryUser(String id) {
        return userDao.queryObject(id);
    }

    /**
     * 查询集合
     *
     * @return
     */
    @Override
    public List<User> queryUserList(Map<String, Object> map) {
        return userDao.queryList(map);
    }

    @Override
    public void saveUser(User user) {
        lock = DistributedLockUtil.getDistributedLock("saveUser_" + user.getId());
        try {
            if (lock.acquire()) {
                //获取锁成功
                //保存
                userDao.save(user);
            } else {
                // 获取锁失败
                throw new CCException("保存用户信息失败");
            }
        } catch (Exception e) {
            throw new CCException("保存用户信息失败");
        } finally {
            if (lock != null) {
                //释放锁
                lock.release();
            }
        }

    }

    @Override
    public int updateUser(User user) {
        int result = -1;
        lock = DistributedLockUtil.getDistributedLock("updateUser_" + user.getId());
        try {
            if (lock.acquire()) {
                //获取锁成功
                //保存
                result = userDao.update(user);
            } else {
                // 获取锁失败
                // todo 不更新，返回失败信息
                result = -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (lock != null) {
                //释放锁
                lock.release();
            }
        }
        return result;
    }

    @Override
    public int deleteUser(String id) {
        int result = -1;
        lock = DistributedLockUtil.getDistributedLock("deleteUser_" + id);
        try {
            if (lock.acquire()) {
                //获取锁成功
                //保存
                result = userDao.delete(id);
            } else {
                // 获取锁失败
                // todo 不删除，返回失败信息
                result = -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (lock != null) {
                //释放锁
                lock.release();
            }
        }
        return result;
    }
}
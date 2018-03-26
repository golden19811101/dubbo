package com.lcz.dubbo.core.rpc;

/**
 * 分布式锁接口
 * @author:luchunzhou
 * @date:2018/3/25
 * @time:14:01
 */
public interface DistributedLock {

    /**
     * 获取锁
     * @return
     */
    boolean acquire();

    /**
     * 释放锁
     */
    void release();

}
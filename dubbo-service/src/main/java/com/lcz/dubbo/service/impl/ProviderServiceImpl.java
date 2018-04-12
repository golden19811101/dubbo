package com.lcz.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lcz.dubbo.service.ProviderService;

/**
 * @author:luchunzhou
 * @date:2018/1/10
 * @time:16:43
 */
@Service(version = "1.0.0")
public class ProviderServiceImpl implements ProviderService {
    @Override
    public String sendMsg() {
        return "CC发送了一条消息......";
    }
}
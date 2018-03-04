package com.lcz.dubbo.service.impl;

import com.lcz.dubbo.service.ProviderService;
import org.springframework.stereotype.Service;

/**
 * @author:luchunzhou
 * @date:2018/1/10
 * @time:16:43
 */
@Service("providerService")
public class ProviderServiceImpl implements ProviderService {
    @Override
    public String sendMsg() {
        return "CC发送了一条消息......";
    }
}
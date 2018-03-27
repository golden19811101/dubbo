package com.lcz.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lcz.dubbo.core.util.R;
import com.lcz.dubbo.service.ProviderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:luchunzhou
 * @date:2018/1/10
 * @time:16:58
 */
@RestController
public class ConsumerController {

    @Reference(version = "1.0.0")
    private ProviderService providerService;

    @RequestMapping("/sendMsg")
    public R senMsg(){
        String msg = providerService.sendMsg();
        return R.ok(msg);
    }
}
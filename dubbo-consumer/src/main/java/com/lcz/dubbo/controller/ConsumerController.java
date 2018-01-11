package com.lcz.dubbo.controller;

import com.lcz.dubbo.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:luchunzhou
 * @date:2018/1/10
 * @time:16:58
 */
@RestController
public class ConsumerController {

    @Autowired
    private ProviderService providerService;

    @RequestMapping("/sendMsg")
    public String senMsg(){
        String msg = providerService.sendMsg();
        return msg;
    }
}
package com.lcz.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lcz.dubbo.core.util.R;
import com.lcz.dubbo.model.SysLogModel;
import com.lcz.dubbo.service.SysLogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 系统日志
 * 
 * @author luchunzhou
 * @date 2018-3-27
 */
@Controller
@RequestMapping(value = "/sys/log")
public class SysLogController {

	@Reference(version = "1.0.0")
	private SysLogService sysLogService;

	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		List<SysLogModel> sysLogList = sysLogService.queryList(new HashMap<>(0));

		return R.ok().put("sysLogList", sysLogList);
	}
	
}

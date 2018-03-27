package com.lcz.dubbo.service;

import com.lcz.dubbo.model.SysLogModel;

import java.util.List;
import java.util.Map;

/**
 * 系统日志
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-08 10:40:56
 */
public interface SysLogService {

	SysLogModel queryObject(String id);
	
	List<SysLogModel> queryList(Map<String, Object> map);

	List<SysLogModel> queryLogDaily();
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysLogModel sysLogModel);
	
	void update(SysLogModel sysLogModel);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}

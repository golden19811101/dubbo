package com.lcz.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lcz.dubbo.core.util.IdUtil;
import com.lcz.dubbo.core.util.StringUtil;
import com.lcz.dubbo.dao.SysLogDao;
import com.lcz.dubbo.model.SysLogModel;
import com.lcz.dubbo.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author luchunzhou
 * @date 2018-3-27
 */
@Service(version = "1.0.0")
public class SysLogServiceImpl implements SysLogService {
	@Autowired
	private SysLogDao sysLogDao;
	
	@Override
	public SysLogModel queryObject(String id){
		return sysLogDao.queryObject(id);
	}
	
	@Override
	public List<SysLogModel> queryList(Map<String, Object> map){
		return sysLogDao.queryList(map);
	}

	@Override
	public List<SysLogModel> queryLogDaily(){
		return sysLogDao.queryLogDaily();
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysLogDao.queryTotal(map);
	}
	
	@Override
	public void save(SysLogModel sysLogModel){
		if(StringUtil.isEmpty(sysLogModel.getId())){
			sysLogModel.setId(IdUtil.uuid());
		}
		sysLogDao.save(sysLogModel);
	}
	
	@Override
	public void update(SysLogModel sysLogModel){
		sysLogDao.update(sysLogModel);
	}
	
	@Override
	public void delete(String id){
		sysLogDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		sysLogDao.deleteBatch(ids);
	}
	
}

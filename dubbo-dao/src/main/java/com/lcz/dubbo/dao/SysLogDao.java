package com.lcz.dubbo.dao;


import com.lcz.dubbo.base.BaseDao;
import com.lcz.dubbo.model.SysLogModel;

import java.util.List;

/**
 * 系统日志
 * 
 * @author luchunzhou
 * @date 2018-3-27
 */
public interface SysLogDao extends BaseDao<SysLogModel> {

    /**
     * 查询每日日志list
     * @return
     */
    List<SysLogModel> queryLogDaily();
	
}

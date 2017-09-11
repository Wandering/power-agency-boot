package com.power.dao;

import com.power.entity.AgenciesEntity;
import io.renren.dao.BaseDao;
/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-21 23:02:38
 */
public interface AgenciesDao extends BaseDao<AgenciesEntity> {
	
	int queryAgencybyUserId(Long userId);
	
}

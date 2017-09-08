package io.renren.dao;

import java.util.List;
import java.util.Map;

import io.renren.entity.SysLogEntity;

/**
 * 系统日志
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-08 10:40:56
 */
public interface SysLogDao extends BaseDao<SysLogEntity> {

	SysLogEntity queryListLogin(Map<String, Object> map);

	int queryVisitTime(Map<String, Object> map);
	
}

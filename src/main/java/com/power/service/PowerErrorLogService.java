package com.power.service;

import com.power.entity.PowerErrorLogEntity;

import java.util.List;
import java.util.Map;

/**
 * 知路反馈充电宝异常
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-23 20:34:04
 */
public interface PowerErrorLogService {
	
	PowerErrorLogEntity queryObject(Long id);
	
	List<PowerErrorLogEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(PowerErrorLogEntity powerErrorLog);
	
	void update(PowerErrorLogEntity powerErrorLog);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}

package com.power.service;

import com.power.entity.PowerUserFreeTimeEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-19 19:26:00
 */
public interface PowerUserFreeTimeService {
	
	PowerUserFreeTimeEntity queryObject(Long id);
	
	List<PowerUserFreeTimeEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(PowerUserFreeTimeEntity powerUserFreeTime);
	
	void update(PowerUserFreeTimeEntity powerUserFreeTime);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}

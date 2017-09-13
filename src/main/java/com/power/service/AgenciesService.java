package com.power.service;

import com.power.entity.AgenciesEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-21 23:02:38
 */
public interface AgenciesService {
	
	AgenciesEntity queryObject(Long id);
	
	List<AgenciesEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AgenciesEntity agencies);
	
	void update(AgenciesEntity agencies);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
	
	AgenciesEntity queryAgencybyUserId(Long userId);
}

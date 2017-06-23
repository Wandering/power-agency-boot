package com.power.service;

import com.power.entity.AgencyOrderLifecyleEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-21 23:02:38
 */
public interface AgencyOrderLifecyleService {
	
	AgencyOrderLifecyleEntity queryObject(Long id);
	
	List<AgencyOrderLifecyleEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AgencyOrderLifecyleEntity agencyOrderLifecyle);
	
	void update(AgencyOrderLifecyleEntity agencyOrderLifecyle);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}

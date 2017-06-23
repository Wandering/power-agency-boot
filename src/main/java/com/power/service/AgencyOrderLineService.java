package com.power.service;

import com.power.entity.AgencyOrderLineEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-21 23:02:38
 */
public interface AgencyOrderLineService {
	
	AgencyOrderLineEntity queryObject(Long id);
	
	List<AgencyOrderLineEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AgencyOrderLineEntity agencyOrderLine);
	
	void update(AgencyOrderLineEntity agencyOrderLine);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}

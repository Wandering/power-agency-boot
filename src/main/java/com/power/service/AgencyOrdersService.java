package com.power.service;

import com.power.entity.AgencyOrdersEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-21 23:02:26
 */
public interface AgencyOrdersService {
	
	AgencyOrdersEntity queryObject(Long id);
	
	List<AgencyOrdersEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AgencyOrdersEntity agencyOrders);
	
	void update(AgencyOrdersEntity agencyOrders);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}

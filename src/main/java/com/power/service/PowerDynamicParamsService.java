package com.power.service;

import com.power.entity.PowerDynamicParamsEntity;

import java.util.List;
import java.util.Map;

/**
 * 动态可配置参数表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-29 09:13:50
 */
public interface PowerDynamicParamsService {
	
	PowerDynamicParamsEntity queryObject(Integer id);
	
	List<PowerDynamicParamsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(PowerDynamicParamsEntity powerDynamicParams);
	
	void update(PowerDynamicParamsEntity powerDynamicParams);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}

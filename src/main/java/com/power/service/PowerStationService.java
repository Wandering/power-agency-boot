package com.power.service;

import com.power.entity.PowerStationEntity;

import java.util.List;
import java.util.Map;

/**
 * 网点基础表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-23 19:43:25
 */
public interface PowerStationService {
	
	PowerStationEntity queryObject(Long id);
	
	List<PowerStationEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(PowerStationEntity powerStation);
	
	void update(PowerStationEntity powerStation);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}

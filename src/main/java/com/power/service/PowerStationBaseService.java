package com.power.service;

import com.power.entity.PowerStationBaseEntity;

import java.util.List;
import java.util.Map;

/**
 * 充电桩基础表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-28 20:03:38
 */
public interface PowerStationBaseService {
	
	PowerStationBaseEntity queryObject(Integer id);
	
	List<PowerStationBaseEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(PowerStationBaseEntity powerStationBase);
	
	void update(PowerStationBaseEntity powerStationBase);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}

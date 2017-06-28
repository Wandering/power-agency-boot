package com.power.service;

import com.power.entity.StationModelEntity;

import java.util.List;
import java.util.Map;

/**
 * 充电桩型号
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-28 19:17:40
 */
public interface StationModelService {
	
	StationModelEntity queryObject(Long id);
	
	List<StationModelEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(StationModelEntity stationModel);
	
	void update(StationModelEntity stationModel);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}

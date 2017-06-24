package com.power.service;

import com.power.entity.StationErrorLogEntity;

import java.util.List;
import java.util.Map;

/**
 * 桩信息错误日志
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-23 20:34:04
 */
public interface StationErrorLogService {
	
	StationErrorLogEntity queryObject(Long id);
	
	List<StationErrorLogEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(StationErrorLogEntity stationErrorLog);
	
	void update(StationErrorLogEntity stationErrorLog);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}

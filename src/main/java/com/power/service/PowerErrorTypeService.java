package com.power.service;

import com.power.entity.PowerErrorTypeEntity;

import java.util.List;
import java.util.Map;

/**
 * 异常类别表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-29 09:41:28
 */
public interface PowerErrorTypeService {
	
	PowerErrorTypeEntity queryObject(Integer id);
	
	List<PowerErrorTypeEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(PowerErrorTypeEntity powerErrorType);
	
	void update(PowerErrorTypeEntity powerErrorType);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}

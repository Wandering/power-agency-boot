package com.power.service;

import com.power.entity.PowerModelEntity;

import java.util.List;
import java.util.Map;

/**
 * 充电宝型号
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-24 16:01:17
 */
public interface PowerModelService {
	
	PowerModelEntity queryObject(Long id);
	
	List<PowerModelEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(PowerModelEntity powerModel);
	
	void update(PowerModelEntity powerModel);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}

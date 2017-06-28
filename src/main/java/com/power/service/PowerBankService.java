package com.power.service;

import com.power.entity.PowerBankEntity;

import java.util.List;
import java.util.Map;

/**
 * 充电宝基础表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-28 19:34:39
 */
public interface PowerBankService {
	
	PowerBankEntity queryObject(Long id);
	
	List<PowerBankEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(PowerBankEntity powerBank);
	
	void update(PowerBankEntity powerBank);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}

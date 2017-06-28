package com.power.service;

import com.power.entity.DictCommonEntity;

import java.util.List;
import java.util.Map;

/**
 * 字典管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-28 19:31:08
 */
public interface DictCommonService {
	
	DictCommonEntity queryObject(Integer id);
	
	List<DictCommonEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(DictCommonEntity dictCommon);
	
	void update(DictCommonEntity dictCommon);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}

package com.power.dao.ex;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 字典查询
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-24 11:49:16
 */
public interface DictDao {
	List<?> queryListByType(String type);
	
	List<?> queryStationModel();
	
	List<?> queryPowerModel();
	
	List<?> queryErrorType(Map<String, Object> map);
}

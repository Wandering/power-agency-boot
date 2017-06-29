package com.power.service.ex;


import java.util.List;
import java.util.Map;

/**
 * 字典查询
 * 
 * @author hwx
 * @date 2017-06-24 11:49:16
 */
public interface DictService {
	
	List<?> queryListByType(String type);
	
	List<?> queryStationModel();
	
	List<?> queryPowerModel();
	
	List<?> queryErrorType(Map<String, Object> map);
}

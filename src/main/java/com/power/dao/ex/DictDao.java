package com.power.dao.ex;


import com.power.entity.ex.PowerStationBaseDTO;

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
	
	List<?> queryChargeModel();
	
	List<?> queryErrorType(Map<String, Object> map);
	
	List<?> queryPlatform();
	
	List<PowerStationBaseDTO> queryStations(Map<String, Object> map);

}

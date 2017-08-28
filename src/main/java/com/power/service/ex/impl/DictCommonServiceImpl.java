package com.power.service.ex.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.power.dao.ex.DictDao;
import com.power.entity.ex.PowerStationBaseDTO;
import com.power.service.ex.DictService;



@Service("dictService")
public class DictCommonServiceImpl implements DictService {
	@Autowired
	private DictDao dictDao;
	
	
	@Override
	public List<?> queryListByType(String type){
		return dictDao.queryListByType(type);
	}
	
	@Override
	public List<?> queryStationModel(){
		return dictDao.queryStationModel();
	}
	
	@Override
	public List<?> queryPowerModel(){
		return dictDao.queryPowerModel();
	}
	
	@Override
	public List<?> queryChargeModel(){
		return dictDao.queryChargeModel();
	}

	@Override
	public List<?> queryErrorType(Map<String, Object> map) {
		return dictDao.queryErrorType(map);
	}
	
	@Override
	public List<PowerStationBaseDTO> queryStations(Map<String, Object> map) {
		return dictDao.queryStations(map);
	}
	
}

package com.power.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.power.dao.PowerStationDao;
import com.power.entity.PowerStationEntity;
import com.power.service.PowerStationService;



@Service("powerStationService")
public class PowerStationServiceImpl implements PowerStationService {
	@Autowired
	private PowerStationDao powerStationDao;
	
	@Override
	public PowerStationEntity queryObject(Long id){
		return powerStationDao.queryObject(id);
	}
	
	@Override
	public List<PowerStationEntity> queryList(Map<String, Object> map){
		return powerStationDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return powerStationDao.queryTotal(map);
	}
	
	@Override
	public void save(PowerStationEntity powerStation){
		powerStationDao.save(powerStation);
	}
	
	@Override
	public void update(PowerStationEntity powerStation){
		powerStationDao.update(powerStation);
	}
	
	@Override
	public void delete(Long id){
		powerStationDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		powerStationDao.deleteBatch(ids);
	}
	
}

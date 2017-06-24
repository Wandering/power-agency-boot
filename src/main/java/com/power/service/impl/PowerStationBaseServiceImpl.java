package com.power.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.power.dao.PowerStationBaseDao;
import com.power.entity.PowerStationBaseEntity;
import com.power.service.PowerStationBaseService;



@Service("powerStationBaseService")
public class PowerStationBaseServiceImpl implements PowerStationBaseService {
	@Autowired
	private PowerStationBaseDao powerStationBaseDao;
	
	@Override
	public PowerStationBaseEntity queryObject(Integer id){
		return powerStationBaseDao.queryObject(id);
	}
	
	@Override
	public List<PowerStationBaseEntity> queryList(Map<String, Object> map){
		return powerStationBaseDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return powerStationBaseDao.queryTotal(map);
	}
	
	@Override
	public void save(PowerStationBaseEntity powerStationBase){
		powerStationBaseDao.save(powerStationBase);
	}
	
	@Override
	public void update(PowerStationBaseEntity powerStationBase){
		powerStationBaseDao.update(powerStationBase);
	}
	
	@Override
	public void delete(Integer id){
		powerStationBaseDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		powerStationBaseDao.deleteBatch(ids);
	}
	
}

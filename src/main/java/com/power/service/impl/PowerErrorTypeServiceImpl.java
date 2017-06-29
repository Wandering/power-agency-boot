package com.power.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.power.dao.PowerErrorTypeDao;
import com.power.entity.PowerErrorTypeEntity;
import com.power.service.PowerErrorTypeService;



@Service("powerErrorTypeService")
public class PowerErrorTypeServiceImpl implements PowerErrorTypeService {
	@Autowired
	private PowerErrorTypeDao powerErrorTypeDao;
	
	@Override
	public PowerErrorTypeEntity queryObject(Integer id){
		return powerErrorTypeDao.queryObject(id);
	}
	
	@Override
	public List<PowerErrorTypeEntity> queryList(Map<String, Object> map){
		return powerErrorTypeDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return powerErrorTypeDao.queryTotal(map);
	}
	
	@Override
	public void save(PowerErrorTypeEntity powerErrorType){
		powerErrorTypeDao.save(powerErrorType);
	}
	
	@Override
	public void update(PowerErrorTypeEntity powerErrorType){
		powerErrorTypeDao.update(powerErrorType);
	}
	
	@Override
	public void delete(Integer id){
		powerErrorTypeDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		powerErrorTypeDao.deleteBatch(ids);
	}
	
}

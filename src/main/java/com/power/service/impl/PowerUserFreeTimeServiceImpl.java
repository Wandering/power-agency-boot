package com.power.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.power.dao.PowerUserFreeTimeDao;
import com.power.entity.PowerUserFreeTimeEntity;
import com.power.service.PowerUserFreeTimeService;



@Service("powerUserFreeTimeService")
public class PowerUserFreeTimeServiceImpl implements PowerUserFreeTimeService {
	@Autowired
	private PowerUserFreeTimeDao powerUserFreeTimeDao;
	
	@Override
	public PowerUserFreeTimeEntity queryObject(Long id){
		return powerUserFreeTimeDao.queryObject(id);
	}
	
	@Override
	public List<PowerUserFreeTimeEntity> queryList(Map<String, Object> map){
		return powerUserFreeTimeDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return powerUserFreeTimeDao.queryTotal(map);
	}
	
	@Override
	public void save(PowerUserFreeTimeEntity powerUserFreeTime){
		powerUserFreeTimeDao.save(powerUserFreeTime);
	}
	
	@Override
	public void update(PowerUserFreeTimeEntity powerUserFreeTime){
		powerUserFreeTimeDao.update(powerUserFreeTime);
	}
	
	@Override
	public void delete(Long id){
		powerUserFreeTimeDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		powerUserFreeTimeDao.deleteBatch(ids);
	}
	
}

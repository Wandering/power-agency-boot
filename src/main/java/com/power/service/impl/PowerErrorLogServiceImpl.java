package com.power.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.power.dao.PowerErrorLogDao;
import com.power.entity.PowerErrorLogEntity;
import com.power.service.PowerErrorLogService;



@Service("powerErrorLogService")
public class PowerErrorLogServiceImpl implements PowerErrorLogService {
	@Autowired
	private PowerErrorLogDao powerErrorLogDao;
	
	@Override
	public PowerErrorLogEntity queryObject(Long id){
		return powerErrorLogDao.queryObject(id);
	}
	
	@Override
	public List<PowerErrorLogEntity> queryList(Map<String, Object> map){
		return powerErrorLogDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return powerErrorLogDao.queryTotal(map);
	}
	
	@Override
	public void save(PowerErrorLogEntity powerErrorLog){
		powerErrorLogDao.save(powerErrorLog);
	}
	
	@Override
	public void update(PowerErrorLogEntity powerErrorLog){
		powerErrorLogDao.update(powerErrorLog);
	}
	
	@Override
	public void delete(Long id){
		powerErrorLogDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		powerErrorLogDao.deleteBatch(ids);
	}
	
}

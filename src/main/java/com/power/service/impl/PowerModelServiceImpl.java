package com.power.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.power.dao.PowerModelDao;
import com.power.entity.PowerModelEntity;
import com.power.service.PowerModelService;



@Service("powerModelService")
public class PowerModelServiceImpl implements PowerModelService {
	@Autowired
	private PowerModelDao powerModelDao;
	
	@Override
	public PowerModelEntity queryObject(Long id){
		return powerModelDao.queryObject(id);
	}
	
	@Override
	public List<PowerModelEntity> queryList(Map<String, Object> map){
		return powerModelDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return powerModelDao.queryTotal(map);
	}
	
	@Override
	public void save(PowerModelEntity powerModel){
		powerModelDao.save(powerModel);
	}
	
	@Override
	public void update(PowerModelEntity powerModel){
		powerModelDao.update(powerModel);
	}
	
	@Override
	public void delete(Long id){
		powerModelDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		powerModelDao.deleteBatch(ids);
	}
	
}

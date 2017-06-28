package com.power.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.power.dao.PowerDynamicParamsDao;
import com.power.entity.PowerDynamicParamsEntity;
import com.power.service.PowerDynamicParamsService;



@Service("powerDynamicParamsService")
public class PowerDynamicParamsServiceImpl implements PowerDynamicParamsService {
	@Autowired
	private PowerDynamicParamsDao powerDynamicParamsDao;
	
	@Override
	public PowerDynamicParamsEntity queryObject(Integer id){
		return powerDynamicParamsDao.queryObject(id);
	}
	
	@Override
	public List<PowerDynamicParamsEntity> queryList(Map<String, Object> map){
		return powerDynamicParamsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return powerDynamicParamsDao.queryTotal(map);
	}
	
	@Override
	public void save(PowerDynamicParamsEntity powerDynamicParams){
		powerDynamicParamsDao.save(powerDynamicParams);
	}
	
	@Override
	public void update(PowerDynamicParamsEntity powerDynamicParams){
		powerDynamicParamsDao.update(powerDynamicParams);
	}
	
	@Override
	public void delete(Integer id){
		powerDynamicParamsDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		powerDynamicParamsDao.deleteBatch(ids);
	}
	
}

package com.power.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.power.dao.PowerUserAcountsDao;
import com.power.entity.PowerUserAcountsEntity;
import com.power.service.PowerUserAcountsService;



@Service("powerUserAcountsService")
public class PowerUserAcountsServiceImpl implements PowerUserAcountsService {
	@Autowired
	private PowerUserAcountsDao powerUserAcountsDao;
	
	@Override
	public PowerUserAcountsEntity queryObject(Long id){
		return powerUserAcountsDao.queryObject(id);
	}
	
	@Override
	public List<PowerUserAcountsEntity> queryList(Map<String, Object> map){
		return powerUserAcountsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return powerUserAcountsDao.queryTotal(map);
	}
	
	@Override
	public void save(PowerUserAcountsEntity powerUserAcounts){
		powerUserAcountsDao.save(powerUserAcounts);
	}
	
	@Override
	public void update(PowerUserAcountsEntity powerUserAcounts){
		powerUserAcountsDao.update(powerUserAcounts);
	}
	
	@Override
	public void delete(Long id){
		powerUserAcountsDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		powerUserAcountsDao.deleteBatch(ids);
	}

	@Override
	public double queryAllBalane() {
		double allbalance = powerUserAcountsDao.queryAllBalane();
		return allbalance;
	}

	@Override
	public PowerUserAcountsEntity queryByUserId(Long userId) {
		return powerUserAcountsDao.queryByUserId(userId);
	}
	
}

package com.power.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.power.dao.ChargeModelDao;
import com.power.entity.ChargeModelEntity;
import com.power.service.ChargeModelService;



@Service("chargeModelService")
public class ChargeModelServiceImpl implements ChargeModelService {
	@Autowired
	private ChargeModelDao chargeModelDao;
	
	@Override
	public ChargeModelEntity queryObject(Long id){
		return chargeModelDao.queryObject(id);
	}
	
	@Override
	public List<ChargeModelEntity> queryList(Map<String, Object> map){
		return chargeModelDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return chargeModelDao.queryTotal(map);
	}
	
	@Override
	public void save(ChargeModelEntity chargeModel){
		chargeModelDao.save(chargeModel);
	}
	
	@Override
	public void update(ChargeModelEntity chargeModel){
		chargeModelDao.update(chargeModel);
	}
	
	@Override
	public void delete(Long id){
		chargeModelDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		chargeModelDao.deleteBatch(ids);
	}
	
}

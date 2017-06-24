package com.power.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.power.dao.PowerBankDao;
import com.power.entity.PowerBankEntity;
import com.power.service.PowerBankService;



@Service("powerBankService")
public class PowerBankServiceImpl implements PowerBankService {
	@Autowired
	private PowerBankDao powerBankDao;
	
	@Override
	public PowerBankEntity queryObject(Long id){
		return powerBankDao.queryObject(id);
	}
	
	@Override
	public List<PowerBankEntity> queryList(Map<String, Object> map){
		return powerBankDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return powerBankDao.queryTotal(map);
	}
	
	@Override
	public void save(PowerBankEntity powerBank){
		powerBankDao.save(powerBank);
	}
	
	@Override
	public void update(PowerBankEntity powerBank){
		powerBankDao.update(powerBank);
	}
	
	@Override
	public void delete(Long id){
		powerBankDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		powerBankDao.deleteBatch(ids);
	}
	
}

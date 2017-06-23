package com.power.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.power.dao.AgencyOrdersDao;
import com.power.entity.AgencyOrdersEntity;
import com.power.service.AgencyOrdersService;



@Service("agencyOrdersService")
public class AgencyOrdersServiceImpl implements AgencyOrdersService {
	@Autowired
	private AgencyOrdersDao agencyOrdersDao;
	
	@Override
	public AgencyOrdersEntity queryObject(Long id){
		return agencyOrdersDao.queryObject(id);
	}
	
	@Override
	public List<AgencyOrdersEntity> queryList(Map<String, Object> map){
		return agencyOrdersDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return agencyOrdersDao.queryTotal(map);
	}
	
	@Override
	public void save(AgencyOrdersEntity agencyOrders){
		agencyOrdersDao.save(agencyOrders);
	}
	
	@Override
	public void update(AgencyOrdersEntity agencyOrders){
		agencyOrdersDao.update(agencyOrders);
	}
	
	@Override
	public void delete(Long id){
		agencyOrdersDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		agencyOrdersDao.deleteBatch(ids);
	}
	
}

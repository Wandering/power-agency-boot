package com.power.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.power.dao.AgencyOrderLineDao;
import com.power.entity.AgencyOrderLineEntity;
import com.power.service.AgencyOrderLineService;



@Service("agencyOrderLineService")
public class AgencyOrderLineServiceImpl implements AgencyOrderLineService {
	@Autowired
	private AgencyOrderLineDao agencyOrderLineDao;
	
	@Override
	public AgencyOrderLineEntity queryObject(Long id){
		return agencyOrderLineDao.queryObject(id);
	}
	
	@Override
	public List<AgencyOrderLineEntity> queryList(Map<String, Object> map){
		return agencyOrderLineDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return agencyOrderLineDao.queryTotal(map);
	}
	
	@Override
	public void save(AgencyOrderLineEntity agencyOrderLine){
		agencyOrderLineDao.save(agencyOrderLine);
	}
	
	@Override
	public void update(AgencyOrderLineEntity agencyOrderLine){
		agencyOrderLineDao.update(agencyOrderLine);
	}
	
	@Override
	public void delete(Long id){
		agencyOrderLineDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		agencyOrderLineDao.deleteBatch(ids);
	}
	
}

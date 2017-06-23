package com.power.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.power.dao.AgencyOrderLifecyleDao;
import com.power.entity.AgencyOrderLifecyleEntity;
import com.power.service.AgencyOrderLifecyleService;



@Service("agencyOrderLifecyleService")
public class AgencyOrderLifecyleServiceImpl implements AgencyOrderLifecyleService {
	@Autowired
	private AgencyOrderLifecyleDao agencyOrderLifecyleDao;
	
	@Override
	public AgencyOrderLifecyleEntity queryObject(Long id){
		return agencyOrderLifecyleDao.queryObject(id);
	}
	
	@Override
	public List<AgencyOrderLifecyleEntity> queryList(Map<String, Object> map){
		return agencyOrderLifecyleDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return agencyOrderLifecyleDao.queryTotal(map);
	}
	
	@Override
	public void save(AgencyOrderLifecyleEntity agencyOrderLifecyle){
		agencyOrderLifecyleDao.save(agencyOrderLifecyle);
	}
	
	@Override
	public void update(AgencyOrderLifecyleEntity agencyOrderLifecyle){
		agencyOrderLifecyleDao.update(agencyOrderLifecyle);
	}
	
	@Override
	public void delete(Long id){
		agencyOrderLifecyleDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		agencyOrderLifecyleDao.deleteBatch(ids);
	}
	
}

package com.power.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.power.dao.AgenciesDao;
import com.power.entity.AgenciesEntity;
import com.power.service.AgenciesService;



@Service("agenciesService")
public class AgenciesServiceImpl implements AgenciesService {
	@Autowired
	private AgenciesDao agenciesDao;
	
	@Override
	public AgenciesEntity queryObject(Long id){
		return agenciesDao.queryObject(id);
	}
	
	@Override
	public List<AgenciesEntity> queryList(Map<String, Object> map){
		return agenciesDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return agenciesDao.queryTotal(map);
	}
	
	@Override
	public void save(AgenciesEntity agencies){
		agenciesDao.save(agencies);
	}
	
	@Override
	public void update(AgenciesEntity agencies){
		agenciesDao.update(agencies);
	}
	
	@Override
	public void delete(Long id){
		agenciesDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		agenciesDao.deleteBatch(ids);
	}

	@Override
	public int queryAgencybyUserId(Long userId) {
		return agenciesDao.queryAgencybyUserId(userId);
	}
	
}

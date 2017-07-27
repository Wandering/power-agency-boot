package com.power.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.power.dao.UserPartnerDao;
import com.power.entity.UserPartnerEntity;
import com.power.service.UserPartnerService;



@Service("userPartnerService")
public class UserPartnerServiceImpl implements UserPartnerService {
	@Autowired
	private UserPartnerDao userPartnerDao;
	
	@Override
	public UserPartnerEntity queryObject(Long id){
		return userPartnerDao.queryObject(id);
	}
	
	@Override
	public List<UserPartnerEntity> queryList(Map<String, Object> map){
		return userPartnerDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return userPartnerDao.queryTotal(map);
	}
	
	@Override
	public void save(UserPartnerEntity userPartner){
		userPartnerDao.save(userPartner);
	}
	
	@Override
	public void update(UserPartnerEntity userPartner){
		userPartnerDao.update(userPartner);
	}
	
	@Override
	public void delete(Long id){
		userPartnerDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		userPartnerDao.deleteBatch(ids);
	}
	
}

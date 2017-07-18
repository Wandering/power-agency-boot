package com.power.service.ex.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.power.dao.ex.UserInfoDao;
import com.power.service.ex.UserInfoService;



@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoDao userInfoDao;
	
	
	@Override
	public List<?> queryUserList(Map<String, Object> map){
		return userInfoDao.queryUserList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return userInfoDao.queryTotal(map);
	}
	
}

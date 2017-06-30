package com.power.service.ex.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.power.dao.ex.ForderDao;
import com.power.service.ex.ForderService;




@Service("ForderService")
public class ForderServiceImpl implements ForderService {

	@Autowired
	private ForderDao forderDao;
	
	@Override
	public List<?> queryOrderModel(Map<String, Object> map) {
		return  forderDao.queryOrderModel(map);
		
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return forderDao.queryTotal(map);
	}
	
	
}

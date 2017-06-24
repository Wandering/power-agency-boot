package com.power.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.power.dao.StationErrorLogDao;
import com.power.entity.StationErrorLogEntity;
import com.power.service.StationErrorLogService;



@Service("stationErrorLogService")
public class StationErrorLogServiceImpl implements StationErrorLogService {
	@Autowired
	private StationErrorLogDao stationErrorLogDao;
	
	@Override
	public StationErrorLogEntity queryObject(Long id){
		return stationErrorLogDao.queryObject(id);
	}
	
	@Override
	public List<StationErrorLogEntity> queryList(Map<String, Object> map){
		return stationErrorLogDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return stationErrorLogDao.queryTotal(map);
	}
	
	@Override
	public void save(StationErrorLogEntity stationErrorLog){
		stationErrorLogDao.save(stationErrorLog);
	}
	
	@Override
	public void update(StationErrorLogEntity stationErrorLog){
		stationErrorLogDao.update(stationErrorLog);
	}
	
	@Override
	public void delete(Long id){
		stationErrorLogDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		stationErrorLogDao.deleteBatch(ids);
	}
	
}

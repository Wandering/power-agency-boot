package com.power.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.power.dao.StationModelDao;
import com.power.entity.StationModelEntity;
import com.power.service.StationModelService;



@Service("stationModelService")
public class StationModelServiceImpl implements StationModelService {
	@Autowired
	private StationModelDao stationModelDao;
	
	@Override
	public StationModelEntity queryObject(Long id){
		return stationModelDao.queryObject(id);
	}
	
	@Override
	public List<StationModelEntity> queryList(Map<String, Object> map){
		return stationModelDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return stationModelDao.queryTotal(map);
	}
	
	@Override
	public void save(StationModelEntity stationModel){
		stationModelDao.save(stationModel);
	}
	
	@Override
	public void update(StationModelEntity stationModel){
		stationModelDao.update(stationModel);
	}
	
	@Override
	public void delete(Long id){
		stationModelDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		stationModelDao.deleteBatch(ids);
	}
	
}

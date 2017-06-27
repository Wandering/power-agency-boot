package com.power.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.power.dao.DictCommonDao;
import com.power.entity.DictCommonEntity;
import com.power.service.DictCommonService;



@Service("dictCommonService")
public class DictCommonServiceImpl implements DictCommonService {
	@Autowired
	private DictCommonDao dictCommonDao;
	
	@Override
	public DictCommonEntity queryObject(Integer id){
		return dictCommonDao.queryObject(id);
	}
	
	@Override
	public List<DictCommonEntity> queryList(Map<String, Object> map){
		return dictCommonDao.queryList(map);
	}
	
	@Override
	public List<DictCommonEntity> queryListByType(String type){
		return dictCommonDao.queryListByType(type);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return dictCommonDao.queryTotal(map);
	}
	
	@Override
	public void save(DictCommonEntity dictCommon){
		dictCommonDao.save(dictCommon);
	}
	
	@Override
	public void update(DictCommonEntity dictCommon){
		dictCommonDao.update(dictCommon);
	}
	
	@Override
	public void delete(Integer id){
		dictCommonDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		dictCommonDao.deleteBatch(ids);
	}
	
	@Override
	public List<?> queryStationModel(){
		return dictCommonDao.queryStationModel();
	}
	
	@Override
	public List<?> queryPowerModel(){
		return dictCommonDao.queryPowerModel();
	}
	
}

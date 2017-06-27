package com.power.dao;

import java.util.List;

import com.power.entity.DictCommonEntity;
import io.renren.dao.BaseDao;
/**
 * 字典管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-24 11:49:16
 */
public interface DictCommonDao extends BaseDao<DictCommonEntity> {
	List<DictCommonEntity> queryListByType(String type);
	
	List<?> queryStationModel();
	
	List<?> queryPowerModel();
}

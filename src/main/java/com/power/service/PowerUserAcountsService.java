package com.power.service;

import com.power.entity.PowerUserAcountsEntity;

import java.util.List;
import java.util.Map;

/**
 * balance 本金
bouns 活动奖金
back_bouns 充返奖金
roles 用户会员级别
credit 信用分
update_dt 更新时间
create_dt 创建时间
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-28 14:38:40
 */
public interface PowerUserAcountsService {
	
	PowerUserAcountsEntity queryObject(Long id);
	
	List<PowerUserAcountsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(PowerUserAcountsEntity powerUserAcounts);
	
	void update(PowerUserAcountsEntity powerUserAcounts);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

	double queryAllBalane();
	
	PowerUserAcountsEntity queryByUserId(Long userId);
}

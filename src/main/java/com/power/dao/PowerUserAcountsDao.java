package com.power.dao;

import com.power.entity.PowerUserAcountsEntity;
import io.renren.dao.BaseDao;
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
public interface PowerUserAcountsDao extends BaseDao<PowerUserAcountsEntity> {

	double queryAllBalane();
	
}

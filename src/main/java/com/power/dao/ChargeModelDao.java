package com.power.dao;

import com.power.entity.ChargeModelEntity;
import io.renren.dao.BaseDao;
/**
 * 收费模式
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-28 19:17:40
 */
public interface ChargeModelDao extends BaseDao<ChargeModelEntity> {

	ChargeModelEntity queryByUserId(Long userId);
	
}

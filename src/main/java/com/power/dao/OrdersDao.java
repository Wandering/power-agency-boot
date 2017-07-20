package com.power.dao;

import com.power.entity.OrdersEntity;
import io.renren.dao.BaseDao;
/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-28 17:02:05
 */
public interface OrdersDao extends BaseDao<OrdersEntity> {

	OrdersEntity queryByUserId(Long userId);
	
}

package com.power.dao.ex;

import com.power.entity.OrderLineEntity;
import io.renren.dao.BaseDao;
/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-28 18:20:15
 */
public interface OrderLineDao extends BaseDao<OrderLineEntity> {
	double queryOrderTotal(String object, String object2);

	OrderLineEntity queryByUserId(Long userId);
}

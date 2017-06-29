package com.power.service;

import com.power.entity.OrdersEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-28 17:02:05
 */
public interface OrdersService {
	
	OrdersEntity queryObject(Long id);
	
	List<OrdersEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(OrdersEntity orders);
	
	void update(OrdersEntity orders);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}

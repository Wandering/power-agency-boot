package com.power.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.power.dao.OrdersDao;
import com.power.entity.OrdersEntity;
import com.power.service.OrdersService;



@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {
	@Autowired
	private OrdersDao ordersDao;
	
	@Override
	public OrdersEntity queryObject(Long id){
		return ordersDao.queryObject(id);
	}
	
	@Override
	public List<OrdersEntity> queryList(Map<String, Object> map){
		return ordersDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return ordersDao.queryTotal(map);
	}
	
	@Override
	public void save(OrdersEntity orders){
		ordersDao.save(orders);
	}
	
	@Override
	public void update(OrdersEntity orders){
		ordersDao.update(orders);
	}
	
	@Override
	public void delete(Long id){
		ordersDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		ordersDao.deleteBatch(ids);
	}

	@Override
	public OrdersEntity queryByUserId(Long userId) {
		return ordersDao.queryByUserId(userId);
	}
	
}

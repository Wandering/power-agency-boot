package com.power.service.ex.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.power.dao.ex.OrderLineDao;
import com.power.entity.OrderLineEntity;
import com.power.service.ex.OrderLineService;



@Service("orderLineService")
public class OrderLineServiceImpl implements OrderLineService {
	@Autowired
	private OrderLineDao orderLineDao;
	
	@Override
	public OrderLineEntity queryObject(Long id){
		return orderLineDao.queryObject(id);
	}
	
	@Override
	public List<OrderLineEntity> queryList(Map<String, Object> map){
		return orderLineDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return orderLineDao.queryTotal(map);
	}
	
	@Override
	public void save(OrderLineEntity orderLine){
		orderLineDao.save(orderLine);
	}
	
	@Override
	public void update(OrderLineEntity orderLine){
		orderLineDao.update(orderLine);
	}
	
	@Override
	public void delete(Long id){
		orderLineDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		orderLineDao.deleteBatch(ids);
	}

	@Override
	public double queryOrderTotal(String object, String object2) {
		double totalfee = orderLineDao.queryOrderTotal( object,  object2);
		return totalfee;
	}

	@Override
	public OrderLineEntity queryByUserId(Long userId) {
		return orderLineDao.queryByUserId(userId);
	}
	
}

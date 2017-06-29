package com.power.service.ex;

import com.power.entity.OrderLineEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-28 18:20:15
 */
public interface OrderLineService {
	
	OrderLineEntity queryObject(Long id);
	
	List<OrderLineEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(OrderLineEntity orderLine);
	
	void update(OrderLineEntity orderLine);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

	double queryOrderTotal(String object, String object2);
}

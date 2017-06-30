package com.power.dao.ex;

import java.util.List;
import java.util.Map;

import io.renren.utils.Query;


public interface ForderDao {
	List<?> queryOrderModel(Map<String, Object> map);
    
	int queryTotal(Map<String, Object> map);
	
}
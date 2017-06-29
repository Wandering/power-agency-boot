package com.power.service.ex;


import java.util.List;
import java.util.Map;



public interface ForderService {
	
	List<?> queryOrderModel(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	
}

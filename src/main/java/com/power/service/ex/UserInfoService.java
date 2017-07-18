package com.power.service.ex;


import java.util.List;
import java.util.Map;

/**
 * 客户端用户信息
 * 
 * @author hwx
 * @date 2017-06-24 11:49:16
 */
public interface UserInfoService {
	
	List<?> queryUserList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
}

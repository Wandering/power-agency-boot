package com.power.dao.ex;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 客户端用户信息
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-24 11:49:16
 */
public interface UserInfoDao {
	
	List<?> queryUserList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
}

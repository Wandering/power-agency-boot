package com.power.service;

import com.power.entity.UserPartnerEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-24 17:27:49
 */
public interface UserPartnerService {
	
	UserPartnerEntity queryObject(Long id);
	
	List<UserPartnerEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(UserPartnerEntity userPartner);
	
	void update(UserPartnerEntity userPartner);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}

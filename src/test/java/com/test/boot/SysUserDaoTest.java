package com.test.boot;


import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import io.renren.RenrenApplication;
import io.renren.RenrenApplicationTests;
import io.renren.entity.SysUserEntity;
import io.renren.service.impl.SysUserServiceImpl;


public class SysUserDaoTest extends RenrenApplicationTests{
   

    @Autowired 
    private SysUserServiceImpl impl;
    
	@Test
	public void testQueryByUserName() {
		List<SysUserEntity> userList =  impl.queryByAgencyId("123");
		
		for(SysUserEntity u:userList){
			System.out.println(u.getUserId()+"----------------");

	}

}}
package com.test.boot;


import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.base.Joiner;

import io.renren.RenrenApplication;
import io.renren.RenrenApplicationTests;
import io.renren.entity.SysUserEntity;
import io.renren.service.impl.SysUserServiceImpl;


public class SysUserDaoTest extends RenrenApplicationTests{
   

    @Autowired 
    private SysUserServiceImpl impl;
    
	@Test
	public void testQueryByUserName() {
		List<SysUserEntity> userList =  impl.queryByAgencyId("admin");
		StringBuffer sb=new StringBuffer();
    	boolean flag=false;
		for(SysUserEntity u:userList){
			if (flag) {
				sb.append("',");
			}else {
				flag=true;
			}
			sb.append("'");
			sb.append(u.getAgencyId());
			
			
		}
		sb.append("'");
		
			System.out.println(sb);


}}
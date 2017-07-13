package com.test.boot;


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

@RunWith(SpringRunner.class)
@SpringBootTest(classes=RenrenApplication.class)
public class SysUserDaoTest extends RenrenApplicationTests{
   
	@Autowired 
	private SysUserEntity sysUserEntity;
    @Autowired 
    private SysUserServiceImpl impl;
    
	@Test
	public void testQueryByUserName() {
		 impl = new SysUserServiceImpl();
//		List<SysUserEntity> userList =  impl.queryByAgencyId("admin");
//		
//		for(SysUserEntity u:userList){
//			System.out.println(u.getUserId()+"----------------");
//		}
		 sysUserEntity = impl.queryByUserName("admin");
		 System.out.println(sysUserEntity.getUsername());
	}

}

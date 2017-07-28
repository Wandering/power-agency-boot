package com.power.controller.ex;


import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.power.yuneng.nonparty.api.IPowerConsumer;
import com.power.yuneng.nonparty.domain.req.*;
import com.power.yuneng.nonparty.domain.res.*;

import io.renren.utils.R;

/**
 * 桩运维相关接口
 * 
 * @author hwx
 * @date 2017-06-24 11:49:16
 */
@RestController
@RequestMapping("operate")
public class StationOperateController {
	
	 @Autowired
	 IPowerConsumer powerConsumer;
	 
	 /*开关锁*/
	 @RequestMapping("/lockSwich")
	 @RequiresPermissions("operate:lockSwich")
	 public R lockSwich(String deviceId,int slotNo,int slotSwitch){
		 LockSwitchReq req = new LockSwitchReq();
		 req.setDevice_id(deviceId);
		 req.setSlot_no(slotNo);
		 req.setType(0);
		 req.setSlot_switch(slotSwitch);
		StationBaseRes res = powerConsumer.lockSwich(req);
		 return R.ok().put("data",res);
	 }
	 
	 /*禁用桩*/
	 @RequestMapping("/disStation")
	 public R disStation(String deviceId,int devstate){
		 DisableReq req = new DisableReq();
		 req.setDevid(deviceId);
		 req.setDevstate(devstate);
		 BaseRes res = powerConsumer.disStation(req);
		 return R.ok().put("data", res);
	 }
	 
	 /*同步知路*/
	 @RequestMapping("/syncZhilu")
	 public R syncZhilu(String devices,String name,String product){
		 List<String> devList = new ArrayList<String>();
		 for(String i : devices.split(",")){
			 devList.add(i);
		 }
		 RegisterReq req = new RegisterReq();
		 req.setDevices(devList);
		 req.setProtocol(0);
		 req.setName(name);
		 req.setProduct(product);
		 RegisterRes res = powerConsumer.registerPower(req);
		 return R.ok().put("data", res);
	 }

}

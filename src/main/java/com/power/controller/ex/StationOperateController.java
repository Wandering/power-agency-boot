package com.power.controller.ex;


import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
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
	 
	 @RequestMapping("/disStation")
	 public R disStation(String deviceId,int devstate){
		 DisableReq req = new DisableReq();
		 req.setDevid(deviceId);
		 req.setDevstate(devstate);
		 BaseRes res = powerConsumer.disStation(req);
		 return R.ok().put("data", res);
	 }

}

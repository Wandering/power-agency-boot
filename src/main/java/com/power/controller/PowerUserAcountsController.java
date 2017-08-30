package com.power.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.power.aop.agency.AutoConfigAgency;
import com.power.entity.ChargeModelEntity;
import com.power.entity.OrderLineEntity;
import com.power.entity.OrdersEntity;
import com.power.entity.PowerUserAcountsEntity;
import com.power.entity.PowerUserFreeTimeEntity;
import com.power.service.ChargeModelService;
import com.power.service.OrdersService;
import com.power.service.PowerUserAcountsService;
import com.power.service.PowerUserFreeTimeService;
import com.power.service.ex.OrderLineService;
import com.power.util.FeeUtil;

import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;


/**
 * balance 本金
bouns 活动奖金
back_bouns 充返奖金
roles 用户会员级别
credit 信用分
update_dt 更新时间
create_dt 创建时间
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-28 14:38:40
 */
@RestController
@RequestMapping("poweruseracounts")
public class PowerUserAcountsController {
	@Autowired
	private PowerUserAcountsService powerUserAcountsService;
	@Autowired
	private PowerUserFreeTimeService powerUserFreeTimeService;
	@Autowired
	private ChargeModelService chargeModelService;
	@Autowired
	private OrderLineService orderLineService;
	@Autowired
	private OrdersService ordersService;
	
	 private final static Logger logger = LoggerFactory.getLogger(PowerUserAcountsController.class);
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("poweruseracounts:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<PowerUserAcountsEntity> powerUserAcountsList = powerUserAcountsService.queryList(query);
		
		
		long[] rtnFee;
		long messageDt = new Date().getTime()/1000;
		double fee =0.00;
		double lastFee =0.00;
		for(PowerUserAcountsEntity entity:powerUserAcountsList){
			
			PowerUserFreeTimeEntity  powerUserFreeTimeEntity = powerUserFreeTimeService.queryObject(entity.getUserId());
			PowerUserAcountsEntity powerUserAcountsEntity = powerUserAcountsService.queryByUserId(entity.getUserId());
			ChargeModelEntity chargeModelEntity = chargeModelService.queryObject(powerUserAcountsEntity.getRoles());
			OrdersEntity  ordersEntity = ordersService.queryByUserId(entity.getUserId());
			 logger.debug("当前准备进入--------------------------------------------------------------------:{}",1);
			if(ordersEntity!=null){
				 logger.debug("当前存在借电中订单，开始计算--------------------------------------------------------------------:{}",2);
				OrderLineEntity orderLineEntity = orderLineService.queryByOrderId(ordersEntity.getId());
				@SuppressWarnings("unchecked")
				Map<Long,Integer> temp1 = (Map<Long,Integer>)JSON.parseObject(powerUserFreeTimeEntity.getTempDayFreeTime(), HashMap.class);
				@SuppressWarnings("unchecked")
				Map<Long,Integer> temp2 = (Map<Long,Integer>)JSON.parseObject(powerUserFreeTimeEntity.getTempDayFreeFee(), HashMap.class);
				
				 logger.debug("当前temp1为--------------------------------------------------------------------:{}",temp1);
				 logger.debug("当前orderLineEntity.getOrderId()为--------------------------------------------------------------------:{}",orderLineEntity.getOrderId());
				 logger.debug("当前temp1.get(orderLineEntity.getOrderId())为--------------------------------------------------------------------:{}",temp1.get(orderLineEntity.getOrderId()));
				 
				if (chargeModelEntity.getChargeDay() == 1) {
					rtnFee = FeeUtil.feeSettlement(
							chargeModelEntity.getOrderFreeTime(),
							chargeModelEntity.getFreeTime(),
							temp1.get(orderLineEntity.getOrderId()),
							chargeModelEntity.getOverdueFee(),
							chargeModelEntity.getMaxOverdueFee(),
							temp2.get(orderLineEntity.getOrderId()),
							orderLineEntity.getStartDt(), messageDt,chargeModelEntity.getBufferTime());
				}else {
					rtnFee = FeeUtil.feeSettlement24(
							chargeModelEntity.getOrderFreeTime(),
							chargeModelEntity.getFreeTime(),
							temp1.get(orderLineEntity.getOrderId()),
							chargeModelEntity.getOverdueFee(),
							chargeModelEntity.getMaxOverdueFee(),
							chargeModelEntity.getMaxOverdueFee(),
							orderLineEntity.getStartDt(), messageDt,chargeModelEntity.getBufferTime());
					fee = rtnFee[0]/100d;
				}
			}else {
				fee =0.00;
			}
				
		lastFee = entity.getBalance()-fee;
		entity.setFee(fee);
		entity.setLastFee(lastFee);
		}
		
		int total = powerUserAcountsService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(powerUserAcountsList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil).put("fee", fee).put("lastFee", lastFee);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("poweruseracounts:info")
	public R info(@PathVariable("id") Long id){
		PowerUserAcountsEntity powerUserAcounts = powerUserAcountsService.queryObject(id);
		
		return R.ok().put("powerUserAcounts", powerUserAcounts);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("poweruseracounts:save")
	public R save(@RequestBody PowerUserAcountsEntity powerUserAcounts){
		powerUserAcountsService.save(powerUserAcounts);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("poweruseracounts:update")
	public R update(@RequestBody PowerUserAcountsEntity powerUserAcounts){
		powerUserAcountsService.update(powerUserAcounts);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("poweruseracounts:delete")
	public R delete(@RequestBody Long[] ids){
		powerUserAcountsService.deleteBatch(ids);
		
		return R.ok();
	}
	@RequestMapping("/allbalance")
	@RequiresPermissions("poweruseracounts:allbalance")
	public R delete(){
		double allBalance = powerUserAcountsService.queryAllBalane();
		
		return R.ok().put("allBalance", allBalance);
	}
	
	@RequestMapping("/qureyfee/{userId}")
	@RequiresPermissions("poweruseracounts:qureyfee")
	public R qureyfee(@PathVariable("userId") Long userId){
		PowerUserFreeTimeEntity  powerUserFreeTimeEntity = powerUserFreeTimeService.queryObject(userId);
		PowerUserAcountsEntity powerUserAcountsEntity = powerUserAcountsService.queryByUserId(userId);
		ChargeModelEntity chargeModelEntity = chargeModelService.queryObject(powerUserAcountsEntity.getRoles());
		OrderLineEntity orderLineEntity = orderLineService.queryByOrderId(userId);
		long[] rtnFee;
		long messageDt = new Date().getTime()/1000;
		@SuppressWarnings("unchecked")
		Map<Long,Integer> temp1 = (Map<Long,Integer>)JSON.parseObject(powerUserFreeTimeEntity.getTempDayFreeTime(), HashMap.class);
		@SuppressWarnings("unchecked")
		Map<Long,Integer> temp2 = (Map<Long,Integer>)JSON.parseObject(powerUserFreeTimeEntity.getTempDayFreeFee(), HashMap.class);
		
		if (chargeModelEntity.getChargeDay() == 1) {
            rtnFee = FeeUtil.feeSettlement(
            		chargeModelEntity.getOrderFreeTime(),
            		chargeModelEntity.getFreeTime(),
            		temp1.get(orderLineEntity.getOrderId()),
            		chargeModelEntity.getOverdueFee(),
            		chargeModelEntity.getMaxOverdueFee(),
            		temp2.get(orderLineEntity.getOrderId()),
            		orderLineEntity.getStartDt(), messageDt,chargeModelEntity.getBufferTime());
        }else {
            rtnFee = FeeUtil.feeSettlement24(
            		chargeModelEntity.getOrderFreeTime(),
            		chargeModelEntity.getFreeTime(),
            		temp1.get(orderLineEntity.getOrderId()),
            		
            		chargeModelEntity.getOverdueFee(),
            		chargeModelEntity.getMaxOverdueFee(),
            		chargeModelEntity.getMaxOverdueFee(),
            		orderLineEntity.getStartDt(), messageDt,chargeModelEntity.getBufferTime());
        }
		double fee = rtnFee[0]/100d;
		return R.ok().put("fee", fee);
		
		
	}
	
	
}

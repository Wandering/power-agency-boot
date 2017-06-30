package com.power.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.power.entity.PowerUserAcountsEntity;
import com.power.service.PowerUserAcountsService;
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
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("poweruseracounts:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<PowerUserAcountsEntity> powerUserAcountsList = powerUserAcountsService.queryList(query);
		int total = powerUserAcountsService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(powerUserAcountsList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
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
	
}
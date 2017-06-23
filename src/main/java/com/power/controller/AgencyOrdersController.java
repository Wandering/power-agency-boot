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

import com.power.entity.AgencyOrdersEntity;
import com.power.service.AgencyOrdersService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;


/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-21 23:02:26
 */
@RestController
@RequestMapping("agencyorders")
public class AgencyOrdersController {
	@Autowired
	private AgencyOrdersService agencyOrdersService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("agencyorders:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<AgencyOrdersEntity> agencyOrdersList = agencyOrdersService.queryList(query);
		int total = agencyOrdersService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(agencyOrdersList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("agencyorders:info")
	public R info(@PathVariable("id") Long id){
		AgencyOrdersEntity agencyOrders = agencyOrdersService.queryObject(id);
		
		return R.ok().put("agencyOrders", agencyOrders);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("agencyorders:save")
	public R save(@RequestBody AgencyOrdersEntity agencyOrders){
		agencyOrdersService.save(agencyOrders);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("agencyorders:update")
	public R update(@RequestBody AgencyOrdersEntity agencyOrders){
		agencyOrdersService.update(agencyOrders);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("agencyorders:delete")
	public R delete(@RequestBody Long[] ids){
		agencyOrdersService.deleteBatch(ids);
		
		return R.ok();
	}
	
}

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

import com.power.entity.OrdersEntity;
import com.power.service.OrdersService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;


/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-28 17:02:05
 */
@RestController
@RequestMapping("orders")
public class OrdersController {
	@Autowired
	private OrdersService ordersService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("orders:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<OrdersEntity> ordersList = ordersService.queryList(query);
		int total = ordersService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(ordersList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("orders:info")
	public R info(@PathVariable("id") Long id){
		OrdersEntity orders = ordersService.queryObject(id);
		
		return R.ok().put("orders", orders);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("orders:save")
	public R save(@RequestBody OrdersEntity orders){
		ordersService.save(orders);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("orders:update")
	public R update(@RequestBody OrdersEntity orders){
		ordersService.update(orders);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("orders:delete")
	public R delete(@RequestBody Long[] ids){
		ordersService.deleteBatch(ids);
		
		return R.ok();
	}
	
}

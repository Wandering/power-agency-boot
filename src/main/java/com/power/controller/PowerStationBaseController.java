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

import com.power.entity.PowerStationBaseEntity;
import com.power.service.PowerStationBaseService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;


/**
 * 充电桩基础表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-23 19:43:25
 */
@RestController
@RequestMapping("powerstationbase")
public class PowerStationBaseController {
	@Autowired
	private PowerStationBaseService powerStationBaseService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("powerstationbase:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<PowerStationBaseEntity> powerStationBaseList = powerStationBaseService.queryList(query);
		int total = powerStationBaseService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(powerStationBaseList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("powerstationbase:info")
	public R info(@PathVariable("id") Integer id){
		PowerStationBaseEntity powerStationBase = powerStationBaseService.queryObject(id);
		
		return R.ok().put("powerStationBase", powerStationBase);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("powerstationbase:save")
	public R save(@RequestBody PowerStationBaseEntity powerStationBase){
		powerStationBaseService.save(powerStationBase);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("powerstationbase:update")
	public R update(@RequestBody PowerStationBaseEntity powerStationBase){
		powerStationBaseService.update(powerStationBase);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("powerstationbase:delete")
	public R delete(@RequestBody Integer[] ids){
		powerStationBaseService.deleteBatch(ids);
		
		return R.ok();
	}
	
}

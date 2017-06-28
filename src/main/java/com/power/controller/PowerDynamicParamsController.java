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

import com.power.entity.PowerDynamicParamsEntity;
import com.power.service.PowerDynamicParamsService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;


/**
 * 动态可配置参数表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-27 11:34:59
 */
@RestController
@RequestMapping("powerdynamicparams")
public class PowerDynamicParamsController {
	@Autowired
	private PowerDynamicParamsService powerDynamicParamsService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("powerdynamicparams:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<PowerDynamicParamsEntity> powerDynamicParamsList = powerDynamicParamsService.queryList(query);
		int total = powerDynamicParamsService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(powerDynamicParamsList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("powerdynamicparams:info")
	public R info(@PathVariable("id") Integer id){
		PowerDynamicParamsEntity powerDynamicParams = powerDynamicParamsService.queryObject(id);
		
		return R.ok().put("powerDynamicParams", powerDynamicParams);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("powerdynamicparams:save")
	public R save(@RequestBody PowerDynamicParamsEntity powerDynamicParams){
		powerDynamicParamsService.save(powerDynamicParams);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("powerdynamicparams:update")
	public R update(@RequestBody PowerDynamicParamsEntity powerDynamicParams){
		powerDynamicParamsService.update(powerDynamicParams);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("powerdynamicparams:delete")
	public R delete(@RequestBody Integer[] ids){
		powerDynamicParamsService.deleteBatch(ids);
		
		return R.ok();
	}
	
}

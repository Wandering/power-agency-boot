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

import com.power.entity.PowerErrorTypeEntity;
import com.power.service.PowerErrorTypeService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;


/**
 * 异常类别表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-29 09:41:28
 */
@RestController
@RequestMapping("powererrortype")
public class PowerErrorTypeController {
	@Autowired
	private PowerErrorTypeService powerErrorTypeService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("powererrortype:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<PowerErrorTypeEntity> powerErrorTypeList = powerErrorTypeService.queryList(query);
		int total = powerErrorTypeService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(powerErrorTypeList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("powererrortype:info")
	public R info(@PathVariable("id") Integer id){
		PowerErrorTypeEntity powerErrorType = powerErrorTypeService.queryObject(id);
		
		return R.ok().put("powerErrorType", powerErrorType);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("powererrortype:save")
	public R save(@RequestBody PowerErrorTypeEntity powerErrorType){
		powerErrorTypeService.save(powerErrorType);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("powererrortype:update")
	public R update(@RequestBody PowerErrorTypeEntity powerErrorType){
		powerErrorTypeService.update(powerErrorType);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("powererrortype:delete")
	public R delete(@RequestBody Integer[] ids){
		powerErrorTypeService.deleteBatch(ids);
		
		return R.ok();
	}
	
}

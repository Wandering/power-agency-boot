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

import com.power.entity.PowerStationEntity;
import com.power.service.PowerStationService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;


/**
 * 网点基础表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-28 20:03:38
 */
@RestController
@RequestMapping("powerstation")
public class PowerStationController {
	@Autowired
	private PowerStationService powerStationService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("powerstation:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<PowerStationEntity> powerStationList = powerStationService.queryList(query);
		int total = powerStationService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(powerStationList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("powerstation:info")
	public R info(@PathVariable("id") Long id){
		PowerStationEntity powerStation = powerStationService.queryObject(id);
		
		return R.ok().put("powerStation", powerStation);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("powerstation:save")
	public R save(@RequestBody PowerStationEntity powerStation){
		
		powerStationService.save(powerStation);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("powerstation:update")
	public R update(@RequestBody PowerStationEntity powerStation){
		powerStationService.update(powerStation);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("powerstation:delete")
	public R delete(@RequestBody Long[] ids){
		powerStationService.deleteBatch(ids);
		
		return R.ok();
	}
	
}

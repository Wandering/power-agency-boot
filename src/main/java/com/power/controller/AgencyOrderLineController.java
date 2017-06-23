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

import com.power.entity.AgencyOrderLineEntity;
import com.power.service.AgencyOrderLineService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;


/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-21 23:02:38
 */
@RestController
@RequestMapping("agencyorderline")
public class AgencyOrderLineController {
	@Autowired
	private AgencyOrderLineService agencyOrderLineService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("agencyorderline:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<AgencyOrderLineEntity> agencyOrderLineList = agencyOrderLineService.queryList(query);
		int total = agencyOrderLineService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(agencyOrderLineList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("agencyorderline:info")
	public R info(@PathVariable("id") Long id){
		AgencyOrderLineEntity agencyOrderLine = agencyOrderLineService.queryObject(id);
		
		return R.ok().put("agencyOrderLine", agencyOrderLine);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("agencyorderline:save")
	public R save(@RequestBody AgencyOrderLineEntity agencyOrderLine){
		agencyOrderLineService.save(agencyOrderLine);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("agencyorderline:update")
	public R update(@RequestBody AgencyOrderLineEntity agencyOrderLine){
		agencyOrderLineService.update(agencyOrderLine);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("agencyorderline:delete")
	public R delete(@RequestBody Long[] ids){
		agencyOrderLineService.deleteBatch(ids);
		
		return R.ok();
	}
	
}

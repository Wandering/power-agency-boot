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

import com.power.entity.AgencyOrderLifecyleEntity;
import com.power.service.AgencyOrderLifecyleService;
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
@RequestMapping("agencyorderlifecyle")
public class AgencyOrderLifecyleController {
	@Autowired
	private AgencyOrderLifecyleService agencyOrderLifecyleService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("agencyorderlifecyle:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<AgencyOrderLifecyleEntity> agencyOrderLifecyleList = agencyOrderLifecyleService.queryList(query);
		int total = agencyOrderLifecyleService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(agencyOrderLifecyleList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("agencyorderlifecyle:info")
	public R info(@PathVariable("id") Long id){
		AgencyOrderLifecyleEntity agencyOrderLifecyle = agencyOrderLifecyleService.queryObject(id);
		
		return R.ok().put("agencyOrderLifecyle", agencyOrderLifecyle);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("agencyorderlifecyle:save")
	public R save(@RequestBody AgencyOrderLifecyleEntity agencyOrderLifecyle){
		agencyOrderLifecyleService.save(agencyOrderLifecyle);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("agencyorderlifecyle:update")
	public R update(@RequestBody AgencyOrderLifecyleEntity agencyOrderLifecyle){
		agencyOrderLifecyleService.update(agencyOrderLifecyle);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("agencyorderlifecyle:delete")
	public R delete(@RequestBody Long[] ids){
		agencyOrderLifecyleService.deleteBatch(ids);
		
		return R.ok();
	}
	
}

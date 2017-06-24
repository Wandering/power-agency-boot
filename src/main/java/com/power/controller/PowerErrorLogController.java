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

import com.power.entity.PowerErrorLogEntity;
import com.power.service.PowerErrorLogService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;


/**
 * 知路反馈充电宝异常
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-23 20:34:04
 */
@RestController
@RequestMapping("powererrorlog")
public class PowerErrorLogController {
	@Autowired
	private PowerErrorLogService powerErrorLogService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("powererrorlog:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<PowerErrorLogEntity> powerErrorLogList = powerErrorLogService.queryList(query);
		int total = powerErrorLogService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(powerErrorLogList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("powererrorlog:info")
	public R info(@PathVariable("id") Long id){
		PowerErrorLogEntity powerErrorLog = powerErrorLogService.queryObject(id);
		
		return R.ok().put("powerErrorLog", powerErrorLog);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("powererrorlog:save")
	public R save(@RequestBody PowerErrorLogEntity powerErrorLog){
		powerErrorLogService.save(powerErrorLog);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("powererrorlog:update")
	public R update(@RequestBody PowerErrorLogEntity powerErrorLog){
		powerErrorLogService.update(powerErrorLog);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("powererrorlog:delete")
	public R delete(@RequestBody Long[] ids){
		powerErrorLogService.deleteBatch(ids);
		
		return R.ok();
	}
	
}

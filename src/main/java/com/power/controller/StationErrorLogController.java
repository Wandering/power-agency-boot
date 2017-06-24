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

import com.power.entity.StationErrorLogEntity;
import com.power.service.StationErrorLogService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;


/**
 * 桩信息错误日志
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-23 20:34:04
 */
@RestController
@RequestMapping("stationerrorlog")
public class StationErrorLogController {
	@Autowired
	private StationErrorLogService stationErrorLogService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("stationerrorlog:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<StationErrorLogEntity> stationErrorLogList = stationErrorLogService.queryList(query);
		int total = stationErrorLogService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(stationErrorLogList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("stationerrorlog:info")
	public R info(@PathVariable("id") Long id){
		StationErrorLogEntity stationErrorLog = stationErrorLogService.queryObject(id);
		
		return R.ok().put("stationErrorLog", stationErrorLog);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("stationerrorlog:save")
	public R save(@RequestBody StationErrorLogEntity stationErrorLog){
		stationErrorLogService.save(stationErrorLog);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("stationerrorlog:update")
	public R update(@RequestBody StationErrorLogEntity stationErrorLog){
		stationErrorLogService.update(stationErrorLog);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("stationerrorlog:delete")
	public R delete(@RequestBody Long[] ids){
		stationErrorLogService.deleteBatch(ids);
		
		return R.ok();
	}
	
}

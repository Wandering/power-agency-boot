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

import com.power.entity.StationModelEntity;
import com.power.service.StationModelService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;


/**
 * 充电桩型号
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-28 19:17:40
 */
@RestController
@RequestMapping("stationmodel")
public class StationModelController {
	@Autowired
	private StationModelService stationModelService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("stationmodel:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<StationModelEntity> stationModelList = stationModelService.queryList(query);
		int total = stationModelService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(stationModelList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("stationmodel:info")
	public R info(@PathVariable("id") Long id){
		StationModelEntity stationModel = stationModelService.queryObject(id);
		
		return R.ok().put("stationModel", stationModel);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("stationmodel:save")
	public R save(@RequestBody StationModelEntity stationModel){
		stationModelService.save(stationModel);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("stationmodel:update")
	public R update(@RequestBody StationModelEntity stationModel){
		stationModelService.update(stationModel);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("stationmodel:delete")
	public R delete(@RequestBody Long[] ids){
		stationModelService.deleteBatch(ids);
		
		return R.ok();
	}
	
}

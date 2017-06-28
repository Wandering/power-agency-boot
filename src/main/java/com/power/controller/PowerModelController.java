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

import com.power.entity.PowerModelEntity;
import com.power.service.PowerModelService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;


/**
 * 充电宝型号
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-28 19:17:41
 */
@RestController
@RequestMapping("powermodel")
public class PowerModelController {
	@Autowired
	private PowerModelService powerModelService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("powermodel:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<PowerModelEntity> powerModelList = powerModelService.queryList(query);
		int total = powerModelService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(powerModelList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("powermodel:info")
	public R info(@PathVariable("id") Long id){
		PowerModelEntity powerModel = powerModelService.queryObject(id);
		
		return R.ok().put("powerModel", powerModel);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("powermodel:save")
	public R save(@RequestBody PowerModelEntity powerModel){
		powerModelService.save(powerModel);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("powermodel:update")
	public R update(@RequestBody PowerModelEntity powerModel){
		powerModelService.update(powerModel);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("powermodel:delete")
	public R delete(@RequestBody Long[] ids){
		powerModelService.deleteBatch(ids);
		
		return R.ok();
	}
	
}

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

import com.power.entity.ChargeModelEntity;
import com.power.service.ChargeModelService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;


/**
 * 收费模式
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-28 19:17:40
 */
@RestController
@RequestMapping("chargemodel")
public class ChargeModelController {
	@Autowired
	private ChargeModelService chargeModelService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("chargemodel:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ChargeModelEntity> chargeModelList = chargeModelService.queryList(query);
		int total = chargeModelService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(chargeModelList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("chargemodel:info")
	public R info(@PathVariable("id") Long id){
		ChargeModelEntity chargeModel = chargeModelService.queryObject(id);
		
		return R.ok().put("chargeModel", chargeModel);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("chargemodel:save")
	public R save(@RequestBody ChargeModelEntity chargeModel){
		chargeModelService.save(chargeModel);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("chargemodel:update")
	public R update(@RequestBody ChargeModelEntity chargeModel){
		chargeModelService.update(chargeModel);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("chargemodel:delete")
	public R delete(@RequestBody Long[] ids){
		chargeModelService.deleteBatch(ids);
		
		return R.ok();
	}
	
}

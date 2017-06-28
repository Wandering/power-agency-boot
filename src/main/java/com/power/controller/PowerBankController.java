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

import com.power.entity.PowerBankEntity;
import com.power.service.PowerBankService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;


/**
 * 充电宝基础表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-28 19:34:39
 */
@RestController
@RequestMapping("powerbank")
public class PowerBankController {
	@Autowired
	private PowerBankService powerBankService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("powerbank:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<PowerBankEntity> powerBankList = powerBankService.queryList(query);
		int total = powerBankService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(powerBankList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("powerbank:info")
	public R info(@PathVariable("id") Long id){
		PowerBankEntity powerBank = powerBankService.queryObject(id);
		
		return R.ok().put("powerBank", powerBank);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("powerbank:save")
	public R save(@RequestBody PowerBankEntity powerBank){
		powerBankService.save(powerBank);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("powerbank:update")
	public R update(@RequestBody PowerBankEntity powerBank){
		powerBankService.update(powerBank);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("powerbank:delete")
	public R delete(@RequestBody Long[] ids){
		powerBankService.deleteBatch(ids);
		
		return R.ok();
	}
	
}

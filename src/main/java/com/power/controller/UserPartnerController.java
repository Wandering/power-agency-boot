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

import com.power.entity.UserPartnerEntity;
import com.power.service.UserPartnerService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;


/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-24 17:27:49
 */
@RestController
@RequestMapping("userpartner")
public class UserPartnerController {
	@Autowired
	private UserPartnerService userPartnerService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("userpartner:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<UserPartnerEntity> userPartnerList = userPartnerService.queryList(query);
		int total = userPartnerService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(userPartnerList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("userpartner:info")
	public R info(@PathVariable("id") Long id){
		UserPartnerEntity userPartner = userPartnerService.queryObject(id);
		
		return R.ok().put("userPartner", userPartner);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("userpartner:save")
	public R save(@RequestBody UserPartnerEntity userPartner){
		userPartnerService.save(userPartner);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("userpartner:update")
	public R update(@RequestBody UserPartnerEntity userPartner){
		userPartnerService.update(userPartner);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("userpartner:delete")
	public R delete(@RequestBody Long[] ids){
		userPartnerService.deleteBatch(ids);
		
		return R.ok();
	}
	
}

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

import com.power.entity.DictCommonEntity;
import com.power.service.DictCommonService;
import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;


/**
 * 字典管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-24 11:49:16
 */
@RestController
@RequestMapping("dictcommon")
public class DictCommonController {
	@Autowired
	private DictCommonService dictCommonService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("dictcommon:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<DictCommonEntity> dictCommonList = dictCommonService.queryList(query);
		int total = dictCommonService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(dictCommonList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	/**
	 * 查询字典
	 */
	@RequestMapping("/{type}")
	public R listbytype(@PathVariable("type") String type){
		//查询列表数据

		List<DictCommonEntity> dictCommonList = dictCommonService.queryListByType(type);
		
		
		return R.ok().put("dictCommon", dictCommonList);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("dictcommon:info")
	public R info(@PathVariable("id") Integer id){
		DictCommonEntity dictCommon = dictCommonService.queryObject(id);
		
		return R.ok().put("dictCommon", dictCommon);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("dictcommon:save")
	public R save(@RequestBody DictCommonEntity dictCommon){
		dictCommonService.save(dictCommon);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("dictcommon:update")
	public R update(@RequestBody DictCommonEntity dictCommon){
		dictCommonService.update(dictCommon);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("dictcommon:delete")
	public R delete(@RequestBody Integer[] ids){
		dictCommonService.deleteBatch(ids);
		
		return R.ok();
	}
	
}

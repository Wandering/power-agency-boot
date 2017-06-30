package com.power.controller.ex;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.power.service.ex.ForderService;

import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;

/**
 * 订单记录
 * 
 * @author lyt
 * @date 2017-06-29 1533
 */
@RestController
@RequestMapping("forder")
public class ForderController {
	
	@Autowired
	private ForderService forderService;
	
	/**
	 * 订单记录
	 */
	@RequestMapping("/queryOrderModel")
	@RequiresPermissions("forder:queryOrderModel")
	public R listbytype(@RequestParam Map<String, Object> params){
		 Query query = new Query(params);
		List<?> orderList = forderService.queryOrderModel(query);
		int total = forderService.queryTotal(query);
		PageUtils pageUtil = new PageUtils(orderList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
}

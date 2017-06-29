package com.power.controller.ex;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.power.entity.OrderLineEntity;
import com.power.service.ex.OrderLineService;
import com.power.util.UtilDate;

import io.renren.utils.PageUtils;
import io.renren.utils.Query;
import io.renren.utils.R;


/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-28 18:20:15
 */
@RestController
@RequestMapping("orderline")
public class OrderLineController {
	@Autowired
	private OrderLineService orderLineService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("orderline:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<OrderLineEntity> orderLineList = orderLineService.queryList(query);
		int total = orderLineService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(orderLineList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("orderline:info")
	public R info(@PathVariable("id") Long id){
		OrderLineEntity orderLine = orderLineService.queryObject(id);
		
		return R.ok().put("orderLine", orderLine);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("orderline:save")
	public R save(@RequestBody OrderLineEntity orderLine){
		orderLineService.save(orderLine);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("orderline:update")
	public R update(@RequestBody OrderLineEntity orderLine){
		orderLineService.update(orderLine);
		
		return R.ok();
	}
	
	/**
	 * 查询上月与昨日的成交额
	 */
	@RequestMapping("/total")
	@RequiresPermissions("orderline:total")
	public R total(){
		double yesdaytotal ;
		double lastmonthtotal;
		Map <String,String> map =UtilDate.getDate();
		try{
		 yesdaytotal = orderLineService.queryOrderTotal(map.get("start"),map.get("end"));
		}catch(Exception e){
		 yesdaytotal=0;
		}
		try{
			 lastmonthtotal = orderLineService.queryOrderTotal(map.get("start2"),map.get("end2"));
			}catch(Exception e){
			 lastmonthtotal=0;
			}
		return R.ok().put("yesdaytotal", yesdaytotal).put("lastmonthtotal",lastmonthtotal );
	}
	
	
	
	
}

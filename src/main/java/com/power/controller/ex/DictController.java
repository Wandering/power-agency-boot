package com.power.controller.ex;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.power.entity.ex.PowerStationBaseDTO;
import com.power.service.ex.DictService;
import io.renren.utils.R;

/**
 * 字典查询
 * 
 * @author hwx
 * @date 2017-06-24 11:49:16
 */
@RestController
@RequestMapping("dict")
public class DictController {
	
	@Autowired
	private DictService dictService;
	
	/**
	 * 查询字典
	 */
	@RequestMapping("/{type}")
	public R listbytype(@PathVariable("type") String type){
		List<?> dictCommonList = dictService.queryListByType(type);
		return R.ok().put("data", dictCommonList);
	}
	
	/**
	 * 
	 * @param type
	 * @return
	 */
	@RequestMapping("/queryPlatform")
	public R queryPlatform(){
		List<?> PlatformList = dictService.queryPlatform();
		return R.ok().put("data",PlatformList);
	}
	
	/**
	 * 字典-充电桩型号
	 */
	@RequestMapping("/queryStationModel")
	public R queryStationModel(){
		List<?> models = dictService.queryStationModel();
		return R.ok().put("data", models);
	}
	
	/**
	 * 字典-充电宝型号
	 */
	@RequestMapping("/queryPowerModel")
	public R queryPowerModel(){
		List<?> models = dictService.queryPowerModel();
		return R.ok().put("data", models);
	}
	
	/**
	 * 字典-收费模式
	 */
	@RequestMapping("/queryChargerModel")
	public R queryChargerModel(){
		List<?> models = dictService.queryChargeModel();
		return R.ok().put("data", models);
	}
	
	/**
	 * 字典-异常类型
	 */
	@RequestMapping("/queryErrorType")
	public R queryErrorType(@RequestParam Map<String, Object> params){
		List<?> types = dictService.queryErrorType(params);
		return R.ok().put("data", types);
	}
	
	/**
	 * 字典-选择充电桩
	 */
	@RequestMapping("/queryStations")
	public R queryStations(Map<String, Object> map){
		List<PowerStationBaseDTO> stations = dictService.queryStations(map);
		return R.ok().put("data", stations);
	}
}

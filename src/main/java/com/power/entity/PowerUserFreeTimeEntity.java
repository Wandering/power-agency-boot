package com.power.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-19 19:26:00
 */
public class PowerUserFreeTimeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//非主键，不自增，与全局key唯一对应，生成用户时自动创建
	private Long id;
	//订单生成时候的缓存时间和订单 订单weikey 形式{1:50，2:20} 标识订单1:50分钟,订单2:20分钟,临时存在使用过之后即删除
	private String tempDayFreeTime;
	//日免费时长(每日刷新)
	private Integer currDayFreeTime;
	//订单生成时候的用户等级 订单weikey 形式{1:1，2:2} 标识订单1:计费模式1,订单2:计费模式2,临时存在使用过之后即删除
	private String tempModelLv;
	//订单生成时候的缓存剩余封顶费用和订单 订单weikey 形式{1:50，2:20} 标识订单1:50,订单2:20 单位:分,临时存在使用过之后即删除
	private String tempDayFreeFee;
	//日封顶费用(每日刷新)
	private Long currDayFreeFee;

	/**
	 * 设置：非主键，不自增，与全局key唯一对应，生成用户时自动创建
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：非主键，不自增，与全局key唯一对应，生成用户时自动创建
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：订单生成时候的缓存时间和订单 订单weikey 形式{1:50，2:20} 标识订单1:50分钟,订单2:20分钟,临时存在使用过之后即删除
	 */
	public void setTempDayFreeTime(String tempDayFreeTime) {
		this.tempDayFreeTime = tempDayFreeTime;
	}
	/**
	 * 获取：订单生成时候的缓存时间和订单 订单weikey 形式{1:50，2:20} 标识订单1:50分钟,订单2:20分钟,临时存在使用过之后即删除
	 */
	public String getTempDayFreeTime() {
		return tempDayFreeTime;
	}
	/**
	 * 设置：日免费时长(每日刷新)
	 */
	public void setCurrDayFreeTime(Integer currDayFreeTime) {
		this.currDayFreeTime = currDayFreeTime;
	}
	/**
	 * 获取：日免费时长(每日刷新)
	 */
	public Integer getCurrDayFreeTime() {
		return currDayFreeTime;
	}
	/**
	 * 设置：订单生成时候的用户等级 订单weikey 形式{1:1，2:2} 标识订单1:计费模式1,订单2:计费模式2,临时存在使用过之后即删除
	 */
	public void setTempModelLv(String tempModelLv) {
		this.tempModelLv = tempModelLv;
	}
	/**
	 * 获取：订单生成时候的用户等级 订单weikey 形式{1:1，2:2} 标识订单1:计费模式1,订单2:计费模式2,临时存在使用过之后即删除
	 */
	public String getTempModelLv() {
		return tempModelLv;
	}
	/**
	 * 设置：订单生成时候的缓存剩余封顶费用和订单 订单weikey 形式{1:50，2:20} 标识订单1:50,订单2:20 单位:分,临时存在使用过之后即删除
	 */
	public void setTempDayFreeFee(String tempDayFreeFee) {
		this.tempDayFreeFee = tempDayFreeFee;
	}
	/**
	 * 获取：订单生成时候的缓存剩余封顶费用和订单 订单weikey 形式{1:50，2:20} 标识订单1:50,订单2:20 单位:分,临时存在使用过之后即删除
	 */
	public String getTempDayFreeFee() {
		return tempDayFreeFee;
	}
	/**
	 * 设置：日封顶费用(每日刷新)
	 */
	public void setCurrDayFreeFee(Long currDayFreeFee) {
		this.currDayFreeFee = currDayFreeFee;
	}
	/**
	 * 获取：日封顶费用(每日刷新)
	 */
	public Long getCurrDayFreeFee() {
		return currDayFreeFee;
	}
}

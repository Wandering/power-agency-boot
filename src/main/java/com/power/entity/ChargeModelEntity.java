package com.power.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 收费模式
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-28 19:17:40
 */
public class ChargeModelEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//######收费模式######
	private Long id;
	//模式名称
	private String name;
	//计费机制 0 24小时 1 自然日制
	private Integer chargeDay;
	//每次需要充值多少
	private BigDecimal firstDeposit;
	//账号本金最少值
	private BigDecimal minDeposit;
	//年费
	private BigDecimal yearFee;
	//免费时长（分钟）
	private Integer freeTime;
	//逾期单价（元/时）
	private Long overdueFee;
	//封顶（元/天）
	private Long maxOverdueFee;
	//还电缓冲时间 单位s
	private Long bufferTime;
	//扣费比例
	private Long borrowScale;
	//
	private Object createDt;
	//
	private Object updateDt;
	//
	private Long createBy;
	//
	private Long updateBy;
	//订单免费时长
	private Long orderFreeTime;

	/**
	 * 设置：######收费模式######
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：######收费模式######
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：模式名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：模式名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：计费机制 0 24小时 1 自然日制
	 */
	public void setChargeDay(Integer chargeDay) {
		this.chargeDay = chargeDay;
	}
	/**
	 * 获取：计费机制 0 24小时 1 自然日制
	 */
	public Integer getChargeDay() {
		return chargeDay;
	}
	/**
	 * 设置：每次需要充值多少
	 */
	public void setFirstDeposit(BigDecimal firstDeposit) {
		this.firstDeposit = firstDeposit;
	}
	/**
	 * 获取：每次需要充值多少
	 */
	public BigDecimal getFirstDeposit() {
		return firstDeposit;
	}
	/**
	 * 设置：账号本金最少值
	 */
	public void setMinDeposit(BigDecimal minDeposit) {
		this.minDeposit = minDeposit;
	}
	/**
	 * 获取：账号本金最少值
	 */
	public BigDecimal getMinDeposit() {
		return minDeposit;
	}
	/**
	 * 设置：年费
	 */
	public void setYearFee(BigDecimal yearFee) {
		this.yearFee = yearFee;
	}
	/**
	 * 获取：年费
	 */
	public BigDecimal getYearFee() {
		return yearFee;
	}
	/**
	 * 设置：免费时长（分钟）
	 */
	public void setFreeTime(Integer freeTime) {
		this.freeTime = freeTime;
	}
	/**
	 * 获取：免费时长（分钟）
	 */
	public Integer getFreeTime() {
		return freeTime;
	}
	/**
	 * 设置：逾期单价（元/时）
	 */
	public void setOverdueFee(Long overdueFee) {
		this.overdueFee = overdueFee;
	}
	/**
	 * 获取：逾期单价（元/时）
	 */
	public Long getOverdueFee() {
		return overdueFee;
	}
	/**
	 * 设置：封顶（元/天）
	 */
	public void setMaxOverdueFee(Long maxOverdueFee) {
		this.maxOverdueFee = maxOverdueFee;
	}
	/**
	 * 获取：封顶（元/天）
	 */
	public Long getMaxOverdueFee() {
		return maxOverdueFee;
	}
	/**
	 * 设置：还电缓冲时间 单位s
	 */
	public void setBufferTime(Long bufferTime) {
		this.bufferTime = bufferTime;
	}
	/**
	 * 获取：还电缓冲时间 单位s
	 */
	public Long getBufferTime() {
		return bufferTime;
	}
	/**
	 * 设置：扣费比例
	 */
	public void setBorrowScale(Long borrowScale) {
		this.borrowScale = borrowScale;
	}
	/**
	 * 获取：扣费比例
	 */
	public Long getBorrowScale() {
		return borrowScale;
	}
	/**
	 * 设置：
	 */
	public void setCreateDt(Object createDt) {
		this.createDt = createDt;
	}
	/**
	 * 获取：
	 */
	public Object getCreateDt() {
		return createDt;
	}
	/**
	 * 设置：
	 */
	public void setUpdateDt(Object updateDt) {
		this.updateDt = updateDt;
	}
	/**
	 * 获取：
	 */
	public Object getUpdateDt() {
		return updateDt;
	}
	/**
	 * 设置：
	 */
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：
	 */
	public Long getCreateBy() {
		return createBy;
	}
	/**
	 * 设置：
	 */
	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}
	/**
	 * 获取：
	 */
	public Long getUpdateBy() {
		return updateBy;
	}
	/**
	 * 设置：订单免费时长
	 */
	public void setOrderFreeTime(Long orderFreeTime) {
		this.orderFreeTime = orderFreeTime;
	}
	/**
	 * 获取：订单免费时长
	 */
	public Long getOrderFreeTime() {
		return orderFreeTime;
	}
}

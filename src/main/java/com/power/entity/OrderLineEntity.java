package com.power.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-28 18:20:15
 */
public class OrderLineEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//######订单行表######
	private Long id;
	//费用
	private Double fee;
	//用户ID
	private Long userId;
	//服务商ID
	private Long agency;
	//借出充电桩ID
	private String fromStation;
	//归还充电桩ID
	private String toStation;
	//充电宝ID
	private String powerBank;
	//交易类型，BALANCE,CONSUME,DEPOSIT
	private String feeType;
	//订单ID
	private Long orderId;
	//
	private Date createDt;
	//
	private Date updateDt;
	//
	private Long createBy;
	//
	private Long updateBy;
	//开始时间
	private Long startDt;
	//结束时间
	private Long endDt;

	/**
	 * 设置：######订单行表######
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：######订单行表######
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：费用
	 */
	public void setFee(Double fee) {
		this.fee = fee;
	}
	/**
	 * 获取：费用
	 */
	public Double getFee() {
		return fee;
	}
	/**
	 * 设置：用户ID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：服务商ID
	 */
	public void setAgency(Long agency) {
		this.agency = agency;
	}
	/**
	 * 获取：服务商ID
	 */
	public Long getAgency() {
		return agency;
	}
	/**
	 * 设置：借出充电桩ID
	 */
	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}
	/**
	 * 获取：借出充电桩ID
	 */
	public String getFromStation() {
		return fromStation;
	}
	/**
	 * 设置：归还充电桩ID
	 */
	public void setToStation(String toStation) {
		this.toStation = toStation;
	}
	/**
	 * 获取：归还充电桩ID
	 */
	public String getToStation() {
		return toStation;
	}
	/**
	 * 设置：充电宝ID
	 */
	public void setPowerBank(String powerBank) {
		this.powerBank = powerBank;
	}
	/**
	 * 获取：充电宝ID
	 */
	public String getPowerBank() {
		return powerBank;
	}
	/**
	 * 设置：交易类型，BALANCE,CONSUME,DEPOSIT
	 */
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	/**
	 * 获取：交易类型，BALANCE,CONSUME,DEPOSIT
	 */
	public String getFeeType() {
		return feeType;
	}
	/**
	 * 设置：订单ID
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：订单ID
	 */
	public Long getOrderId() {
		return orderId;
	}
	/**
	 * 设置：
	 */
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	/**
	 * 获取：
	 */
	public Date getCreateDt() {
		return createDt;
	}
	/**
	 * 设置：
	 */
	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}
	/**
	 * 获取：
	 */
	public Date getUpdateDt() {
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
	 * 设置：开始时间
	 */
	public void setStartDt(Long startDt) {
		this.startDt = startDt;
	}
	/**
	 * 获取：开始时间
	 */
	public Long getStartDt() {
		return startDt;
	}
	/**
	 * 设置：结束时间
	 */
	public void setEndDt(Long endDt) {
		this.endDt = endDt;
	}
	/**
	 * 获取：结束时间
	 */
	public Long getEndDt() {
		return endDt;
	}
}

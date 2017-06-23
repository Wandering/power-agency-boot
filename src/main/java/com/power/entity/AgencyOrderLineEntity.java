package com.power.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-21 23:02:38
 */
public class AgencyOrderLineEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//######服务商订单行，和用户订单行一样######
	private Long id;
	//
	private Double fee;
	//
	private Long userId;
	//
	private Long agency;
	//
	private String fromStation;
	//
	private String toStation;
	//
	private String powerBank;
	//
	private String feeType;
	//
	private Long orderId;
	//
	private Long startDt;
	//
	private Date createDt;
	//
	private Date updateDt;
	//
	private Long createBy;
	//
	private Long updateBy;
	//
	private Long endDt;
	//
	private Long originOrder;

	/**
	 * 设置：######服务商订单行，和用户订单行一样######
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：######服务商订单行，和用户订单行一样######
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setFee(Double fee) {
		this.fee = fee;
	}
	/**
	 * 获取：
	 */
	public Double getFee() {
		return fee;
	}
	/**
	 * 设置：
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：
	 */
	public void setAgency(Long agency) {
		this.agency = agency;
	}
	/**
	 * 获取：
	 */
	public Long getAgency() {
		return agency;
	}
	/**
	 * 设置：
	 */
	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}
	/**
	 * 获取：
	 */
	public String getFromStation() {
		return fromStation;
	}
	/**
	 * 设置：
	 */
	public void setToStation(String toStation) {
		this.toStation = toStation;
	}
	/**
	 * 获取：
	 */
	public String getToStation() {
		return toStation;
	}
	/**
	 * 设置：
	 */
	public void setPowerBank(String powerBank) {
		this.powerBank = powerBank;
	}
	/**
	 * 获取：
	 */
	public String getPowerBank() {
		return powerBank;
	}
	/**
	 * 设置：
	 */
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	/**
	 * 获取：
	 */
	public String getFeeType() {
		return feeType;
	}
	/**
	 * 设置：
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：
	 */
	public Long getOrderId() {
		return orderId;
	}
	/**
	 * 设置：
	 */
	public void setStartDt(Long startDt) {
		this.startDt = startDt;
	}
	/**
	 * 获取：
	 */
	public Long getStartDt() {
		return startDt;
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
	 * 设置：
	 */
	public void setEndDt(Long endDt) {
		this.endDt = endDt;
	}
	/**
	 * 获取：
	 */
	public Long getEndDt() {
		return endDt;
	}
	/**
	 * 设置：
	 */
	public void setOriginOrder(Long originOrder) {
		this.originOrder = originOrder;
	}
	/**
	 * 获取：
	 */
	public Long getOriginOrder() {
		return originOrder;
	}
}

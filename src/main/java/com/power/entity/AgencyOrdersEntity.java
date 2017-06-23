package com.power.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-21 23:02:26
 */
public class AgencyOrdersEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//######服务商订单，从用户支付订单的提成，和用户订单orders基本一样######
	private Long id;
	//
	private Double totalFee;
	//
	private Long orderOwner;
	//
	private Long parentOrder;
	//
	private Long agency;
	//
	private String type;
	//
	private String status;
	//
	private Date createDt;
	//
	private Date updateDt;
	//
	private Long createBy;
	//
	private Long updateBy;
	//
	private Integer useCount;
	//
	private String agencyType;
	//
	private String fromStation;
	//
	private String orderNo;

	/**
	 * 设置：######服务商订单，从用户支付订单的提成，和用户订单orders基本一样######
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：######服务商订单，从用户支付订单的提成，和用户订单orders基本一样######
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setTotalFee(Double totalFee) {
		this.totalFee = totalFee;
	}
	/**
	 * 获取：
	 */
	public Double getTotalFee() {
		return totalFee;
	}
	/**
	 * 设置：
	 */
	public void setOrderOwner(Long orderOwner) {
		this.orderOwner = orderOwner;
	}
	/**
	 * 获取：
	 */
	public Long getOrderOwner() {
		return orderOwner;
	}
	/**
	 * 设置：
	 */
	public void setParentOrder(Long parentOrder) {
		this.parentOrder = parentOrder;
	}
	/**
	 * 获取：
	 */
	public Long getParentOrder() {
		return parentOrder;
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
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：
	 */
	public String getStatus() {
		return status;
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
	public void setUseCount(Integer useCount) {
		this.useCount = useCount;
	}
	/**
	 * 获取：
	 */
	public Integer getUseCount() {
		return useCount;
	}
	/**
	 * 设置：
	 */
	public void setAgencyType(String agencyType) {
		this.agencyType = agencyType;
	}
	/**
	 * 获取：
	 */
	public String getAgencyType() {
		return agencyType;
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
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * 获取：
	 */
	public String getOrderNo() {
		return orderNo;
	}
}

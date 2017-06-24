package com.power.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 充电宝基础表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-24 09:59:18
 */
public class PowerBankEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//######充电宝表######
	private Long id;
	//用户ID，充电宝目前被哪个用户借用
	private Long customer;
	//充电桩ID，充电宝目前位于哪个充电桩
	private String station;
	//充电桩卡槽号，充电宝目前位于哪个卡槽中
	private String position;
	//充电宝IMEI号
	private String code;
	//充电宝型号
	private String type;
	//服务商
	private Long agency;
	//充电宝状态，在卡槽中IN_POSITION，借出RENT
	private String status;
	//
	private Date createDt;
	//
	private Date updateDt;
	//
	private Long createBy;
	//
	private Long updateBy;
	//充电宝被借出次数
	private Integer borrowCount;

	/**
	 * 设置：######充电宝表######
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：######充电宝表######
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：用户ID，充电宝目前被哪个用户借用
	 */
	public void setCustomer(Long customer) {
		this.customer = customer;
	}
	/**
	 * 获取：用户ID，充电宝目前被哪个用户借用
	 */
	public Long getCustomer() {
		return customer;
	}
	/**
	 * 设置：充电桩ID，充电宝目前位于哪个充电桩
	 */
	public void setStation(String station) {
		this.station = station;
	}
	/**
	 * 获取：充电桩ID，充电宝目前位于哪个充电桩
	 */
	public String getStation() {
		return station;
	}
	/**
	 * 设置：充电桩卡槽号，充电宝目前位于哪个卡槽中
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * 获取：充电桩卡槽号，充电宝目前位于哪个卡槽中
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * 设置：充电宝IMEI号
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：充电宝IMEI号
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：充电宝型号
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：充电宝型号
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：服务商
	 */
	public void setAgency(Long agency) {
		this.agency = agency;
	}
	/**
	 * 获取：服务商
	 */
	public Long getAgency() {
		return agency;
	}
	/**
	 * 设置：充电宝状态，在卡槽中IN_POSITION，借出RENT
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：充电宝状态，在卡槽中IN_POSITION，借出RENT
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
	 * 设置：充电宝被借出次数
	 */
	public void setBorrowCount(Integer borrowCount) {
		this.borrowCount = borrowCount;
	}
	/**
	 * 获取：充电宝被借出次数
	 */
	public Integer getBorrowCount() {
		return borrowCount;
	}
}

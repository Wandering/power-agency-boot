package com.power.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * balance 本金
bouns 活动奖金
back_bouns 充返奖金
roles 用户会员级别
credit 信用分
update_dt 更新时间
create_dt 创建时间
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-28 14:38:40
 */
public class PowerUserAcountsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//###账户资金表###
	private Long id;
	//账户编号
	private String accountNo;
	//用户id
	private Long userId;
	//余额(本金)
	private Double balance;
	//赠送金
	private Double bouns;
	//充返
	private Double backBouns;
	//会员类型
	private Long roles;
	//信用分
	private Long credit;
	//
	private Date createDt;
	//
	private Date updateDt;
	//
	private Long createBy;
	//
	private Long updateBy;

	/**
	 * 设置：###账户资金表###
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：###账户资金表###
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：账户编号
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	/**
	 * 获取：账户编号
	 */
	public String getAccountNo() {
		return accountNo;
	}
	/**
	 * 设置：用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：余额(本金)
	 */
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	/**
	 * 获取：余额(本金)
	 */
	public Double getBalance() {
		return balance;
	}
	/**
	 * 设置：赠送金
	 */
	public void setBouns(Double bouns) {
		this.bouns = bouns;
	}
	/**
	 * 获取：赠送金
	 */
	public Double getBouns() {
		return bouns;
	}
	/**
	 * 设置：充返
	 */
	public void setBackBouns(Double backBouns) {
		this.backBouns = backBouns;
	}
	/**
	 * 获取：充返
	 */
	public Double getBackBouns() {
		return backBouns;
	}
	/**
	 * 设置：会员类型
	 */
	public void setRoles(Long roles) {
		this.roles = roles;
	}
	/**
	 * 获取：会员类型
	 */
	public Long getRoles() {
		return roles;
	}
	/**
	 * 设置：信用分
	 */
	public void setCredit(Long credit) {
		this.credit = credit;
	}
	/**
	 * 获取：信用分
	 */
	public Long getCredit() {
		return credit;
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
}

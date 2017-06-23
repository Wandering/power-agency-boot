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
public class AgencyOrderLifecyleEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//######服务商订单账期结算时间######
	private Long id;
	//开始时间
	private Date startDt;
	//结束时间
	private Date endDt;
	//类型
	private String type;
	//
	private Date createDt;
	//
	private Date updateDt;
	//
	private Long createBy;
	//
	private Long updateBy;
	//月份
	private String mounth;

	/**
	 * 设置：######服务商订单账期结算时间######
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：######服务商订单账期结算时间######
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：开始时间
	 */
	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}
	/**
	 * 获取：开始时间
	 */
	public Date getStartDt() {
		return startDt;
	}
	/**
	 * 设置：结束时间
	 */
	public void setEndDt(Date endDt) {
		this.endDt = endDt;
	}
	/**
	 * 获取：结束时间
	 */
	public Date getEndDt() {
		return endDt;
	}
	/**
	 * 设置：类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型
	 */
	public String getType() {
		return type;
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
	 * 设置：月份
	 */
	public void setMounth(String mounth) {
		this.mounth = mounth;
	}
	/**
	 * 获取：月份
	 */
	public String getMounth() {
		return mounth;
	}
}

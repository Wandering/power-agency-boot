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
public class AgenciesEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//######服务商表######
	private Long id;
	//服务商名称
	private String name;
	//英文缩写????
	private String abbrCode;
	//地域
	private Long region;
	//地址
	private String address;
	//状态
	private String status;
	//类型：平台还是服务商
	private String type;
	//
	private Long parent;
	//
	private Date createDt;
	//
	private Date updateDt;
	//
	private Long createBy;
	//
	private Long updateBy;

	/**
	 * 设置：######服务商表######
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：######服务商表######
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：服务商名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：服务商名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：英文缩写????
	 */
	public void setAbbrCode(String abbrCode) {
		this.abbrCode = abbrCode;
	}
	/**
	 * 获取：英文缩写????
	 */
	public String getAbbrCode() {
		return abbrCode;
	}
	/**
	 * 设置：地域
	 */
	public void setRegion(Long region) {
		this.region = region;
	}
	/**
	 * 获取：地域
	 */
	public Long getRegion() {
		return region;
	}
	/**
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：类型：平台还是服务商
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型：平台还是服务商
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：
	 */
	public void setParent(Long parent) {
		this.parent = parent;
	}
	/**
	 * 获取：
	 */
	public Long getParent() {
		return parent;
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

package com.power.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 异常类别表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-29 09:41:28
 */
public class PowerErrorTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//错误码
	private Integer code;
	//故障等级(故障紧急程度,现阶段默认1最高 以后考虑分级)
	private Integer lv;
	//异常所属设备(1:桩2：充电宝)
	private Integer deviceType;
	//故障类别(1:硬严重（硬件故障） 2:软异常（软件故障）)
	private Integer type;
	//故障描述
	private String note;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：错误码
	 */
	public void setCode(Integer code) {
		this.code = code;
	}
	/**
	 * 获取：错误码
	 */
	public Integer getCode() {
		return code;
	}
	/**
	 * 设置：故障等级(故障紧急程度,现阶段默认1最高 以后考虑分级)
	 */
	public void setLv(Integer lv) {
		this.lv = lv;
	}
	/**
	 * 获取：故障等级(故障紧急程度,现阶段默认1最高 以后考虑分级)
	 */
	public Integer getLv() {
		return lv;
	}
	/**
	 * 设置：异常所属设备(1:桩2：充电宝)
	 */
	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}
	/**
	 * 获取：异常所属设备(1:桩2：充电宝)
	 */
	public Integer getDeviceType() {
		return deviceType;
	}
	/**
	 * 设置：故障类别(1:硬严重（硬件故障） 2:软异常（软件故障）)
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：故障类别(1:硬严重（硬件故障） 2:软异常（软件故障）)
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：故障描述
	 */
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * 获取：故障描述
	 */
	public String getNote() {
		return note;
	}
}

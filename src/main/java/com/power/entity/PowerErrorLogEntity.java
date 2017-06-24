package com.power.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 知路反馈充电宝异常
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-23 20:34:04
 */
public class PowerErrorLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增主键
	private Long id;
	//充电宝id
	private String batteryId;
	//幢ID
	private String deviceId;
	//槽位
	private Integer slotNo;
	//错误类型(1：认为处理，2：系统处理)
	private Integer type;
	//错误码
	private Integer errorCode;
	//重放次数
	private Integer chargeCount;
	//电量当前
	private Integer eq;
	//电压
	private Integer vol;
	//温度
	private Integer tempNow;
	//充电宝状态(上报字段)
	private Integer state;
	//上报时间
	private Date upTime;
	//当前处理状态(已处理，未处理)
	private Integer status;

	/**
	 * 设置：自增主键
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：自增主键
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：充电宝id
	 */
	public void setBatteryId(String batteryId) {
		this.batteryId = batteryId;
	}
	/**
	 * 获取：充电宝id
	 */
	public String getBatteryId() {
		return batteryId;
	}
	/**
	 * 设置：幢ID
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	/**
	 * 获取：幢ID
	 */
	public String getDeviceId() {
		return deviceId;
	}
	/**
	 * 设置：槽位
	 */
	public void setSlotNo(Integer slotNo) {
		this.slotNo = slotNo;
	}
	/**
	 * 获取：槽位
	 */
	public Integer getSlotNo() {
		return slotNo;
	}
	/**
	 * 设置：错误类型(1：认为处理，2：系统处理)
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：错误类型(1：认为处理，2：系统处理)
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：错误码
	 */
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * 获取：错误码
	 */
	public Integer getErrorCode() {
		return errorCode;
	}
	/**
	 * 设置：重放次数
	 */
	public void setChargeCount(Integer chargeCount) {
		this.chargeCount = chargeCount;
	}
	/**
	 * 获取：重放次数
	 */
	public Integer getChargeCount() {
		return chargeCount;
	}
	/**
	 * 设置：电量当前
	 */
	public void setEq(Integer eq) {
		this.eq = eq;
	}
	/**
	 * 获取：电量当前
	 */
	public Integer getEq() {
		return eq;
	}
	/**
	 * 设置：电压
	 */
	public void setVol(Integer vol) {
		this.vol = vol;
	}
	/**
	 * 获取：电压
	 */
	public Integer getVol() {
		return vol;
	}
	/**
	 * 设置：温度
	 */
	public void setTempNow(Integer tempNow) {
		this.tempNow = tempNow;
	}
	/**
	 * 获取：温度
	 */
	public Integer getTempNow() {
		return tempNow;
	}
	/**
	 * 设置：充电宝状态(上报字段)
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：充电宝状态(上报字段)
	 */
	public Integer getState() {
		return state;
	}
	/**
	 * 设置：上报时间
	 */
	public void setUpTime(Date upTime) {
		this.upTime = upTime;
	}
	/**
	 * 获取：上报时间
	 */
	public Date getUpTime() {
		return upTime;
	}
	/**
	 * 设置：当前处理状态(已处理，未处理)
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：当前处理状态(已处理，未处理)
	 */
	public Integer getStatus() {
		return status;
	}
}

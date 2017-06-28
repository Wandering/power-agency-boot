package com.power.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 桩信息错误日志
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-28 19:21:05
 */
public class StationErrorLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//充电桩
	private String deviceId;
	//卡槽号
	private Integer slotNo;
	//错误类型(需要处理，不需要处理[暂定])
	private Integer type;
	//错误码
	private Integer errorCode;
	//上报时间
	private Date upTime;
	//当前处理状态(被处理1，未处理0)
	private Integer status;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：充电桩
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	/**
	 * 获取：充电桩
	 */
	public String getDeviceId() {
		return deviceId;
	}
	/**
	 * 设置：卡槽号
	 */
	public void setSlotNo(Integer slotNo) {
		this.slotNo = slotNo;
	}
	/**
	 * 获取：卡槽号
	 */
	public Integer getSlotNo() {
		return slotNo;
	}
	/**
	 * 设置：错误类型(需要处理，不需要处理[暂定])
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：错误类型(需要处理，不需要处理[暂定])
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
	 * 设置：当前处理状态(被处理1，未处理0)
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：当前处理状态(被处理1，未处理0)
	 */
	public Integer getStatus() {
		return status;
	}
}

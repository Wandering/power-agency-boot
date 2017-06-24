package com.power.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 充电宝型号
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-24 16:01:17
 */
public class PowerModelEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//充电宝型号
	private String model;
	//电池容量
	private String capacity;
	//电芯类型
	private String coreType;
	//输入电流
	private String inputCurrent;
	//输出电流
	private String outputCurrent;
	//输入电压
	private String inputVoltage;
	//输出电压
	private String outputVoltage;
	//认证
	private String authentication;
	//尺寸
	private String size;
	//NFC
	private Integer isnfc;
	//充电线
	private String chargeLine;
	//生产厂家
	private String manufacturer;
	//
	private Date createDt;
	//
	private Date updateDt;
	//
	private Integer createBy;
	//
	private Integer updateBy;

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
	 * 设置：充电宝型号
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * 获取：充电宝型号
	 */
	public String getModel() {
		return model;
	}
	/**
	 * 设置：电池容量
	 */
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	/**
	 * 获取：电池容量
	 */
	public String getCapacity() {
		return capacity;
	}
	/**
	 * 设置：电芯类型
	 */
	public void setCoreType(String coreType) {
		this.coreType = coreType;
	}
	/**
	 * 获取：电芯类型
	 */
	public String getCoreType() {
		return coreType;
	}
	/**
	 * 设置：输入电流
	 */
	public void setInputCurrent(String inputCurrent) {
		this.inputCurrent = inputCurrent;
	}
	/**
	 * 获取：输入电流
	 */
	public String getInputCurrent() {
		return inputCurrent;
	}
	/**
	 * 设置：输出电流
	 */
	public void setOutputCurrent(String outputCurrent) {
		this.outputCurrent = outputCurrent;
	}
	/**
	 * 获取：输出电流
	 */
	public String getOutputCurrent() {
		return outputCurrent;
	}
	/**
	 * 设置：输入电压
	 */
	public void setInputVoltage(String inputVoltage) {
		this.inputVoltage = inputVoltage;
	}
	/**
	 * 获取：输入电压
	 */
	public String getInputVoltage() {
		return inputVoltage;
	}
	/**
	 * 设置：输出电压
	 */
	public void setOutputVoltage(String outputVoltage) {
		this.outputVoltage = outputVoltage;
	}
	/**
	 * 获取：输出电压
	 */
	public String getOutputVoltage() {
		return outputVoltage;
	}
	/**
	 * 设置：认证
	 */
	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}
	/**
	 * 获取：认证
	 */
	public String getAuthentication() {
		return authentication;
	}
	/**
	 * 设置：尺寸
	 */
	public void setSize(String size) {
		this.size = size;
	}
	/**
	 * 获取：尺寸
	 */
	public String getSize() {
		return size;
	}
	/**
	 * 设置：NFC
	 */
	public void setIsnfc(Integer isnfc) {
		this.isnfc = isnfc;
	}
	/**
	 * 获取：NFC
	 */
	public Integer getIsnfc() {
		return isnfc;
	}
	/**
	 * 设置：充电线
	 */
	public void setChargeLine(String chargeLine) {
		this.chargeLine = chargeLine;
	}
	/**
	 * 获取：充电线
	 */
	public String getChargeLine() {
		return chargeLine;
	}
	/**
	 * 设置：生产厂家
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	/**
	 * 获取：生产厂家
	 */
	public String getManufacturer() {
		return manufacturer;
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
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：
	 */
	public Integer getCreateBy() {
		return createBy;
	}
	/**
	 * 设置：
	 */
	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}
	/**
	 * 获取：
	 */
	public Integer getUpdateBy() {
		return updateBy;
	}
}

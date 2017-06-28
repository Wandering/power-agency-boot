package com.power.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 充电桩型号
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-28 19:17:40
 */
public class StationModelEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//充电桩型号
	private String model;
	//卡槽数量
	private Integer slotNo;
	//通讯方式
	private Integer channel;
	//输入电压
	private String inputVoltage;
	//最大输入电流
	private String maxInputCurrent;
	//最大输入功耗
	private String maxInputPower;
	//静态输入功耗
	private String staticInputPower;
	//认证
	private String authentication;
	//尺寸
	private String size;
	//NFC
	private Integer isnfc;
	//出仓方式
	private String deliveryModel;
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
	 * 设置：充电桩型号
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * 获取：充电桩型号
	 */
	public String getModel() {
		return model;
	}
	/**
	 * 设置：卡槽数量
	 */
	public void setSlotNo(Integer slotNo) {
		this.slotNo = slotNo;
	}
	/**
	 * 获取：卡槽数量
	 */
	public Integer getSlotNo() {
		return slotNo;
	}
	/**
	 * 设置：通讯方式
	 */
	public void setChannel(Integer channel) {
		this.channel = channel;
	}
	/**
	 * 获取：通讯方式
	 */
	public Integer getChannel() {
		return channel;
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
	 * 设置：最大输入电流
	 */
	public void setMaxInputCurrent(String maxInputCurrent) {
		this.maxInputCurrent = maxInputCurrent;
	}
	/**
	 * 获取：最大输入电流
	 */
	public String getMaxInputCurrent() {
		return maxInputCurrent;
	}
	/**
	 * 设置：最大输入功耗
	 */
	public void setMaxInputPower(String maxInputPower) {
		this.maxInputPower = maxInputPower;
	}
	/**
	 * 获取：最大输入功耗
	 */
	public String getMaxInputPower() {
		return maxInputPower;
	}
	/**
	 * 设置：静态输入功耗
	 */
	public void setStaticInputPower(String staticInputPower) {
		this.staticInputPower = staticInputPower;
	}
	/**
	 * 获取：静态输入功耗
	 */
	public String getStaticInputPower() {
		return staticInputPower;
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
	 * 设置：出仓方式
	 */
	public void setDeliveryModel(String deliveryModel) {
		this.deliveryModel = deliveryModel;
	}
	/**
	 * 获取：出仓方式
	 */
	public String getDeliveryModel() {
		return deliveryModel;
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

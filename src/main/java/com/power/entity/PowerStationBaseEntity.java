package com.power.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 充电桩基础表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-28 20:03:38
 */
public class PowerStationBaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键(不参与关联)
	private Integer id;
	//充电桩code，充电桩IMEI编号
	private String code;
	//主要通信信道 0：Wi-Fi,1：GPRS,2：4G 字典表STATION_CHANNEL
	private Integer channel;
	//充电桩型号
	private String type;
	//服务商id(由哪个服务商提供服务，默认是1知路)
	private Integer facilitatorId;
	//充电桩槽位
	private Integer slotNo;
	//充电桩错误状态：0、正常
	private Integer errorCode;
	//是否同步到知路服务器(1：是 0：否)
	private Integer isSync;
	//是否正在被使用(1，正在使用  2未使用)
	private Integer status;
	//异常槽位数量
	private Integer errorSlot;
	//空闲槽位
	private Integer free;
	//可借(记录当前充电中状态，减少每次统计)
	private Integer canBorrow;
	//设备上下线状态 1：上线 0：下线
	private Integer onlineStatus;
	//充电桩状态码：0、正常、1、禁用 2、删除
	private Integer stateCode;
	//总共借出次数
	private Integer borrowCount;
	//编辑人
	private String editName;
	//编辑人ID
	private Integer editId;
	//批次
	private String batch;
	//备注
	private String note;
	//生产日期
	private Date production;
	//运营商ID
	private Long agencyid;
	//
	private Date createDt;
	//
	private Date updateDt;
	//
	private Long createBy;
	//
	private Long updateBy;

	/**
	 * 设置：主键(不参与关联)
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键(不参与关联)
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：充电桩code，充电桩IMEI编号
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：充电桩code，充电桩IMEI编号
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：主要通信信道 0：Wi-Fi,1：GPRS,2：4G 字典表STATION_CHANNEL
	 */
	public void setChannel(Integer channel) {
		this.channel = channel;
	}
	/**
	 * 获取：主要通信信道 0：Wi-Fi,1：GPRS,2：4G 字典表STATION_CHANNEL
	 */
	public Integer getChannel() {
		return channel;
	}
	/**
	 * 设置：充电桩型号
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：充电桩型号
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：服务商id(由哪个服务商提供服务，默认是1知路)
	 */
	public void setFacilitatorId(Integer facilitatorId) {
		this.facilitatorId = facilitatorId;
	}
	/**
	 * 获取：服务商id(由哪个服务商提供服务，默认是1知路)
	 */
	public Integer getFacilitatorId() {
		return facilitatorId;
	}
	/**
	 * 设置：充电桩槽位
	 */
	public void setSlotNo(Integer slotNo) {
		this.slotNo = slotNo;
	}
	/**
	 * 获取：充电桩槽位
	 */
	public Integer getSlotNo() {
		return slotNo;
	}
	/**
	 * 设置：充电桩错误状态：0、正常
	 */
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * 获取：充电桩错误状态：0、正常
	 */
	public Integer getErrorCode() {
		return errorCode;
	}
	/**
	 * 设置：是否同步到知路服务器(1：是 0：否)
	 */
	public void setIsSync(Integer isSync) {
		this.isSync = isSync;
	}
	/**
	 * 获取：是否同步到知路服务器(1：是 0：否)
	 */
	public Integer getIsSync() {
		return isSync;
	}
	/**
	 * 设置：是否正在被使用(1，正在使用  2未使用)
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：是否正在被使用(1，正在使用  2未使用)
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：异常槽位数量
	 */
	public void setErrorSlot(Integer errorSlot) {
		this.errorSlot = errorSlot;
	}
	/**
	 * 获取：异常槽位数量
	 */
	public Integer getErrorSlot() {
		return errorSlot;
	}
	/**
	 * 设置：空闲槽位
	 */
	public void setFree(Integer free) {
		this.free = free;
	}
	/**
	 * 获取：空闲槽位
	 */
	public Integer getFree() {
		return free;
	}
	/**
	 * 设置：可借(记录当前充电中状态，减少每次统计)
	 */
	public void setCanBorrow(Integer canBorrow) {
		this.canBorrow = canBorrow;
	}
	/**
	 * 获取：可借(记录当前充电中状态，减少每次统计)
	 */
	public Integer getCanBorrow() {
		return canBorrow;
	}
	/**
	 * 设备上下线状态 1：上线 0：下线
	 */
	public void setonlineStatus(Integer onlineStatus) {
		this.onlineStatus = onlineStatus;
	}
	/**
	 * 设备上下线状态 1：上线 0：下线
	 */
	public Integer getonlineStatus() {
		return onlineStatus;
	}
	/**
	 * 设置：充电桩状态码：0、正常、1、禁用 2、删除
	 */
	public void setStateCode(Integer stateCode) {
		this.stateCode = stateCode;
	}
	/**
	 * 获取：充电桩状态码：0、正常、1、禁用 2、删除
	 */
	public Integer getStateCode() {
		return stateCode;
	}
	/**
	 * 设置：总共借出次数
	 */
	public void setBorrowCount(Integer borrowCount) {
		this.borrowCount = borrowCount;
	}
	/**
	 * 获取：总共借出次数
	 */
	public Integer getBorrowCount() {
		return borrowCount;
	}
	/**
	 * 设置：编辑人
	 */
	public void setEditName(String editName) {
		this.editName = editName;
	}
	/**
	 * 获取：编辑人
	 */
	public String getEditName() {
		return editName;
	}
	/**
	 * 设置：编辑人ID
	 */
	public void setEditId(Integer editId) {
		this.editId = editId;
	}
	/**
	 * 获取：编辑人ID
	 */
	public Integer getEditId() {
		return editId;
	}
	/**
	 * 设置：批次
	 */
	public void setBatch(String batch) {
		this.batch = batch;
	}
	/**
	 * 获取：批次
	 */
	public String getBatch() {
		return batch;
	}
	/**
	 * 设置：备注
	 */
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * 获取：备注
	 */
	public String getNote() {
		return note;
	}
	/**
	 * 设置：生产日期
	 */
	public void setProduction(Date production) {
		this.production = production;
	}
	/**
	 * 获取：生产日期
	 */
	public Date getProduction() {
		return production;
	}
	/**
	 * 设置：运营商ID
	 */
	public void setAgencyid(Long agencyid) {
		this.agencyid = agencyid;
	}
	/**
	 * 获取：运营商ID
	 */
	public Long getAgencyid() {
		return agencyid;
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

package com.power.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 网点基础表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-28 20:03:38
 */
public class PowerStationEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//######充电桩表######
	private Long id;
	//服务商
	private Long agent;
	//充电桩ID
	private String code;
	//充电桩网点地址
	private String address;
	//表region.地点ID(如深圳南山1000103)
	private Long region;
	//网点地址对应纬度
	private Double latitude;
	//网点地址对应经度
	private Double longitude;
	//维修人员/负责人
	private String wxUser;
	//维修人员联系电话
	private String wxUserPhone;
	//
	private Object dimensionCode;
	//充电桩状态，启用（正常运营） or 禁用 or 审核 
	private String status;
	//
	private Date createDt;
	//
	private Date updateDt;
	//生产日期
	private Date productDt;
	//生产厂家
	private String productCreator;
	//充电桩网点名称
	private String shopName;
	//充电桩联网方式，wifi GPRS 4G BLE
	private String connectType;
	//
	private Long createBy;
	//
	private Long updateBy;
	//开始营业时间
	private Double shopStartDt;
	//结束营业时间
	private Double shopEndDt;
	//
	private Integer activeBankNo;
	//网点联系电话
	private String shopPhone;
	//充电桩在网点的摆放位置，如收银台
	private String shopStationPoint;
	//收费模式
	private String feescale;
	//最后编辑人员
	private String lasteditor;

	/**
	 * 设置：######充电桩表######
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：######充电桩表######
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：服务商
	 */
	public void setAgent(Long agent) {
		this.agent = agent;
	}
	/**
	 * 获取：服务商
	 */
	public Long getAgent() {
		return agent;
	}
	/**
	 * 设置：充电桩ID
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：充电桩ID
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：充电桩网点地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：充电桩网点地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：表region.地点ID(如深圳南山1000103)
	 */
	public void setRegion(Long region) {
		this.region = region;
	}
	/**
	 * 获取：表region.地点ID(如深圳南山1000103)
	 */
	public Long getRegion() {
		return region;
	}
	/**
	 * 设置：网点地址对应纬度
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	/**
	 * 获取：网点地址对应纬度
	 */
	public Double getLatitude() {
		return latitude;
	}
	/**
	 * 设置：网点地址对应经度
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	/**
	 * 获取：网点地址对应经度
	 */
	public Double getLongitude() {
		return longitude;
	}
	/**
	 * 设置：维修人员/负责人
	 */
	public void setWxUser(String wxUser) {
		this.wxUser = wxUser;
	}
	/**
	 * 获取：维修人员/负责人
	 */
	public String getWxUser() {
		return wxUser;
	}
	/**
	 * 设置：维修人员联系电话
	 */
	public void setWxUserPhone(String wxUserPhone) {
		this.wxUserPhone = wxUserPhone;
	}
	/**
	 * 获取：维修人员联系电话
	 */
	public String getWxUserPhone() {
		return wxUserPhone;
	}
	/**
	 * 设置：
	 */
	public void setDimensionCode(Object dimensionCode) {
		this.dimensionCode = dimensionCode;
	}
	/**
	 * 获取：
	 */
	public Object getDimensionCode() {
		return dimensionCode;
	}
	/**
	 * 设置：充电桩状态，启用（正常运营） or 禁用 or 审核 
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：充电桩状态，启用（正常运营） or 禁用 or 审核 
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
	 * 设置：生产日期
	 */
	public void setProductDt(Date productDt) {
		this.productDt = productDt;
	}
	/**
	 * 获取：生产日期
	 */
	public Date getProductDt() {
		return productDt;
	}
	/**
	 * 设置：生产厂家
	 */
	public void setProductCreator(String productCreator) {
		this.productCreator = productCreator;
	}
	/**
	 * 获取：生产厂家
	 */
	public String getProductCreator() {
		return productCreator;
	}
	/**
	 * 设置：充电桩网点名称
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	/**
	 * 获取：充电桩网点名称
	 */
	public String getShopName() {
		return shopName;
	}
	/**
	 * 设置：充电桩联网方式，wifi GPRS 4G BLE
	 */
	public void setConnectType(String connectType) {
		this.connectType = connectType;
	}
	/**
	 * 获取：充电桩联网方式，wifi GPRS 4G BLE
	 */
	public String getConnectType() {
		return connectType;
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
	 * 设置：开始营业时间
	 */
	public void setShopStartDt(Double shopStartDt) {
		this.shopStartDt = shopStartDt;
	}
	/**
	 * 获取：开始营业时间
	 */
	public Double getShopStartDt() {
		return shopStartDt;
	}
	/**
	 * 设置：结束营业时间
	 */
	public void setShopEndDt(Double shopEndDt) {
		this.shopEndDt = shopEndDt;
	}
	/**
	 * 获取：结束营业时间
	 */
	public Double getShopEndDt() {
		return shopEndDt;
	}
	/**
	 * 设置：
	 */
	public void setActiveBankNo(Integer activeBankNo) {
		this.activeBankNo = activeBankNo;
	}
	/**
	 * 获取：
	 */
	public Integer getActiveBankNo() {
		return activeBankNo;
	}
	/**
	 * 设置：网点联系电话
	 */
	public void setShopPhone(String shopPhone) {
		this.shopPhone = shopPhone;
	}
	/**
	 * 获取：网点联系电话
	 */
	public String getShopPhone() {
		return shopPhone;
	}
	/**
	 * 设置：充电桩在网点的摆放位置，如收银台
	 */
	public void setShopStationPoint(String shopStationPoint) {
		this.shopStationPoint = shopStationPoint;
	}
	/**
	 * 获取：充电桩在网点的摆放位置，如收银台
	 */
	public String getShopStationPoint() {
		return shopStationPoint;
	}
	/**
	 * 设置：收费模式
	 */
	public void setFeescale(String feescale) {
		this.feescale = feescale;
	}
	/**
	 * 获取：收费模式
	 */
	public String getFeescale() {
		return feescale;
	}
	/**
	 * 设置：最后编辑人员
	 */
	public void setLasteditor(String lasteditor) {
		this.lasteditor = lasteditor;
	}
	/**
	 * 获取：最后编辑人员
	 */
	public String getLasteditor() {
		return lasteditor;
	}
}

package com.power.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-24 17:27:49
 */
public class UserPartnerEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//加盟类型 shop_partner 合作商家 user_partner 合伙人
	private String type;
	//联系人名称
	private String name;
	//联系人手机号
	private String phone;
	//店铺名称
	private String shopName;
	//商铺地址
	private String shopAdress;
	//所在城市
	private String city;
	//团队情况
	private String teamInfo;
	//
	private Date createDt;
	//
	private Date updateDt;

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
	 * 设置：加盟类型 shop_partner 合作商家 user_partner 合伙人
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：加盟类型 shop_partner 合作商家 user_partner 合伙人
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：联系人名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：联系人名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：联系人手机号
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：联系人手机号
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：店铺名称
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	/**
	 * 获取：店铺名称
	 */
	public String getShopName() {
		return shopName;
	}
	/**
	 * 设置：商铺地址
	 */
	public void setShopAdress(String shopAdress) {
		this.shopAdress = shopAdress;
	}
	/**
	 * 获取：商铺地址
	 */
	public String getShopAdress() {
		return shopAdress;
	}
	/**
	 * 设置：所在城市
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：所在城市
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：团队情况
	 */
	public void setTeamInfo(String teamInfo) {
		this.teamInfo = teamInfo;
	}
	/**
	 * 获取：团队情况
	 */
	public String getTeamInfo() {
		return teamInfo;
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
}

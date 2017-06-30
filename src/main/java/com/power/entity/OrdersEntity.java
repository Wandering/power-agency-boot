package com.power.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-28 17:02:05
 */
public class OrdersEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//######订单编号表######
	private Long id;
	//费用
	private Double totalFee;
	//用户ID，订单所属账户ID
	private Long orderOwner;
	//服务商ID
	private Long agency;
	//类型：充值BALANCE：消费CONSUME：充押金DEPOSIT：退押金REFUND
	private String type;
	//REFUND：PRE_PAY：ACTIVE：PAYED：PENDING
	private String status;
	//
	private Date createDt;
	//
	private Date updateDt;
	//
	private Long createBy;
	//
	private Long updateBy;
	//订单编号
	private String orderNo;
	//父订单编号，退押金时使用
	private Long parentOrder;
	//交易类型，微信JSAPI，安卓苹果应用APP
	private String tradeType;
	//
	private String tradeIdentify;
	//
	private Long editor;
	//
	private String des;
	//
	private String editorName;
	//该订单所消费的会员模式
	private Long userRoles;

	/**
	 * 设置：######订单编号表######
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：######订单编号表######
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：费用
	 */
	public void setTotalFee(Double totalFee) {
		this.totalFee = totalFee;
	}
	/**
	 * 获取：费用
	 */
	public Double getTotalFee() {
		return totalFee;
	}
	/**
	 * 设置：用户ID，订单所属账户ID
	 */
	public void setOrderOwner(Long orderOwner) {
		this.orderOwner = orderOwner;
	}
	/**
	 * 获取：用户ID，订单所属账户ID
	 */
	public Long getOrderOwner() {
		return orderOwner;
	}
	/**
	 * 设置：服务商ID
	 */
	public void setAgency(Long agency) {
		this.agency = agency;
	}
	/**
	 * 获取：服务商ID
	 */
	public Long getAgency() {
		return agency;
	}
	/**
	 * 设置：类型：充值BALANCE：消费CONSUME：充押金DEPOSIT：退押金REFUND
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型：充值BALANCE：消费CONSUME：充押金DEPOSIT：退押金REFUND
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：REFUND：PRE_PAY：ACTIVE：PAYED：PENDING
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：REFUND：PRE_PAY：ACTIVE：PAYED：PENDING
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
	 * 设置：订单编号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * 获取：订单编号
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * 设置：父订单编号，退押金时使用
	 */
	public void setParentOrder(Long parentOrder) {
		this.parentOrder = parentOrder;
	}
	/**
	 * 获取：父订单编号，退押金时使用
	 */
	public Long getParentOrder() {
		return parentOrder;
	}
	/**
	 * 设置：交易类型，微信JSAPI，安卓苹果应用APP
	 */
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
	/**
	 * 获取：交易类型，微信JSAPI，安卓苹果应用APP
	 */
	public String getTradeType() {
		return tradeType;
	}
	/**
	 * 设置：
	 */
	public void setTradeIdentify(String tradeIdentify) {
		this.tradeIdentify = tradeIdentify;
	}
	/**
	 * 获取：
	 */
	public String getTradeIdentify() {
		return tradeIdentify;
	}
	/**
	 * 设置：
	 */
	public void setEditor(Long editor) {
		this.editor = editor;
	}
	/**
	 * 获取：
	 */
	public Long getEditor() {
		return editor;
	}
	/**
	 * 设置：
	 */
	public void setDes(String des) {
		this.des = des;
	}
	/**
	 * 获取：
	 */
	public String getDes() {
		return des;
	}
	/**
	 * 设置：
	 */
	public void setEditorName(String editorName) {
		this.editorName = editorName;
	}
	/**
	 * 获取：
	 */
	public String getEditorName() {
		return editorName;
	}
	/**
	 * 设置：该订单所消费的会员模式
	 */
	public void setUserRoles(Long userRoles) {
		this.userRoles = userRoles;
	}
	/**
	 * 获取：该订单所消费的会员模式
	 */
	public Long getUserRoles() {
		return userRoles;
	}
}

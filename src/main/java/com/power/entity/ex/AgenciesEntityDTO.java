package com.power.entity.ex;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



/**
 * 代理商
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-09-05 16:39:29
 */
public class AgenciesEntityDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//######服务商表######
	private Long id;
	//服务商名称
	private String name;
	//英文缩写
	private String abbrCode;
	//地域
	private Long region;
	//地址
	private String address;
	//状态
	private String status;
	//类型：平台还是服务商-del
	private String type;
	//父级ID
	private Long parent;
	//创建时间
	private Date createDt;
	//修改时间
	private Date updateDt;
	//创建人
	private Long createBy;
	//修改人
	private Long updateBy;
	//代理商类型
	private Integer agencytype;
	//营业执照注册号
	private String businessNo;
	//营业执照副本
	private String businessImg;
	//开户银行
	private String openBank;
	//开户名称
	private String bankname;
	//银行卡号
	private String bankCardno;
	//法人姓名
	private String legaluserName;
	//法人身份证号
	private String legaluserNo;
	//法人身份证扫描件
	private String legaluserImg;
	//推广二维码
	private String qrcode;
	//代理商权限池
	private String agencyPool;
	//代理商角色
	private String agencyrole;
	//合同开始时间
	private Date contractStartdt;
	//合同结束时间
	private Date contractEnddt;
	//通过审核时间
	private Date examineDt;
	//登录用户名
	private String username;
	//邮箱
	private String email;
	//最后登录IP
	private List<?> sysLogList;

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
	 * 设置：英文缩写
	 */
	public void setAbbrCode(String abbrCode) {
		this.abbrCode = abbrCode;
	}
	/**
	 * 获取：英文缩写
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
	 * 设置：类型：平台还是服务商-del
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型：平台还是服务商-del
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：父级ID
	 */
	public void setParent(Long parent) {
		this.parent = parent;
	}
	/**
	 * 获取：父级ID
	 */
	public Long getParent() {
		return parent;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateDt() {
		return createDt;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateDt() {
		return updateDt;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}
	/**
	 * 获取：创建人
	 */
	public Long getCreateBy() {
		return createBy;
	}
	/**
	 * 设置：修改人
	 */
	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}
	/**
	 * 获取：修改人
	 */
	public Long getUpdateBy() {
		return updateBy;
	}
	/**
	 * 设置：代理商类型
	 */
	public void setAgencytype(Integer agencytype) {
		this.agencytype = agencytype;
	}
	/**
	 * 获取：代理商类型
	 */
	public Integer getAgencytype() {
		return agencytype;
	}
	/**
	 * 设置：营业执照注册号
	 */
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}
	/**
	 * 获取：营业执照注册号
	 */
	public String getBusinessNo() {
		return businessNo;
	}
	/**
	 * 设置：营业执照副本
	 */
	public void setBusinessImg(String businessImg) {
		this.businessImg = businessImg;
	}
	/**
	 * 获取：营业执照副本
	 */
	public String getBusinessImg() {
		return businessImg;
	}
	/**
	 * 设置：开户银行
	 */
	public void setOpenBank(String openBank) {
		this.openBank = openBank;
	}
	/**
	 * 获取：开户银行
	 */
	public String getOpenBank() {
		return openBank;
	}
	/**
	 * 设置：开户名称
	 */
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	/**
	 * 获取：开户名称
	 */
	public String getBankname() {
		return bankname;
	}
	/**
	 * 设置：银行卡号
	 */
	public void setBankCardno(String bankCardno) {
		this.bankCardno = bankCardno;
	}
	/**
	 * 获取：银行卡号
	 */
	public String getBankCardno() {
		return bankCardno;
	}
	/**
	 * 设置：法人姓名
	 */
	public void setLegaluserName(String legaluserName) {
		this.legaluserName = legaluserName;
	}
	/**
	 * 获取：法人姓名
	 */
	public String getLegaluserName() {
		return legaluserName;
	}
	/**
	 * 设置：法人身份证号
	 */
	public void setLegaluserNo(String legaluserNo) {
		this.legaluserNo = legaluserNo;
	}
	/**
	 * 获取：法人身份证号
	 */
	public String getLegaluserNo() {
		return legaluserNo;
	}
	/**
	 * 设置：法人身份证扫描件
	 */
	public void setLegaluserImg(String legaluserImg) {
		this.legaluserImg = legaluserImg;
	}
	/**
	 * 获取：法人身份证扫描件
	 */
	public String getLegaluserImg() {
		return legaluserImg;
	}
	/**
	 * 设置：推广二维码
	 */
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	/**
	 * 获取：推广二维码
	 */
	public String getQrcode() {
		return qrcode;
	}
	/**
	 * 设置：代理商权限池（1代表最大权限，空代表无权限，1，2，3代表拥有部分权限）
	 */
	public void setAgencyPool(String agencyPool) {
		this.agencyPool = agencyPool;
	}
	/**
	 * 获取：代理商权限池（1代表最大权限，空代表无权限，1，2，3代表拥有部分权限）
	 */
	public String getAgencyPool() {
		return agencyPool;
	}
	/**
	 * 设置：代理商角色
	 */
	public void setAgencyrole(String agencyrole) {
		this.agencyrole = agencyrole;
	}
	/**
	 * 获取：代理商角色
	 */
	public String getAgencyrole() {
		return agencyrole;
	}
	/**
	 * 设置：合同开始时间
	 */
	public void setContractStartdt(Date contractStartdt) {
		this.contractStartdt = contractStartdt;
	}
	/**
	 * 获取：合同开始时间
	 */
	public Date getContractStartdt() {
		return contractStartdt;
	}
	/**
	 * 设置：合同结束时间
	 */
	public void setContractEnddt(Date contractEnddt) {
		this.contractEnddt = contractEnddt;
	}
	/**
	 * 获取：合同结束时间
	 */
	public Date getContractEnddt() {
		return contractEnddt;
	}
	/**
	 * 设置：通过审核时间
	 */
	public void setExamineDt(Date examineDt) {
		this.examineDt = examineDt;
	}
	/**
	 * 获取：通过审核时间
	 */
	public Date getExamineDt() {
		return examineDt;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<?> getSysLogList() {
		return sysLogList;
	}
	public void setSysLogList(List<?> sysLogList) {
		this.sysLogList = sysLogList;
	}
}

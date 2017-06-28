package com.power.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 动态可配置参数表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-27 11:34:59
 */
public class PowerDynamicParamsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//参数类型，具体分类
	private String category;
	//参数名称，当前类型下唯一标识
	private String name;
	//该参数允许被编码
	private Integer code;
	//字符类型 (int,long,String,boolean,float,double,byte,short)
	private String type;
	//具体数值
	private String value;

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
	 * 设置：参数类型，具体分类
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * 获取：参数类型，具体分类
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * 设置：参数名称，当前类型下唯一标识
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：参数名称，当前类型下唯一标识
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：该参数允许被编码
	 */
	public void setCode(Integer code) {
		this.code = code;
	}
	/**
	 * 获取：该参数允许被编码
	 */
	public Integer getCode() {
		return code;
	}
	/**
	 * 设置：字符类型 (int,long,String,boolean,float,double,byte,short)
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：字符类型 (int,long,String,boolean,float,double,byte,short)
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：具体数值
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * 获取：具体数值
	 */
	public String getValue() {
		return value;
	}
}

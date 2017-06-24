package com.power.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 字典管理
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-06-24 11:49:16
 */
public class DictCommonEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//代码
	private String code;
	//名称
	private String name;
	//字典类型
	private String type;
	//字典描述
	private String note;

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
	 * 设置：代码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：代码
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：字典类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：字典类型
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：字典描述
	 */
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * 获取：字典描述
	 */
	public String getNote() {
		return note;
	}
}

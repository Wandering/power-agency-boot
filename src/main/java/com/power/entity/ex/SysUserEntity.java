package com.power.entity.ex;


public class SysUserEntity extends io.renren.entity.SysUserEntity{
		private static final long serialVersionUID = 1L;
		
		//服务商名称
		private String name;
		//地域
		private Long region;
		//地址
		private String address;
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
	}

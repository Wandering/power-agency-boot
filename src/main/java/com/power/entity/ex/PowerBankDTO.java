package com.power.entity.ex;

import com.power.entity.PowerBankEntity;

public class PowerBankDTO extends  PowerBankEntity{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 充电宝电量
	 */
	private double capacity;

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

}

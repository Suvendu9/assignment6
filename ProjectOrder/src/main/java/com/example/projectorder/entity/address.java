package com.example.projectorder.entity;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class address {
	
	@NotNull
	@Size(max=30)
	private String addressline1;
	@NotNull
	@Size(max=30)
	private String addressline2;
	@NotNull
	@Size(max=6)
	private int pincode;
	@NotNull
	private String state;
	
	public String getAddressline1() {
		return addressline1;
	}
	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}
	public String getAddressline2() {
		return addressline2;
	}
	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	
}

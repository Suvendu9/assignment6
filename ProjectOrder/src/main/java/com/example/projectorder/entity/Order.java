package com.example.projectorder.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class Order {
	
	@Id
	private String orderid;
	@Min(value = 1, message="Must be greater than 1")
	private float totalAmount;
	
	@DateTimeFormat
	private Date orderDate;
	
	@NotNull
	private orderStatus orderstatus;
	
	
	private List<orderLine> allOrderLines;
	
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public orderStatus getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(orderStatus orderstatus) {
		this.orderstatus = orderstatus;
	}
	public List<orderLine> getAllOrderLines() {
		return allOrderLines;
	}
	public void setAllOrderLines(List<orderLine> allOrderLines) {
		this.allOrderLines = allOrderLines;
	}

	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
}

package com.example.projectorder.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class orderLine {

	@Id
	@NotNull
	private String orderlineid;
	@NotNull
	private String item;
	@Min(value = 1, message = "must be greater than 1")
	private float price;
	@Min(value = 0, message = "must not be less than 0")
	private int quantity;
	@DateTimeFormat
	private Date date;
	@NotBlank(message="Address is mandatory")
	private address deliveryaddress;
	private orderLineStatus status;
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public address getDeliveryaddress() {
		return deliveryaddress;
	}
	public void setDeliveryaddress(address deliveryaddress) {
		this.deliveryaddress = deliveryaddress;
	}
	public orderLineStatus getStatus() {
		return status;
	}
	public void setStatus(orderLineStatus status) {
		this.status = status;
	}
	public String getOrderlineid() {
		return orderlineid;
	}
	public void setOrderlineid(String orderlineid) {
		this.orderlineid = orderlineid;
	}
	
}

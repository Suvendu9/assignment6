package com.order.app.demo.entity;

import java.util.Date;
import java.util.List;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.order.app.demo.utils.OrderLineStatus;

public class OrderLine {
	private List<Item> listOfItems;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
	private Date eta;
	
	private OrderLineStatus orderLineStatus;
	private String addressPincode;
	

	public String getAddressPincode() {
		return addressPincode;
	}

	public OrderLine(List<Item> listOfItems, Date eta, OrderLineStatus orderLineStatus, String addressPincode) {
		super();
		this.listOfItems = listOfItems;
		this.eta = eta;
		this.orderLineStatus = orderLineStatus;
		this.addressPincode = addressPincode;
	}

	public void setAddressPincode(String addressPincode) {
		this.addressPincode = addressPincode;
	}

	public List<Item> getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(List<Item> listOfItems) {
		this.listOfItems = listOfItems;
	}

	public Date getEta() {
		return eta;
	}

	public void setEta(Date eta) {
		this.eta = eta;
	}

	public OrderLineStatus getOrderLineStatus() {
		return orderLineStatus;
	}

	public void setOrderLineStatus(OrderLineStatus orderLineStatus) {
		this.orderLineStatus = orderLineStatus;
	}
}

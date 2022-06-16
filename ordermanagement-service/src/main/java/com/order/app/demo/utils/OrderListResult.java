package com.order.app.demo.utils;

import java.util.List;

import com.order.app.demo.entity.Order;

public class OrderListResult extends Result {
	private List<Order> listOfOrders;

	public List<Order> getListOfOrders() {
		return listOfOrders;
	}

	public void setListOfOrders(List<Order> listOfOrders) {
		this.listOfOrders = listOfOrders;
	}
}

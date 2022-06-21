package com.order.app.demo.utils;

import com.order.app.demo.entity.Order;

public class OrderResult extends Result {
	private Order order;

	
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}

}

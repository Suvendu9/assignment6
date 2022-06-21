package com.order.app.demo.entity;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.order.app.demo.utils.OrderStatus;

@Document(collection = "orderDB")

public class Order {
	@Id
	private String orderId;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
	private Date orderDate;
	
	@Min(value = 0, message = "price should not be negative")
	private float totalAmount;
	private OrderStatus orderStatus;
	private List<OrderLine> listOfOrderLines;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public List<OrderLine> getListOfOrderLines() {
		return listOfOrderLines;
	}

	public void setListOfOrderLines(List<OrderLine> listOfOrderLines) {
		this.listOfOrderLines = listOfOrderLines;
	}

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

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Order(String orderId, Date orderDate,
			@Min(value = 0, message = "price should not be negative") float totalAmount, OrderStatus orderStatus,
			List<OrderLine> listOfOrderLines) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.orderStatus = orderStatus;
		this.listOfOrderLines = listOfOrderLines;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", totalAmount=" + totalAmount
				+ ", orderStatus=" + orderStatus + ", listOfOrderLines=" + listOfOrderLines + "]";
	}
	
	
}

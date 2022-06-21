package com.order.app.demo.utils;

import java.util.Optional;

import com.order.app.demo.entity.Order;

public class Result {
	private int errorCode;
	private String errorMessage;
	private Order order;

	public Result(int errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public Result(int errorCode, String errorMessage, Order order) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.order = order;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Result() {
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "Result [errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", order=" + order + "]";
	}



	
	
}

package com.order.app.demo.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Item {
	@NotBlank
	private String itemName;
	public Item(@NotBlank String itemName, String qty,
			@Min(value = 1, message = "price must be greater than 1") float price) {
		super();
		this.itemName = itemName;
		this.qty = qty;
		this.price = price;
	}

	private String qty;
	@Min(value = 1, message = "price must be greater than 1")
	private float price;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getqty() {
		return qty;
	}

	public void setqty(String qty) {
		this.qty = qty;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}

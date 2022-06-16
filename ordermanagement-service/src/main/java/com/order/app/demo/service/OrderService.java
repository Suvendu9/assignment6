package com.order.app.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.app.demo.entity.Order;
import com.order.app.demo.repository.OrderRepository;
import com.order.app.demo.utils.ErrorMessages;
import com.order.app.demo.utils.OrderListResult;
import com.order.app.demo.utils.OrderResult;
import com.order.app.demo.utils.Result;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepo;

	public Result saveOrder(Order order) {
		orderRepo.save(order);
		return new Result(200, ErrorMessages.SAVED,order);
	}

	public OrderListResult getOrdersByPincode(int pincode) {
		List<Order> listOfOrders = orderRepo.findByPincode(pincode);
		OrderListResult result = new OrderListResult();
		if (!listOfOrders.isEmpty()) {
			result.setErrorCode(200);
			result.setErrorMessage(ErrorMessages.RETRIEVED);
			result.setListOfOrders(listOfOrders);
		} else {
			result.setErrorCode(404);
			result.setErrorMessage(ErrorMessages.NO_RECORD_FOUND);
			result.setListOfOrders(null);
		}
		return result;
	}

	public OrderResult getOrderById(String id) {
		OrderResult orderResult = new OrderResult();
		Optional<Order> result = orderRepo.findById(id);
		if (result.get() != null) {
			orderResult.setErrorCode(200);
			orderResult.setErrorMessage(ErrorMessages.RETRIEVED);
			orderResult.setOrder(result.get());
		} else {
			orderResult.setErrorCode(404);
			orderResult.setErrorMessage(ErrorMessages.NO_RECORD_FOUND);
			orderResult.setOrder(null);
		}
		return orderResult;
	}

}

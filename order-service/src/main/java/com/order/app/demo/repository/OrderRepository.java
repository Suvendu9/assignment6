package com.order.app.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.order.app.demo.entity.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
	@Query("{'listOfOrderLines.addressPincode':?0}")
	List<Order> findByPincode(int pincode);

}

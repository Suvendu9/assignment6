package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.order.app.demo.controller.OrderController;
import com.order.app.demo.entity.Item;
import com.order.app.demo.entity.Order;
import com.order.app.demo.entity.OrderLine;
import com.order.app.demo.repository.OrderRepository;
import com.order.app.demo.service.OrderService;
import com.order.app.demo.utils.ErrorMessages;
import com.order.app.demo.utils.OrderLineStatus;
import com.order.app.demo.utils.OrderListResult;
import com.order.app.demo.utils.OrderResult;
import com.order.app.demo.utils.OrderStatus;
import com.order.app.demo.utils.Result;

@AutoConfigureMockMvc
@SpringBootTest
class OrderServiceApplicationTests {


	
	
}

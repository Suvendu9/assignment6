package com.example.demo;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.order.app.demo.OrderServiceApplication;
import com.order.app.demo.controller.OrderController;
import com.order.app.demo.entity.Item;
import com.order.app.demo.entity.Order;
import com.order.app.demo.entity.OrderLine;
import com.order.app.demo.repository.OrderRepository;
import com.order.app.demo.service.OrderService;
import com.order.app.demo.utils.OrderLineStatus;
import com.order.app.demo.utils.OrderStatus;
import com.order.app.demo.utils.Result;


@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes =  OrderServiceApplication.class)
public class TestOrderService {
	@Mock
	private OrderRepository orderRepository;
	
	
	@InjectMocks
	private OrderService orderService;
	
	@Mock
	private Result result;
	
	@Mock
	private Order order;
	@Mock
	private OrderLine orderline;
	@Mock
	private Item item;
	@Mock
	private List<OrderLine> listOfOrderLines;
	@Mock
	private List<Item> listOfItems;
	
	
	public void CreateBeans() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd",Locale.ENGLISH);
		Date date1= sdf.parse("2021/08/04");
		
		item = new Item("Toshiba","2",150000.0f);
		
		listOfItems.add(item);
		orderline = new OrderLine(listOfItems,date1,OrderLineStatus.OPEN,"123456");
		listOfOrderLines.add(orderline);
		order = new Order("62a893c5ab3fcc309483e557",date1,678900.0f,OrderStatus.OPEN,listOfOrderLines);
		
		result = new Result();
		result.setErrorCode(200);
		result.setErrorMessage("Item successfully saved");
		result.setOrder(order);
		
	}
		
	public void teardown() {
		
		order=null;
		result=null;
		orderline=null;
		item=null;
	}		
	
	@Test
	public void AddingOrders() throws Exception
	{
		
		this.CreateBeans();
		Mockito.when(orderService.saveOrder(order)).thenReturn(result);
		
		
		Result resultofservice = orderService.saveOrder(order);
		Mockito.verify(orderService).saveOrder(order);
		assertEquals(resultofservice,result);
		assertNotNull(resultofservice);
		this.teardown();
	}
	
}

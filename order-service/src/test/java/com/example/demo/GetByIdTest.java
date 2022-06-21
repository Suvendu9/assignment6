package com.example.demo;

import static org.junit.Assert.*;

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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import com.order.app.demo.controller.OrderController;
import com.order.app.demo.entity.Item;
import com.order.app.demo.entity.Order;
import com.order.app.demo.entity.OrderLine;
import com.order.app.demo.service.OrderService;
import com.order.app.demo.utils.OrderLineStatus;
import com.order.app.demo.utils.OrderResult;
import com.order.app.demo.utils.OrderStatus;


@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class GetByIdTest {

	
	@Mock
	private OrderService orderService;
	
	
	@InjectMocks
	private OrderController orderController;
	
	

	@Mock
	private OrderResult orderresult;
	
	
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

	public void createBeans() throws Exception {
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd",Locale.ENGLISH);
		Date date1= sdf.parse("2021/08/04");
	
		item = new Item("Toshiba","2",150000.0f);
		
		listOfItems.add(item);
		orderline = new OrderLine(listOfItems,date1,OrderLineStatus.OPEN,"123456");
		listOfOrderLines.add(orderline);

		order = new Order("6112a893c5ab3fcc309483e557",date1,678900.0f,OrderStatus.OPEN,listOfOrderLines);
	
		
		orderresult = new OrderResult();
		orderresult.setErrorCode(200);
		orderresult.setErrorMessage("Item successfully saved");
		orderresult.setOrder(order);
	
	}
	
	
	public void tearDown()
	{
		item=null;
		orderline=null;
		order= null;
		orderresult=null;
	}
	
	
	@Test
	public void GettingOrderById() throws Exception
	{
		
		
		this.createBeans();
		
		Mockito.when(orderService.getOrderById("6112a893c5ab3fcc309483e557")).thenReturn(orderresult);
		OrderResult orderResultById = orderController.getOrderById("6112a893c5ab3fcc309483e557");
		Mockito.verify(orderService).getOrderById("6112a893c5ab3fcc309483e557");
		assertEquals(orderResultById, orderresult);
		assertNotNull(orderresult);
		this.tearDown();
	}
	
	

}
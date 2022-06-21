package com.example.demo;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.app.demo.OrderServiceApplication;
import com.order.app.demo.controller.OrderController;
import com.order.app.demo.entity.Item;
import com.order.app.demo.entity.Order;
import com.order.app.demo.entity.OrderLine;
import com.order.app.demo.service.OrderService;
import com.order.app.demo.utils.OrderLineStatus;
import com.order.app.demo.utils.OrderStatus;
import com.order.app.demo.utils.Result;


@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class SaveOrderTest {


	@Mock
	private OrderService orderService;
	
	
	@InjectMocks
	private OrderController orderController;
	
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
		Mockito.when(orderService.saveOrder(any())).thenReturn(result);
		
		Result resultOfController = orderController.createOrder(order);
		
		Mockito.verify(orderService).saveOrder(order);
		assertEquals(resultOfController,result);
		assertNotNull(resultOfController);
		this.teardown();
	}
	
	

}

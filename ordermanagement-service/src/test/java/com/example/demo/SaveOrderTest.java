package com.example.demo;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.app.demo.controller.OrderController;
import com.order.app.demo.entity.Item;
import com.order.app.demo.entity.Order;
import com.order.app.demo.entity.OrderLine;
import com.order.app.demo.repository.OrderRepository;
import com.order.app.demo.service.OrderService;
import com.order.app.demo.utils.OrderLineStatus;
import com.order.app.demo.utils.OrderStatus;
import com.order.app.demo.utils.Result;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class SaveOrderTest {

	@Mock
	private OrderService orderService;
	
	
	@InjectMocks
	private OrderController orderController;
	@Autowired
	private MockMvc mockMvc;
	
	
	private Result result;
	
	private Optional<Order> orderoptional;
	
	private Order order;
	private OrderLine orderline;
	
	private Item item;
	
	private List<OrderLine> listOfOrderLines;
	
	private List<Item> listOfItems;
	
	
	@BeforeEach
	public void  setup() throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd",Locale.ENGLISH);
		Date date1= sdf.parse("2021/08/04");
		
		item = new Item("Toshiba","2",150000.0f);
	
		orderline = new OrderLine(listOfItems,date1,OrderLineStatus.OPEN,"123456");
		listOfOrderLines.add(orderline);
	
		order = new Order("62a893c5ab3fcc309483e557",date1,678900.0f,OrderStatus.OPEN,listOfOrderLines);
		
		//orderoptional= Optional.of(order);
		result = new Result();
		result.setErrorCode(200);
		result.setErrorMessage("Item successfully saved");
		result.setOrder(order);
		
		
		
		
		mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
		
				
	}
	
	@AfterEach
	public void tearDown()
	{
		order=null;
	}
	
	
	@Test
	public void AddingOrders() throws Exception
	{
		when(orderService.saveOrder(any())).thenReturn(result);
		mockMvc.perform(MockMvcRequestBuilders.post("/order/addOrder")
				.contentType(MediaType.APPLICATION_JSON).
				content(asJsonString(order))).
		        andExpect(status().isCreated())
		        .andDo(MockMvcResultHandlers.print());
		verify(orderService,times(1)).saveOrder(any());
		
	}
	
	public static String asJsonString(final Object obj)
	{
		try {
			return new ObjectMapper().writeValueAsString(obj);
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}
}

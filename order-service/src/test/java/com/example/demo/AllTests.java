package com.example.demo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.boot.test.context.SpringBootTest;

import com.order.app.demo.OrderServiceApplication;

@RunWith(Suite.class)
@SuiteClasses({ GetByIdTest.class, SaveOrderTest.class })
@SpringBootTest(classes =  OrderServiceApplication.class)
public class AllTests {

}

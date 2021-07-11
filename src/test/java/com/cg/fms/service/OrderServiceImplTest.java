//package com.cg.fms.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import com.cg.fms.entities.Order;
//import com.cg.fms.repository.OrderRepository;
//import com.cg.fms.services.IOrderService;
//
//@SpringBootTest
//class OrderServiceImplTest {
//	
//	@Autowired
//	private IOrderService orderService;
//
//	@MockBean
//	private OrderRepository orderRepository;
//
//	@BeforeEach
//	void setUp() throws Exception {
//		Order order = new Order();
//		order.setId(1);
//	    order.setDeliveryplace("hyderabad");
//		order.setQuantity("2");
//		order.setDeliverydate("20-06-2021");
//		
//	}
//
//	
//
//	@Test
//	@DisplayName("Verify add order functionality")
//	void addOrderTest() {
//		Order order = new Order();
//		when(orderRepository.save(order)).thenReturn(order);
//		assertEquals(order, orderService.addOrder(order));
//	}
//
//	@Test
//	@DisplayName("fetch all orders functionality")
//	void fetchAllTest() {
//		when(orderRepository.findAll()).thenReturn(Stream
//				.of(new Order(),
//						new Order()).collect(Collectors.toList()));
//		assertEquals(2, orderService.fetchAll().size());
//	}
//
//}
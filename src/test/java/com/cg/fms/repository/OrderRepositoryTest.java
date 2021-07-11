//package com.cg.fms.repository;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//
//import com.cg.fms.entities.Order;
//
//@DataJpaTest
//class OrderRepositoryTest {
//
//	@Autowired
//	private OrderRepository repo;
//
//	@Autowired
//	private TestEntityManager entityManager;
//
////	@BeforeEach
//////	void setUp() throws Exception {
//////		// it follows builder design pattern - used @Builder - lombok annotation in
//////		// Customer class
//////		Order order = Order.builder().id(1).deliveryplace("Hyderabad").deliverydate("20-06-2021").quantity("1").build();
//////		//entityManager.persist(customer);
////
////		List<Customer> customers = Arrays.asList(
////				Customer.builder().firstName("raza").lastName("khan").email("raza@cg.com").address("hyd").build(),
////				Customer.builder().firstName("neha").lastName("khan").email("neha@cg.com").address("hyd").build());
////		repo.saveAll(customers);
////	}
//
//	@Test
//	@DisplayName("Get Order when id matches")
//	@Disabled
//	void testFindById() {
//	Order order = repo.findById(1).get();
//		assertEquals(1, order.getId());
//	}
//
//	@Test
//	@DisplayName("Get All orders")
//	void testFindAll() {
//		List<Order> orders = repo.findAll();
//		assertEquals(2, orders.size());
//	}
//
//}
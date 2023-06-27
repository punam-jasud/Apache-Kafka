package com.punam.order.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.punam.domains.model.Order;
import com.punam.domains.model.OrderEvent;
import com.punam.order.kafka.OrderProducer;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderProducer orderProducer;
	
	@PostMapping("/placeOrder")
	public String placeOrder(@RequestBody Order order) {
		
		order.setOrderId(UUID.randomUUID().toString());
		
		OrderEvent orderEvent = new OrderEvent();
		orderEvent.setStatus("PENDING");
		orderEvent.setMessage("Order status is in pending");
		orderEvent.setOrder(order);
		
		orderProducer.sendMessage(orderEvent);
		
		return "Order Placed Successfully..!";
		
	}

}

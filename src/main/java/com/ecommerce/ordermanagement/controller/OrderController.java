package com.ecommerce.ordermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ordermanagement.model.Order;
import com.ecommerce.ordermanagement.service.IOrderService;

@RestController
@RequestMapping(path = "orders")
public class OrderController {
	
	@Autowired
	private IOrderService orderService;
	
	
	@PostMapping
	public Order addOrder(@RequestBody Order order) {
		Order savedOrder = orderService.addOrder(order);
		return savedOrder;
	}
	
	@GetMapping(path = "/{id}")
	public Order getOrder(@PathVariable Integer id) {
		return orderService.getOrder(id);
	}
	
	@DeleteMapping(path = "/{id}")
	public String deleteOrder(@PathVariable Integer id) {
		return orderService.deleteOrder(id);
	}
	
	@PutMapping
	public Order updateOrder(@RequestBody Order order) {
		Order updatedOrder = orderService.updateOrder(order);
		return updatedOrder;
	}

	public IOrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}
	

}

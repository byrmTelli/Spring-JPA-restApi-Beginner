package com.ecommerce.ordermanagement.service;

import com.ecommerce.ordermanagement.model.Order;

public interface IOrderService {
	
	public Order addOrder(Order order);

	Order getOrder(Integer id);

	Order updateOrder(Order order);

	String deleteOrder(Integer id);

}

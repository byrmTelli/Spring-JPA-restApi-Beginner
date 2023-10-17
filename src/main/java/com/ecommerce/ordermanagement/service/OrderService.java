package com.ecommerce.ordermanagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ordermanagement.model.Order;
import com.ecommerce.ordermanagement.repository.IOrderRepository;

@Service
public class OrderService implements IOrderService{
	
	@Autowired
	private IOrderRepository orderRepository;

	public IOrderRepository getOrderRepository() {
		return orderRepository;
	}

	public void setOrderRepository(IOrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public Order addOrder(Order order) {
		Order savedOrder = orderRepository.save(order);
		return savedOrder;
	}
	
	
	@Override
	public Order getOrder(Integer id) {
		
		Optional<Order> orderOptional = orderRepository.findById(id);
		return orderOptional.orElse(null);
	}
	
	@Override
	public Order updateOrder(Order order) {
		Order orderFromDb = orderRepository.findById(order.getId()).orElse(null);
		
		if (orderFromDb == null) {
			throw new RuntimeException("No such order exist");
		}
		orderFromDb.setCustomerName(order.getCustomerName());
		orderFromDb.setAmount(order.getAmount());
		
		return orderRepository.save(orderFromDb);
	}
	
	@Override
	public String deleteOrder(Integer id) {
		orderRepository.deleteById(id);
		return "Deleted";
	}
	
}

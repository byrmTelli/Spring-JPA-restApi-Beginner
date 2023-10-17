package com.ecommerce.ordermanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.ordermanagement.model.Order;

public interface IOrderRepository extends CrudRepository<Order, Integer> {

}

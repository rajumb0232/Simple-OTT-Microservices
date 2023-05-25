package com.ty.order_service.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.order_service.entity.Order;
import com.ty.order_service.repository.OrderRepository;

@Repository
public class OrderDao {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}
	
	public List<Order> getOrderByUUID(String uuid){
		Optional<List<Order>> optional = orderRepository.findByUuid(uuid);
		if(optional.isEmpty()) {
			return null;
		}else {
			return optional.get();
		}
	}

}

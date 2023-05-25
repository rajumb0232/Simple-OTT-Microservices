package com.ty.order_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.order_service.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	public Optional<List<Order>> findByUuid(String uuid);

}

package com.ty.order_service.controller;

import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ty.order_service.dao.OrderDao;
import com.ty.order_service.entity.Order;
import com.ty.order_service.proxies.OrderProxy;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderDao dao;
	@Autowired
	private OrderProxy orderProxy;
	
	@PostMapping("/save/uuid/{userUUID}/movieId/{movieId}")
	public ResponseEntity<Order> saveOrder(@PathVariable String userUUID, @PathVariable int movieId){
		
		RestTemplate restTemplate = new RestTemplate();
		Hashtable<String, Integer> uriVariables = new Hashtable<>();
		uriVariables.put("movieId",movieId);
		ResponseEntity<Order> orderEntity = restTemplate.getForEntity("http://localhost:8000/movie/movieId/{movieId}", Order.class, uriVariables);
		Order order = orderEntity.getBody();
		order.setUuid(userUUID);
		order = dao.saveOrder(order);
		return new ResponseEntity<Order> (order, HttpStatus.CREATED);
	}
	
	@GetMapping("/user-uuid/{uuid}")
	public ResponseEntity<List<Order>> getOrderByUUID(@PathVariable String uuid){
		List<Order> orders = dao.getOrderByUUID(uuid);
		return new ResponseEntity<List<Order>> (orders, HttpStatus.FOUND);
	}
	
	
	@PostMapping("/feign/save/uuid/{userUUID}/movieId/{movieId}")
	public ResponseEntity<Order> saveOrderUsingFeign(@PathVariable String userUUID, @PathVariable int movieId){
		Order order = orderProxy.getMovie(movieId);
		order.setUuid(userUUID);
		order  = dao.saveOrder(order);
		return new ResponseEntity<Order> (order, HttpStatus.CREATED);
	}

}

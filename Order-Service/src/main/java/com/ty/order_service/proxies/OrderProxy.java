package com.ty.order_service.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ty.order_service.entity.Order;

@FeignClient(name = "Movie-Service")
public interface OrderProxy {

	@GetMapping("/movie/movieId/{movieId}")
	public Order getMovie(@PathVariable int movieId);
}

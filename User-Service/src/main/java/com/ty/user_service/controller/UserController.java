package com.ty.user_service.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.user_service.dao.UserDao;
import com.ty.user_service.entity.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		user.setUuid(UUID.randomUUID().toString());
		return userDao.saveUser(user);
	}
	
	@GetMapping("/userId/{userId}")
	public User getUserById(@PathVariable int userId) {
		return userDao.getUserById(userId);
	}
}

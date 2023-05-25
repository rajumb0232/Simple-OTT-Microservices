package com.ty.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.user_service.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}

package com.agridence.microservice.Assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.agridence.microservice.Assignment.entity.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, Integer> {
	UserInfo findByUsername(String username);
}
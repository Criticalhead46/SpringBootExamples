package com.microservices.userservice.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.userservice.model.User;

public interface UserRepository  extends JpaRepository<User, Serializable> {

	public List<User> findByUsername(String username);
}

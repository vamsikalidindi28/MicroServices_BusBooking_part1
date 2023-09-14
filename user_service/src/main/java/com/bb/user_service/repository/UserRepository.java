package com.bb.user_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bb.user_service.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String name);
	
	List<User> findByRole(String role);
	
}

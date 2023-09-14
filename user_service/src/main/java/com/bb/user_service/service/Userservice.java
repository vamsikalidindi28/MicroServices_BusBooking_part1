package com.bb.user_service.service;

import java.util.List;

import com.bb.user_service.entity.User;

public interface Userservice {

	List<User> getAllUsers();
	
	boolean saveUsers(User user);
	
	User findByUsername(String username);
	
	List<User> findByRole(String role);
	
	boolean deleteUser(long id);
}

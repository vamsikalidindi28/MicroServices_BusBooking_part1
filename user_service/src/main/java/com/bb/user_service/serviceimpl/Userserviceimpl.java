package com.bb.user_service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bb.user_service.entity.User;
import com.bb.user_service.repository.UserRepository;
import com.bb.user_service.service.Userservice;

@Service
public class Userserviceimpl implements Userservice {

	@Autowired
	private UserRepository userRepossitory;

	@Override
	public List<User> getAllUsers() {

		return userRepossitory.findAll();
	}

	@Override
	public boolean saveUsers(User user) {
		return userRepossitory.save(user).getUser_id() > 0;
	}

	@Override
	public User findByUsername(String username) {
		return userRepossitory.findByUsername(username);
	}

	@Override
	public List<User> findByRole(String role) {
		return userRepossitory.findByRole(role);
	}

	@Override
	public boolean deleteUser(long id) {
		try {
			userRepossitory.deleteById(id);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

}

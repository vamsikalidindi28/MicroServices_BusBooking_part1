package com.bb.user_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bb.user_service.entity.User;
import com.bb.user_service.service.Userservice;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private Userservice userservice;

	@PostMapping("/saveuser")
	public ResponseEntity<Boolean> saveusers(@RequestBody User user) {
		boolean isusersaved = userservice.saveUsers(user);

		if (isusersaved) {
			return new ResponseEntity<Boolean>(isusersaved, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(isusersaved, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllusers() {
		List<User> user = userservice.getAllUsers();
		if (user.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
	}

	@GetMapping("/findByUsername")
	public ResponseEntity<User> findByUsername(@RequestParam String username) {

		User user = userservice.findByUsername(username);
		if (user.equals(null)) {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<User>(user, HttpStatus.FOUND);
		}
	}

	@GetMapping("/findByRole")
	public ResponseEntity<List<User>> findByRole(@RequestParam String role) {
		List<User> user = userservice.findByRole(role);
		if (user.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<User>>(user, HttpStatus.FOUND);
		}
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<Boolean> deleteuser(@PathVariable("id") long id) {
		return new ResponseEntity<Boolean>(userservice.deleteUser(id), HttpStatus.OK);

	}
}

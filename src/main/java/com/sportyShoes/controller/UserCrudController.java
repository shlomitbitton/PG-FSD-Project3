package com.sportyShoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sportyShoes.model.User;
import com.sportyShoes.service.UserCrudService;



//@Api(value="usercrud")
@RestController
public class UserCrudController {
	
	@Autowired
	private UserCrudService userCrudService;
	
	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) {
		return userCrudService.createUser(user);
	}

	@PutMapping("/user")
	public User updateUser(@RequestBody User user) {
		return userCrudService.updateUser(user);
	}

	@GetMapping("/user/{userId}")
	public User getUserById(@PathVariable int userId) {
		return userCrudService.getUserById(userId);
	}

	@DeleteMapping("/user/{userId}")
	public void deleteUserById(@PathVariable int userId) {
		userCrudService.deleteUserById(userId);
	}
	@GetMapping("/userList")
	public List<User> userList() {
		return userCrudService.userList();
	}
	
}

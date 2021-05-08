package com.sportyShoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session.Cookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
		List<User> userList=userCrudService.userList();
		if(!userList.isEmpty()) {
			for(User usern:userList) {
				if(!usern.getUserName().equals(user.getUserName())){
					return userCrudService.createUser(user);
				}
			}
		}else {
			return userCrudService.createUser(user);
		}
		return null;
	}
	

	@PutMapping("/user")
	public User updateUser( @RequestBody User user) {
		List<User> userList=userCrudService.userList();
		if(!userList.isEmpty()) {
			for(User usern:userList) {
				if(!usern.getUserName().equals(user.getUserName())){
					return userCrudService.updateUser(user);
				}
			}
		}
		else {
			return userCrudService.createUser(user);
		}
		//return a message
		return null;
	}

	@GetMapping("/user/{userId}")
	public User getUserById(@PathVariable (value="userId") int userId) {
		return userCrudService.getUserById(userId);
	}
	

	
	public User getUserByUserName(String userName) {
		User user=null;
		for(User i :userCrudService.userList()){
			if(i.getUserName().equals(userName)){
				user=i;
			}
		}
			return user;
	}

	@DeleteMapping("/user/{userId}")
	public void deleteUserById(@PathVariable int userId) {
		userCrudService.deleteUserById(userId);
	}
	
	//password change for an admin
	@PutMapping("/passwordChange")
	public void updateUserPassword(@RequestBody User user) {
		//Later: check in session who is the user
		if(getUserByUserName(user.getUserName())!=null){
			User currentUser =getUserByUserName(user.getUserName());
			if(currentUser.getIsAdmin()) {
				userCrudService.updateUser(currentUser);
			}
		}
	}
	
//	@GetMapping(value = "/login/{userName}/{password}")
//	public boolean isExistingUser(@PathVariable (value="username") String userName, @PathVariable (value="password") String password) {
//		for(User user :userList()) {
//			if(userName.equals(user.getUserName())) {
//				if(user.getPassword().equals(password)){
//					return true;
//				}
//			}
//		}
//		return false;
//	}
	


	
}

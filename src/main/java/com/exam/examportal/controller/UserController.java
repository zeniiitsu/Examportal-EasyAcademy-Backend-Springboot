/**
 * 
 */
package com.exam.examportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examportal.model.User;
import com.exam.examportal.model.UserRole;
import com.exam.examportal.model.Role;
import com.exam.examportal.service.UserService;

import java.util.*;

/**
 * @author Bhavesh
 *
 */

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	// Creating user
	@PostMapping("/")
	public ResponseEntity<?> createUser(@RequestBody User user) throws Exception {

		Set<UserRole> roles = new HashSet<>();
		
		user.setProfile("default.png");
		//Encoding password with BCryptPasswordEncoder
		
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

		Role role = new Role();
		role.setRoleId(45L);
		role.setRoleName("NORMAL");

		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);

		roles.add(userRole);

		try {
			User user2 = this.userService.createUser(user, roles);
			return ResponseEntity.ok(user2);
		}catch(Exception e) {
			return ResponseEntity.status(400).body("User Already Present or Something went wrong");
		}
		
	}

	// Getting user by username
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {

		return this.userService.getUser(username);

	}
	
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Long userId) {
		this.userService.deleteUser(userId);
	}
}

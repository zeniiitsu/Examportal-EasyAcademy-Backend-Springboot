/**
 * 
 */
package com.exam.examportal.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examportal.model.User;
import com.exam.examportal.request.JwtRequest;
import com.exam.examportal.response.JwtResponse;
import com.exam.examportal.service.impl.UserDetailsServiceImpl;
import com.exam.examportal.util.JwtUtil;

/**
 * @author Bhavesh
 *
 */

@RestController
@CrossOrigin("*")
public class AuthenticateController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthenticateController.class);

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	
	//Generate Token
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		try {
		
		logger.info("Inside generate token");
		logger.info("Request data-->" + jwtRequest.toString());
		 authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
		logger.info("No exception");
		}catch(Exception e) {
			e.printStackTrace();
			logger.info("User not found");
			return ResponseEntity.status(400).body("User Not Found");		}
		
		//Authenticated now
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	private void authenticate(String username, String password) throws Exception {
		
		try {
			logger.info("Inside authenticate");
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
			logger.info("No exception");
		}catch(DisabledException e) {
			throw new Exception("USER DISABLED " + e.getMessage());
		}catch(BadCredentialsException e) {
			logger.info("INVALID CREDENTIALS");
			throw new Exception("INVALID CREDENTIALS "+e.getMessage());
		}
		
	}
	
	
	//Returns the details of current user
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {
		return ((User)this.userDetailsService.loadUserByUsername(principal.getName()));
	}
}

/**
 * 
 */
package com.exam.examportal.service;
import java.util.*;

import com.exam.examportal.model.User;
import com.exam.examportal.model.UserRole; 
/**
 * @author Bhavesh
 *
 */
public interface UserService {
	
	//Creating user
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
	//Get User by username
	public User getUser(String username);
	
	//Deelet user by userId
	public void deleteUser(Long id);

}

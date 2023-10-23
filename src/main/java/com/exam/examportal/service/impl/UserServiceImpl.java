/**
 * 
 */
package com.exam.examportal.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examportal.model.User;
import com.exam.examportal.model.UserRole;
import com.exam.examportal.repo.RoleRepository;
import com.exam.examportal.repo.UserRepository;
import com.exam.examportal.service.UserService;

/**
 * @author Bhavesh
 *
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	// Creating User
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {

		// TODO Auto-generated method stub
		User local = this.userRepository.findByUsername(user.getUsername());
		if (local != null) {
			System.out.println("User Already present.");
			throw new Exception("User Already present.");
		} else {
			// Create User
			for (UserRole ur : userRoles) {
				this.roleRepository.save(ur.getRole());
			}

			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
		}
		return local;
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub

		User user = this.userRepository.findByUsername(username);
		if (user != null) {
			//System.out.println("User found--> " + user.toString());
			System.out.print("Reuested By---------->" + user.getUsername());
			return user;
		}

		return null;
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		
		this.userRepository.deleteById(id);
		
	}

}

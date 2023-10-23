/**
 * 
 */
package com.exam.examportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.examportal.model.User;

/**
 * @author Bhavesh
 *
 */
public interface UserRepository extends JpaRepository<User,Long>{

	/**
	 * @param username
	 * @return
	 */
	public User findByUsername(String username);

}

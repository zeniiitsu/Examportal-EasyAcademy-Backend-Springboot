package com.exam.examportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.exam.examportal.model.UserRole;
import com.exam.examportal.service.UserService;
import com.exam.examportal.model.User;
import com.exam.examportal.model.Role;
import java.util.*; 

@SpringBootApplication
public class ExamportalApplication implements CommandLineRunner{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ExamportalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.print("Starting application");
		
//		User user = new User();
//		user.setFirstname("Bhavesh");
//		user.setLastname("Ainkar");
//		user.setUsername("Zeniiitsu");
//		user.setPassword(this.bCryptPasswordEncoder.encode("abc123"));
//		user.setEmail("bhaveshainkar1234@gmail.com");
//		user.setProfile("default.png");
//		
//		Role role1 = new Role();
//		role1.setRoleId(44L);
//		//role1.setRoleId(45L);
//		role1.setRoleName("ADMIN");
//		//role1.setRoleName("NORMAL");
//		
//		Set<UserRole> userRoleSet = new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setUser(user);
//		userRole.setRole(role1);
//		userRoleSet.add(userRole);
//		
//		User user1 = this.userService.createUser(user, userRoleSet);
//		System.out.println(user1.getUsername());
		
	}

}

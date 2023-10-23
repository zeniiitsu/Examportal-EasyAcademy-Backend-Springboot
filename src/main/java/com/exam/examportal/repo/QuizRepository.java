/**
 * 
 */
package com.exam.examportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.examportal.model.Quiz;

/**
 * @author Bhavesh
 *
 */
public interface QuizRepository extends JpaRepository<Quiz, Long>{

}

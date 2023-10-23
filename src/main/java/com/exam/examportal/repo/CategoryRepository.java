/**
 * 
 */
package com.exam.examportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.examportal.model.Category;

/**
 * @author Bhavesh
 *
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
	

}

/**
 * 
 */
package com.exam.examportal.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.examportal.model.Question;
import com.exam.examportal.model.Quiz;

/**
 * @author Bhavesh
 *
 */
public interface QuestionRepository extends JpaRepository<Question, Long>{

	/**
	 * @param quiz
	 * @return
	 */
	Set<Question> findByQuiz(Quiz quiz);

}

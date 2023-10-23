/**
 * 
 */
package com.exam.examportal.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.exam.examportal.model.Quiz;

/**
 * @author Bhavesh
 *
 */
@Service
public interface QuizService {
	
	public Quiz addQuiz(Quiz quiz);
	
	public Quiz updateQuiz(Quiz quiz);
	
	public Set<Quiz> getQuizzes();
	
	public Quiz getQuiz(Long quizId);
	
	public void deleteQuiz(Long quizId);
	

}

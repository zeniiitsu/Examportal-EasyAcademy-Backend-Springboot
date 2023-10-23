/**
 * 
 */
package com.exam.examportal.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.exam.examportal.model.Question;
import com.exam.examportal.model.Quiz;

/**
 * @author Bhavesh
 *
 */
@Service
public interface QuestionService {
	
	public Question addQuestion(Question question);
	
	public Question updateQuestion(Question question);
	
	public Set<Question> getQuestions();
	
	public Question getQuestion(Long questionId);
	
	public Set<Question> getQuestionsOfQuiz(Quiz quiz);
	
	public void deleteQestion(Long id);

}

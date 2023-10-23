/**
 * 
 */
package com.exam.examportal.service.impl;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examportal.controller.QuizController;
import com.exam.examportal.model.Quiz;
import com.exam.examportal.repo.QuizRepository;
import com.exam.examportal.service.QuizService;

/**
 * @author Bhavesh
 *
 */
@Service
public class QuizServiceImpl implements QuizService{
	
	private static final Logger logger = LoggerFactory.getLogger(QuizServiceImpl.class);
	
	@Autowired
	private QuizRepository quizRepository;

	@Override
	public Quiz addQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizRepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizRepository.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizzes() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(this.quizRepository.findAll());
	}

	@Override
	public Quiz getQuiz(Long quizId) {
		// TODO Auto-generated method stub
		return this.quizRepository.findById(quizId).get();
	}

	@Override
	public void deleteQuiz(Long quizId) {
		// TODO Auto-generated method stub
		logger.info("Inside deleteQuiz impl");
//		Quiz quiz = new Quiz();
//		quiz.setQid(quizId);
		this.quizRepository.deleteById(quizId);
		logger.info("Deleted");
		
	}

}

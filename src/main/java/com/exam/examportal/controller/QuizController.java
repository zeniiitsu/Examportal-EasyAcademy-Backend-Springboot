/**
 * 
 */
package com.exam.examportal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examportal.model.Quiz;
import com.exam.examportal.service.QuizService;

/**
 * @author Bhavesh
 *
 */

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {
	
	private static final Logger logger = LoggerFactory.getLogger(QuizController.class);
	
	@Autowired
	private QuizService quizService;
	
	
	//Add Quiz service
	@PostMapping("/")
	public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){
		Quiz quiz1 = this.quizService.addQuiz(quiz);
		return ResponseEntity.ok(quiz);
	}
	
	//Update quiz
	@PutMapping("/")
	public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz){
		return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
	}
	
	//Get Quizzes
	@GetMapping("/")
	public ResponseEntity<?> getQuizzes(){
		return ResponseEntity.ok(this.quizService.getQuizzes());
	}
	
	//Get Single quiz
	@GetMapping("/{qid}")
	public Quiz getQuiz(@PathVariable("qid") Long qid) {
		return this.quizService.getQuiz(qid);
	}
	
	//Delete mapping
	@DeleteMapping("/{qid}")
	public void delete(@PathVariable("qid") Long qid) {
		logger.info("Inside delete quiz of controller");
		this.quizService.deleteQuiz(qid);
	}
	

}

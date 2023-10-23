/**
 * 
 */
package com.exam.examportal.controller;

import java.util.*;

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

import com.exam.examportal.model.Question;
import com.exam.examportal.model.Quiz;
import com.exam.examportal.service.QuestionService;
import com.exam.examportal.service.QuizService;

/**
 * @author Bhavesh
 *
 */

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService service;
	
	@Autowired
	private QuizService quizService;
	
	
	
	//Add Question
	@PostMapping("/")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question){
		return ResponseEntity.ok(this.service.addQuestion(question));
	}
	
	//Update Question
	@PutMapping("/")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
		return ResponseEntity.ok(this.service.updateQuestion(question));
	}
	
	//get all questions of any quiz
	@GetMapping("/quiz/{qid}")
	public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid") Long qid){
//		Quiz quiz = new Quiz();
//		quiz.setQid(qid);
//		return ResponseEntity.ok(this.service.getQuestionsOfQuiz(quiz));
		Quiz quiz = this.quizService.getQuiz(qid);
		Set<Question> questions = quiz.getQuestions();
		List list = new ArrayList(questions);
		if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions())) {
			list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions()+1));
		}
		
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
	}
	
	//Get Single question
	@GetMapping("/{quesId}")
	public Question getQuestion(@PathVariable("quesId") Long quesId) {
		return this.service.getQuestion(quesId);
	}
	
	//Delete Question
	@DeleteMapping("/{quesId}")
	public void delete(@PathVariable("quesId") Long quesId) {
		this.service.deleteQestion(quesId);
	}


}

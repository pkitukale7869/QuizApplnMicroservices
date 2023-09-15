package com.project.questionservice.controller;

import com.project.questionservice.service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("question")
public class QuestionController {

	@Autowired
	QuestionService questionService;

	@Autowired
	Environment environment;

	@GetMapping("allQuestions")
	public List<Map<String, Object>> getAllQuestions() {
		return questionService.getAllQuestions();
	}

	@GetMapping("category/{category}")
	public List<Map<String, Object>> getQuestionsByCategory(@PathVariable String category) {
		return questionService.getQuestionsByCategory(category);
	}

//	@PostMapping("add")
//	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
//		return questionService.addQuestion(question);
//	}
//
//	@GetMapping("generate")
//	public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName,
//			@RequestParam Integer numQuestions) {
//		return questionService.getQuestionsForQuiz(categoryName, numQuestions);
//	}
//
//	@PostMapping("getQuestions")
//	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds) {
//		System.out.println(environment.getProperty("local.server.port"));
//		return questionService.getQuestionsFromId(questionIds);
//	}
//
//	@PostMapping("getScore")
//	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses) {
//		return questionService.getScore(responses);
//	}

	// generate
	// getQuestions (questionid)
	// getScore

}
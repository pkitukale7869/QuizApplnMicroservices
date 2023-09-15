package com.project.questionservice.service;

import com.project.questionservice.dao.Select;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class QuestionService {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public QuestionService() {
		this.jdbcTemplate = new JdbcTemplate();
	}

	public List<Map<String, Object>> getAllQuestions() {
		try {
			Select builder = new Select("question");

			builder.selectAll();

			String query = builder.getFinalQuery();
			return jdbcTemplate.queryForList(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<Map<String, Object>> getQuestionsByCategory(String category) {
		try {
			Select builder = new Select("question");

			builder.selectAll();
			builder.where(category, null);

			String query = builder.getFinalQuery();
			System.out.println(query);
			return jdbcTemplate.queryForList(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

//	public ResponseEntity<String> addQuestion(Question question) {
//		questionDao.save(question);
//		return new ResponseEntity<>("success", HttpStatus.CREATED);
//	}
//
//	public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer numQuestions) {
//		List<Integer> questions = questionDao.findRandomQuestionsByCategory(categoryName, numQuestions);
//		return new ResponseEntity<>(questions, HttpStatus.OK);
//	}
//
//	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds) {
//		List<QuestionWrapper> wrappers = new ArrayList<>();
//		List<Question> questions = new ArrayList<>();
//
//		for (Integer id : questionIds) {
//			questions.add(questionDao.findById(id).get());
//		}
//
//		for (Question question : questions) {
//			QuestionWrapper wrapper = new QuestionWrapper();
//			wrapper.setId(question.getId());
//			wrapper.setQuestionTitle(question.getQuestionTitle());
//			wrapper.setOption1(question.getOption1());
//			wrapper.setOption2(question.getOption2());
//			wrapper.setOption3(question.getOption3());
//			wrapper.setOption4(question.getOption4());
//			wrappers.add(wrapper);
//		}
//
//		return new ResponseEntity<>(wrappers, HttpStatus.OK);
//	}
//
//	public ResponseEntity<Integer> getScore(List<Response> responses) {
//
//		int right = 0;
//
//		for (Response response : responses) {
//			Question question = questionDao.findById(response.getId()).get();
//			if (response.getResponse().equals(question.getRightAnswer()))
//				right++;
//		}
//		return new ResponseEntity<>(right, HttpStatus.OK);
//	}
}

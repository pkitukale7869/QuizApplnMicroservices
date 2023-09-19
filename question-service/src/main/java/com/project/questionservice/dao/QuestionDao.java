package com.project.questionservice.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.questionservice.model.Question;

import feign.Param;

import java.util.List;

@Repository
public interface QuestionDao extends CrudRepository<Question, Integer> {
	List<Question> findByCategory(String category);

	@Query(value = "SELECT q.id FROM question q WHERE q.category = :category ORDER BY RAND() LIMIT :numQuestions", nativeQuery = true)
	List<Integer> findRandomQuestionsByCategory(@Param("category") String category,
			@Param("numQuestions") Integer numQuestions);

}

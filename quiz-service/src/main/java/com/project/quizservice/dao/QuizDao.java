package com.project.quizservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.quizservice.model.Quiz;

import java.util.List;

public interface QuizDao extends JpaRepository<Quiz, Integer> {

//	List<Quiz> findByName(String name);

}

package com.project.quizservice.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Quiz {

	@Id
	private Integer id;
	private String name;
	private String title;

	@ElementCollection
	private List<Integer> questionIds;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Integer> getQuestionIds() {
		return questionIds;
	}

	public void setQuestionIds(List<Integer> questionIds) {
		this.questionIds = questionIds;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

package com.project.quizservice.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "quiz")
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "title")
	private String title;

	@ElementCollection
	@CollectionTable(name = "quiz_questions_ids", joinColumns = @JoinColumn(name = "quiz_id"))
	@Column(name = "questions_id")
	private List<Integer> questionIds;

	public Quiz() {
		// Default constructor
	}

	public Quiz(String title, List<Integer> questionIds) {
		this.title = title;
		this.questionIds = questionIds;
	}

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

}

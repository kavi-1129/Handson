package com.cognizant.quiz.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "qt_id")
	private int questionId;

	@Column(name = "qt_text")
	private String questionText;

	@OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
	private Set<Options> optionList;

	public Set<Options> getOptionList() {
		return optionList;
	}

	public void setOptionList(Set<Options> optionList) {
		this.optionList = optionList;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionText=" + questionText + ", optionList=" + optionList
				+ "]";
	}

}

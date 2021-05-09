package com.cognizant.quiz.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "options")
public class Options {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "op_id")
	private int optionId;

	@Column(name = "iop_score")
	private double optionScore;

	@Column(name = "op_text")
	private String optionText;

	@ManyToOne
	@JoinColumn(name = "op_qt_id")
	private Question question;

	@OneToMany(mappedBy = "options", fetch = FetchType.EAGER)
	private Set<AttemptOption> attemptOptionList;

	public Set<AttemptOption> getAttemptOptionList() {
		return attemptOptionList;
	}

	public void setAttemptOptionList(Set<AttemptOption> attemptOptionList) {
		this.attemptOptionList = attemptOptionList;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public double getOptionScore() {
		return optionScore;
	}

	public void setOptionScore(double optionScore) {
		this.optionScore = optionScore;
	}

	public String getOptionText() {
		return optionText;
	}

	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}

	@Override
	public String toString() {
		return "Options [optionId=" + optionId + ", optionScore=" + optionScore + ", optionText=" + optionText
				+ ", question=" + question + ", attemptOptionList=" + attemptOptionList + "]";
	}

}

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
@Table(name = "attempt_question")
public class AttemptQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aq_id")
	private int attemptQuestionId;

	@Column(name = "aq_qt_id")
	private int questionId;

	@ManyToOne
	@JoinColumn(name = "aq_at_id")
	private Attempt attempt;

	@OneToMany(mappedBy = "attemptQuestion", fetch = FetchType.EAGER)
	private Set<AttemptOption> attemptOptionList;

	public Set<AttemptOption> getAttemptOptionList() {
		return attemptOptionList;
	}

	public void setAttemptOptionList(Set<AttemptOption> attemptOptionList) {
		this.attemptOptionList = attemptOptionList;
	}

	public Attempt getAttempt() {
		return attempt;
	}

	public void setAttempt(Attempt attempt) {
		this.attempt = attempt;
	}

	public int getAttemptQuestionId() {
		return attemptQuestionId;
	}

	public void setAttemptQuestionId(int attemptQuestionId) {
		this.attemptQuestionId = attemptQuestionId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	@Override
	public String toString() {
		return "AttemptQuestion [attemptQuestionId=" + attemptQuestionId + ", questionId=" + questionId + ", attempt="
				+ attempt + ", attemptOptionList=" + attemptOptionList + "]";
	}

}

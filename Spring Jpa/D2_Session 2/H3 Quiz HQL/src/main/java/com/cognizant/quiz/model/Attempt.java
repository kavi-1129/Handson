package com.cognizant.quiz.model;

import java.util.Date;
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
@Table(name = "attempt")
public class Attempt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "at_id")
	private int attemptId;

	@Column(name = "at_date")
	private Date attemptDate;

	@Column(name = "at_score")
	private double attemptScore;

	@ManyToOne
	@JoinColumn(name = "at_us_id")
	private User user;

	@OneToMany(mappedBy = "attempt", fetch = FetchType.EAGER)
	private Set<AttemptQuestion> attemptQuestionsList;

	public Set<AttemptQuestion> getAttemptQuestionsList() {
		return attemptQuestionsList;
	}

	public void setAttemptQuestionsList(Set<AttemptQuestion> attemptQuestionsList) {
		this.attemptQuestionsList = attemptQuestionsList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getAttemptId() {
		return attemptId;
	}

	public void setAttemptId(int attemptId) {
		this.attemptId = attemptId;
	}

	public Date getAttemptDate() {
		return attemptDate;
	}

	public void setAttemptDate(Date attemptDate) {
		this.attemptDate = attemptDate;
	}

	public double getAttemptScore() {
		return attemptScore;
	}

	public void setAttemptScore(double attemptScore) {
		this.attemptScore = attemptScore;
	}

}

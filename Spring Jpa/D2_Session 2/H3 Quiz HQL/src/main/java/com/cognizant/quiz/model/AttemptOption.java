package com.cognizant.quiz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "attempt_option")
public class AttemptOption {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ao_id")
	private int attemptOptionId;

	@Column(columnDefinition = "bit", name = "ao_selected")
	private int selected;

	@ManyToOne
	@JoinColumn(name = "ao_aq_id")
	private AttemptQuestion attemptQuestion;

	@ManyToOne
	@JoinColumn(name = "ao_op_id")
	private Options options;

	public AttemptQuestion getAttemptQuestion() {
		return attemptQuestion;
	}

	public void setAttemptQuestion(AttemptQuestion attemptQuestion) {
		this.attemptQuestion = attemptQuestion;
	}

	public Options getOptions() {
		return options;
	}

	public void setOptions(Options options) {
		this.options = options;
	}

	public int getAttemptOptionId() {
		return attemptOptionId;
	}

	public void setAttemptOptionId(int attemptOptionId) {
		this.attemptOptionId = attemptOptionId;
	}

	public int getSelected() {
		return selected;
	}

	public void setSelected(int selected) {
		this.selected = selected;
	}

	@Override
	public String toString() {
		return "AttemptOption [attemptOptionId=" + attemptOptionId + ", selected=" + selected + ", attemptQuestion="
				+ attemptQuestion + ", options=" + options + "]";
	}

}

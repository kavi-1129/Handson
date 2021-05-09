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
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "us_id")
	private int userId;

	@Column(name = "us_name")
	private String userName;

	@Column(name = "us_email")
	private String email;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private Set<Attempt> attemptList;

	public Set<Attempt> getAttemptList() {
		return attemptList;
	}

	public void setAttemptList(Set<Attempt> attemptList) {
		this.attemptList = attemptList;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	@Override
//	public String toString() {
//		return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", attemptList=" + attemptList
//				+ "]";
//	}

}

package edu.uga.cs1302.quiz;

import java.util.Date;

public class QuizScore {
	private String score;
	private Date date;

	public QuizScore() {
		score = null;
		date = new Date();
	}
	
	public QuizScore(String s) {
		score = s;
		date = new Date();
	}

	public String getScore() {
		return score;
	}

	public Date getDate() {
		return date;
	}

	public void setScore(String s) {
		score = s;
	}
	
	public String toString() {
		return score + date;
	}

}

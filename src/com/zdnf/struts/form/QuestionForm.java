package com.zdnf.struts.form;

import java.util.Set;

import org.apache.struts.action.ActionForm;

import com.zdnf.model.Answer;
import com.zdnf.model.Course;

public class QuestionForm extends ActionForm {

	private int id;
	
	private String title;
	
	private String content;
	
	private String score;
	
	private Course course;
	
	private Set<Answer> answers;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Set<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}
	
	
}

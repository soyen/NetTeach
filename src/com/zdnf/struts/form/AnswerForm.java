package com.zdnf.struts.form;

import org.apache.struts.action.ActionForm;

import com.zdnf.model.Question;
import com.zdnf.model.Student;

public class AnswerForm extends ActionForm {

private int id;
	
	private String title;
	
	private String content;
	
	private String score;
	
	private Question question;
	
	private Student student;

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

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}

package com.zdnf.service;

import java.util.Set;

public interface IStudentHomeworkService {
	
	public Set getCourseQuestion(int courseID);
	
	public Set getStudentCourse(int studentID);
	
	public void saveAnswer(int studentID,int questionID,String content,String title);
	
	public boolean isDone(int studentID,int questionID);
	
	public Set getAnswers(int studentID);

}

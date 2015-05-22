package com.zdnf.service;

import java.util.Set;

import com.zdnf.model.Answer;
import com.zdnf.model.Question;

public interface ITeacherHomeworkService {
	
	public void saveQuestion(String title,String content,String score,int courseId);
	
	public void deleteQuestion(int id);
	
	public void updateQuestion(int id,String title,String content,String score);
	
	public Question getQuestion(int id);

	public Set getTeacherCourse(int teacherId);
	
	public Set getQuestions(int courseId);
	
	public Set getAnswers(int id);
	
	public void saveScore(int answerId,String score);
}

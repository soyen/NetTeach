package com.zdnf.dao;

import java.util.List;

import com.zdnf.model.Answer;


public interface IAnswerDAO {
	
	public void saveAnswer(Answer answer);
	
	public void deleteAnswer(Answer answer);
	
	public void updateAnswer(Answer answer);
	
	public Answer getAnswerById(int id);
	
	public List<Answer> findAllAnswer();

}

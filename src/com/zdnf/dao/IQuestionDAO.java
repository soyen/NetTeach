package com.zdnf.dao;

import java.util.List;


import com.zdnf.model.Question;

public interface IQuestionDAO {
	
    public void saveQuestion(Question question);
	
	public void deleteQuestion(Question question);
	
	public void updateQuestion(Question question);
	
	public Question getQuestionById(int id);
	
	public List<Question> findAllQuestion();

}

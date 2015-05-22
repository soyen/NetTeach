package com.zdnf.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zdnf.dao.IQuestionDAO;
import com.zdnf.model.Question;

public class QuestionDAO extends HibernateDaoSupport implements IQuestionDAO {

	@Override
	public void deleteQuestion(Question question) {
		this.getHibernateTemplate().delete(question);
		
	}

	@Override
	public List<Question> findAllQuestion() {
		
		return this.getHibernateTemplate().loadAll(Question.class);
	}

	@Override
	public Question getQuestionById(int id) {
		
		return (Question)this.getHibernateTemplate().load(Question.class, id);
	}

	@Override
	public void saveQuestion(Question question) {
		this.getHibernateTemplate().save(question);
		
	}

	@Override
	public void updateQuestion(Question question) {
		this.getHibernateTemplate().update(question);
		
	}

}

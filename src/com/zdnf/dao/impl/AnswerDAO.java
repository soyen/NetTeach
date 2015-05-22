package com.zdnf.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zdnf.dao.IAnswerDAO;
import com.zdnf.model.Answer;

public class AnswerDAO extends HibernateDaoSupport implements IAnswerDAO {

	@Override
	public void deleteAnswer(Answer answer) {
		this.getHibernateTemplate().delete(answer);
		
	}

	@Override
	public List<Answer> findAllAnswer() {
		
		return this.getHibernateTemplate().loadAll(Answer.class);
	}

	@Override
	public Answer getAnswerById(int id) {
		
		return (Answer)this.getHibernateTemplate().load(Answer.class, id);
	}

	@Override
	public void saveAnswer(Answer answer) {
		this.getHibernateTemplate().save(answer);
		
	}

	@Override
	public void updateAnswer(Answer answer) {
		this.getHibernateTemplate().update(answer);
		
	}

}

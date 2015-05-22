package com.zdnf.service.impl;

import java.util.Set;

import com.zdnf.dao.IAnswerDAO;
import com.zdnf.dao.ICourseDAO;
import com.zdnf.dao.IQuestionDAO;
import com.zdnf.dao.ITeacherDAO;
import com.zdnf.model.Answer;
import com.zdnf.model.Course;
import com.zdnf.model.Question;
import com.zdnf.model.Teacher;
import com.zdnf.service.ITeacherHomeworkService;

public class TeacherHomeworkService implements ITeacherHomeworkService {
	
	private IQuestionDAO questionDAO;
	
	private ICourseDAO courseDAO;
	
	private ITeacherDAO teacherDAO;
	
	private IAnswerDAO answerDAO;

	public void setAnswerDAO(IAnswerDAO answerDAO) {
		this.answerDAO = answerDAO;
	}

	public void setTeacherDAO(ITeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	public void setCourseDAO(ICourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	public void setQuestionDAO(IQuestionDAO questionDAO) {
		this.questionDAO = questionDAO;
	}

	

	@Override
	public void saveQuestion(String title, String content, String score,
			int courseId) {
		Question question = new Question();
		Course course = courseDAO.getCourseById(courseId);
		question.setTitle(title);
		question.setContent(content);
		question.setScore(score);
		question.setCourse(course);
		questionDAO.saveQuestion(question);
		
	}

	@Override
	public void updateQuestion(int id, String title, String content,
			String score) {
		Question question = questionDAO.getQuestionById(id);
		question.setTitle(title);
		question.setContent(content);
		question.setScore(score);
		questionDAO.saveQuestion(question);
		
	}
	@Override
	public void deleteQuestion(int id) {
		questionDAO.deleteQuestion(getQuestion(id));
		
	}

	@Override
	public Question getQuestion(int id) {
		
		return questionDAO.getQuestionById(id);
	}

	@Override
	public Set getTeacherCourse(int teacherId) {
		Teacher teacher = teacherDAO.getTeacherById(teacherId);
		Set courseSet = teacher.getCourses();
		return courseSet;
	}

	@Override
	public Set getQuestions(int courseId) {
		Course course = courseDAO.getCourseById(courseId);
		Set questionSet = course.getQuestions();
		return questionSet;
	}

	@Override
	public Set getAnswers(int id) {
		Question question = questionDAO.getQuestionById(id);
		Set answerSet = question.getAnswers();
		return answerSet;
	}

	@Override
	public void saveScore(int answerId,String score) {
		Answer answer = answerDAO.getAnswerById(answerId);
		answer.setScore(score);
		answerDAO.updateAnswer(answer);		
	}

	

}

package com.zdnf.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zdnf.dao.IAnswerDAO;
import com.zdnf.dao.ICourseDAO;
import com.zdnf.dao.IQuestionDAO;
import com.zdnf.dao.IStudentDAO;
import com.zdnf.model.Answer;
import com.zdnf.model.Course;
import com.zdnf.model.Question;
import com.zdnf.model.Student;
import com.zdnf.service.IStudentHomeworkService;

public class StudentHomeworkService implements
		IStudentHomeworkService {

	

	private ICourseDAO courseDAO;

	private IQuestionDAO questionDAO;
	
	private IAnswerDAO answerDAO;
	
	private IStudentDAO studentDAO;
	
	
	
	
	public void setStudentDAO(IStudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}



	public void setQuestionDAO(IQuestionDAO questionDAO) {
		this.questionDAO = questionDAO;
	}



	public void setAnswerDAO(IAnswerDAO answerDAO) {
		this.answerDAO = answerDAO;
	}



	public void setCourseDAO(ICourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}



	@Override
	public Set getCourseQuestion(int courseID) {
		Course course = courseDAO.getCourseById(courseID);
		Set questionSet = course.getQuestions();		
		return questionSet;
	}



	@Override
	public Set getStudentCourse(int studentID) {
		Student student = studentDAO.getStudentById(studentID);
		Set courseSet = student.getCourses();
		return courseSet;
	}



	@Override
	public void saveAnswer(int studentID, int questionID,String content,String title) {
		Student student = studentDAO.getStudentById(studentID);
		Question question = questionDAO.getQuestionById(questionID);
		Answer answer = new Answer();
		answer.setContent(content);
		answer.setTitle(title);
		answer.setTitle(question.getTitle());
		answer.setStudent(student);
		answer.setQuestion(question);
		answerDAO.saveAnswer(answer);
		
	}



	@Override
	public boolean isDone(int studentID, int questionID) {
		boolean isDone = false;
		Student student = studentDAO.getStudentById(studentID);
		Question question = questionDAO.getQuestionById(questionID);
		List<Answer> answerList = answerDAO.findAllAnswer();
		for(int i = 0;i<answerList.size();i++){
			if(answerList.get(i).getQuestion().equals(question)&&answerList.get(i).getStudent().equals(student))
				isDone = true;
		}
		return isDone;
	}



	@Override
	public Set getAnswers(int studentID) {
		Student student = studentDAO.getStudentById(studentID);
		Set answerSet = student.getAnswers();
		return answerSet;
	}

}

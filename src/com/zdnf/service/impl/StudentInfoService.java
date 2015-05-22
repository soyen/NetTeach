package com.zdnf.service.impl;

import com.zdnf.dao.IStudentDAO;
import com.zdnf.model.Student;
import com.zdnf.service.IStudentInfoService;

public class StudentInfoService implements IStudentInfoService {

	private IStudentDAO studentDAO;
	
	public void setStudentDAO(IStudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public Student getStudentInfo(int id) {
		return studentDAO.getStudentById(id);
	}

	@Override
	public void updateInfo(int id, String username, String password,
			String sex, String info, String name) {
		Student student = getStudentInfo(id);
		student.setUsername(username);
		student.setPassword(password);
		student.setSex(sex);
		student.setInfo(info);
		student.setName(name);
		studentDAO.updateStudent(student);

	}

}

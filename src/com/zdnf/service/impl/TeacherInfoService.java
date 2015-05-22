package com.zdnf.service.impl;

import com.zdnf.dao.ITeacherDAO;
import com.zdnf.model.Teacher;
import com.zdnf.service.ITeacherInfoService;

public class TeacherInfoService implements ITeacherInfoService {

	private ITeacherDAO teacherDAO;
	
	public void setTeacherDAO(ITeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	@Override
	public Teacher getTeacherInfo(int id) {
		
		return teacherDAO.getTeacherById(id);
	}

	@Override
	public void updateInfo(int id, String username, String password,
			String sex, String info, String name) {
		
		Teacher teacher = getTeacherInfo(id);
		teacher.setUsername(username);
		teacher.setPassword(password);
		teacher.setSex(sex);
		teacher.setInfo(info);
		teacher.setName(name);
		teacherDAO.updateTeacher(teacher);
		
	}

}

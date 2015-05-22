package com.zdnf.dao;

import java.util.List;

import com.zdnf.model.Teacher;
import com.zdnf.util.PageModel;

public interface ITeacherDAO {
	
	public Teacher validate(String username,String password);
	
    public void saveTeacher(Teacher teacher);
	
	public void deleteTeacher(Teacher teacher);
	
	public Teacher getTeacherById(int id);
	
	public void updateTeacher(Teacher teacher);
	
	public List<Teacher> findAllTeacher();
	
	public PageModel findTeacherByPage(final int pageNo,final int pageSize,final String queryStr);
	

}

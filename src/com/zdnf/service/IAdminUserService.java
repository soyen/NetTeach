package com.zdnf.service;

import java.util.List;

import com.zdnf.model.Student;
import com.zdnf.model.Teacher;
import com.zdnf.util.PageModel;

public interface IAdminUserService {
	
	public void saveTeacher(String username,String password,String name,String sex,String info,String teacherNo,String title,int departmentId);
	public void deleteTeacher(int id);
	public Teacher getTeacher(int id);
	public void updateTeacher(int id,String username,String password,String sex,String info,String teacherNo,String title,String name);
	public List findAllTeacher();
	public PageModel queryTeacher(int pageNo, int pageSize, String queryStr);
	
	public void saveStudent(String username,String password,String name,String sex,String info,String studentNo,String major,int classesId);
	public void deleteStudent(int id);
	public Student getStudent(int id);
	public void updateStudent(int id,String username,String password,String name,String sex,String info,String studentNo,String major);
	public List findAllStudent();
	public PageModel queryStudent(int pageNo, int pageSize, String queryStr);

}

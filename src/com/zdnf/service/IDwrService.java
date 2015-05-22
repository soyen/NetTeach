package com.zdnf.service;


import java.util.Map;
import java.util.Set;

import org.apache.struts.util.ModuleException;

import com.zdnf.model.Classes;

public interface IDwrService {
	
	public Map<Integer, String> findAllDepartment();
	
	public Map<Integer, String> findTeacher(int deptId);
	
	public Set findCourse(int teacherID);

	public String addCourse(int studentId,int courseId);
			
	public Set findClasses(int dpetID);
	
	public void updateClass(int id,String className);
	
	public void deleteClass(int id);
	
	public Set findTeacherSet(int deptID);
	
	public void updateTeacher(int id,String username,String password,String teacherNo,
			String sex,String title,String info,String name);
	
	public void deleteTeacher(int id);
	
	public Map<Integer, String> findClass(int deptId);
	
	public Set findStudent(int id);
	
	public void updateStudent(int id,String username,String password,String studentNo,
			String sex,String major,String info,String name);
	
	public void deleteStudent(int id);
}

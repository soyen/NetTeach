package com.zdnf.service.impl;

import java.util.List;

import com.zdnf.dao.IClassesDAO;
import com.zdnf.dao.IDepartmentDAO;
import com.zdnf.dao.IStudentDAO;
import com.zdnf.dao.ITeacherDAO;
import com.zdnf.model.Classes;
import com.zdnf.model.Department;
import com.zdnf.model.Student;
import com.zdnf.model.Teacher;
import com.zdnf.service.IAdminUserService;
import com.zdnf.util.PageModel;

public class AdminUserService implements IAdminUserService {
	
	private ITeacherDAO teacherDAO;
	
	private IStudentDAO studentDAO;
	
	private IDepartmentDAO departmentDAO;
	
	private IClassesDAO classesDAO;
	
	
	

	public void setClassesDAO(IClassesDAO classesDAO) {
		this.classesDAO = classesDAO;
	}

	public void setTeacherDAO(ITeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	public void setStudentDAO(IStudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public void setDepartmentDAO(IDepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	public void saveTeacher(String username, String password,String name, String sex,
			String info, String teacherNo, String title, int departmentId
			) {
		
		Department department = departmentDAO.getDepartmentById(departmentId);
		
		Teacher teacher = new Teacher();
		teacher.setUsername(username);
		teacher.setPassword(password);
		teacher.setSex(sex);
		teacher.setInfo(info);
		teacher.setTeacherNo(teacherNo);
		teacher.setTitle(title);
		teacher.setName(name);
		teacher.setDepartment(department);
		
		teacherDAO.saveTeacher(teacher);
		
		
	}

	@Override
	public void deleteTeacher(int id) {
		teacherDAO.deleteTeacher(getTeacher(id));
	
	}

	@Override
	public void updateTeacher(int id, String username, String password,
			String sex, String info, String teacherNo, String title,
			String name) {
		Teacher teacher = getTeacher(id);
		teacher.setUsername(username);
		teacher.setPassword(password);
		teacher.setSex(sex);
		teacher.setInfo(info);
		teacher.setTeacherNo(teacherNo);
		teacher.setTitle(title);
		teacher.setName(name);
		teacherDAO.updateTeacher(teacher);
	}

	@Override
	public PageModel queryTeacher(int pageNo, int pageSize, String queryStr) {
		
		return teacherDAO.findTeacherByPage(pageNo, pageSize, queryStr);
	}

	@Override
	public Teacher getTeacher(int id) {
	     return teacherDAO.getTeacherById(id);
	}

	@Override
	public List findAllTeacher() {
		return teacherDAO.findAllTeacher();
	}

	@Override
	public void saveStudent(String username, String password,String name, String sex,
			String info, String studentNo, String major, int classesId) {
		Classes classes = classesDAO.getClassesById(classesId);
	    int capacity = classes.getCapacity();
	    classes.setCapacity(capacity+1);
		Student student = new Student();
		student.setUsername(username);
		student.setPassword(password);
		student.setName(name);
		student.setSex(sex);
		student.setInfo(info);
		student.setStudentNo(studentNo);
		student.setMajor(major);
		student.setClasses(classes);
		studentDAO.saveStudent(student);
	
	}

	@Override
	public void deleteStudent(int id) {
		Student student = getStudent(id);
		Classes classes = student.getClasses();
		int capacity = classes.getCapacity();
	    classes.setCapacity(capacity-1);
		student.setClasses(classes);
		studentDAO.deleteStudent(student);

	}

	@Override
	public void updateStudent(int id,String username,String password,String name,String sex,String info,String studentNo,String major) {
		Student student = getStudent(id);
		student.setUsername(username);
		student.setPassword(password);
		student.setName(name);
		student.setSex(sex);
		student.setInfo(info);
		student.setStudentNo(studentNo);
		student.setMajor(major);
		studentDAO.updateStudent(student);
	
	}

	@Override
	public Student getStudent(int id) {
		
		return studentDAO.getStudentById(id);
	}

	@Override
	public List findAllStudent() {
		
		return studentDAO.findAllStudent();
	}

	@Override
	public PageModel queryStudent(int pageNo, int pageSize, String queryStr) {
		
		return studentDAO.findStudentByPage(pageNo, pageSize, queryStr);
	}

	

}

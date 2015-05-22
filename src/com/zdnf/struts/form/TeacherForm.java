package com.zdnf.struts.form;

import java.util.Set;

import org.apache.struts.action.ActionForm;

import com.zdnf.model.Course;
import com.zdnf.model.Department;


public class TeacherForm extends ActionForm {
	
private int id;
	
    private String username;
    
    private String password;
    
    private String name;
    
    private String sex;
    
    private String info;
    
	private String title;
	
	private String teacherNo;
	
    private Department department;

    private Set<Course> courses;
    
    
    
    private String queryStr ;

	private int pageNo;
	
	private int pageSize;
	
	private String deptList;
	
	

	public String getDeptList() {
		return deptList;
	}

	public void setDeptList(String deptList) {
		this.deptList = deptList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTeacherNo() {
		return teacherNo;
	}

	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}


	public String getQueryStr() {
		return queryStr;
	}

	public void setQueryStr(String queryStr) {
		this.queryStr = queryStr;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
   
}

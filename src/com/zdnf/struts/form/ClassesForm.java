package com.zdnf.struts.form;

import java.util.Set;

import org.apache.struts.action.ActionForm;

import com.zdnf.model.Department;
import com.zdnf.model.Student;

public class ClassesForm extends ActionForm {
	
	private int id;
	
	private String className;
	
	private String maxCapacity;
	
	private int departmentId;
	
    private Set<Student> students;
	
	private Department department;
	
	private int pageNo;
	
	private int pageSize;
	
	private String queryStr;
	
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

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(String maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
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

	public String getQueryStr() {
		return queryStr;
	}

	public void setQueryStr(String queryStr) {
		this.queryStr = queryStr;
	}

}
